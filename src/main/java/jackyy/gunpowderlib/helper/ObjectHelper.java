package jackyy.gunpowderlib.helper;

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

    public static Item getItemByName(String path) {
        return Item.REGISTRY.getObject(new ResourceLocation(path));
    }

    public static Item getItemByName(String namespace, String path) {
        return Item.REGISTRY.getObject(new ResourceLocation(namespace, path));
    }

    public static ItemStack getItemStackByName(String path, int amount, int meta) {
        return new ItemStack(getItemByName(path), amount, meta);
    }

    public static ItemStack getItemStackByName(String namespace, String path, int amount, int meta) {
        return new ItemStack(getItemByName(namespace, path), amount, meta);
    }

    public static ItemStack getStackWithNBT(ItemStack stack, NBTTagCompound nbt) {
        stack.setTagCompound(nbt);
        return stack;
    }

    public static ItemStack[] getStacksFromOreDict(String oredict) {
        NonNullList<ItemStack> stacks = OreDictionary.getOres(oredict);
        ItemStack[] oredictlist = new ItemStack[stacks.size()];
        oredictlist = stacks.toArray(oredictlist);
        return oredictlist;
    }

    public static Block getBlockByName(String path) {
        return Block.REGISTRY.getObject(new ResourceLocation(path));
    }

    public static Block getBlockByName(String namespace, String path) {
        return Block.REGISTRY.getObject(new ResourceLocation(namespace, path));
    }

    public static ItemStack getBlockStackByName(String path, int amount, int meta) {
        return new ItemStack(getBlockByName(path), amount, meta);
    }

    public static ItemStack getBlockStackByName(String namespace, String path, int amount, int meta) {
        return new ItemStack(getBlockByName(namespace, path), amount, meta);
    }

    public static SoundEvent getSoundByName(String namespace, String path) {
        return SoundEvent.REGISTRY.getObject(new ResourceLocation(namespace, path));
    }

    public static Potion getPotionByName(String namespace, String path) {
        return Potion.REGISTRY.getObject(new ResourceLocation(namespace, path));
    }

    public static PotionEffect getPotionEffectByName(String namespace, String path) {
        return new PotionEffect(getPotionByName(namespace, path));
    }

    public static PotionEffect getPotionEffectByName(String namespace, String path, int duration) {
        return new PotionEffect(getPotionByName(namespace, path), duration);
    }

    public static PotionEffect getPotionEffectByName(String namespace, String path, int duration, int amplifier) {
        return new PotionEffect(getPotionByName(namespace, path), duration, amplifier);
    }

    public static PotionEffect getPotionEffectByName(String namespace, String path, int duration, int amplifier, boolean beacon, boolean particles) {
        return new PotionEffect(getPotionByName(namespace, path), duration, amplifier, beacon, particles);
    }

    public static ItemStack getBotaniaFlower(String type) {
        NBTTagCompound tag = new NBTTagCompound();
        tag.setString("type", type);
        return getStackWithNBT(getItemStackByName("botania", "specialflower", 1, 0), tag);
    }

}
