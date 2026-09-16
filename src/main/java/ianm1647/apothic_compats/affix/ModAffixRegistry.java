package ianm1647.apothic_compats.affix;

import dev.shadowsoffire.apotheosis.affix.AffixRegistry;
import ianm1647.apothic_compats.ApothicCompats;
import ianm1647.apothic_compats.affix.irons_artifice.BulletModifierAffix;
import ianm1647.apothic_compats.affix.irons_artifice.InfiniteAmmoAffix;
import net.neoforged.fml.ModList;

public class ModAffixRegistry {

    public static void registerAffixes() {
        if (ModList.get().isLoaded("irons_artifice")) {
            AffixRegistry.SERIALIZER.register(ApothicCompats.loc("bullet_mob_effect"), BulletModifierAffix.CODEC);
            AffixRegistry.SERIALIZER.register(ApothicCompats.loc("infinite_ammo"), InfiniteAmmoAffix.CODEC);
        }



    }
}
