package ianm1647.apothic_compats.affix.create;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.simibubi.create.content.equipment.potatoCannon.PotatoProjectileEntity;
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

public class MagicalPotatoAffix extends Affix {
    public static final Codec<MagicalPotatoAffix> CODEC = RecordCodecBuilder.create((inst) -> {
        return inst.group(affixDef(), PlaceboCodecs.setOf(LootRarity.CODEC).fieldOf("rarities").forGetter((a) -> {
            return a.rarities;
        })).apply(inst, MagicalPotatoAffix::new);
    });
    protected Set<LootRarity> rarities;

    public MagicalPotatoAffix(AffixDefinition def, Set<LootRarity> rarities) {
        super(def);
        this.rarities = rarities;
    }

    public boolean canApplyTo(ItemStack stack, LootCategory cat, LootRarity rarity) {
        return ModLootCategories.isPotatoCannon(cat) && this.rarities.contains(rarity);
    }

    public static void modifyIncomingDamageTags(EntityInvulnerabilityCheckEvent e) {
        Entity var2 = e.getSource().getDirectEntity();
        if (var2 instanceof PotatoProjectileEntity dart) {
            if (AffixHelper.streamAffixes(dart).anyMatch((a) -> {
                return a.getAffix() instanceof MagicalPotatoAffix;
            })) {
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