package woodisdaniel.notreepunchingremastered.common.event;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockEvent;
import woodisdaniel.notreepunchingremastered.NoTreePunchingRemastered;
import woodisdaniel.notreepunchingremastered.datagen.util.ModTags;

@EventBusSubscriber(modid = NoTreePunchingRemastered.MOD_ID)
public class StickDropHandler {

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {

        Player player = event.getPlayer();
        BlockState state = event.getState();
        Level level = (Level) event.getLevel();
        BlockPos pos = event.getPos();

        if (state.is(BlockTags.LEAVES)) {

            ItemStack heldItem = player.getMainHandItem();

            if (heldItem.is(ModTags.Items.KNIVES)) {

                if (!level.isClientSide()) {


                    if (event.getLevel().getRandom().nextInt(10) == 0) {

                        int amount = 1;

                        Block.popResource(level, pos, new ItemStack(Items.STICK, amount));
                    }
                }
            }
        }
    }
}