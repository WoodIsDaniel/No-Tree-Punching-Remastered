package woodisdaniel.notreepunchingremastered.common;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import woodisdaniel.notreepunchingremastered.NoTreePunchingRemastered;
import woodisdaniel.notreepunchingremastered.common.block.ModBlocks;
import woodisdaniel.notreepunchingremastered.common.item.ModItems;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NoTreePunchingRemastered.MOD_ID);

    public static final Supplier<CreativeModeTab> NOTREEPUNCHING_MISC_TAB = CREATIVE_MODE_TAB.register("notreepunching_misc_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.GRASS_FIBER.get()))
                    .title(Component.translatable("creativetab.notreepunching.notreepunching_misc_items"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModBlocks.TIN_ORE);
                        output.accept(ModBlocks.DEEPSLATE_TIN_ORE);

                        output.accept(ModItems.GRASS_FIBER);
                        output.accept(ModItems.PLANT_STRING);
                        output.accept(ModItems.FLINT_SHARD);

                        output.accept(ModItems.CLAY_VESSEL);
                        output.accept(ModItems.CERAMIC_VESSEL);

                    }).build());

    public static final Supplier<CreativeModeTab> NOTREEPUNCHING_TOOLS_TAB = CREATIVE_MODE_TAB.register("notreepunching_tools_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.FLINT_PICKAXE.get()))
                    .title(Component.translatable("creativetab.notreepunching.notreepunching_tool_items"))
                    .displayItems((itemDisplayParameters, output) -> {

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

                        output.accept(ModItems.IRON_KNIFE);
                        output.accept(ModItems.IRON_SAW);

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}