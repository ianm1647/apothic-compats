package ianm1647.apothic_compats.affix.irons_artifice;

import java.util.Set;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import dev.shadowsoffire.apotheosis.affix.Affix;
import dev.shadowsoffire.apotheosis.affix.AffixDefinition;
import dev.shadowsoffire.apotheosis.affix.AffixHelper;
import dev.shadowsoffire.apotheosis.affix.AffixInstance;
import dev.shadowsoffire.apotheosis.loot.LootCategory;
import dev.shadowsoffire.apotheosis.loot.LootRarity;
import dev.shadowsoffire.apotheosis.util.DamageSourceExtension;
import dev.shadowsoffire.placebo.codec.PlaceboCodecs;
import ianm1647.apothic_compats.Comp;
import io.redspace.irons_artifice.entity.Bullet;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.event.entity.EntityInvulnerabilityCheckEvent;

public class MagicalBulletAffix extends Affix {

    public static final Codec<MagicalBulletAffix> CODEC = RecordCodecBuilder.create(inst -> inst
        .group(
            affixDef(),
            PlaceboCodecs.setOf(LootRarity.CODEC).fieldOf("rarities").forGetter(a -> a.rarities))
        .apply(inst, MagicalBulletAffix::new));

    protected Set<LootRarity> rarities;

    public MagicalBulletAffix(AffixDefinition def, Set<LootRarity> rarities) {
        super(def);
        this.rarities = rarities;
    }

    @Override
    public boolean canApplyTo(ItemStack stack, LootCategory cat, LootRarity rarity) {
        return Comp.LootCategories.Artifice.isGun(cat) && this.rarities.contains(rarity);
    }

    public static void modifyIncomingDamageTags(EntityInvulnerabilityCheckEvent e) {
        if (e.getSource().getDirectEntity() instanceof Bullet bullet) {
            if (AffixHelper.streamAffixes(bullet).anyMatch(a -> a.getAffix() instanceof MagicalBulletAffix)) {
                DamageSourceExtension ext = (DamageSourceExtension) e.getSource();
                ext.addTag(Tags.DamageTypes.IS_MAGIC);
                ext.addTag(DamageTypeTags.BYPASSES_ARMOR);
            }
        }
    }

    @Override
    public Codec<? extends Affix> getCodec() {
        return CODEC;
    }

    @Override
    public boolean isLevelIndependent(AffixInstance inst) {
        return true;
    }

}