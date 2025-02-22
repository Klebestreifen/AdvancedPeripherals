package de.srendi.advancedperipherals.common.blocks.tileentity;

import de.srendi.advancedperipherals.common.addons.computercraft.peripheral.EnvironmentDetectorPeripheral;
import de.srendi.advancedperipherals.common.blocks.base.PoweredPeripheralTileEntity;
import de.srendi.advancedperipherals.common.configuration.APConfig;
import de.srendi.advancedperipherals.common.setup.TileEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class EnvironmentDetectorTile extends PoweredPeripheralTileEntity<EnvironmentDetectorPeripheral> {

    public EnvironmentDetectorTile(BlockPos pos, BlockState state) {
        super(TileEntityTypes.ENVIRONMENT_DETECTOR.get(), pos, state);
    }

    @Override
    protected int getMaxEnergyStored() {
        return APConfig.PERIPHERALS_CONFIG.POWERED_PERIPHERAL_MAX_ENERGY_STORAGE.get();
    }

    @NotNull
    @Override
    protected EnvironmentDetectorPeripheral createPeripheral() {
        return new EnvironmentDetectorPeripheral(this);
    }

}
