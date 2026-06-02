package woodisdaniel.notreepunchingremastered.common.crafting;

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

public class DamageToolShapelessRecipe implements CraftingRecipe {

    private final String group;
    public final CraftingBookCategory category;
    public final NonNullList<Ingredient> ingredients;
    public final ItemStack result;

    public DamageToolShapelessRecipe(
            String group,
            CraftingBookCategory category,
            NonNullList<Ingredient> ingredients,
            ItemStack result
    ) {
        this.group = group;
        this.category = category;
        this.ingredients = ingredients;
        this.result = result;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipeTypes.DAMAGE_TOOL_SHAPELESS_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return RecipeType.CRAFTING;
    }

    @Override
    public String getGroup() {
        return group;
    }

    @Override
    public CraftingBookCategory category() {
        return category;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider registries) {
        return result;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= ingredients.size();
    }

    @Override
    public boolean matches(CraftingInput input, Level level) {
        int ingredientCount = 0;

        for (int i = 0; i < input.size(); i++) {
            if (!input.getItem(i).isEmpty()) {
                ingredientCount++;
            }
        }

        if (ingredientCount != this.ingredients.size()) {
            return false;
        }

        return input.stackedContents().canCraft(this, null);
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public ItemStack assemble(CraftingInput input, HolderLookup.Provider registries) {
        return result.copy();
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems(CraftingInput input) {
        NonNullList<ItemStack> remainingItems =
                NonNullList.withSize(input.size(), ItemStack.EMPTY);

        RandomSource random = RandomSource.create();

        for (int i = 0; i < input.size(); ++i) {
            ItemStack itemstack = input.getItem(i);

            if (itemstack.hasCraftingRemainingItem()) {
                remainingItems.set(i, itemstack.getCraftingRemainingItem());
            }
            else if (itemstack.isDamageableItem()) {
                ItemStack damagedStack = itemstack.copy();

                int unbreakingLevel = 0;
                ItemEnchantments enchantments =
                        itemstack.get(DataComponents.ENCHANTMENTS);

                if (enchantments != null) {
                    for (Holder<Enchantment> enchantment : enchantments.keySet()) {
                        if (enchantment.is(Enchantments.UNBREAKING)) {
                            unbreakingLevel =
                                    enchantments.getLevel(enchantment);
                            break;
                        }
                    }
                }

                boolean shouldTakeDamage = true;

                if (unbreakingLevel > 0 &&
                        random.nextInt(unbreakingLevel + 1) > 0) {
                    shouldTakeDamage = false;
                }

                if (shouldTakeDamage) {
                    int newDamage = damagedStack.getDamageValue() + 1;

                    if (newDamage < damagedStack.getMaxDamage()) {
                        damagedStack.setDamageValue(newDamage);
                        remainingItems.set(i, damagedStack);
                    }
                } else {
                    remainingItems.set(i, damagedStack);
                }
            }
        }

        return remainingItems;
    }
}