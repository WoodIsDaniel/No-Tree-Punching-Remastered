package woodisdaniel.novanillaprogression.datagen;

import net.minecraft.world.level.block.Blocks;
import woodisdaniel.novanillaprogression.NoVanillaProgression;
import woodisdaniel.novanillaprogression.common.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import woodisdaniel.novanillaprogression.datagen.util.ModTags;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.tags.BlockTags.*;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, NoVanillaProgression.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.TIN_ORE.get())
                .add(ModBlocks.DEEPSLATE_TIN_ORE.get())
                .add(ModBlocks.TIN_BLOCK.get())
                .add(ModBlocks.BRONZE_BLOCK.get());

        tag(ModTags.Blocks.INCORRECT_FOR_FLINT_TOOL)
                .addTag(INCORRECT_FOR_WOODEN_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_COPPER_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_STONE_TOOL)
                .remove(NEEDS_STONE_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_BRONZE_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_STONE_TOOL)
                .remove(NEEDS_STONE_TOOL);

        tag(BlockTags.NEEDS_STONE_TOOL)
                .remove(Blocks.COPPER_ORE)
                .remove(Blocks.DEEPSLATE_COPPER_ORE);
    }
}