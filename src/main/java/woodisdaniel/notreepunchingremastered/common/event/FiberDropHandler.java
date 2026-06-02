package woodisdaniel.notreepunchingremastered.common.event;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockEvent;
import woodisdaniel.notreepunchingremastered.NoTreePunchingRemastered;
import woodisdaniel.notreepunchingremastered.common.item.ModItems;
import woodisdaniel.notreepunchingremastered.datagen.util.ModTags;

@EventBusSubscriber(modid = NoTreePunchingRemastered.MOD_ID)
public class FiberDropHandler {

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {

        Player player = event.getPlayer();
        BlockState state = event.getState();
        Level level = (Level) event.getLevel();
        BlockPos pos = event.getPos();

        if (state.getBlock() == Blocks.SHORT_GRASS || state.getBlock() == Blocks.TALL_GRASS) {

            ItemStack heldItem = player.getMainHandItem();

            if (heldItem.is(ModTags.Items.KNIVES)) {

                if (!level.isClientSide()) {


                    if (event.getLevel().getRandom().nextInt(4) == 0) {

                        int amount = 1 + event.getLevel().getRandom().nextInt(2);

                        Block.popResource(level, pos, new ItemStack(ModItems.GRASS_FIBER.get(), amount));
                    }


/*
                    ItemStack fiber = new ItemStack(ModItems.GRASS_FIBER.get(), (int)(Math.random() * 50 + 1));

                    net.minecraft.world.entity.item.ItemEntity itemEntity = new net.minecraft.world.entity.item.ItemEntity(
                            level,
                            pos.getX() + 0.5,
                            pos.getY() + 0.5,
                            pos.getZ() + 0.5,
                            fiber
                    );
                    level.addFreshEntity(itemEntity);
*/
                }
            }
        }
    }
}
