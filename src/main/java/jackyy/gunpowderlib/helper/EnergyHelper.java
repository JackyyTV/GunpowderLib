package jackyy.gunpowderlib.helper;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;

public class EnergyHelper {

    public static ItemStack setDefaultEnergyTag(ItemStack container, int energy) {
        if (!container.hasTag()) {
            container.setTag(new CompoundNBT());
        }
        container.getOrCreateTag().putInt("Energy", energy);
        return container;
    }

}
