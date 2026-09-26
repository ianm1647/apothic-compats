package ianm1647.apothic_compats.event.irons_artifice;

import ianm1647.apothic_compats.affix.irons_artifice.MultiShotAffix;
import ianm1647.apothic_compats.affix.irons_artifice.InfiniteAmmoAffix;
import ianm1647.apothic_compats.affix.irons_artifice.MagicalBulletAffix;
import ianm1647.apothic_compats.affix.irons_artifice.TelepathicGunAffix;
import io.redspace.irons_artifice.api.AmmoEvent;
import io.redspace.irons_artifice.api.ComposeShotEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.EntityInvulnerabilityCheckEvent;
import net.neoforged.neoforge.event.entity.living.LivingDropsEvent;

public class ArtificeAffixEvents {

    @SubscribeEvent(priority = EventPriority.HIGH)
    public void gunShootEvents(ComposeShotEvent e) {
        MultiShotAffix.multiplyBullets(e);
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void dropsLowest(LivingDropsEvent e) {
        TelepathicGunAffix.drops(e);
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public void preventAmmoConsumption(AmmoEvent.Consume e) {
        InfiniteAmmoAffix.preventAmmoConsumption(e);
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public void modifyIncomingDamageTags(EntityInvulnerabilityCheckEvent e) {
        MagicalBulletAffix.modifyIncomingDamageTags(e);
    }

}