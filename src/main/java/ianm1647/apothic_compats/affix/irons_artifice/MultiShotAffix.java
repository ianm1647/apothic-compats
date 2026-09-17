package ianm1647.apothic_compats.affix.irons_artifice;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.shadowsoffire.apotheosis.affix.Affix;
import dev.shadowsoffire.apotheosis.affix.AffixDefinition;
import dev.shadowsoffire.apotheosis.affix.AffixHelper;
import dev.shadowsoffire.apotheosis.affix.AffixInstance;
import dev.shadowsoffire.apotheosis.loot.LootCategory;
import dev.shadowsoffire.apotheosis.loot.LootRarity;
import dev.shadowsoffire.placebo.dynreg.DynamicHolder;
import dev.shadowsoffire.placebo.util.StepFunction;
import ianm1647.apothic_compats.Comp;
import io.redspace.irons_artifice.api.GunShootEvent;
import io.redspace.irons_artifice.data.ShotComponentMap;
import io.redspace.irons_artifice.data.ShotComponentTemplate;
import io.redspace.irons_artifice.data.ShotComponents;
import io.redspace.irons_artifice.data.ValueModifier;
import io.redspace.irons_artifice.entity.Bullet;
import io.redspace.irons_artifice.gun.ShotProfile;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.neoforged.neoforge.common.util.AttributeTooltipContext;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.stream.Stream;

public class MultiShotAffix extends Affix {
    public static final Codec<MultiShotAffix> CODEC = RecordCodecBuilder.create(inst -> inst
            .group(
                    affixDef(),
                    LootRarity.mapCodec(StepFunction.CODEC).fieldOf("values").forGetter(a -> a.values))
            .apply(inst, MultiShotAffix::new));

    protected final Map<LootRarity, StepFunction> values;

    public MultiShotAffix(AffixDefinition definition, Map<LootRarity, StepFunction> values) {
        super(definition);
        this.values = values;
    }

    @Override
    public MutableComponent getDescription(AffixInstance inst, AttributeTooltipContext ctx) {
        return Component.translatable("affix." + this.id() + ".desc", fmt(this.getTrueLevel(inst.getRarity(), inst.level())));
    }

    public static void multiplyBullets(GunShootEvent.Pre event) {
        ShotProfile profile = event.getShotProfile();
        ItemStack weapon = profile.itemStack();
        Map<DynamicHolder<Affix>, AffixInstance> inst = AffixHelper.getAffixes(weapon);

        inst.values().forEach((a) -> {
            if (a.getAffix() instanceof MultiShotAffix affix) {
                profile.components().modifyValue(ShotComponents.PROJECTILE_COUNT, new ValueModifier(affix.getTrueLevel(a.getRarity(), a.level()), ValueModifier.Operation.ADD, ValueModifier.Type.BENEFICIAL));
            }
        });
    }

    private float getTrueLevel(LootRarity rarity, float level) {
        return this.values.get(rarity).get(level);
    }

    @Override
    public boolean canApplyTo(ItemStack stack, LootCategory cat, LootRarity rarity) {
        return Comp.LootCategories.Artifice.isGun(cat) && this.values.containsKey(rarity);
    }

    @Override
    public Codec<? extends Affix> getCodec() {
        return CODEC;
    }
}
