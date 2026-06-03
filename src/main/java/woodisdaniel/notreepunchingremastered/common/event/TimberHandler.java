package woodisdaniel.notreepunchingremastered.common.event;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import woodisdaniel.notreepunchingremastered.Config;
import woodisdaniel.notreepunchingremastered.NoTreePunchingRemastered;

@EventBusSubscriber(modid = NoTreePunchingRemastered.MOD_ID)
public class TimberHandler {

    private static boolean isLogOrPlank(BlockState state) {
        return state.is(BlockTags.create(ResourceLocation.parse("minecraft:logs"))) ||
                state.is(BlockTags.create(ResourceLocation.parse("minecraft:planks"))) ||
                state.is(BlockTags.create(ResourceLocation.parse("minecraft:wooden_slabs"))) ||
                state.is(BlockTags.create(ResourceLocation.parse("minecraft:wooden_stairs"))) ||
                state.is(BlockTags.create(ResourceLocation.parse("minecraft:wooden_trapdoors"))) ||
                state.is(BlockTags.create(ResourceLocation.parse("minecraft:wooden_pressure_plates"))) ||
                state.is(BlockTags.create(ResourceLocation.parse("minecraft:wooden_fences"))) ||
                state.is(BlockTags.create(ResourceLocation.parse("minecraft:wooden_doors"))) ||
                state.is(BlockTags.create(ResourceLocation.parse("minecraft:wooden_buttons"))) ||
                state.is(BlockTags.create(ResourceLocation.parse("c:wooden_gates"))) ||
                state.is(BlockTags.create(ResourceLocation.parse("notreepunchingremastered:misc_wooden_block")));
    }

    @SubscribeEvent
    public static void onBreakSpeed(PlayerEvent.BreakSpeed event) {

        if (Config.DISABLE_TIMBERHANDLER.get()) return;

        BlockState state = event.getState();
        Player player = event.getEntity();

        if (isLogOrPlank(state)) {

            ItemStack heldItem = player.getMainHandItem();

            boolean hasAxe = heldItem.is(ItemTags.create(ResourceLocation.parse("minecraft:axes")));

            if (!hasAxe) {
                event.setNewSpeed(event.getOriginalSpeed() / 2.0f);
            }
        }
    }

    @SubscribeEvent
    public static void onHarvestCheck(PlayerEvent.HarvestCheck event) {

        if (Config.DISABLE_TIMBERHANDLER.get()) return;

        BlockState state = event.getTargetBlock();
        Player player = event.getEntity();

        if (isLogOrPlank(state)) {

            ItemStack heldItem = player.getMainHandItem();
            boolean hasAxe = heldItem.is(ItemTags.create(ResourceLocation.parse("minecraft:axes")));

            if (!hasAxe) {
                event.setCanHarvest(false);
            }
        }
    }
}