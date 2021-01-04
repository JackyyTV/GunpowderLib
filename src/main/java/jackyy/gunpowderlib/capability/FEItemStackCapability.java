package jackyy.gunpowderlib.capability;

import jackyy.gunpowderlib.helper.StringHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;

import javax.annotation.Nullable;

public class FEItemStackCapability implements ICapabilityProvider {

    private LazyOptional<IEnergyStorage> energy;
    private int max;
    private ItemStack stack;

    public FEItemStackCapability(final ItemStack stack, int capacity) {
        this.max = capacity;
        this.stack = stack;
        energy = LazyOptional.of(this::createEnergy);
    }

    private IEnergyStorage createEnergy() {
        return new FEStorageCapability(max, max / 4) {
            @Override
            public int getEnergyStored() {
                if (stack.hasTag()) {
                    return stack.getOrCreateTag().getInt(StringHelper.ENERGY_NBT);
                }
                else {
                    return super.getEnergyStored();
                }
            }
            @Override
            public void setEnergy(int energy) {
                if (!stack.hasTag()) {
                    stack.setTag(new CompoundNBT());
                }
                stack.getOrCreateTag().putInt(StringHelper.ENERGY_NBT, energy);
                super.setEnergy(energy);
            }
        };
    }

    @Override @Nullable
    public <T> LazyOptional<T> getCapability(Capability<T> capability, Direction facing) {
        if (CapabilityEnergy.ENERGY == capability)
            return energy.cast();
        return LazyOptional.empty();
    }

}
