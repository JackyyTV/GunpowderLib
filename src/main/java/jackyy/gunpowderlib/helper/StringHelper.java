package jackyy.gunpowderlib.helper;

import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModList;

import java.text.NumberFormat;
import java.util.Optional;

public class StringHelper {

    public static final String ENERGY_NBT = "energy";

    public static IFormattableTextComponent getTierText(String modid, int tier) {
        return localize(modid, "tooltip.tier", tier);
    }

    public static IFormattableTextComponent getShiftText(String modid) {
        return localize(modid, "tooltip.hold_shift", localize(modid, "tooltip.hold_shift.shift").mergeStyle(TextFormatting.YELLOW, TextFormatting.ITALIC)).mergeStyle(TextFormatting.GRAY);
    }

    public static IFormattableTextComponent getCtrlText(String modid) {
        return localize(modid, "tooltip.hold_ctrl", localize(modid, "tooltip.hold_ctrl.ctrl").mergeStyle(TextFormatting.AQUA, TextFormatting.ITALIC)).mergeStyle(TextFormatting.GRAY);
    }

    public static IFormattableTextComponent formatNumber(long number) {
        return new StringTextComponent(NumberFormat.getInstance().format(number));
    }

    public static String getModNameByID(String modid) {
        Optional<? extends ModContainer> modContainer = ModList.get().getModContainerById(modid);
        if (modContainer.isPresent()) {
            return modContainer.get().getModInfo().getDisplayName();
        }
        return modid;
    }

    public static IFormattableTextComponent formatHarvestLevel(String modid, int harvestLevel) {
        return localize(modid, "harvest_level." + harvestLevel).toString()
                .equals(modid + ".harvest_level." + harvestLevel)
                ? new StringTextComponent(String.valueOf(harvestLevel))
                : localize(modid, "harvest_level." + harvestLevel);
    }

    public static IFormattableTextComponent localize(String modid, String unlocalized, Object... args) {
        String toLocalize = modid + "." + unlocalized;
        if (args != null && args.length > 0) {
            return new TranslationTextComponent(toLocalize, args);
        }
        else {
            return new TranslationTextComponent(toLocalize);
        }
    }

}
