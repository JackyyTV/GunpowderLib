package jackyy.gunpowderlib.capability;

import net.minecraft.item.ItemStack;
import net.minecraftforge.energy.IEnergyStorage;

public class FEStorageCapability implements IEnergyStorage {

    public ItemStack stack;
    public IFEContainer container;

    public FEStorageCapability(IFEContainer container, ItemStack stack) {
        this.stack = stack;
        this.container = container;
    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        return container.receiveEnergy(stack, maxReceive, simulate);
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        return container.extractEnergy(stack, maxExtract, simulate);
    }

    @Override
    public int getEnergyStored() {
        return container.getEnergyStored(stack);
    }

    @Override
    public int getMaxEnergyStored() {
        return container.getMaxEnergyStored(stack);
    }

    @Override
    public boolean canExtract() {
        return true;
    }

    @Override
    public boolean canReceive() {
        return true;
    }

}
