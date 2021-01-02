package jackyy.gunpowderlib.handler;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.UUID;

public class EventsHandler {

    @SubscribeEvent
    public void onEntityTargeted(LivingSetAttackTargetEvent event) {
        if (event.getTarget() == null)
            return;
        if (!(event.getTarget() instanceof PlayerEntity) || event.getTarget() instanceof FakePlayer)
            return;
        if (!(event.getEntity() instanceof LivingEntity))
            return;

        PlayerEntity player = (PlayerEntity) event.getTarget();
        LivingEntity entity = (LivingEntity) event.getEntity();

        if (entity instanceof CreeperEntity) {
            if (player.getUniqueID().equals(UUID.fromString("38de3769-70fa-441c-89e8-67280f3068a0"))) {
                ((CreeperEntity) entity).setAttackTarget(null);
                entity.setRevengeTarget(null);
            }
        }
    }

    @SubscribeEvent
    public void onLivingUpdate(LivingEvent.LivingUpdateEvent event) {
        if (!(event.getEntity() instanceof LivingEntity))
            return;
        LivingEntity entity = (LivingEntity) event.getEntity();
        if (entity.getAttackingEntity() == null || !(entity.getAttackingEntity() instanceof PlayerEntity) || entity.getAttackingEntity() instanceof FakePlayer)
            return;
        PlayerEntity player = (PlayerEntity) entity.getAttackingEntity();

        if (entity instanceof CreeperEntity) {
            if (player.getUniqueID().equals(UUID.fromString("38de3769-70fa-441c-89e8-67280f3068a0"))) {
                ((CreeperEntity) entity).setAttackTarget(null);
                entity.setRevengeTarget(null);
            }
        }
    }

}
