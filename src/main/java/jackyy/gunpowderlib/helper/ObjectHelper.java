package jackyy.gunpowderlib.helper;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class ObjectHelper {

    public static Item getItemByName(String name) {
        return ForgeRegistries.ITEMS.getValue(new ResourceLocation(name));
    }

    public static Item getItemByName(String modid, String name) {
        return ForgeRegistries.ITEMS.getValue(new ResourceLocation(modid, name));
    }

    public static ItemStack getItemStackByName(String name, int amount) {
        return new ItemStack(getItemByName(name), amount);
    }

    public static ItemStack getItemStackByName(String modid, String name, int amount) {
        return new ItemStack(getItemByName(modid, name), amount);
    }

    /*
    TODO Use new tags system
    public static ItemStack[] getStacksFromOreDict(String oredict) {
        NonNullList<ItemStack> stacks = OreDictionary.getOres(oredict);
        ItemStack[] oredictlist = new ItemStack[stacks.size()];
        oredictlist = stacks.toArray(oredictlist);;
        return oredictlist;
    }
    */

    public static Block getBlockByName(String name) {
        return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(name));
    }

    public static Block getBlockByName(String modid, String name) {
        return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(modid, name));
    }

    public static ItemStack getBlockStackByName(String name, int amount) {
        return new ItemStack(getBlockByName(name), amount);
    }

    public static ItemStack getBlockStackByName(String modid, String name, int amount) {
        return new ItemStack(getBlockByName(modid, name), amount);
    }

    public static ItemStack getStackWithNBT(ItemStack stack, CompoundNBT nbt) {
        stack.setTag(nbt);
        return stack;
    }

    public static SoundEvent getSoundByName(String modid, String name) {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(modid, name));
    }

    public static Effect getPotionByName(String modid, String name) {
        return ForgeRegistries.POTIONS.getValue(new ResourceLocation(modid, name));
    }

    public static EffectInstance getPotionEffectByName(String modid, String name) {
        return new EffectInstance(getPotionByName(modid, name));
    }

    public static EffectInstance getPotionEffectByName(String modid, String name, int duration) {
        return new EffectInstance(getPotionByName(modid, name), duration);
    }

    public static EffectInstance getPotionEffectByName(String modid, String name, int duration, int amplifier) {
        return new EffectInstance(getPotionByName(modid, name), duration, amplifier);
    }

    public static EffectInstance getPotionEffectByName(String modid, String name, int duration, int amplifier, boolean beacon, boolean particles) {
        return new EffectInstance(getPotionByName(modid, name), duration, amplifier, beacon, particles);
    }

    public static ItemStack getBotaniaFlower(String type) {
        CompoundNBT tag = new CompoundNBT();
        tag.putString("type", type);
        return getStackWithNBT(getItemStackByName("botania", "specialflower", 1), tag);
    }

}
