package jackyy.gunpowder.helper;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.oredict.OreDictionary;

public class ObjectHelper {

    public static Item getItemByName(String name) {
        return Item.REGISTRY.getObject(new ResourceLocation(name));
    }

    public static Item getItemByName(String modid, String name) {
        return Item.REGISTRY.getObject(new ResourceLocation(modid, name));
    }

    public static ItemStack getItemStackByName(String name, int amount, int meta) {
        return new ItemStack(getItemByName(name), amount, meta);
    }

    public static ItemStack getItemStackByName(String modid, String name, int amount, int meta) {
        return new ItemStack(getItemByName(modid, name), amount, meta);
    }

    public static ItemStack[] getStacksFromOreDict(String oredict) {
        NonNullList<ItemStack> stacks = OreDictionary.getOres(oredict);
        ItemStack[] oredictlist = new ItemStack[stacks.size()];
        oredictlist = stacks.toArray(oredictlist);
        return oredictlist;
    }

    public static Block getBlockByName(String name) {
        return Block.REGISTRY.getObject(new ResourceLocation(name));
    }

    public static Block getBlockByName(String modid, String name) {
        return Block.REGISTRY.getObject(new ResourceLocation(modid, name));
    }

    public static ItemStack getBlockStackByName(String name, int amount, int meta) {
        return new ItemStack(getBlockByName(name), amount, meta);
    }

    public static ItemStack getBlockStackByName(String modid, String name, int amount, int meta) {
        return new ItemStack(getBlockByName(modid, name), amount, meta);
    }

    public static SoundEvent getSoundByName(String modid, String name) {
        return SoundEvent.REGISTRY.getObject(new ResourceLocation(modid, name));
    }

    public static Potion getPotionByName(String modid, String name) {
        return Potion.REGISTRY.getObject(new ResourceLocation(modid, name));
    }

    public static PotionEffect getPotionEffectByName(String modid, String name) {
        return new PotionEffect(getPotionByName(modid, name));
    }

    public static PotionEffect getPotionEffectByName(String modid, String name, int duration) {
        return new PotionEffect(getPotionByName(modid, name), duration);
    }

    public static PotionEffect getPotionEffectByName(String modid, String name, int duration, int amplifier) {
        return new PotionEffect(getPotionByName(modid, name), duration, amplifier);
    }

    public static PotionEffect getPotionEffectByName(String modid, String name, int duration, int amplifier, boolean beacon, boolean particles) {
        return new PotionEffect(getPotionByName(modid, name), duration, amplifier, beacon, particles);
    }

    public static ItemStack getBotaniaFlower(String type) {
        ItemStack flower = getItemStackByName("botania", "specialflower", 1, 0);
        NBTTagCompound tag = new NBTTagCompound();
        tag.setString("type", type);
        flower.setTagCompound(tag);
        return flower;
    }

}
