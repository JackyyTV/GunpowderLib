package jackyy.gunpowderlib.helper;

import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;

import java.text.NumberFormat;
import java.util.Map;

@SuppressWarnings("deprecation")
public class StringHelper {

    public static String getTierText(String modid, int tier) {
        return localize(modid, "tooltip.tier", tier);
    }

    public static String getShiftText(String modid) {
        return TextFormatting.GRAY + localize(modid, "tooltip.hold_shift", TextFormatting.YELLOW.toString() + TextFormatting.ITALIC + localize(modid, "tooltip.hold_shift.shift") + TextFormatting.RESET + TextFormatting.GRAY);
    }

    public static String getCtrlText(String modid) {
        return TextFormatting.GRAY + localize(modid, "tooltip.hold_ctrl", TextFormatting.AQUA.toString() + TextFormatting.ITALIC + localize(modid, "tooltip.hold_ctrl.ctrl") + TextFormatting.RESET + TextFormatting.GRAY);
    }

    public static String formatNumber(long number) {
        return NumberFormat.getInstance().format(number);
    }

    public static String getModNameByID(String modid) {
        Map<String, ModContainer> indexedModList = Loader.instance().getIndexedModList();
        ModContainer modContainer = indexedModList.get(modid);
        if (modContainer != null) {
            return modContainer.getName();
        }
        return modid;
    }

    public static String formatHarvestLevel(String modid, int harvestLevel) {
        return localize(modid, "harvest_level." + harvestLevel)
                .equals(modid + ".harvest_level." + harvestLevel)
                ? String.valueOf(harvestLevel)
                : localize(modid, "harvest_level." + harvestLevel);
    }

    public static String localize(String modid, String unlocalized, Object... args) {
        String toLocalize = modid + "." + unlocalized;
        if (args != null && args.length > 0) {
            return I18n.translateToLocalFormatted(toLocalize, args);
        }
        else {
            return I18n.translateToLocal(toLocalize);
        }
    }

}
