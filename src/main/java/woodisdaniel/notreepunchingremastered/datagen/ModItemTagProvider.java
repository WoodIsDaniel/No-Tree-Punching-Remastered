package woodisdaniel.notreepunchingremastered.datagen;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import woodisdaniel.notreepunchingremastered.NoTreePunchingRemastered;
import woodisdaniel.notreepunchingremastered.common.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import woodisdaniel.notreepunchingremastered.datagen.util.ModTags;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, NoTreePunchingRemastered.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.SAWS)
                .add(ModItems.COPPER_SAW.get())
                .add(ModItems.GOLDEN_SAW.get())
                .add(ModItems.IRON_SAW.get())
                .add(ModItems.STEEL_SAW.get())
                .add(ModItems.DIAMOND_SAW.get())
                .add(ModItems.NETHERITE_SAW.get());

        tag(ModTags.Items.KNIVES)
                .add(ModItems.FLINT_KNIFE.get())
                .add(ModItems.COPPER_KNIFE.get())
                .add(ModItems.GOLDEN_KNIFE.get())
                .add(ModItems.IRON_KNIFE.get())
                .add(ModItems.STEEL_KNIFE.get())
                .add(ModItems.DIAMOND_KNIFE.get())
                .add(ModItems.NETHERITE_KNIFE.get());

        tag(ModTags.Items.AXES)
                .add(ModItems.FLINT_AXE.get())
                .add(ModItems.COPPER_AXE.get())
                .add(Items.GOLDEN_AXE)
                .add(Items.IRON_AXE)
                .add(Items.DIAMOND_AXE)
                .add(Items.NETHERITE_AXE)
                .addOptional(ResourceLocation.fromNamespaceAndPath("immersiveengineering", "axe_steel"));

        tag(ItemTags.SWORDS)
                .add(ModItems.COPPER_SWORD.get())
                .addTag(ModTags.Items.KNIVES);;

        tag(ItemTags.PICKAXES)
                .add(ModItems.FLINT_PICKAXE.get())
                .add(ModItems.COPPER_PICKAXE.get());

        tag(ItemTags.AXES)
                .add(ModItems.FLINT_AXE.get())
                .add(ModItems.COPPER_AXE.get())
                .addTag(ModTags.Items.SAWS);

        tag(ItemTags.SHOVELS)
                .add(ModItems.FLINT_SHOVEL.get())
                .add(ModItems.COPPER_SHOVEL.get());

        tag(ItemTags.HOES)
                .add(ModItems.FLINT_HOE.get())
                .add(ModItems.COPPER_HOE.get());
    }
}