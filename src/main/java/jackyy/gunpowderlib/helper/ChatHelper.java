package jackyy.gunpowderlib.helper;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.player.Player;

public class ChatHelper {

    public static void msgPlayer(Player player, String modid, String msg) {
        player.displayClientMessage(StringHelper.localize(modid, msg), true);
    }

    public static void msgPlayerRaw(Player player, String msg) {
        player.displayClientMessage(new TextComponent(msg), true);
    }

    public static void msgPlayerRaw(Player player, Component msg) {
        player.displayClientMessage(msg, true);
    }

}
