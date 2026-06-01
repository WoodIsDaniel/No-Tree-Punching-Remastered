package woodisdaniel.notreepunchingremastered.common.item;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import woodisdaniel.notreepunchingremastered.common.gui.VesselMenu;

public class VesselItem extends Item {

    public VesselItem(Properties properties) {
        super(properties.stacksTo(1));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!level.isClientSide && player instanceof ServerPlayer serverPlayer) {
            serverPlayer.openMenu(new SimpleMenuProvider(
                    // Create the menu on the server
                    (pContainerId, pPlayerInventory, pPlayer) -> new VesselMenu(pContainerId, pPlayerInventory, stack),
                    // Title
                    Component.literal("Ceramic Vessel")
            ), (buf) -> {
                // Send the item stack to the client so it knows what to display
                ItemStack.STREAM_CODEC.encode(buf, stack);
            });
        }

        return InteractionResultHolder.success(stack);
    }
}