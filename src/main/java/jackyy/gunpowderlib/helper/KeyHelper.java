package jackyy.gunpowderlib.helper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.lwjgl.glfw.GLFW;

@OnlyIn(Dist.CLIENT)
public class KeyHelper {

    private static long window = Minecraft.getInstance().getMainWindow().getHandle();

    public static boolean isShiftKeyDown() {
        return InputMappings.isKeyDown(window, GLFW.GLFW_KEY_LEFT_SHIFT) || InputMappings.isKeyDown(window, GLFW.GLFW_KEY_RIGHT_SHIFT);
    }

    public static boolean isCtrlKeyDown() {
        return InputMappings.isKeyDown(window, GLFW.GLFW_KEY_LEFT_CONTROL) || InputMappings.isKeyDown(window, GLFW.GLFW_KEY_RIGHT_CONTROL);
    }

    public static boolean isAltKeyDown() {
        return InputMappings.isKeyDown(window, GLFW.GLFW_KEY_LEFT_ALT) || InputMappings.isKeyDown(window, GLFW.GLFW_KEY_RIGHT_ALT);
    }

}
