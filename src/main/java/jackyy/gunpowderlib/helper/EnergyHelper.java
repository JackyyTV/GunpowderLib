package jackyy.gunpowderlib.helper;

import jackyy.gunpowderlib.capability.FEStorageCapability;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.energy.CapabilityEnergy;

public class EnergyHelper {

    public static ItemStack setDefaultEnergyTag(ItemStack stack, int energy) {
        if (!stack.hasTag()) {
            stack.setTag(new CompoundNBT());
        }
        stack.getOrCreateTag().putInt("energy", energy);
        return stack;
    }

    public static int getEnergyStored(ItemStack stack) {
        FEStorageCapability storage = (FEStorageCapability) stack.getCapability(CapabilityEnergy.ENERGY, null).orElse(null);
        return storage.getEnergyStored();
    }

    public static void setEnergyStored(ItemStack stack, int amount) {
        FEStorageCapability storage = (FEStorageCapability) stack.getCapability(CapabilityEnergy.ENERGY, null).orElse(null);
        storage.setEnergy(amount);
    }

    public static void addEnergyStored(ItemStack stack, int amount) {
        FEStorageCapability storage = (FEStorageCapability) stack.getCapability(CapabilityEnergy.ENERGY, null).orElse(null);
        storage.addEnergy(amount);
    }

}
