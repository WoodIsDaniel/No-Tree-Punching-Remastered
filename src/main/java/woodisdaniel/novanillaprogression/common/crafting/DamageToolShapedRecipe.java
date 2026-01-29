package woodisdaniel.novanillaprogression.common.crafting;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.Level;

public class DamageToolShapedRecipe implements CraftingRecipe {
    final String group;
    public final CraftingBookCategory category;
    public final ShapedRecipePattern pattern;
    public final ItemStack result;
    public final boolean showNotification;

    public DamageToolShapedRecipe(String group, CraftingBookCategory category, ShapedRecipePattern pattern, ItemStack result, boolean showNotification) {
        this.group = group;
        this.category = category;
        this.pattern = pattern;
        this.result = result;
        this.showNotification = showNotification;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipeTypes.DAMAGE_TOOL_SHAPED_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return RecipeType.CRAFTING;
    }

    @Override
    public String getGroup() { return this.group; }

    @Override
    public CraftingBookCategory category() { return this.category; }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider registries) { return this.result; }

    @Override
    public NonNullList<Ingredient> getIngredients() { return this.pattern.ingredients(); }

    @Override
    public boolean showNotification() { return this.showNotification; }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width >= this.pattern.width() && height >= this.pattern.height();
    }

    @Override
    public boolean matches(CraftingInput input, Level level) { return this.pattern.matches(input); }

    @Override
    public ItemStack assemble(CraftingInput input, HolderLookup.Provider registries) { return this.result.copy(); }

    @Override
    public NonNullList<ItemStack> getRemainingItems(CraftingInput input) {
        NonNullList<ItemStack> remainingItems = NonNullList.withSize(input.size(), ItemStack.EMPTY);
        RandomSource random = RandomSource.create();

        for (int i = 0; i < remainingItems.size(); ++i) {
            ItemStack itemstack = input.getItem(i);

            if (itemstack.hasCraftingRemainingItem()) {
                remainingItems.set(i, itemstack.getCraftingRemainingItem());
            }
            else if (itemstack.isDamageableItem()) {
                ItemStack damagedStack = itemstack.copy();

                int unbreakingLevel = 0;
                ItemEnchantments enchantments = itemstack.get(DataComponents.ENCHANTMENTS);

                if (enchantments != null) {

                    for (Holder<Enchantment> enchantment : enchantments.keySet()) {
                        if (enchantment.is(Enchantments.UNBREAKING)) {
                            unbreakingLevel = enchantments.getLevel(enchantment);
                            break;
                        }
                    }
                }

                boolean shouldTakeDamage = true;
                if (unbreakingLevel > 0) {
                    if (random.nextInt(unbreakingLevel + 1) > 0) {
                        shouldTakeDamage = false;
                    }
                }

                if (shouldTakeDamage) {
                    int newDamage = damagedStack.getDamageValue() + 1;
                    if (newDamage < damagedStack.getMaxDamage()) {
                        damagedStack.setDamageValue(newDamage);
                        remainingItems.set(i, damagedStack);
                    } else {
                        remainingItems.set(i, ItemStack.EMPTY);
                    }
                } else {
                    remainingItems.set(i, damagedStack);
                }
            }
        }
        return remainingItems;
    }
}