package jackyy.gunpowderlib.helper;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.tags.ITag;

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

    public static ItemStack getStackWithNBT(ItemStack stack, CompoundTag nbt) {
        stack.setTag(nbt);
        return stack;
    }

    public static ITag<Item> getItemsFromTag(String namespace, String path) {
        return ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation(namespace, path)));
    }

    public static ITag<Item> getItemsFromTag(TagKey<Item> tagKey) {
        return ForgeRegistries.ITEMS.tags().getTag(tagKey);
    }

    public static SoundEvent getSoundByName(String namespace, String path) {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(namespace, path));
    }

    public static MobEffect getPotionByName(String namespace, String path) {
        return ForgeRegistries.MOB_EFFECTS.getValue(new ResourceLocation(namespace, path));
    }

    public static MobEffectInstance getPotionEffectByName(String namespace, String path) {
        return new MobEffectInstance(getPotionByName(namespace, path));
    }

    public static MobEffectInstance getPotionEffectByName(String namespace, String path, int duration) {
        return new MobEffectInstance(getPotionByName(namespace, path), duration);
    }

    public static MobEffectInstance getPotionEffectByName(String namespace, String path, int duration, int amplifier) {
        return new MobEffectInstance(getPotionByName(namespace, path), duration, amplifier);
    }

    public static MobEffectInstance getPotionEffectByName(String namespace, String path, int duration, int amplifier, boolean ambient, boolean particles) {
        return new MobEffectInstance(getPotionByName(namespace, path), duration, amplifier, ambient, particles);
    }

    public static ItemStack getBotaniaFlower(String type) {
        CompoundTag tag = new CompoundTag();
        tag.putString("type", type);
        return getStackWithNBT(getItemStackByName("botania", "specialflower", 1), tag);
    }

}
