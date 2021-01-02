package jackyy.gunpowderlib;

import jackyy.gunpowderlib.handler.EventsHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(GunpowderLib.MODID)
public class GunpowderLib {

    public static final String MODID = "gunpowderlib";

    public GunpowderLib() {
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new EventsHandler());
    }

}
