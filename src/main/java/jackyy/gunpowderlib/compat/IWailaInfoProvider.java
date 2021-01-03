package jackyy.gunpowderlib.compat;

import mcp.mobius.waila.api.ICommonAccessor;
import mcp.mobius.waila.api.IComponentProvider;
import net.minecraft.item.ItemStack;

import java.util.List;

public interface IWailaInfoProvider {
    List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, ICommonAccessor accessor, IComponentProvider config);
}
