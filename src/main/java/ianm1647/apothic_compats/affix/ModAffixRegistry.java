package ianm1647.apothic_compats.affix;

import dev.shadowsoffire.apotheosis.affix.AffixRegistry;
import ianm1647.apothic_compats.ApothicCompats;
import ianm1647.apothic_compats.affix.aether.MagicalDartAffix;
import ianm1647.apothic_compats.affix.create.MagicalPotatoAffix;
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
        if (ModList.get().isLoaded("malum")) {
            AffixRegistry.INSTANCE.registerCodec(ApothicCompats.loc("scythe_thunderstruck"), ScytheThunderstruckAffix.CODEC);
            AffixRegistry.INSTANCE.registerCodec(ApothicCompats.loc("scythe_executing"), ScytheExecutingAffix.CODEC);
            AffixRegistry.INSTANCE.registerCodec(ApothicCompats.loc("scythe_cleaving"), ScytheCleavingAffix.CODEC);
            AffixRegistry.INSTANCE.registerCodec(ApothicCompats.loc("staff_thunderstruck"), StaffThunderstruckAffix.CODEC);
            AffixRegistry.INSTANCE.registerCodec(ApothicCompats.loc("staff_executing"), StaffExecutingAffix.CODEC);
            AffixRegistry.INSTANCE.registerCodec(ApothicCompats.loc("staff_cleaving"), StaffCleavingAffix.CODEC);
        }


    }
}
