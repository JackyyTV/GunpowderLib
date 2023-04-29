package jackyy.gunpowderlib.handler;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.entity.living.LivingChangeTargetEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.UUID;

public class EventsHandler {

    @SubscribeEvent
    public void onEntityTargeted(LivingChangeTargetEvent event) {
        if (event.getNewTarget() == null)
            return;
        if (!(event.getNewTarget() instanceof Player player) || event.getNewTarget() instanceof FakePlayer)
            return;
        if (!(event.getEntity() instanceof LivingEntity entity))
            return;

        if (entity instanceof Creeper) {
            if (player.getUUID().equals(UUID.fromString("38de3769-70fa-441c-89e8-67280f3068a0"))) {
                event.setNewTarget(null);
            }
        }
    }

}
