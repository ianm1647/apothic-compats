package ianm1647.apothic_compats.affix.irons_artifice;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.shadowsoffire.apotheosis.affix.Affix;
import dev.shadowsoffire.apotheosis.affix.AffixDefinition;
import dev.shadowsoffire.apotheosis.affix.AffixHelper;
import dev.shadowsoffire.apotheosis.affix.AffixInstance;
import dev.shadowsoffire.apotheosis.affix.effect.MagicalArrowAffix;
import dev.shadowsoffire.apotheosis.loot.LootCategory;
import dev.shadowsoffire.apotheosis.loot.LootRarity;
import dev.shadowsoffire.placebo.codec.PlaceboCodecs;
import dev.shadowsoffire.placebo.util.StepFunction;
import ianm1647.apothic_compats.Comp;
import io.redspace.irons_artifice.api.AmmoEvent;
import io.redspace.irons_artifice.data.PlayableSound;
import io.redspace.irons_artifice.entity.Bullet;
import io.redspace.irons_artifice.registry.SoundRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.common.util.AttributeTooltipContext;

import java.util.Map;
import java.util.Set;

public class InfiniteAmmoAffix extends Affix {
    public static final Codec<InfiniteAmmoAffix> CODEC = RecordCodecBuilder.create(inst -> inst
            .group(
                    affixDef(),
                    PlaceboCodecs.setOf(LootRarity.CODEC).fieldOf("rarities").forGetter(a -> a.rarities))
            .apply(inst, InfiniteAmmoAffix::new));

    protected final Set<LootRarity> rarities;

    public InfiniteAmmoAffix(AffixDefinition definition, Set<LootRarity> rarities) {
        super(definition);
        this.rarities = rarities;
    }

    public static void preventAmmoConsumption(AmmoEvent.Consume event) {
        if (AffixHelper.streamAffixes(event.getShotProfile().itemStack()).anyMatch(a -> a.getAffix() instanceof InfiniteAmmoAffix)) {
            if (event.getAmmoToConsume() > 0) {
                LivingEntity shooter = event.getEntity();
                event.setCanceled(true);
                PlayableSound.of(SoundRegistry.INFINITY_BULLET, 1.0F, 0.9F, 1.1F).play(shooter.level(), shooter.position(), SoundSource.NEUTRAL);
            }
        }
    }

    @Override
    public boolean canApplyTo(ItemStack stack, LootCategory cat, LootRarity rarity) {
        return Comp.LootCategories.Artifice.isGun(cat) && this.rarities.contains(rarity);
    }

    @Override
    public Codec<? extends Affix> getCodec() {
        return CODEC;
    }
}
