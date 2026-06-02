package woodisdaniel.notreepunchingremastered.common.item;

import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;
import woodisdaniel.notreepunchingremastered.datagen.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {

    public static final Tier FLINT = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_FLINT_TOOL,
            60, 2f, 0.0f, 5, () -> Ingredient.of(Items.FLINT));

    public static final Tier COPPER = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_COPPER_TOOL,
            140, 4f, 1.0f, 15, () -> Ingredient.of(Items.COPPER_INGOT));

    public static final Tier STEEL = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_STEEL_TOOL,
            640, 7f, 2.0f, 13, () -> Ingredient.of(ModTags.Items.STEEL_INGOT));
}