package ianm1647.apothic_compats.data.malum;

import com.sammy.malum.registry.common.MalumAttributes;
import com.sammy.malum.registry.common.enchantment.EnchantmentKeys;
import dev.shadowsoffire.apotheosis.Apoth;
import dev.shadowsoffire.apotheosis.Apotheosis;
import dev.shadowsoffire.apotheosis.affix.effect.MobEffectAffix;
import dev.shadowsoffire.apotheosis.socket.gem.ExtraGemBonusRegistry;
import dev.shadowsoffire.apotheosis.socket.gem.GemClass;
import dev.shadowsoffire.apotheosis.socket.gem.GemRegistry;
import dev.shadowsoffire.apotheosis.socket.gem.Purity;
import dev.shadowsoffire.apotheosis.socket.gem.bonus.AttributeBonus;
import dev.shadowsoffire.apotheosis.socket.gem.bonus.EnchantmentBonus;
import dev.shadowsoffire.apotheosis.socket.gem.bonus.MobEffectBonus;
import dev.shadowsoffire.apotheosis.socket.gem.bonus.MultiAttrBonus;
import dev.shadowsoffire.apotheosis.tiers.Constraints;
import dev.shadowsoffire.apotheosis.tiers.TieredWeights;
import dev.shadowsoffire.apotheosis.tiers.WorldTier;
import dev.shadowsoffire.apotheosis.util.ApothMiscUtil;
import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import dev.shadowsoffire.placebo.util.data.DynamicRegistryProvider;
import ianm1647.apothic_compats.ApothicCompats;
import ianm1647.apothic_compats.loot.ModLootCategories;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import team.lodestar.lodestone.registry.common.LodestoneAttributes;

import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

public class MalumExtraGemBonusProvider extends DynamicRegistryProvider<ExtraGemBonusRegistry.ExtraGemBonus> {

    public MalumExtraGemBonusProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, ExtraGemBonusRegistry.INSTANCE);
    }

    public static final GemClass MALUM_WEAPON = new GemClass("malum_weapon", ModLootCategories.SCYTHE, ModLootCategories.STAFF);

    @Override
    public String getName() {
        return "Malum Extra Gem Bonuses";
    }

    @Override
    public void generate() {
        HolderLookup.Provider registries = this.lookupProvider.join();
        HolderLookup.RegistryLookup<Enchantment> enchants = registries.lookupOrThrow(Registries.ENCHANTMENT);

        addBonus(Apotheosis.loc("core/ballast"), b -> b
                .bonus(MALUM_WEAPON, AttributeBonus.builder()
                        .attr(LodestoneAttributes.MAGIC_DAMAGE)
                        .op(AttributeModifier.Operation.ADD_VALUE)
                        .value(Purity.CRACKED, 1)
                        .value(Purity.CHIPPED, 2)
                        .value(Purity.FLAWED, 3.5F)
                        .value(Purity.NORMAL, 5)
                        .value(Purity.FLAWLESS, 7)
                        .value(Purity.PERFECT, 10)));

        addBonus(Apotheosis.loc("core/brawlers"), b -> b
                .bonus(MALUM_WEAPON, AttributeBonus.builder()
                        .attr(Attributes.ATTACK_DAMAGE)
                        .op(AttributeModifier.Operation.ADD_VALUE)
                        .value(Purity.CRACKED, 1)
                        .value(Purity.CHIPPED, 2)
                        .value(Purity.FLAWED, 3.5F)
                        .value(Purity.NORMAL, 5)
                        .value(Purity.FLAWLESS, 7)
                        .value(Purity.PERFECT, 10)));

        addBonus(Apotheosis.loc("core/breach"), c -> c
                .bonus(MALUM_WEAPON, AttributeBonus.builder()
                        .attr(ALObjects.Attributes.ARMOR_SHRED)
                        .op(AttributeModifier.Operation.ADD_VALUE)
                        .value(Purity.CRACKED, 0.025f)
                        .value(Purity.CHIPPED, 0.05f)
                        .value(Purity.FLAWED, 0.075F)
                        .value(Purity.NORMAL, 0.15F)
                        .value(Purity.FLAWLESS, 0.25F)
                        .value(Purity.PERFECT, 0.40F)));

        addBonus(Apotheosis.loc("core/combatant"), c -> c
                .bonus(ModLootCategories.STAFF, AttributeBonus.builder()
                        .attr(ALObjects.Attributes.PROJECTILE_DAMAGE)
                        .op(AttributeModifier.Operation.ADD_VALUE)
                        .value(Purity.CRACKED, 0.1)
                        .value(Purity.CHIPPED, 0.2)
                        .value(Purity.FLAWED, 0.3)
                        .value(Purity.NORMAL, 0.4)
                        .value(Purity.FLAWLESS, 0.5)
                        .value(Purity.PERFECT, 0.6)));

        addBonus(Apotheosis.loc("core/lunar"), c -> c
                .bonus(MALUM_WEAPON, AttributeBonus.builder()
                        .attr(LodestoneAttributes.MAGIC_PROFICIENCY)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                        .value(Purity.CRACKED, 0.15)
                        .value(Purity.CHIPPED, 0.2)
                        .value(Purity.FLAWED, 0.25)
                        .value(Purity.NORMAL, 0.3)
                        .value(Purity.FLAWLESS, 0.4)
                        .value(Purity.PERFECT, 0.5)));

        addBonus(Apotheosis.loc("core/splendor"), c -> c
                .bonus(MALUM_WEAPON, AttributeBonus.builder()
                        .attr(MalumAttributes.SPIRIT_SPOILS)
                        .op(AttributeModifier.Operation.ADD_VALUE)
                        .value(Purity.CRACKED, 1)
                        .value(Purity.CHIPPED, 2)
                        .value(Purity.FLAWED, 3)
                        .value(Purity.NORMAL, 4)
                        .value(Purity.FLAWLESS, 5)
                        .value(Purity.PERFECT, 6)));

        addBonus(Apotheosis.loc("core/slipstream"), c -> c
                .bonus(ModLootCategories.STAFF, AttributeBonus.builder()
                        .attr(MalumAttributes.CHARGE_DURATION)
                        .op(AttributeModifier.Operation.ADD_VALUE)
                        .value(Purity.CRACKED, -1)
                        .value(Purity.CHIPPED, -2)
                        .value(Purity.FLAWED, -3)
                        .value(Purity.NORMAL, -4)
                        .value(Purity.FLAWLESS, -5)
                        .value(Purity.PERFECT, -6))
                .bonus(ModLootCategories.SCYTHE, AttributeBonus.builder()
                        .attr(Attributes.ATTACK_SPEED)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                        .value(Purity.CRACKED, 0.10)
                        .value(Purity.CHIPPED, 0.15)
                        .value(Purity.FLAWED, 0.25)
                        .value(Purity.NORMAL, 0.35)
                        .value(Purity.FLAWLESS, 0.45)
                        .value(Purity.PERFECT, 0.60)));

        addBonus(Apotheosis.loc("core/warlord"), c -> c
                .bonus(MALUM_WEAPON, AttributeBonus.builder()
                        .attr(ALObjects.Attributes.CRIT_CHANCE)
                        .op(AttributeModifier.Operation.ADD_VALUE)
                        .value(Purity.CRACKED, 0.05)
                        .value(Purity.CHIPPED, 0.15)
                        .value(Purity.FLAWED, 0.25)
                        .value(Purity.NORMAL, 0.35)
                        .value(Purity.FLAWLESS, 0.4)
                        .value(Purity.PERFECT, 0.5)));

        addBonus(Apotheosis.loc("overworld/earth"), b -> b
                .bonus(ModLootCategories.SCYTHE, EnchantmentBonus.builder()
                        .enchantment(standaloneHolder(registries, EnchantmentKeys.REBOUND))
                        .mode(EnchantmentBonus.Mode.EXISTING)
                        .value(Purity.FLAWED, 1)
                        .value(Purity.NORMAL, 2)
                        .value(Purity.FLAWLESS, 3)
                        .value(Purity.PERFECT, 4))
                .bonus(ModLootCategories.STAFF, EnchantmentBonus.builder()
                        .enchantment(standaloneHolder(registries, EnchantmentKeys.CAPACITOR))
                        .mode(EnchantmentBonus.Mode.EXISTING)
                        .value(Purity.FLAWED, 1)
                        .value(Purity.NORMAL, 2)
                        .value(Purity.FLAWLESS, 3)
                        .value(Purity.PERFECT, 4)));

        addBonus(Apotheosis.loc("the_nether/inferno"), c -> c
                .bonus(MALUM_WEAPON, EnchantmentBonus.builder()
                        .enchantment(standaloneHolder(registries, EnchantmentKeys.SPIRIT_PLUNDER))
                        .mode(EnchantmentBonus.Mode.SINGLE)
                        .value(Purity.FLAWED, 1)
                        .value(Purity.NORMAL, 2)
                        .value(Purity.FLAWLESS, 3)
                        .value(Purity.PERFECT, 4)));

        addBonus(Apotheosis.loc("the_end/mageslayer"), c -> c
                .bonus(MALUM_WEAPON, MultiAttrBonus.builder()
                        .desc("bonus.apotheosis:multi_attr.desc.and")
                        .modifier(b -> b
                                .attr(MalumAttributes.CHARGE_DURATION)
                                .op(AttributeModifier.Operation.ADD_VALUE)
                                .value(Purity.NORMAL, -3)
                                .value(Purity.FLAWLESS, -5)
                                .value(Purity.PERFECT, -7))
                        .modifier(b -> b
                                .attr(MalumAttributes.CHARGE_RECOVERY_RATE)
                                .op(AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                                .value(Purity.NORMAL, -0.3f)
                                .value(Purity.FLAWLESS, -0.4f)
                                .value(Purity.PERFECT, -0.5f))));
    }

    private void addBonus(ResourceLocation gem, UnaryOperator<ExtraGemBonusRegistry.ExtraGemBonus.Builder> config) {
        var builder = ExtraGemBonusRegistry.ExtraGemBonus.builder(GemRegistry.INSTANCE.holder(gem));
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc("malum/" + gem.getNamespace() + "/" + gem.getPath()), builder.build(), new ModLoadedCondition("malum"));
    }

    private static <T> Holder.Reference<T> standaloneHolder(HolderLookup.Provider registries, ResourceKey<T> key) {
        return ApothMiscUtil.standaloneHolder(registries, key);
    }
}
