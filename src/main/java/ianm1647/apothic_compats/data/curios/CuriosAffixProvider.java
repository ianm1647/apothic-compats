package ianm1647.apothic_compats.data.curios;

import com.hollingsworth.arsnouveau.ArsNouveau;
import com.hollingsworth.arsnouveau.api.perk.PerkAttributes;
import com.sammy.malum.MalumMod;
import com.sammy.malum.registry.common.MalumAttributes;
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
import team.lodestar.lodestone.registry.common.LodestoneAttributes;

import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

public class CuriosAffixProvider extends AffixProvider {
    String mod = "curios";

    public static final LootCategory[] CURIOS = {
            ModLootCategories.BACK, ModLootCategories.BELT, ModLootCategories.BODY, ModLootCategories.BRACELET, ModLootCategories.CHARM,
            ModLootCategories.CURIO, ModLootCategories.FEET, ModLootCategories.HANDS, ModLootCategories.HEAD, ModLootCategories.NECKLACE,
            ModLootCategories.RING, ModLootCategories.BROOCH, ModLootCategories.RUNE, ModLootCategories.AN_FOCUS
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
        this.addModdedAttribute("curios", "mana", ArsNouveau.MODID, PerkAttributes.MAX_MANA, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .value(common, 5, 15)
                .value(uncommon, 20, 30)
                .value(rare, 35, 45)
                .value(epic, 50, 60)
                .value(mythic, 65, 75));

        this.addAncientModdedAttribute("curios", "mana", ArsNouveau.MODID, PerkAttributes.MAX_MANA, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .value(ancient, 80, 90));

        this.addModdedAttribute("curios", "spell_damaged", ArsNouveau.MODID, PerkAttributes.SPELL_DAMAGE_BONUS, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .value(common, 0.05f, 0.1f)
                .value(uncommon, 0.125f, 0.175f)
                .value(rare, 0.2f, 0.25f)
                .value(epic, 0.275f, 0.325f)
                .value(mythic, 0.35f, 0.4f));

        this.addAncientModdedAttribute("curios", "spell_damaged", ArsNouveau.MODID, PerkAttributes.SPELL_DAMAGE_BONUS, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .value(ancient, 0.425f, 0.475f));

        this.addModdedAttribute("curios", "regenerative", ArsNouveau.MODID, PerkAttributes.MANA_REGEN_BONUS, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .value(common, 0.05f, 0.1f)
                .value(uncommon, 0.15f, 0.2f)
                .value(rare, 0.25f, 0.3f)
                .value(epic, 0.35f, 0.4f)
                .value(mythic, 0.45f, 0.5f));

        this.addAncientModdedAttribute("curios", "regenerative", ArsNouveau.MODID, PerkAttributes.MANA_REGEN_BONUS, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .value(ancient, 0.55f, 0.6f));

        // MALUM
        this.addModdedAttribute("curios", "abjured", MalumMod.MALUM, LodestoneAttributes.MAGIC_RESISTANCE, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .value(uncommon, 0.05f,0.1f)
                .value(rare, 0.1f,0.15f)
                .value(epic, 0.15f,0.2f)
                .value(mythic, 0.2f,0.25f));

        this.addAncientModdedAttribute("curios", "abjured", MalumMod.MALUM, LodestoneAttributes.MAGIC_RESISTANCE, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .value(ancient, 0.25f,0.35f));

        this.addModdedAttribute("curios", "vandalous", MalumMod.MALUM, LodestoneAttributes.MAGIC_DAMAGE, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .value(uncommon, 0.05f,0.1f)
                .value(rare, 0.1f,0.15f)
                .value(epic, 0.15f,0.2f)
                .value(mythic, 0.2f,0.25f));

        this.addAncientModdedAttribute("curios", "vandalous", MalumMod.MALUM, LodestoneAttributes.MAGIC_DAMAGE, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .value(ancient, 0.25f,0.35f));

        this.addModdedAttribute("curios", "mystic", MalumMod.MALUM, LodestoneAttributes.MAGIC_DAMAGE, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .value(common, 0.05F, 0.1F)
                .value(uncommon, 0.1F, 0.15F)
                .value(rare, 0.15F, 0.2F)
                .value(epic, 0.2F, 0.25F)
                .value(mythic, 0.25F, 0.35F));

        this.addAncientModdedAttribute("curios", "mystic", MalumMod.MALUM, LodestoneAttributes.MAGIC_DAMAGE, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .value(ancient, 0.35F, 0.55F));

        this.addModdedAttribute("curios", "adept", MalumMod.MALUM, LodestoneAttributes.MAGIC_PROFICIENCY, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .value(common, 0.05F, 0.1F)
                .value(uncommon, 0.1F, 0.15F)
                .value(rare, 0.15F, 0.2F)
                .value(epic, 0.2F, 0.25F)
                .value(mythic, 0.25F, 0.3F));

        this.addAncientModdedAttribute("curios", "adept", MalumMod.MALUM, LodestoneAttributes.MAGIC_PROFICIENCY, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .value(ancient, 0.35F, 0.4F));

        this.addModdedAttribute("curios", "scythe_proficiency", MalumMod.MALUM, MalumAttributes.SCYTHE_PROFICIENCY, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .value(uncommon, 0.1f, 0.2f)
                .value(rare, 0.2f, 0.3f)
                .value(epic, 0.3f, 0.4f)
                .value(mythic, 0.4f, 0.5f));

        this.addAncientModdedAttribute("curios", "scythe_proficiency", MalumMod.MALUM, MalumAttributes.SCYTHE_PROFICIENCY, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .value(ancient, 0.5f, 0.6f));



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
                .categories(CURIOS)
                .value(common, 0.05F, 0.15F)
                .value(uncommon, 0.1F, 0.2F)
                .value(rare, 0.15F, 0.25F)
                .value(epic, 0.2F, 0.3F)
                .value(mythic, 0.25F, 0.35F));

        this.addAttribute("curios", "aquatic", NeoForgeMod.SWIM_SPEED, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .value(common, 0.1F, 0.15F)
                .value(uncommon, 0.15F, 0.2F)
                .value(rare, 0.25F, 0.3F)
                .value(epic, 0.35F, 0.4F)
                .value(mythic, 0.45F, 0.5F));

        this.addAttribute("curios", "blessed", Attributes.MAX_HEALTH, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .step(0.25F)
                .value(common, 1, 2)
                .value(uncommon, 2, 3)
                .value(rare, 3, 4)
                .value(epic, 4, 5)
                .value(mythic, 5, 6));

        this.addAttribute("curios", "gravitational", Attributes.GRAVITY, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .step(-0.01F)
                .value(common, -0.1F, -0.15F)
                .value(uncommon, -0.1F, -0.2F)
                .value(rare, -0.15F, -0.25F)
                .value(epic, -0.2F, -0.3F)
                .value(mythic, -0.25F, -0.4F));

        this.addAttribute("curios", "ironforged", Attributes.ARMOR, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .step(0.25F)
                .value(common, 1, 1.5F)
                .value(uncommon, 1, 2)
                .value(rare, 2, 4)
                .value(epic, 3, 4)
                .value(mythic, 3, 5));

        this.addAttribute("curios", "adamantine", Attributes.ARMOR, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .value(rare, 0.05F, 0.15F)
                .value(epic, 0.1F, 0.25F)
                .value(mythic, 0.2F, 0.35F));

        this.addAttribute("curios", "spiritual", ALObjects.Attributes.HEALING_RECEIVED, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .value(rare, 0.05F, 0.15F)
                .value(epic, 0.2F, 0.25F)
                .value(mythic, 0.2F, 0.35F));

        this.addAttribute("curios", "stalwart", Attributes.KNOCKBACK_RESISTANCE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .value(uncommon, 0.05F, 0.1F)
                .value(rare, 0.05F, 0.1F)
                .value(epic, 0.15F, 0.20F)
                .value(mythic, 0.25F, 0.35F));

        this.addAttribute("curios", "fireproof", Attributes.BURNING_TIME, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .step(-0.05F)
                .value(uncommon, -0.1F, -0.15F)
                .value(rare, -0.1F, -0.2F)
                .value(epic, -0.15F, -0.45F)
                .value(mythic, -0.35F, -0.65F));

        this.addAttribute("curios", "oxygenated", Attributes.OXYGEN_BONUS, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .value(uncommon, 0.1F, 0.25F)
                .value(rare, 0.15F, 0.35F)
                .value(epic, 0.2F, 0.5F)
                .value(mythic, 0.35F, 0.85F));

        this.addAttribute("curios", "destructive", ALObjects.Attributes.MINING_SPEED, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .value(common, 0.05F, 0.15F)
                .value(uncommon, 0.1F, 0.2F)
                .value(rare, 0.15F, 0.25F)
                .value(epic, 0.2F, 0.3F)
                .value(mythic, 0.25F, 0.35F));

        this.addAttribute("curios", "experienced", ALObjects.Attributes.EXPERIENCE_GAINED, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .value(common, 0.05F, 0.15F)
                .value(uncommon, 0.1F, 0.2F)
                .value(rare, 0.15F, 0.25F)
                .value(epic, 0.2F, 0.3F)
                .value(mythic, 0.25F, 0.35F));

        this.addAttribute("curios", "submerged", Attributes.SUBMERGED_MINING_SPEED, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .value(common, 0.05F, 0.1F)
                .value(uncommon, 0.15F, 0.25F)
                .value(rare, 0.25F, 0.45F)
                .value(epic, 0.4F, 0.55F)
                .value(mythic, 0.55F, 0.75F));

        this.addAttribute("curios", "vampiric", ALObjects.Attributes.LIFE_STEAL, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, d -> d
                        .weights(TieredWeights.forAllTiers(DEFAULT_WEIGHT, DEFAULT_QUALITY)))
                .categories(CURIOS)
                .value(common, 0.1F, 0.15F)
                .value(uncommon, 0.1F, 0.25F)
                .value(rare, 0.2F, 0.35F)
                .value(epic, 0.25F, 0.4F)
                .value(mythic, 0.35F, 0.45F));

        this.addAttribute("curios", "murderous", Attributes.ATTACK_DAMAGE, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .value(rare, 0.1F, 0.25F)
                .value(epic, 0.2F, 0.38F)
                .value(mythic, 0.3F, 0.5F));

        this.addAttribute("curios", "lacerating", ALObjects.Attributes.CRIT_DAMAGE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .value(common, 0.05F, 0.15F)
                .value(uncommon, 0.1F, 0.2F)
                .value(rare, 0.15F, 0.25F)
                .value(epic, 0.15F, 0.35F)
                .value(mythic, 0.25F, 0.45F));

        this.addAttribute("curios", "intricate", ALObjects.Attributes.CRIT_CHANCE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .value(common, 0.05F, 0.15F)
                .value(uncommon, 0.1F, 0.2F)
                .value(rare, 0.15F, 0.25F)
                .value(epic, 0.2F, 0.3F)
                .value(mythic, 0.25F, 0.35F));

        this.addAttribute("curios", "graceful", Attributes.ATTACK_SPEED, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .value(common, 0.1F, 0.2F)
                .value(uncommon, 0.2F, 0.3F)
                .value(rare, 0.3F, 0.4F)
                .value(epic, 0.4F, 0.5F)
                .value(mythic, 0.45F, 0.6F));

        this.addAttribute("curios", "berserking", ALObjects.Attributes.OVERHEAL, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
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
                .categories(CURIOS)
                .value(ancient, 0.3F, 0.4F));

        this.addAncientAttribute("curios", "aquatic", NeoForgeMod.SWIM_SPEED, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .value(ancient, 0.5F, 0.75F));

        this.addAncientAttribute("curios", "blessed", Attributes.MAX_HEALTH, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .step(0.25F)
                .value(ancient, 6, 10));

        this.addAncientAttribute("curios", "gravitational", Attributes.GRAVITY, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .step(-0.01F)
                .value(ancient, -0.4F, -0.85F));

        this.addAncientAttribute("curios", "ironforged", Attributes.ARMOR, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .step(0.25F)
                .value(ancient, 5, 8));

        this.addAncientAttribute("curios", "adamantine", Attributes.ARMOR, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .value(ancient, 0.3F, 0.45F));

        this.addAncientAttribute("curios", "spiritual", ALObjects.Attributes.HEALING_RECEIVED, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .value(ancient, 0.4F, 0.65F));

        this.addAncientAttribute("curios", "stalwart", Attributes.KNOCKBACK_RESISTANCE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .value(ancient, 0.4F, 0.65F));

        this.addAncientAttribute("curios", "fireproof", Attributes.BURNING_TIME, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .step(-0.05F)
                .value(ancient, -0.45F, -0.85F));

        this.addAncientAttribute("curios", "oxygenated", Attributes.OXYGEN_BONUS, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .value(ancient, 0.55F, 0.95F));

        this.addAncientAttribute("curios", "destructive", ALObjects.Attributes.MINING_SPEED, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .value(ancient, 0.35F, 0.45F));

        this.addAncientAttribute("curios", "experienced", ALObjects.Attributes.EXPERIENCE_GAINED, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .value(ancient, 0.35F, 0.55F));

        this.addAncientAttribute("curios", "submerged", Attributes.SUBMERGED_MINING_SPEED, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .value(ancient, 0.65F, 0.95F));

        this.addAncientAttribute("curios", "vampiric", ALObjects.Attributes.LIFE_STEAL, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, d -> d
                        .weights(TieredWeights.forAllTiers(DEFAULT_WEIGHT, DEFAULT_QUALITY)))
                .categories(CURIOS)
                .value(ancient, 0.45F, 0.55F));

        this.addAncientAttribute("curios", "murderous", Attributes.ATTACK_DAMAGE, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .value(ancient, 0.4F, 0.55F));

        this.addAncientAttribute("curios", "lacerating", ALObjects.Attributes.CRIT_DAMAGE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .value(ancient, 0.3F, 0.65F));

        this.addAncientAttribute("curios", "intricate", ALObjects.Attributes.CRIT_CHANCE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .value(mythic, 0.35F, 0.45F));

        this.addAncientAttribute("curios", "graceful", Attributes.ATTACK_SPEED, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .value(ancient, 0.55F, 0.7F));

        this.addAncientAttribute("curios", "berserking", ALObjects.Attributes.OVERHEAL, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(CURIOS)
                .value(ancient, 0.4F, 0.55F));

    }

    public void addAttribute(String type, String name, Holder<Attribute> attribute, AttributeModifier.Operation op, UnaryOperator<AttributeAffix.Builder> config) {
        var builder = new AttributeAffix.Builder(attribute, op);
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc(type + "/attribute/" + name), builder.build(), new ModLoadedCondition(mod));
    }

    public void addModdedAttribute(String type, String name, String modid, Holder<Attribute> attribute, AttributeModifier.Operation op, UnaryOperator<AttributeAffix.Builder> config) {
        var builder = new AttributeAffix.Builder(attribute, op);
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc(type + "/attribute/" + name), builder.build(), new ModLoadedCondition(mod), new ModLoadedCondition(modid));
    }

    public void addAncientAttribute(String type, String name, Holder<Attribute> attribute, AttributeModifier.Operation op, UnaryOperator<AttributeAffix.Builder> config) {
        var builder = new AttributeAffix.Builder(attribute, op);
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc(type + "/attribute/ancient/" + name), builder.build(), new ModLoadedCondition(mod), new ModLoadedCondition(AncientReforging.MODID));
    }

    public void addAncientModdedAttribute(String type, String name, String modid, Holder<Attribute> attribute, AttributeModifier.Operation op, UnaryOperator<AttributeAffix.Builder> config) {
        var builder = new AttributeAffix.Builder(attribute, op);
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc(type + "/attribute/ancient/" + name), builder.build(), new ModLoadedCondition(mod), new ModLoadedCondition(AncientReforging.MODID), new ModLoadedCondition(modid));
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
