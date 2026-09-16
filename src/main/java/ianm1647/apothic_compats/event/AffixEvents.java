package ianm1647.apothic_compats.event;

import ianm1647.apothic_compats.affix.irons_artifice.InfiniteAmmoAffix;
import io.redspace.irons_artifice.api.AmmoEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;

public class AffixEvents {

    @SubscribeEvent(priority = EventPriority.HIGH)
    public void preventAmmoConsumption(AmmoEvent.Consume event) {
        InfiniteAmmoAffix.preventAmmoConsumption(event);
    }

}
