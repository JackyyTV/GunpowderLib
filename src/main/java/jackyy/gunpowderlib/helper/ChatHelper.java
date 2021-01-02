package jackyy.gunpowderlib.helper;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class ChatHelper {

    public static void msgPlayer(PlayerEntity player, String modid, String msg) {
        player.sendStatusMessage(new TranslationTextComponent(modid + "." + msg), true);
    }

    public static void msgPlayerRaw(PlayerEntity player, String msg) {
        player.sendStatusMessage(new StringTextComponent(msg), true);
    }

}
