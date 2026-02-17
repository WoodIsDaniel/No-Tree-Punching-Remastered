package woodisdaniel.novanillaprogression.common.gui;

import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.items.SlotItemHandler;

public class VesselMenu extends AbstractContainerMenu {
    private static final int CONTAINER_SIZE = 4;
    private final ItemStack vesselStack;
    private final ItemStackHandler itemHandler;
    private final Inventory playerInv;

    public VesselMenu(int containerId, Inventory playerInv, FriendlyByteBuf extraData) {
        this(containerId, playerInv, ItemStack.STREAM_CODEC.decode((RegistryFriendlyByteBuf) extraData));
    }

    public VesselMenu(int containerId, Inventory playerInv, ItemStack vesselStack) {
        super(ModMenuTypes.VESSEL_MENU.get(), containerId);
        this.vesselStack = vesselStack;
        this.playerInv = playerInv;

        this.itemHandler = new ItemStackHandler(CONTAINER_SIZE) {
            @Override
            protected void onContentsChanged(int slot) {
                saveDataToStack();
            }
        };

        // Load existing data
        loadDataFromStack();

        // Slots

        int startX = 71;
        int startY = 23;

        addSlot(new SlotItemHandler(itemHandler, 0, startX, startY));
        addSlot(new SlotItemHandler(itemHandler, 1, startX + 18, startY));
        addSlot(new SlotItemHandler(itemHandler, 2, startX, startY + 18));
        addSlot(new SlotItemHandler(itemHandler, 3, startX + 18, startY + 18));


        // Player Inventory
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                addSlot(new Slot(playerInv, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
            }
        }

        // Player Hotbar
        for (int col = 0; col < 9; col++) {
            addSlot(new Slot(playerInv, col, 8 + col * 18, 142));
        }
    }

    private void loadDataFromStack() {
        CustomData customData = vesselStack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
        CompoundTag tag = customData.copyTag();
        if (tag.contains("Inventory")) {
            itemHandler.deserializeNBT(playerInv.player.registryAccess(), tag.getCompound("Inventory"));
        }
    }

    private void saveDataToStack() {
        CompoundTag inventoryTag = itemHandler.serializeNBT(playerInv.player.registryAccess());
        CompoundTag baseTag = new CompoundTag();
        baseTag.put("Inventory", inventoryTag);

        CustomData.set(DataComponents.CUSTOM_DATA, vesselStack, baseTag);
    }

    @Override
    public ItemStack quickMoveStack(Player playerIn, int index) {
        ItemStack sourceStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot != null && slot.hasItem()) {
            ItemStack slotStack = slot.getItem();
            sourceStack = slotStack.copy();

            if (index < CONTAINER_SIZE) {
                if (!this.moveItemStackTo(slotStack, CONTAINER_SIZE, 36 + CONTAINER_SIZE, true)) {
                    return ItemStack.EMPTY;
                }
            }

            else {
                if (!this.moveItemStackTo(slotStack, 0, CONTAINER_SIZE, false)) {
                    return ItemStack.EMPTY;
                }
            }

            if (slotStack.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }
        return sourceStack;
    }

    @Override
    public boolean stillValid(Player player) {
        return player.getMainHandItem() == vesselStack || player.getOffhandItem() == vesselStack;
    }
}