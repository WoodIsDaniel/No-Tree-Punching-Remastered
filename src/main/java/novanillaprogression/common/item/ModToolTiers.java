package novanillaprogression.common.item;

import net.minecraft.world.item.Items;
import novanillaprogression.datagen.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {

    public static final Tier FLINT = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_FLINT_TOOL,
            130, 2f, 0.0f, 15, () -> Ingredient.of(Items.FLINT));

    public static final Tier COPPER = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_COPPER_TOOL,
            95, 4f, 1.0f, 5, () -> Ingredient.of(Items.COPPER_INGOT));

    public static final Tier BRONZE = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_BRONZE_TOOL,
            350, 5f, 1.5f, 14, () -> Ingredient.of(ModTags.Items.BRONZE_INGOTS));

}