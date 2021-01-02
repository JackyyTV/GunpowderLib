package jackyy.gunpowderlib.helper;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;

public class NBTHelper {

    public static CompoundNBT getTag(ItemStack stack) {
        if (!stack.hasTag())
            stack.setTag(new CompoundNBT());
        return stack.getTag();
    }

    public static boolean hasTag(ItemStack stack) {
        return stack.hasTag();
    }

    public static void setInt(ItemStack stack, String key, int val) {
        getTag(stack).putInt(key, val);
    }

    public static int getInt(ItemStack stack, String key) {
        return hasTag(stack) ? getTag(stack).getInt(key) : 0;
    }

    public static int receiveEnergy(ItemStack container, int energy, int maxEnergy, boolean simulate) {
        int stored = getEnergyStored(container);
        int accepted = Math.min(energy, maxEnergy - stored);
        if (!simulate) {
            stored += accepted;
            setInt(container, "Energy", stored);
        }
        return accepted;
    }

    public static int extractEnergy(ItemStack container, int energy, boolean simulate) {
        int stored = getEnergyStored(container);
        int extracted = Math.min(energy, stored);
        if (!simulate) {
            stored -= extracted;
            setInt(container, "Energy", stored);
        }
        return extracted;
    }

    public static int getEnergyStored(ItemStack container) {
        return getInt(container, "Energy");
    }

}
