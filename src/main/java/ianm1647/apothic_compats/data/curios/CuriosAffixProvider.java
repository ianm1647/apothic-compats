package ianm1647.apothic_compats.data.curios;

import com.hollingsworth.arsnouveau.ArsNouveau;
import com.hollingsworth.arsnouveau.api.perk.PerkAttributes;
import dev.shadowsoffire.apotheosis.Apoth;
import dev.shadowsoffire.apotheosis.Apotheosis;
import dev.shadowsoffire.apotheosis.affix.Affix;
import dev.shadowsoffire.apotheosis.affix.AffixRegistry;
import dev.shadowsoffire.apotheosis.affix.AffixType;
import dev.shadowsoffire.apotheosis.affix.AttributeAffix;
import dev.shadowsoffire.apotheosis.data.AffixProvider;
import dev.shadowsoffire.apotheosis.loot.LootCategory;
import dev.shadowsoffire.apotheosis.loot.LootRarity;
import dev.shadowsoffire.apotheosis.loot.RarityRegistry;
import dev.shadowsoffire.apotheosis.tiers.TieredWeights;
import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import dev.shadowsoffire.placebo.reload.DynamicHolder;
import ianm1647.ancientreforging.AncientReforging;
import ianm1647.apothic_compats.ApothicCompats;
import ianm1647.apothic_compats.loot.ModLootCategories;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import org.spongepowered.include.com.google.common.base.Preconditions;

import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

public class CuriosAffixProvider extends AffixProvider {
    String mod = "curios";

    public static final LootCategory[] CURIOS = {
            ModLootCategories.BACK, ModLootCategories.BELT, ModLootCategories.BODY, ModLootCategories.BRACELET, ModLootCategories.CHARM,
            ModLootCategories.CURIO, ModLootCategories.FEET, ModLootCategories.HANDS, ModLootCategories.HEAD, ModLootCategories.NECKLACE, ModLootCategories.RING
    };

    public CuriosAffixProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    public String getName() {
        return "Curios Affixes";
    }

    @Override
    public void generate() {
        LootRarity common = rarity("common");
        LootRarity uncommon = rarity("uncommon");
        LootRarity rare = rarity("rare");
        LootRarity epic = rarity("epic");
        LootRarity mythic = rarity("mythic");
        LootRarity ancient = ancientRarity("ancient");

        //ARS NOUVEAU
        this.addArsAttribute("curios", "mana", PerkAttributes.MAX_MANA, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.RING, ModLootCategories.CHARM, ModLootCategories.BRACELET)
                .value(common, 5, 15)
                .value(uncommon, 20, 30)
                .value(rare, 35, 45)
                .value(epic, 50, 60)
                .value(mythic, 65, 75));

        this.addAncientArsAttribute("curios", "mana", PerkAttributes.MAX_MANA, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.RING, ModLootCategories.CHARM, ModLootCategories.BRACELET)
                .value(ancient, 80, 90));

        this.addArsAttribute("curios", "spell_damaged", PerkAttributes.SPELL_DAMAGE_BONUS, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.FEET, ModLootCategories.HANDS, ModLootCategories.BACK)
                .value(common, 0.05f, 0.1f)
                .value(uncommon, 0.125f, 0.175f)
                .value(rare, 0.2f, 0.25f)
                .value(epic, 0.275f, 0.325f)
                .value(mythic, 0.35f, 0.4f));

        this.addAncientArsAttribute("curios", "spell_damaged", PerkAttributes.SPELL_DAMAGE_BONUS, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.FEET, ModLootCategories.HANDS, ModLootCategories.BACK)
                .value(ancient, 0.425f, 0.475f));

        this.addArsAttribute("curios", "regenerative", PerkAttributes.MANA_REGEN_BONUS, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.BODY, ModLootCategories.HEAD, ModLootCategories.BELT)
                .value(common, 0.05f, 0.1f)
                .value(uncommon, 0.15f, 0.2f)
                .value(rare, 0.25f, 0.3f)
                .value(epic, 0.35f, 0.4f)
                .value(mythic, 0.45f, 0.5f));

        this.addAncientArsAttribute("curios", "regenerative", PerkAttributes.MANA_REGEN_BONUS, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.BODY, ModLootCategories.HEAD, ModLootCategories.BELT)
                .value(ancient, 0.55f, 0.6f));

        // CORE

        this.addAttribute("curios", "lucky", Attributes.LUCK, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .step(0.25F)
                .value(uncommon, 1F, 1.5F)
                .value(rare, 2F, 3F)
                .value(epic, 2.5F, 4F)
                .value(mythic, 3F, 6F));

        this.addAttribute("curios", "windswept", Attributes.MOVEMENT_SPEED, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.FEET, ModLootCategories.RING, ModLootCategories.CURIO)
                .value(common, 0.05F, 0.15F)
                .value(uncommon, 0.1F, 0.2F)
                .value(rare, 0.15F, 0.25F)
                .value(epic, 0.2F, 0.3F)
                .value(mythic, 0.25F, 0.35F));

        this.addAttribute("curios", "aquatic", NeoForgeMod.SWIM_SPEED, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.FEET, ModLootCategories.NECKLACE, ModLootCategories.BELT)
                .value(common, 0.1F, 0.15F)
                .value(uncommon, 0.15F, 0.2F)
                .value(rare, 0.25F, 0.3F)
                .value(epic, 0.35F, 0.4F)
                .value(mythic, 0.45F, 0.5F));

        this.addAttribute("curios", "blessed", Attributes.MAX_HEALTH, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.BRACELET, ModLootCategories.CHARM, ModLootCategories.CURIO)
                .step(0.25F)
                .value(common, 1, 2)
                .value(uncommon, 2, 3)
                .value(rare, 3, 4)
                .value(epic, 4, 5)
                .value(mythic, 5, 6));

        this.addAttribute("curios", "gravitational", Attributes.GRAVITY, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.FEET, ModLootCategories.BELT, ModLootCategories.BODY)
                .step(-0.01F)
                .value(common, -0.1F, -0.15F)
                .value(uncommon, -0.1F, -0.2F)
                .value(rare, -0.15F, -0.25F)
                .value(epic, -0.2F, -0.3F)
                .value(mythic, -0.25F, -0.4F));

        this.addAttribute("curios", "ironforged", Attributes.ARMOR, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.BODY, ModLootCategories.HEAD, ModLootCategories.NECKLACE)
                .step(0.25F)
                .value(common, 1, 1.5F)
                .value(uncommon, 1, 2)
                .value(rare, 2, 4)
                .value(epic, 3, 4)
                .value(mythic, 3, 5));

        this.addAttribute("curios", "spiritual", ALObjects.Attributes.HEALING_RECEIVED, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.BRACELET, ModLootCategories.CHARM, ModLootCategories.CURIO)
                .value(rare, 0.05F, 0.15F)
                .value(epic, 0.2F, 0.25F)
                .value(mythic, 0.2F, 0.35F));

        this.addAttribute("curios", "stalwart", Attributes.KNOCKBACK_RESISTANCE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.BODY, ModLootCategories.BACK, ModLootCategories.BELT)
                .value(uncommon, 0.05F, 0.1F)
                .value(rare, 0.05F, 0.1F)
                .value(epic, 0.15F, 0.20F)
                .value(mythic, 0.25F, 0.35F));

        this.addAttribute("curios", "fireproof", Attributes.BURNING_TIME, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.BELT, ModLootCategories.CHARM, ModLootCategories.HEAD)
                .step(-0.05F)
                .value(uncommon, -0.1F, -0.15F)
                .value(rare, -0.1F, -0.2F)
                .value(epic, -0.15F, -0.45F)
                .value(mythic, -0.35F, -0.65F));

        this.addAttribute("curios", "oxygenated", Attributes.OXYGEN_BONUS, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.HEAD, ModLootCategories.NECKLACE, ModLootCategories.RING)
                .value(uncommon, 0.1F, 0.25F)
                .value(rare, 0.15F, 0.35F)
                .value(epic, 0.2F, 0.5F)
                .value(mythic, 0.35F, 0.85F));

        this.addAttribute("curios", "experienced", ALObjects.Attributes.EXPERIENCE_GAINED, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.HANDS, ModLootCategories.RING, ModLootCategories.BRACELET)
                .value(common, 0.15F, 0.25F)
                .value(uncommon, 0.2F, 0.3F)
                .value(rare, 0.25F, 0.35F)
                .value(epic, 0.3F, 0.5F)
                .value(mythic, 0.45F, 0.65F));

        this.addAttribute("curios", "submerged", Attributes.SUBMERGED_MINING_SPEED, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.HANDS, ModLootCategories.RING, ModLootCategories.CHARM)
                .value(common, 0.05F, 0.1F)
                .value(uncommon, 0.15F, 0.25F)
                .value(rare, 0.25F, 0.45F)
                .value(epic, 0.4F, 0.55F)
                .value(mythic, 0.55F, 0.75F));

        this.addAttribute("curios", "vampiric", ALObjects.Attributes.LIFE_STEAL, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, d -> d
                        .weights(TieredWeights.forAllTiers(DEFAULT_WEIGHT, DEFAULT_QUALITY)))
                .categories(ModLootCategories.HANDS, ModLootCategories.NECKLACE, ModLootCategories.BELT)
                .value(common, 0.1F, 0.15F)
                .value(uncommon, 0.1F, 0.25F)
                .value(rare, 0.2F, 0.35F)
                .value(epic, 0.25F, 0.4F)
                .value(mythic, 0.35F, 0.45F));

        this.addAttribute("curios", "murderous", Attributes.ATTACK_DAMAGE, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.HANDS, ModLootCategories.RING, ModLootCategories.BRACELET)
                .value(rare, 0.1F, 0.25F)
                .value(epic, 0.2F, 0.38F)
                .value(mythic, 0.3F, 0.5F));

        this.addAttribute("curios", "lacerating", ALObjects.Attributes.CRIT_DAMAGE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.FEET, ModLootCategories.BACK, ModLootCategories.NECKLACE)
                .value(common, 0.05F, 0.15F)
                .value(uncommon, 0.1F, 0.2F)
                .value(rare, 0.15F, 0.25F)
                .value(epic, 0.15F, 0.35F)
                .value(mythic, 0.25F, 0.45F));

        this.addAttribute("curios", "graceful", Attributes.ATTACK_SPEED, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.HANDS, ModLootCategories.CURIO, ModLootCategories.RING)
                .value(common, 0.1F, 0.2F)
                .value(uncommon, 0.2F, 0.3F)
                .value(rare, 0.3F, 0.4F)
                .value(epic, 0.4F, 0.5F)
                .value(mythic, 0.45F, 0.6F));

        this.addAttribute("curios", "berserking", ALObjects.Attributes.OVERHEAL, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, d -> d
                        .weights(TieredWeights.forAllTiers(DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .exclusiveWith(afx("melee/attribute/vampiric")))
                .categories(Apoth.LootCategories.MELEE_WEAPON)
                .value(common, 0.1F, 0.2F)
                .value(uncommon, 0.1F, 0.25F)
                .value(rare, 0.15F, 0.3F)
                .value(epic, 0.2F, 0.4F)
                .value(mythic, 0.35F, 0.5F));

        this.addAncientAttribute("curios", "lucky", Attributes.LUCK, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .step(0.25F)
                .value(ancient, 6F, 12F));

        this.addAncientAttribute("curios", "windswept", Attributes.MOVEMENT_SPEED, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.FEET, ModLootCategories.RING, ModLootCategories.CURIO)
                .value(ancient, 0.3F, 0.4F));

        this.addAncientAttribute("curios", "aquatic", NeoForgeMod.SWIM_SPEED, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.FEET, ModLootCategories.NECKLACE, ModLootCategories.BELT)
                .value(ancient, 0.5F, 0.75F));

        this.addAncientAttribute("curios", "blessed", Attributes.MAX_HEALTH, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.BRACELET, ModLootCategories.CHARM, ModLootCategories.CURIO)
                .step(0.25F)
                .value(ancient, 6, 10));

        this.addAncientAttribute("curios", "gravitational", Attributes.GRAVITY, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.FEET, ModLootCategories.BELT, ModLootCategories.BODY)
                .step(-0.01F)
                .value(ancient, -0.4F, -0.85F));

        this.addAncientAttribute("curios", "ironforged", Attributes.ARMOR, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.BODY, ModLootCategories.HEAD, ModLootCategories.NECKLACE)
                .step(0.25F)
                .value(ancient, 5, 8));

        this.addAncientAttribute("curios", "spiritual", ALObjects.Attributes.HEALING_RECEIVED, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.BRACELET, ModLootCategories.CHARM, ModLootCategories.CURIO)
                .value(ancient, 0.4F, 0.65F));

        this.addAncientAttribute("curios", "stalwart", Attributes.KNOCKBACK_RESISTANCE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.BODY, ModLootCategories.BACK, ModLootCategories.BELT)
                .value(ancient, 0.4F, 0.65F));

        this.addAncientAttribute("curios", "fireproof", Attributes.BURNING_TIME, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.BELT, ModLootCategories.CHARM, ModLootCategories.HEAD)
                .step(-0.05F)
                .value(ancient, -0.45F, -0.85F));

        this.addAncientAttribute("curios", "oxygenated", Attributes.OXYGEN_BONUS, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.HEAD, ModLootCategories.NECKLACE, ModLootCategories.RING)
                .value(ancient, 0.55F, 0.95F));

        this.addAncientAttribute("curios", "experienced", ALObjects.Attributes.EXPERIENCE_GAINED, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.HANDS, ModLootCategories.RING, ModLootCategories.BRACELET)
                .value(ancient, 0.55F, 0.85F));

        this.addAncientAttribute("curios", "submerged", Attributes.SUBMERGED_MINING_SPEED, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.HANDS, ModLootCategories.RING, ModLootCategories.CHARM)
                .value(ancient, 0.65F, 0.95F));

        this.addAncientAttribute("curios", "vampiric", ALObjects.Attributes.LIFE_STEAL, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, d -> d
                        .weights(TieredWeights.forAllTiers(DEFAULT_WEIGHT, DEFAULT_QUALITY)))
                .categories(ModLootCategories.HANDS, ModLootCategories.NECKLACE, ModLootCategories.BELT)
                .value(ancient, 0.45F, 0.55F));

        this.addAncientAttribute("curios", "murderous", Attributes.ATTACK_DAMAGE, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.HANDS, ModLootCategories.RING, ModLootCategories.BRACELET)
                .value(ancient, 0.4F, 0.55F));

        this.addAncientAttribute("curios", "lacerating", ALObjects.Attributes.CRIT_DAMAGE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.FEET, ModLootCategories.BACK, ModLootCategories.NECKLACE)
                .value(ancient, 0.3F, 0.65F));

        this.addAncientAttribute("curios", "graceful", Attributes.ATTACK_SPEED, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.HANDS, ModLootCategories.CURIO, ModLootCategories.RING)
                .value(ancient, 0.55F, 0.7F));

        this.addAncientAttribute("curios", "berserking", ALObjects.Attributes.OVERHEAL, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, d -> d
                        .weights(TieredWeights.forAllTiers(DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .exclusiveWith(afx("melee/attribute/vampiric")))
                .categories(Apoth.LootCategories.MELEE_WEAPON)
                .value(ancient, 0.4F, 0.55F));

    }

    public void addAttribute(String type, String name, Holder<Attribute> attribute, AttributeModifier.Operation op, UnaryOperator<AttributeAffix.Builder> config) {
        var builder = new AttributeAffix.Builder(attribute, op);
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc(type + "/attribute/" + name), builder.build(), new ModLoadedCondition(mod));
    }

    public void addArsAttribute(String type, String name, Holder<Attribute> attribute, AttributeModifier.Operation op, UnaryOperator<AttributeAffix.Builder> config) {
        var builder = new AttributeAffix.Builder(attribute, op);
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc(type + "/attribute/" + name), builder.build(), new ModLoadedCondition(mod), new ModLoadedCondition(ArsNouveau.MODID));
    }

    public void addAncientAttribute(String type, String name, Holder<Attribute> attribute, AttributeModifier.Operation op, UnaryOperator<AttributeAffix.Builder> config) {
        var builder = new AttributeAffix.Builder(attribute, op);
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc(type + "/attribute/ancient/" + name), builder.build(), new ModLoadedCondition(mod), new ModLoadedCondition(AncientReforging.MODID));
    }
    public void addAncientArsAttribute(String type, String name, Holder<Attribute> attribute, AttributeModifier.Operation op, UnaryOperator<AttributeAffix.Builder> config) {
        var builder = new AttributeAffix.Builder(attribute, op);
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc(type + "/attribute/ancient/" + name), builder.build(), new ModLoadedCondition(mod), new ModLoadedCondition(ArsNouveau.MODID), new ModLoadedCondition(AncientReforging.MODID));
    }

    private static DynamicHolder<Affix> afx(String path) {
        return AffixRegistry.INSTANCE.holder(ApothicCompats.loc(path));
    }

    private static LootRarity rarity(String path) {
        return Preconditions.checkNotNull(RarityRegistry.INSTANCE.getValue(Apotheosis.loc(path)));
    }

    private static LootRarity ancientRarity(String path) {
        return Preconditions.checkNotNull(RarityRegistry.INSTANCE.getValue(AncientReforging.loc(path)));
    }
}
