package woodisdaniel.novanillaprogression.common;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import woodisdaniel.novanillaprogression.NoVanillaProgression;
import net.minecraft.world.item.Items;
import woodisdaniel.novanillaprogression.common.block.ModBlocks;
import woodisdaniel.novanillaprogression.common.item.ModItems;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NoVanillaProgression.MOD_ID);

    public static final Supplier<CreativeModeTab> NOVAILLAPROGRESSION_MISC_TAB = CREATIVE_MODE_TAB.register("novanillaprogression_misc_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.GRASS_FIBER.get()))
                    .title(Component.translatable("creativetab.novanillaprogression.novanillaprogression_misc_items"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModBlocks.TIN_ORE);
                        output.accept(ModBlocks.DEEPSLATE_TIN_ORE);
                        output.accept(ModItems.RAW_TIN);
                        output.accept(ModItems.TIN_INGOT);
                        output.accept(ModItems.TIN_NUGGET);
                        output.accept(ModBlocks.TIN_BLOCK);
                        output.accept(ModItems.BRONZE_INGOT);
                        output.accept(ModItems.BRONZE_NUGGET);
                        output.accept(ModBlocks.BRONZE_BLOCK);

                        output.accept(ModItems.GRASS_FIBER);
                        output.accept(ModItems.PLANT_STRING);
                        output.accept(ModItems.FLINT_SHARD);

                    }).build());

    public static final Supplier<CreativeModeTab> NOVAILLAPROGRESSION_TOOLS_TAB = CREATIVE_MODE_TAB.register("novanillaprogression_tools_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.FLINT_PICKAXE.get()))
                    .title(Component.translatable("creativetab.novanillaprogression.novanillaprogression_tool_items"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(Items.WOODEN_SWORD);
                        output.accept(ModItems.FLINT_PICKAXE);
                        output.accept(ModItems.FLINT_AXE);
                        output.accept(ModItems.FLINT_SHOVEL);
                        output.accept(ModItems.FLINT_HOE);
                        output.accept(ModItems.FLINT_KNIFE);

                        output.accept(ModItems.COPPER_SWORD);
                        output.accept(ModItems.COPPER_PICKAXE);
                        output.accept(ModItems.COPPER_AXE);
                        output.accept(ModItems.COPPER_SHOVEL);
                        output.accept(ModItems.COPPER_HOE);
                        output.accept(ModItems.COPPER_KNIFE);
                        output.accept(ModItems.COPPER_SAW);

                        output.accept(ModItems.BRONZE_SWORD);
                        output.accept(ModItems.BRONZE_PICKAXE);
                        output.accept(ModItems.BRONZE_AXE);
                        output.accept(ModItems.BRONZE_SHOVEL);
                        output.accept(ModItems.BRONZE_HOE);
                        output.accept(ModItems.BRONZE_KNIFE);
                        output.accept(ModItems.BRONZE_SAW);

                        output.accept(ModItems.IRON_KNIFE);
                        output.accept(ModItems.IRON_SAW);

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}