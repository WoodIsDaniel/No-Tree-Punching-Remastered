package woodisdaniel.notreepunchingremastered.datagen;

import woodisdaniel.notreepunchingremastered.NoTreePunchingRemastered;
import woodisdaniel.notreepunchingremastered.common.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, NoTreePunchingRemastered.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.GRASS_FIBER.get());
        basicItem(ModItems.PLANT_STRING.get());
        basicItem(ModItems.FLINT_SHARD.get());
        basicItem(ModItems.CLAY_VESSEL.get());
        basicItem(ModItems.CERAMIC_VESSEL.get());

        handheldItem(ModItems.FLINT_PICKAXE);
        handheldItem(ModItems.FLINT_SHOVEL);
        handheldItem(ModItems.FLINT_AXE);
        handheldItem(ModItems.FLINT_HOE);
        handheldItem(ModItems.FLINT_KNIFE);

        handheldItem(ModItems.COPPER_SWORD);
        handheldItem(ModItems.COPPER_PICKAXE);
        handheldItem(ModItems.COPPER_SHOVEL);
        handheldItem(ModItems.COPPER_AXE);
        handheldItem(ModItems.COPPER_HOE);
        handheldItem(ModItems.COPPER_KNIFE);
        handheldItem(ModItems.COPPER_SAW);

        handheldItem(ModItems.IRON_KNIFE);
        handheldItem(ModItems.IRON_SAW);
    }

    private ItemModelBuilder handheldItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(NoTreePunchingRemastered.MOD_ID,"item/tool/" + item.getId().getPath()));
    }

    private ItemModelBuilder metalItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(NoTreePunchingRemastered.MOD_ID, "item/metal/" + item.getId().getPath()));
    }
}