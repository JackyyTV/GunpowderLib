package jackyy.gunpowderlib.helper;

import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.player.Player;

public class ChatHelper {

    public static void msgPlayer(Player player, String modid, String msg) {
        player.sendMessage(StringHelper.localize(modid, msg), Util.NIL_UUID);
    }

    public static void msgPlayerRaw(Player player, String msg) {
        player.sendMessage(new TextComponent(msg), Util.NIL_UUID);
    }

    public static void msgPlayerRaw(Player player, Component msg) {
        player.sendMessage(msg, Util.NIL_UUID);
    }

}
