package jackyy.gunpowderlib.helper;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModList;

import java.text.NumberFormat;
import java.util.Optional;

public class StringHelper {

    public static MutableComponent getTierText(String modid, int tier) {
        return localize(modid, "tooltip.tier", tier);
    }

    public static MutableComponent getShiftText(String modid) {
        return localize(modid, "tooltip.hold_shift", localize(modid, "tooltip.hold_shift.shift").withStyle(ChatFormatting.YELLOW, ChatFormatting.ITALIC)).withStyle(ChatFormatting.GRAY);
    }

    public static MutableComponent getCtrlText(String modid) {
        return localize(modid, "tooltip.hold_ctrl", localize(modid, "tooltip.hold_ctrl.ctrl").withStyle(ChatFormatting.AQUA, ChatFormatting.ITALIC)).withStyle(ChatFormatting.GRAY);
    }

    public static MutableComponent formatNumber(long number) {
        return Component.literal(NumberFormat.getInstance().format(number));
    }

    public static String getModNameByID(String modid) {
        Optional<? extends ModContainer> modContainer = ModList.get().getModContainerById(modid);
        if (modContainer.isPresent()) {
            return modContainer.get().getModInfo().getDisplayName();
        }
        return modid;
    }

    public static MutableComponent formatHarvestLevel(String modid, String harvestLevel) {
        Tier tier = TierSortingRegistry.byName(new ResourceLocation(modid, harvestLevel));
        if (tier == null) {
            return Component.literal("Unknown");
        }
        return Component.literal(TierSortingRegistry.getName(tier).toString());
    }

    public static MutableComponent formatHarvestLevel(String harvestLevel) {
        Tier tier = TierSortingRegistry.byName(new ResourceLocation(harvestLevel));
        if (tier == null) {
            return Component.literal("Unknown");
        }
        return Component.literal(TierSortingRegistry.getName(tier).toString());
    }

    public static MutableComponent localize(String modid, String unlocalized, Object... args) {
        String toLocalize = modid + "." + unlocalized;
        if (args != null && args.length > 0) {
            return Component.translatable(toLocalize, args);
        }
        else {
            return Component.translatable(toLocalize);
        }
    }

}
