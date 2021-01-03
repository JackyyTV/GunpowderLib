package jackyy.gunpowderlib.helper;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class ObjectHelper {

    public static Item getItemByName(String path) {
        return ForgeRegistries.ITEMS.getValue(new ResourceLocation(path));
    }

    public static Item getItemByName(String namespace, String path) {
        return ForgeRegistries.ITEMS.getValue(new ResourceLocation(namespace, path));
    }

    public static ItemStack getItemStackByName(String path, int amount) {
        return new ItemStack(getItemByName(path), amount);
    }

    public static ItemStack getItemStackByName(String namespace, String path, int amount) {
        return new ItemStack(getItemByName(namespace, path), amount);
    }

    public static Block getBlockByName(String path) {
        return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(path));
    }

    public static Block getBlockByName(String namespace, String path) {
        return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(namespace, path));
    }

    public static ItemStack getBlockStackByName(String path, int amount) {
        return new ItemStack(getBlockByName(path), amount);
    }

    public static ItemStack getBlockStackByName(String namespace, String path, int amount) {
        return new ItemStack(getBlockByName(namespace, path), amount);
    }

    public static ItemStack getStackWithNBT(ItemStack stack, CompoundNBT nbt) {
        stack.setTag(nbt);
        return stack;
    }

    public static ITag<Item> getItemsFromTag(String namespace, String path) {
        return ItemTags.getCollection().get(new ResourceLocation(namespace, path));
    }

    public static SoundEvent getSoundByName(String namespace, String path) {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(namespace, path));
    }

    public static Effect getPotionByName(String namespace, String path) {
        return ForgeRegistries.POTIONS.getValue(new ResourceLocation(namespace, path));
    }

    public static EffectInstance getPotionEffectByName(String namespace, String path) {
        return new EffectInstance(getPotionByName(namespace, path));
    }

    public static EffectInstance getPotionEffectByName(String namespace, String path, int duration) {
        return new EffectInstance(getPotionByName(namespace, path), duration);
    }

    public static EffectInstance getPotionEffectByName(String namespace, String path, int duration, int amplifier) {
        return new EffectInstance(getPotionByName(namespace, path), duration, amplifier);
    }

    public static EffectInstance getPotionEffectByName(String namespace, String path, int duration, int amplifier, boolean ambient, boolean particles) {
        return new EffectInstance(getPotionByName(namespace, path), duration, amplifier, ambient, particles);
    }

    public static ItemStack getBotaniaFlower(String type) {
        CompoundNBT tag = new CompoundNBT();
        tag.putString("type", type);
        return getStackWithNBT(getItemStackByName("botania", "specialflower", 1), tag);
    }

}
