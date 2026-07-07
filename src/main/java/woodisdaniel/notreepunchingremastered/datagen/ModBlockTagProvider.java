package woodisdaniel.notreepunchingremastered.datagen;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import woodisdaniel.notreepunchingremastered.NoTreePunchingRemastered;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import woodisdaniel.notreepunchingremastered.common.block.ModBlocks;
import woodisdaniel.notreepunchingremastered.datagen.util.ModTags;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.tags.BlockTags.*;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, NoTreePunchingRemastered.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(ModTags.Blocks.INCORRECT_FOR_FLINT_TOOL)
                .addTag(INCORRECT_FOR_WOODEN_TOOL)
                .remove(Blocks.COPPER_ORE)
                .remove(Blocks.DEEPSLATE_COPPER_ORE);

        tag(ModTags.Blocks.INCORRECT_FOR_COPPER_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_STONE_TOOL)
                .remove(NEEDS_STONE_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_STEEL_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(NEEDS_IRON_TOOL);

        tag(ModTags.Blocks.WOODEN)
                //Minecraft Wooden Tags
                .addTag(LOGS)
                .addTag(PLANKS)
                .addTag(WOODEN_SLABS)
                .addTag(WOODEN_STAIRS)
                .addTag(WOODEN_BUTTONS)
                .addTag(WOODEN_PRESSURE_PLATES)
                .addTag(WOODEN_DOORS)
                .addTag(WOODEN_TRAPDOORS)
                .addTag(WOODEN_FENCES)

                //NeoForge Wooden Tags
                .addTag(BlockTags.create(ResourceLocation.parse("c:fence_gates/wooden")))
                .addTag(BlockTags.create(ResourceLocation.parse("c:barrels/wooden")))
                .addTag(BlockTags.create(ResourceLocation.parse("c:chests/wooden")))
                .addTag(BlockTags.create(ResourceLocation.parse("c:fences/wooden")))

                //NoTreePunchingRemastered Wooden Tags
                //.addTag(ModTags.Blocks.WOODEN_FENCE_GATES)
                .add(Blocks.CRAFTING_TABLE)
                .add(Blocks.CRAFTER);

        tag(ModTags.Blocks.WOODEN_FENCE_GATES)
                .add(Blocks.OAK_FENCE_GATE)
                .add(Blocks.SPRUCE_FENCE_GATE)
                .add(Blocks.BIRCH_FENCE_GATE)
                .add(Blocks.JUNGLE_FENCE_GATE)
                .add(Blocks.ACACIA_FENCE_GATE)
                .add(Blocks.DARK_OAK_FENCE_GATE)
                .add(Blocks.MANGROVE_FENCE_GATE)
                .add(Blocks.CHERRY_FENCE_GATE)
                .add(Blocks.BAMBOO_FENCE_GATE)
                .add(Blocks.CRIMSON_FENCE_GATE)
                .add(Blocks.WARPED_FENCE_GATE);
    }
}