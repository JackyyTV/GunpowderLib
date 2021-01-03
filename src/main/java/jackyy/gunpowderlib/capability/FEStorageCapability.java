package jackyy.gunpowderlib.capability;

import jackyy.gunpowderlib.helper.StringHelper;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.energy.EnergyStorage;

public class FEStorageCapability extends EnergyStorage implements INBTSerializable<CompoundNBT> {

    public FEStorageCapability(int capacity, int maxTransfer) {
        super(capacity, maxTransfer);
    }

    public void setEnergy(int energyIn) {
        if (energyIn < 0) {
            energyIn = 0;
        }
        if (energyIn > getMaxEnergyStored()) {
            energyIn = getEnergyStored();
        }
        this.energy = energyIn;
    }

    public void addEnergy(int energy) {
        this.energy += energy;
        if (this.energy > getMaxEnergyStored()) {
            this.energy = getEnergyStored();
        }
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT tag = new CompoundNBT();
        tag.putInt(StringHelper.ENERGY_NBT, getEnergyStored());
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        setEnergy(nbt.getInt(StringHelper.ENERGY_NBT));
    }

}
