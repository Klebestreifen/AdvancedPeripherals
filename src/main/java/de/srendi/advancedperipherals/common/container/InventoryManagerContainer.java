package de.srendi.advancedperipherals.common.container;

import de.srendi.advancedperipherals.common.container.base.BaseContainer;
import de.srendi.advancedperipherals.common.container.base.SlotCondition;
import de.srendi.advancedperipherals.common.container.base.SlotInputHandler;
import de.srendi.advancedperipherals.common.setup.ContainerTypes;
import de.srendi.advancedperipherals.common.setup.Items;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.CapabilityItemHandler;

public class InventoryManagerContainer extends BaseContainer {

    public InventoryManagerContainer(int id, Inventory inventory, BlockPos pos, Level level) {
        super(ContainerTypes.INVENTORY_MANAGER_CONTAINER.get(), id, inventory, pos, level);
        layoutPlayerInventorySlots(7, 84);
        if (tileEntity != null) {
            tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(handler -> {
                addSlot(new SlotInputHandler(handler, 0, 79, 29, new SlotCondition().setNeededItem(Items.MEMORY_CARD.get()))); //Input
            });
        }
    }

    @Override
    public boolean stillValid(Player playerIn) {
        return true;
    }
}
