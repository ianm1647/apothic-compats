package ianm1647.apothic_compats.event;

import ianm1647.apothic_compats.affix.aether.MagicalDartAffix;
import ianm1647.apothic_compats.affix.create.MagicalPotatoAffix;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.EntityInvulnerabilityCheckEvent;

public class AffixEvents {

    @SubscribeEvent(priority = EventPriority.HIGH)
    public void modifyIncomingDamageTags(EntityInvulnerabilityCheckEvent e) {
        MagicalDartAffix.modifyIncomingDamageTags(e);
        MagicalPotatoAffix.modifyIncomingDamageTags(e);
    }
}
