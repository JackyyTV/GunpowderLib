package jackyy.gunpowderlib.compat;

import mcp.mobius.waila.api.Accessor;
import mcp.mobius.waila.api.IComponentProvider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.HitResult;

import java.util.List;

public interface IWailaInfoProvider {
    List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, Accessor<HitResult> accessor, IComponentProvider config);
}
