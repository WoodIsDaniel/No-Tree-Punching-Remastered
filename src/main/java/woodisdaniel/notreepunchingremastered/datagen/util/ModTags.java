package woodisdaniel.notreepunchingremastered.datagen.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.biome.Biome;
import woodisdaniel.notreepunchingremastered.NoTreePunchingRemastered;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> INCORRECT_FOR_FLINT_TOOL = createTag("incorrect_for_flint_tool");
        public static final TagKey<Block> INCORRECT_FOR_COPPER_TOOL = createTag("incorrect_for_copper_tool");
        public static final TagKey<Block> INCORRECT_FOR_STEEL_TOOL = createTag("incorrect_for_steel_tool");

        // Used for TimberHandler & Loose Rock WorldGen.
        public static final TagKey<Block> WOODEN =
                BlockTags.create(ResourceLocation.fromNamespaceAndPath("notreepunchingremastered", "wooden"));

        public static final TagKey<Block> WOODEN_FENCE_GATES =
                BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", "wooden_fence_gates"));

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(NoTreePunchingRemastered.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> KNIVES =
                ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "tools/knives"));
        public static final TagKey<Item> SAWS =
                ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "tools/saws"));
        public static final TagKey<Item> AXES =
                ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "tools/axes"));

        public static final TagKey<Item> STEEL_INGOT =
                ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "ingots/steel"));

        public static final TagKey<Item> VESSEL_BLACKLISTED = TagKey.create(
                net.minecraft.core.registries.Registries.ITEM,
                net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("notreepunchingremastered", "vessel_blacklisted")
        );
    }

    public static class Worldgen {
        public static class Biomes {
            public static final TagKey<Biome> HAS_STONE_ROCK = TagKey.create(
                    Registries.BIOME,
                    ResourceLocation.fromNamespaceAndPath(NoTreePunchingRemastered.MOD_ID, "has_stone_rock")
            );

            public static final TagKey<Biome> HAS_SANDSTONE_ROCK = TagKey.create(
                    Registries.BIOME,
                    ResourceLocation.fromNamespaceAndPath(NoTreePunchingRemastered.MOD_ID, "has_sandstone_rock")
            );

            public static final TagKey<Biome> HAS_RED_SANDSTONE_ROCK = TagKey.create(
                    Registries.BIOME,
                    ResourceLocation.fromNamespaceAndPath(NoTreePunchingRemastered.MOD_ID, "has_red_sandstone_rock")
            );
        }
    }
}