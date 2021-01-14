package jackyy.gunpowderlib.capability;

import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class FEItemStackCapability implements ICapabilityProvider {

    public IEnergyStorage instance;

    public FEItemStackCapability(IEnergyStorage instance) {
        this.instance = instance;
    }

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        return this.getCapability(capability, facing) != null;
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        if (capability == CapabilityEnergy.ENERGY) {
            return CapabilityEnergy.ENERGY.cast(this.instance);
        }
        return null;
    }

}
