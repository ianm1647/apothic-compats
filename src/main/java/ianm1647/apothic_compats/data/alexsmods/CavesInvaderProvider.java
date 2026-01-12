package ianm1647.apothic_compats.data.alexsmods;

import com.github.alexmodguy.alexscaves.server.entity.ACEntityRegistry;
import com.github.alexmodguy.alexscaves.server.level.biome.ACBiomeRarity;
import com.github.alexmodguy.alexscaves.server.level.biome.ACBiomeRegistry;
import com.github.alexmodguy.alexscaves.server.misc.ACTagRegistry;
import com.github.alexthe666.alexsmobs.entity.AMEntityRegistry;
import dev.shadowsoffire.apotheosis.Apoth;
import dev.shadowsoffire.apotheosis.data.InvaderProvider;
import dev.shadowsoffire.apotheosis.loot.LootRarity;
import dev.shadowsoffire.apotheosis.loot.RarityRegistry;
import dev.shadowsoffire.apotheosis.mobs.types.Invader;
import dev.shadowsoffire.apotheosis.mobs.util.BasicBossData;
import dev.shadowsoffire.apotheosis.tiers.Constraints;
import dev.shadowsoffire.apotheosis.tiers.TieredWeights;
import dev.shadowsoffire.apotheosis.tiers.WorldTier;
import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import dev.shadowsoffire.placebo.util.StepFunction;
import ianm1647.ancientreforging.AncientReforging;
import ianm1647.apothic_compats.ApothicCompats;
import ianm1647.apothic_compats.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import org.spongepowered.include.com.google.common.base.Preconditions;

import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

public class CavesInvaderProvider extends InvaderProvider {
    String mod = "alexscaves";

    public CavesInvaderProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    public String getName() {
        return "Alexs Caves Invaders";
    }

    @Override
    public void generate() {
        HolderLookup.Provider registries = this.lookupProvider.join();
        HolderLookup.RegistryLookup<Biome> biomes = registries.lookup(Registries.BIOME).get();

        addBoss("teletor", b -> basicMeleeStats(b)
                .entity(ACEntityRegistry.TELETOR.get())
                .basicData(c -> meleeGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.ASCENT, DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(Level.OVERWORLD))
                        .constraints(Constraints.forBiomes(biomes, ModTags.Biomes.IS_MAGNETIC_CAVES))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        addBoss("magnetron", b -> basicMeleeStats(b)
                .entity(ACEntityRegistry.MAGNETRON.get())
                .basicData(c -> meleeGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.ASCENT, DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(Level.OVERWORLD))
                        .constraints(Constraints.forBiomes(biomes, ModTags.Biomes.IS_MAGNETIC_CAVES))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        addBoss("ferrouslime", b -> basicMeleeStats(b)
                .entity(ACEntityRegistry.FERROUSLIME.get())
                .basicData(c -> meleeGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.SUMMIT, DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(Level.OVERWORLD))
                        .constraints(Constraints.forBiomes(biomes, ModTags.Biomes.IS_MAGNETIC_CAVES))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        addBoss("vallumraptor", b -> basicMeleeStats(b)
                .entity(ACEntityRegistry.VALLUMRAPTOR.get())
                .basicData(c -> meleeGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.ASCENT, DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(Level.OVERWORLD))
                        .constraints(Constraints.forBiomes(biomes, ModTags.Biomes.IS_PRIMORDIAL_CAVES))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        addBoss("grottoceratops", b -> basicMeleeStats(b)
                .entity(ACEntityRegistry.GROTTOCERATOPS.get())
                .basicData(c -> meleeGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.SUMMIT, DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(Level.OVERWORLD))
                        .constraints(Constraints.forBiomes(biomes, ModTags.Biomes.IS_PRIMORDIAL_CAVES))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        addBoss("tremorsaurus", b -> basicMeleeStats(b)
                .entity(ACEntityRegistry.TREMORSAURUS.get())
                .basicData(c -> meleeGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.PINNACLE, DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(Level.OVERWORLD))
                        .constraints(Constraints.forBiomes(biomes, ModTags.Biomes.IS_PRIMORDIAL_CAVES))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        addBoss("brainiac", b -> basicMeleeStats(b)
                .entity(ACEntityRegistry.BRAINIAC.get())
                .basicData(c -> meleeGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.SUMMIT, DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(Level.OVERWORLD))
                        .constraints(Constraints.forBiomes(biomes, ModTags.Biomes.IS_TOXIC_CAVES))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        addBoss("gammaroach", b -> basicMeleeStats(b)
                .entity(ACEntityRegistry.GAMMAROACH.get())
                .basicData(c -> meleeGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.ASCENT, DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(Level.OVERWORLD))
                        .constraints(Constraints.forBiomes(biomes, ModTags.Biomes.IS_TOXIC_CAVES))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        addBoss("gossamer", b -> basicMeleeStats(b)
                .entity(ACEntityRegistry.GAMMAROACH.get())
                .basicData(c -> meleeGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.ASCENT, DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(Level.OVERWORLD))
                        .constraints(Constraints.forBiomes(biomes, ModTags.Biomes.IS_ABYSSAL_CHASM))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        addBoss("deep_one", b -> basicMeleeStats(b)
                .entity(ACEntityRegistry.DEEP_ONE.get())
                .basicData(c -> meleeGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.SUMMIT, DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(Level.OVERWORLD))
                        .constraints(Constraints.forBiomes(biomes, ModTags.Biomes.IS_ABYSSAL_CHASM))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        addBoss("deep_one_knight", b -> basicMeleeStats(b)
                .entity(ACEntityRegistry.DEEP_ONE_KNIGHT.get())
                .basicData(c -> meleeGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.SUMMIT, DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(Level.OVERWORLD))
                        .constraints(Constraints.forBiomes(biomes, ModTags.Biomes.IS_ABYSSAL_CHASM))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        addBoss("deep_one_mage", b -> basicMeleeStats(b)
                .entity(ACEntityRegistry.DEEP_ONE_MAGE.get())
                .basicData(c -> meleeGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.SUMMIT, DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(Level.OVERWORLD))
                        .constraints(Constraints.forBiomes(biomes, ModTags.Biomes.IS_ABYSSAL_CHASM))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        addBoss("underzealot", b -> basicMeleeStats(b)
                .entity(ACEntityRegistry.UNDERZEALOT.get())
                .basicData(c -> meleeGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.ASCENT, DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(Level.OVERWORLD))
                        .constraints(Constraints.forBiomes(biomes, ModTags.Biomes.IS_FORLORN_HOLLOWS))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        addBoss("watcher", b -> basicMeleeStats(b)
                .entity(ACEntityRegistry.WATCHER.get())
                .basicData(c -> meleeGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.SUMMIT, DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(Level.OVERWORLD))
                        .constraints(Constraints.forBiomes(biomes, ModTags.Biomes.IS_FORLORN_HOLLOWS))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        addBoss("corrodent", b -> basicMeleeStats(b)
                .entity(ACEntityRegistry.CORRODENT.get())
                .basicData(c -> meleeGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.FRONTIER, DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(Level.OVERWORLD))
                        .constraints(Constraints.forBiomes(biomes, ModTags.Biomes.IS_FORLORN_HOLLOWS))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        addBoss("caniac", b -> basicMeleeStats(b)
                .entity(ACEntityRegistry.CANIAC.get())
                .basicData(c -> meleeGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.ASCENT, DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(Level.OVERWORLD))
                        .constraints(Constraints.forBiomes(biomes, ModTags.Biomes.IS_CANDY_CAVITY))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        addBoss("gummy_bear", b -> basicMeleeStats(b)
                .entity(ACEntityRegistry.GUMMY_BEAR.get())
                .basicData(c -> meleeGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.FRONTIER, DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(Level.OVERWORLD))
                        .constraints(Constraints.forBiomes(biomes, ModTags.Biomes.IS_CANDY_CAVITY))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        addBoss("licowitch", b -> basicRangedStats(b)
                .entity(ACEntityRegistry.LICOWITCH.get())
                .basicData(c -> rangedGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.ASCENT, DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(Level.OVERWORLD))
                        .constraints(Constraints.forBiomes(biomes, ModTags.Biomes.IS_CANDY_CAVITY))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));


        //TODO: ANCIENT

        addAncientBoss("teletor", b -> ancientMeleeStats(b)
                .entity(ACEntityRegistry.TELETOR.get())
                .basicData(c -> meleeGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.PINNACLE, 10, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(Level.OVERWORLD))
                        .constraints(Constraints.forBiomes(biomes, ModTags.Biomes.IS_MAGNETIC_CAVES))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        addAncientBoss("magnetron", b -> ancientMeleeStats(b)
                .entity(ACEntityRegistry.MAGNETRON.get())
                .basicData(c -> meleeGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.PINNACLE, 10, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(Level.OVERWORLD))
                        .constraints(Constraints.forBiomes(biomes, ModTags.Biomes.IS_MAGNETIC_CAVES))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        addAncientBoss("vallumraptor", b -> ancientMeleeStats(b)
                .entity(ACEntityRegistry.VALLUMRAPTOR.get())
                .basicData(c -> meleeGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.PINNACLE, 10, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(Level.OVERWORLD))
                        .constraints(Constraints.forBiomes(biomes, ModTags.Biomes.IS_PRIMORDIAL_CAVES))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        addAncientBoss("tremorsaurus", b -> ancientMeleeStats(b)
                .entity(ACEntityRegistry.TREMORSAURUS.get())
                .basicData(c -> meleeGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.PINNACLE, 10, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(Level.OVERWORLD))
                        .constraints(Constraints.forBiomes(biomes, ModTags.Biomes.IS_PRIMORDIAL_CAVES))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        addAncientBoss("brainiac", b -> ancientMeleeStats(b)
                .entity(ACEntityRegistry.BRAINIAC.get())
                .basicData(c -> meleeGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.PINNACLE, 10, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(Level.OVERWORLD))
                        .constraints(Constraints.forBiomes(biomes, ModTags.Biomes.IS_TOXIC_CAVES))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        addAncientBoss("tremorzilla", b -> ancientMeleeStats(b)
                .entity(ACEntityRegistry.TREMORZILLA.get())
                .basicData(c -> meleeGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.PINNACLE, 10, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(Level.OVERWORLD))
                        .constraints(Constraints.forBiomes(biomes, ModTags.Biomes.IS_TOXIC_CAVES))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        addAncientBoss("deep_one_knight", b -> basicMeleeStats(b)
                .entity(ACEntityRegistry.DEEP_ONE_KNIGHT.get())
                .basicData(c -> meleeGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.PINNACLE, 10, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(Level.OVERWORLD))
                        .constraints(Constraints.forBiomes(biomes, ModTags.Biomes.IS_ABYSSAL_CHASM))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        addAncientBoss("deep_one_mage", b -> basicMeleeStats(b)
                .entity(ACEntityRegistry.DEEP_ONE_MAGE.get())
                .basicData(c -> meleeGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.PINNACLE, 10, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(Level.OVERWORLD))
                        .constraints(Constraints.forBiomes(biomes, ModTags.Biomes.IS_ABYSSAL_CHASM))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        addAncientBoss("watcher", b -> basicMeleeStats(b)
                .entity(ACEntityRegistry.WATCHER.get())
                .basicData(c -> meleeGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.PINNACLE, 10, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(Level.OVERWORLD))
                        .constraints(Constraints.forBiomes(biomes, ModTags.Biomes.IS_FORLORN_HOLLOWS))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        addAncientBoss("forsaken", b -> basicMeleeStats(b)
                .entity(ACEntityRegistry.FORSAKEN.get())
                .basicData(c -> meleeGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.PINNACLE, 10, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(Level.OVERWORLD))
                        .constraints(Constraints.forBiomes(biomes, ModTags.Biomes.IS_FORLORN_HOLLOWS))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        addAncientBoss("caniac", b -> basicMeleeStats(b)
                .entity(ACEntityRegistry.CANIAC.get())
                .basicData(c -> meleeGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.PINNACLE, 10, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(Level.OVERWORLD))
                        .constraints(Constraints.forBiomes(biomes, ModTags.Biomes.IS_CANDY_CAVITY))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        addAncientBoss("licowitch", b -> basicRangedStats(b)
                .entity(ACEntityRegistry.LICOWITCH.get())
                .basicData(c -> rangedGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.PINNACLE, 10, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(Level.OVERWORLD))
                        .constraints(Constraints.forBiomes(biomes, ModTags.Biomes.IS_CANDY_CAVITY))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

    }

    protected static Invader.Builder ancientMeleeStats(Invader.Builder builder) {
        LootRarity ancient = ancientRarity("ancient");
        return builder
                .stats(ancient, c -> c
                        .enchantChance(0.95F)
                        .enchLevels(40, 30)
                        .effect(1, MobEffects.FIRE_RESISTANCE)
                        .modifier(Attributes.MAX_HEALTH, AttributeModifier.Operation.ADD_VALUE, 220, 450)
                        .modifier(Attributes.MOVEMENT_SPEED, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, 0.5F, 0.8F)
                        .modifier(Attributes.ATTACK_DAMAGE, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, 0.8F, 1.5F)
                        .modifier(Attributes.KNOCKBACK_RESISTANCE, AttributeModifier.Operation.ADD_VALUE, StepFunction.constant(1.2F))
                        .modifier(Attributes.ARMOR, AttributeModifier.Operation.ADD_VALUE, StepFunction.constant(20F))
                        .modifier(Attributes.ARMOR_TOUGHNESS, AttributeModifier.Operation.ADD_VALUE, StepFunction.constant(25F))
                        .modifier(Attributes.SCALE, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, -0.15F, 0.25F));
    }

    protected static Invader.Builder ancientRangedStats(Invader.Builder builder) {
        LootRarity ancient = ancientRarity("ancient");
        return builder
                .stats(ancient, c -> c
                        .enchantChance(0.95F)
                        .enchLevels(40, 30)
                        .effect(1, MobEffects.FIRE_RESISTANCE)
                        .modifier(Attributes.MAX_HEALTH, AttributeModifier.Operation.ADD_VALUE, 220, 450)
                        .modifier(Attributes.MOVEMENT_SPEED, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, 0.5F, 0.8F)
                        .modifier(ALObjects.Attributes.PROJECTILE_DAMAGE, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, 0.9F, 1.8F)
                        .modifier(Attributes.KNOCKBACK_RESISTANCE, AttributeModifier.Operation.ADD_VALUE, StepFunction.constant(1F))
                        .modifier(Attributes.ARMOR, AttributeModifier.Operation.ADD_VALUE, StepFunction.constant(20F))
                        .modifier(Attributes.ARMOR_TOUGHNESS, AttributeModifier.Operation.ADD_VALUE, StepFunction.constant(25F))
                        .modifier(Attributes.SCALE, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, -0.15F, 0.25F));
    }

    @Override
    protected void addBoss(String name, UnaryOperator<Invader.Builder> builder) {
        this.addConditionally(ApothicCompats.loc(mod + "/" + name), builder.apply(Invader.builder()).size(1.0, 1.0).build(), new ModLoadedCondition(mod));
    }

    protected void addAncientBoss(String name, UnaryOperator<Invader.Builder> builder) {
        this.addConditionally(ApothicCompats.loc(mod + "/ancient/" + name), builder.apply(Invader.builder()).size(1.0, 1.0).build(), new ModLoadedCondition(mod), new ModLoadedCondition(AncientReforging.MODID));
    }

    private static LootRarity ancientRarity(String path) {
        return Preconditions.checkNotNull(RarityRegistry.INSTANCE.getValue(AncientReforging.loc(path)));
    }
}
