package jackyy.gunpowderlib;

import jackyy.gunpowderlib.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = GunpowderLib.MODID, version = GunpowderLib.VERSION, name = GunpowderLib.MODNAME, acceptedMinecraftVersions = GunpowderLib.MCVERSION, certificateFingerprint = "@FINGERPRINT@", useMetadata = true)
public class GunpowderLib {

    public static final String MODID = "gunpowderlib";
    public static final String MODNAME = "GunpowderLib";
    public static final String VERSION = "1.12.2-1.0";
    public static final String MCVERSION = "[1.12,1.13)";

    public static final Logger LOGGER = LogManager.getLogger(MODNAME);

    public static final String COMMON_PROXY = "jackyy.gunpowderlib.proxy.CommonProxy";
    public static final String CLIENT_PROXY = "jackyy.gunpowderlib.proxy.ClientProxy";

    @SidedProxy(serverSide = GunpowderLib.COMMON_PROXY, clientSide = GunpowderLib.CLIENT_PROXY)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @Mod.EventHandler
    public void onFingerprintViolation(FMLFingerprintViolationEvent event) {
        GunpowderLib.LOGGER.warn("Invalid fingerprint detected! The file " + event.getSource().getName() + " may have been modified. This will NOT be supported by the mod author!");
    }

}
