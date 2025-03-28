package ianm1647.apothic_compats.data.malum;

import dev.shadowsoffire.apotheosis.Apotheosis;
import dev.shadowsoffire.apotheosis.socket.gem.ExtraGemBonusRegistry;
import dev.shadowsoffire.apotheosis.socket.gem.GemClass;
import dev.shadowsoffire.apotheosis.socket.gem.GemRegistry;
import dev.shadowsoffire.apotheosis.socket.gem.Purity;
import dev.shadowsoffire.apotheosis.socket.gem.bonus.AttributeBonus;
import dev.shadowsoffire.apotheosis.socket.gem.bonus.EnchantmentBonus;
import dev.shadowsoffire.placebo.util.data.DynamicRegistryProvider;
import ianm1647.apothic_compats.ApothicCompats;
import ianm1647.apothic_compats.loot.ModLootCategories;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
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
        HolderLookup.RegistryLookup<Enchantment> enchants = registries.lookup(Registries.ENCHANTMENT).get();

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

        addBonus(Apotheosis.loc("the_end/endersurge"), b -> b
                .bonus(MALUM_WEAPON, EnchantmentBonus.builder()
                        .enchantment(enchants.getOrThrow(Enchantments.SHARPNESS))
                        .mode(EnchantmentBonus.Mode.GLOBAL)
                        .value(Purity.FLAWLESS, 1)
                        .value(Purity.PERFECT, 2)));


    }

    private void addBonus(ResourceLocation gem, UnaryOperator<ExtraGemBonusRegistry.ExtraGemBonus.Builder> config) {
        var builder = ExtraGemBonusRegistry.ExtraGemBonus.builder(GemRegistry.INSTANCE.holder(gem));
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc("malum/" + gem.getNamespace() + "/" + gem.getPath()), builder.build(), new ModLoadedCondition("malum"));
    }
}
