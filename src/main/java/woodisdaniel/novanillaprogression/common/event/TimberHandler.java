package woodisdaniel.novanillaprogression.common.event;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import woodisdaniel.novanillaprogression.NoVanillaProgression;

@EventBusSubscriber(modid = NoVanillaProgression.MOD_ID)
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
                state.is(BlockTags.create(ResourceLocation.parse("minecraft:wooden_buttons")));
    }

    @SubscribeEvent
    public static void onBreakSpeed(PlayerEvent.BreakSpeed event) {
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