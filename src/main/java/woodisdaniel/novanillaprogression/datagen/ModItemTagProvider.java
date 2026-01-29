package woodisdaniel.novanillaprogression.datagen;

import net.minecraft.world.item.Items;
import woodisdaniel.novanillaprogression.NoVanillaProgression;
import woodisdaniel.novanillaprogression.common.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import woodisdaniel.novanillaprogression.datagen.util.ModTags;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, NoVanillaProgression.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.TIN_INGOTS)
                .add(ModItems.TIN_INGOT.get());
        tag(ModTags.Items.BRONZE_INGOTS)
                .add(ModItems.BRONZE_INGOT.get());

        tag(ModTags.Items.SAWS)
                .add(ModItems.COPPER_SAW.get())
                .add(ModItems.BRONZE_SAW.get())
                .add(ModItems.IRON_SAW.get());
        tag(ModTags.Items.KNIVES)
                .add(ModItems.FLINT_KNIFE.get())
                .add(ModItems.COPPER_KNIFE.get())
                .add(ModItems.BRONZE_KNIFE.get())
                .add(ModItems.IRON_KNIFE.get());
        tag(ModTags.Items.AXES)
                .add(ModItems.FLINT_AXE.get())
                .add(ModItems.COPPER_AXE.get())
                .add(ModItems.BRONZE_AXE.get())
                .add(Items.GOLDEN_AXE)
                .add(Items.IRON_AXE)
                .add(Items.DIAMOND_AXE)
                .add(Items.NETHERITE_AXE);

        tag(ItemTags.SWORDS)
                .add(ModItems.COPPER_SWORD.get())
                .add(ModItems.BRONZE_SWORD.get())
                .add(ModItems.FLINT_KNIFE.get())
                .add(ModItems.COPPER_KNIFE.get())
                .add(ModItems.BRONZE_KNIFE.get())
                .add(ModItems.IRON_KNIFE.get());
        tag(ItemTags.PICKAXES)
                .add(ModItems.FLINT_PICKAXE.get())
                .add(ModItems.COPPER_PICKAXE.get())
                .add(ModItems.BRONZE_PICKAXE.get());
        tag(ItemTags.AXES)
                .add(ModItems.FLINT_AXE.get())
                .add(ModItems.COPPER_AXE.get())
                .add(ModItems.BRONZE_AXE.get())
                .add(ModItems.COPPER_SAW.get())
                .add(ModItems.BRONZE_SAW.get())
                .add(ModItems.IRON_SAW.get());
        tag(ItemTags.SHOVELS)
                .add(ModItems.FLINT_SHOVEL.get())
                .add(ModItems.COPPER_SHOVEL.get())
                .add(ModItems.BRONZE_SHOVEL.get());
        tag(ItemTags.HOES)
                .add(ModItems.FLINT_HOE.get())
                .add(ModItems.COPPER_HOE.get())
                .add(ModItems.BRONZE_HOE.get());

    }
}