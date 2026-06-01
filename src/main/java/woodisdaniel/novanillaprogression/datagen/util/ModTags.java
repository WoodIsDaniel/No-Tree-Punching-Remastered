package woodisdaniel.novanillaprogression.datagen.util;

import net.neoforged.neoforge.common.Tags;
import woodisdaniel.novanillaprogression.NoVanillaProgression;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import woodisdaniel.novanillaprogression.common.gui.VesselMenu;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> INCORRECT_FOR_FLINT_TOOL = createTag("incorrect_for_flint_tool");
        public static final TagKey<Block> INCORRECT_FOR_COPPER_TOOL = createTag("incorrect_for_copper_tool");

        public static final TagKey<Block> WOODEN_GATES =
                BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", "wooden_gates"));

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(NoVanillaProgression.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> KNIVES =
                ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "tools/knives"));
        public static final TagKey<Item> SAWS =
                ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "tools/saws"));
        public static final TagKey<Item> AXES =
                ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "tools/axes"));

        public static final TagKey<Item> VESSEL_BLACKLISTED = TagKey.create(
                net.minecraft.core.registries.Registries.ITEM,
                net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("notreepunching", "vessel_blacklisted")
        );
    }
}