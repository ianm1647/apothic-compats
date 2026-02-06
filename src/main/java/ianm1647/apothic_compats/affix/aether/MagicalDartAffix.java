package ianm1647.apothic_compats.affix.aether;

import com.aetherteam.aether.entity.projectile.dart.AbstractDart;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.shadowsoffire.apotheosis.affix.Affix;
import dev.shadowsoffire.apotheosis.affix.AffixDefinition;
import dev.shadowsoffire.apotheosis.affix.AffixHelper;
import dev.shadowsoffire.apotheosis.loot.LootCategory;
import dev.shadowsoffire.apotheosis.loot.LootRarity;
import dev.shadowsoffire.apotheosis.util.DamageSourceExtension;
import dev.shadowsoffire.placebo.codec.PlaceboCodecs;
import ianm1647.apothic_compats.loot.ModLootCategories;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.event.entity.EntityInvulnerabilityCheckEvent;

import java.util.Set;

public class MagicalDartAffix extends Affix {
    public static final Codec<MagicalDartAffix> CODEC = RecordCodecBuilder.create((inst) -> inst
            .group(affixDef(), PlaceboCodecs.setOf(LootRarity.CODEC).fieldOf("rarities").forGetter((a) -> a.rarities))
            .apply(inst, MagicalDartAffix::new));
    protected Set<LootRarity> rarities;

    public MagicalDartAffix(AffixDefinition def, Set<LootRarity> rarities) {
        super(def);
        this.rarities = rarities;
    }

    public boolean canApplyTo(ItemStack stack, LootCategory cat, LootRarity rarity) {
        return ModLootCategories.isDartShooter(cat) && this.rarities.contains(rarity);
    }

    public static void modifyIncomingDamageTags(EntityInvulnerabilityCheckEvent e) {
        Entity var2 = e.getSource().getDirectEntity();
        if (var2 instanceof AbstractDart dart) {
            if (AffixHelper.streamAffixes(dart).anyMatch((a) -> a.getAffix() instanceof MagicalDartAffix)) {
                DamageSourceExtension ext = (DamageSourceExtension)e.getSource();
                ext.addTag(Tags.DamageTypes.IS_MAGIC);
                ext.addTag(DamageTypeTags.BYPASSES_ARMOR);
            }
        }

    }

    public Codec<? extends Affix> getCodec() {
        return CODEC;
    }
}