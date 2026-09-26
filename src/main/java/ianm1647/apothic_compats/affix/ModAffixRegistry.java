package ianm1647.apothic_compats.affix;

import dev.shadowsoffire.apotheosis.affix.AffixRegistry;
import ianm1647.apothic_compats.ApothicCompats;
import ianm1647.apothic_compats.affix.aether.MagicalDartAffix;
import ianm1647.apothic_compats.affix.create.MagicalPotatoAffix;
import ianm1647.apothic_compats.affix.irons_artifice.*;
import ianm1647.apothic_compats.affix.malum.*;
import net.neoforged.fml.ModList;

public class ModAffixRegistry {

    public static void registerAffixes() {
        if (ModList.get().isLoaded("aether")) {
            AffixRegistry.INSTANCE.registerCodec(ApothicCompats.loc("magical_dart"), MagicalDartAffix.CODEC);
        }
        if (ModList.get().isLoaded("create")) {
            AffixRegistry.INSTANCE.registerCodec(ApothicCompats.loc("magical_potato"), MagicalPotatoAffix.CODEC);
        }
        if (ModList.get().isLoaded("irons_artifice")) {
            AffixRegistry.INSTANCE.registerCodec(ApothicCompats.loc("bullet_mob_effect"), BulletModifierAffix.CODEC);
            AffixRegistry.INSTANCE.registerCodec(ApothicCompats.loc("telepathic"), TelepathicGunAffix.CODEC);
            AffixRegistry.INSTANCE.registerCodec(ApothicCompats.loc("infinite_ammo"), InfiniteAmmoAffix.CODEC);
            AffixRegistry.INSTANCE.registerCodec(ApothicCompats.loc("double_shot"), MultiShotAffix.CODEC);
            AffixRegistry.INSTANCE.registerCodec(ApothicCompats.loc("magic_bullet"), MagicalBulletAffix.CODEC);
        }
        if (ModList.get().isLoaded("malum")) {
            AffixRegistry.INSTANCE.registerCodec(ApothicCompats.loc("scythe_thunderstruck"), ScytheThunderstruckAffix.CODEC);
            AffixRegistry.INSTANCE.registerCodec(ApothicCompats.loc("scythe_cleaving"), ScytheCleavingAffix.CODEC);
            AffixRegistry.INSTANCE.registerCodec(ApothicCompats.loc("staff_thunderstruck"), StaffThunderstruckAffix.CODEC);
            AffixRegistry.INSTANCE.registerCodec(ApothicCompats.loc("staff_cleaving"), StaffCleavingAffix.CODEC);
        }


    }
}
