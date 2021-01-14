package jackyy.gunpowderlib.helper;

import jackyy.gunpowderlib.capability.FEStorageCapability;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.energy.CapabilityEnergy;

public class EnergyHelper {

    public static final String ENERGY_NBT = "Energy";

    public static ItemStack setDefaultEnergyTag(ItemStack container, int energy) {
        if (!container.hasTagCompound()) {
            container.setTagCompound(new NBTTagCompound());
        }
        container.getTagCompound().setInteger(ENERGY_NBT, energy);
        return container;
    }

    public static int receiveEnergy(ItemStack container, int maxReceive, boolean simulate) {
        if (!container.hasTagCompound()) {
            setDefaultEnergyTag(container, 0);
        }
        int stored = getEnergyStored(container);
        int received = Math.min(getMaxEnergyStored(container) - stored, Math.min(getMaxEnergyStored(container) / 4, maxReceive));
        if (!simulate) {
            stored += received;
            NBTHelper.setInt(container, ENERGY_NBT, stored);
        }
        return received;
    }

    public static int extractEnergy(ItemStack container, int maxExtract, boolean simulate) {
        if (container.hasTagCompound() && !container.getTagCompound().hasKey(ENERGY_NBT)) {
            return 0;
        }
        int stored = getEnergyStored(container);
        int extracted = Math.min(stored, Math.min(getMaxEnergyStored(container) / 4, maxExtract));
        if (!simulate) {
            stored -= extracted;
            NBTHelper.setInt(container, ENERGY_NBT, stored);
        }
        return extracted;
    }

    public static int getEnergyStored(ItemStack stack) {
        FEStorageCapability storage = (FEStorageCapability) stack.getCapability(CapabilityEnergy.ENERGY, null);
        return storage != null ? storage.getEnergyStored() : 0;
    }

    public static int getMaxEnergyStored(ItemStack stack) {
        FEStorageCapability storage = (FEStorageCapability) stack.getCapability(CapabilityEnergy.ENERGY, null);
        return storage != null ? storage.getMaxEnergyStored() : 0;
    }

}
