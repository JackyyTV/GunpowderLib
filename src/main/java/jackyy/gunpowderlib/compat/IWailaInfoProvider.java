package jackyy.gunpowderlib.compat;

import mcp.mobius.waila.api.BlockAccessor;
import mcp.mobius.waila.api.IComponentProvider;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public interface IWailaInfoProvider {
    List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, BlockAccessor accessor, IComponentProvider config);
}
