package jackyy.gunpowderlib.helper;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
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
        return new TextComponent(NumberFormat.getInstance().format(number));
    }

    public static String getModNameByID(String modid) {
        Optional<? extends ModContainer> modContainer = ModList.get().getModContainerById(modid);
        if (modContainer.isPresent()) {
            return modContainer.get().getModInfo().getDisplayName();
        }
        return modid;
    }

    public static MutableComponent formatHarvestLevel(String modid, int harvestLevel) {
        return localize(modid, "harvest_level." + harvestLevel).toString()
                .equals(modid + ".harvest_level." + harvestLevel)
                ? new TextComponent(String.valueOf(harvestLevel))
                : localize(modid, "harvest_level." + harvestLevel);
    }

    public static MutableComponent localize(String modid, String unlocalized, Object... args) {
        String toLocalize = modid + "." + unlocalized;
        if (args != null && args.length > 0) {
            return new TranslatableComponent(toLocalize, args);
        }
        else {
            return new TranslatableComponent(toLocalize);
        }
    }

}
