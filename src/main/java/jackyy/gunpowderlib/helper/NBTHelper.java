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

    public static void setString(ItemStack stack, String key, String val) {
        getTag(stack).putString(key, val);
    }

    public static String getString(ItemStack stack, String key) {
        return hasTag(stack) ? getTag(stack).getString(key) : "";
    }

    public static void setBoolean(ItemStack stack, String key, boolean val) {
        getTag(stack).putBoolean(key, val);
    }

    public static boolean getBoolean(ItemStack stack, String key) {
        return getTag(stack).getBoolean(key);
    }

}
