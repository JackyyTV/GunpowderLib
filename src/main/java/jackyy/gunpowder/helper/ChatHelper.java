package jackyy.gunpowder.helper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;

public class ChatHelper {

    public static void msgPlayer(EntityPlayer player, String modid, String msg) {
        player.sendStatusMessage(new TextComponentTranslation(modid + "." + msg), true);
    }

    public static void msgPlayerRaw(EntityPlayer player, String msg) {
        player.sendStatusMessage(new TextComponentString(msg), true);
    }

}
