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

}
