package woodisdaniel.novanillaprogression.common.item;

import net.minecraft.world.item.Items;
import woodisdaniel.novanillaprogression.datagen.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {

    public static final Tier FLINT = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_FLINT_TOOL,
            130, 2f, 0.0f, 15, () -> Ingredient.of(Items.FLINT));

    public static final Tier COPPER = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_COPPER_TOOL,
            95, 4f, 1.0f, 5, () -> Ingredient.of(Items.COPPER_INGOT));

}