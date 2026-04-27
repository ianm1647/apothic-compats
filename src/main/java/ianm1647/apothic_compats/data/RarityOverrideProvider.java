package ianm1647.apothic_compats.data;

import dev.shadowsoffire.apotheosis.Apoth;
import dev.shadowsoffire.apotheosis.Apotheosis;
import dev.shadowsoffire.apotheosis.affix.AffixType;
import dev.shadowsoffire.apotheosis.loot.*;
import dev.shadowsoffire.placebo.util.data.DynamicRegistryProvider;
import ianm1647.ancientreforging.AncientReforging;
import ianm1647.apothic_compats.ApothicCompats;
import ianm1647.apothic_compats.Comp.LootCategories.Curios;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import net.neoforged.neoforge.common.conditions.NotCondition;
import org.spongepowered.include.com.google.common.base.Preconditions;

import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

public class RarityOverrideProvider extends DynamicRegistryProvider<RarityOverride> {
    public RarityOverrideProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, RarityOverrideRegistry.INSTANCE);
    }

    @Override
    public void generate() {
        LootRarity common = rarity("common");
        LootRarity uncommon = rarity("uncommon");
        LootRarity rare = rarity("rare");
        LootRarity epic = rarity("epic");
        LootRarity mythic = rarity("mythic");
        LootRarity ancient = ancientRarity("ancient");

        addOverride(Curios.BACK, b -> b
                .override(uncommon, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(0, 1)))
                .override(rare, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.15F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 1)))
                .override(epic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 2)))
                .override(mythic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.SocketLootRule(2, 2))));

        addAncientOverride(Curios.BACK, b -> b
                .override(uncommon, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(0, 1)))
                .override(rare, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.15F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 1)))
                .override(epic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 2)))
                .override(mythic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.SocketLootRule(2, 2)))
                .override(ancient, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.1F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(2, 3))));

        addOverride(Curios.BELT, b -> b
                .override(uncommon, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(0, 1)))
                .override(rare, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.15F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 1)))
                .override(epic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 2)))
                .override(mythic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.SocketLootRule(2, 2))));

        addAncientOverride(Curios.BELT, b -> b
                .override(uncommon, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(0, 1)))
                .override(rare, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.15F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 1)))
                .override(epic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 2)))
                .override(mythic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.SocketLootRule(2, 2)))
                .override(ancient, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.1F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(2, 3))));

        addOverride(Curios.BODY, b -> b
                .override(uncommon, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(0, 1)))
                .override(rare, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.15F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 1)))
                .override(epic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 2)))
                .override(mythic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.SocketLootRule(2, 2))));

        addAncientOverride(Curios.BODY, b -> b
                .override(uncommon, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(0, 1)))
                .override(rare, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.15F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 1)))
                .override(epic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 2)))
                .override(mythic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.SocketLootRule(2, 2)))
                .override(ancient, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.1F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(2, 3))));

        addOverride(Curios.BRACELET, b -> b
                .override(uncommon, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(0, 1)))
                .override(rare, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.15F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 1)))
                .override(epic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 2)))
                .override(mythic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.SocketLootRule(2, 2))));

        addAncientOverride(Curios.BRACELET, b -> b
                .override(uncommon, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(0, 1)))
                .override(rare, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.15F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 1)))
                .override(epic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 2)))
                .override(mythic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.SocketLootRule(2, 2)))
                .override(ancient, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.1F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(2, 3))));

        addOverride(Curios.CHARM, b -> b
                .override(uncommon, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(0, 1)))
                .override(rare, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.15F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 1)))
                .override(epic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 2)))
                .override(mythic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.SocketLootRule(2, 2))));

        addAncientOverride(Curios.CHARM, b -> b
                .override(uncommon, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(0, 1)))
                .override(rare, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.15F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 1)))
                .override(epic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 2)))
                .override(mythic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.SocketLootRule(2, 2)))
                .override(ancient, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.1F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(2, 3))));

        addOverride(Curios.CURIO, b -> b
                .override(uncommon, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(0, 1)))
                .override(rare, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.15F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 1)))
                .override(epic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 2)))
                .override(mythic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.SocketLootRule(2, 2))));

        addAncientOverride(Curios.CURIO, b -> b
                .override(uncommon, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(0, 1)))
                .override(rare, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.15F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 1)))
                .override(epic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 2)))
                .override(mythic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.SocketLootRule(2, 2)))
                .override(ancient, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.1F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(2, 3))));

        addOverride(Curios.FEET, b -> b
                .override(uncommon, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(0, 1)))
                .override(rare, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.15F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 1)))
                .override(epic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 2)))
                .override(mythic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.SocketLootRule(2, 2))));

        addAncientOverride(Curios.FEET, b -> b
                .override(uncommon, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(0, 1)))
                .override(rare, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.15F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 1)))
                .override(epic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 2)))
                .override(mythic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.SocketLootRule(2, 2)))
                .override(ancient, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.1F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(2, 3))));

        addOverride(Curios.HANDS, b -> b
                .override(uncommon, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(0, 1)))
                .override(rare, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.15F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 1)))
                .override(epic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 2)))
                .override(mythic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.SocketLootRule(2, 2))));

        addAncientOverride(Curios.HANDS, b -> b
                .override(uncommon, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(0, 1)))
                .override(rare, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.15F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 1)))
                .override(epic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 2)))
                .override(mythic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.SocketLootRule(2, 2)))
                .override(ancient, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.1F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(2, 3))));

        addOverride(Curios.HEAD, b -> b
                .override(uncommon, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(0, 1)))
                .override(rare, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.15F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 1)))
                .override(epic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 2)))
                .override(mythic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.SocketLootRule(2, 2))));

        addAncientOverride(Curios.HEAD, b -> b
                .override(uncommon, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(0, 1)))
                .override(rare, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.15F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 1)))
                .override(epic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 2)))
                .override(mythic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.SocketLootRule(2, 2)))
                .override(ancient, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.1F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(2, 3))));

        addOverride(Curios.NECKLACE, b -> b
                .override(uncommon, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(0, 1)))
                .override(rare, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.15F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 1)))
                .override(epic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 2)))
                .override(mythic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.SocketLootRule(2, 2))));

        addAncientOverride(Curios.NECKLACE, b -> b
                .override(uncommon, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(0, 1)))
                .override(rare, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.15F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 1)))
                .override(epic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 2)))
                .override(mythic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.SocketLootRule(2, 2)))
                .override(ancient, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.1F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(2, 3))));

        addOverride(Curios.RING, b -> b
                .override(uncommon, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(0, 1)))
                .override(rare, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.15F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 1)))
                .override(epic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 2)))
                .override(mythic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.SocketLootRule(2, 2))));

        addAncientOverride(Curios.RING, b -> b
                .override(uncommon, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(0, 1)))
                .override(rare, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.15F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 1)))
                .override(epic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 2)))
                .override(mythic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.SocketLootRule(2, 2)))
                .override(ancient, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.1F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(2, 3))));

        addOverride(Curios.AN_FOCUS, b -> b
                .override(uncommon, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(0, 1)))
                .override(rare, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.15F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 1)))
                .override(epic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 2)))
                .override(mythic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.SocketLootRule(2, 2))));

        addAncientOverride(Curios.AN_FOCUS, b -> b
                .override(uncommon, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(0, 1)))
                .override(rare, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.15F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 1)))
                .override(epic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 2)))
                .override(mythic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.SocketLootRule(2, 2)))
                .override(ancient, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.1F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(2, 3))));

        addOverride(Curios.BROOCH, b -> b
                .override(uncommon, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(0, 1)))
                .override(rare, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.15F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 1)))
                .override(epic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 2)))
                .override(mythic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.SocketLootRule(2, 2))));

        addAncientOverride(Curios.BROOCH, b -> b
                .override(uncommon, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(0, 1)))
                .override(rare, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.15F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 1)))
                .override(epic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 2)))
                .override(mythic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.SocketLootRule(2, 2)))
                .override(ancient, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.1F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(2, 3))));

        addOverride(Curios.RUNE, b -> b
                .override(uncommon, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(0, 1)))
                .override(rare, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.15F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 1)))
                .override(epic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 2)))
                .override(mythic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.SocketLootRule(2, 2))));

        addAncientOverride(Curios.RUNE, b -> b
                .override(uncommon, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(0, 1)))
                .override(rare, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.15F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 1)))
                .override(epic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.5F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(1, 2)))
                .override(mythic, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.SocketLootRule(2, 2)))
                .override(ancient, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.1F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(2, 3))));

    }

    @Override
    public String getName() {
        return "Rarity Overrides";
    }

    private void addOverride(LootCategory category, UnaryOperator<RarityOverride.Builder> config) {
        this.addConditionally(ApothicCompats.loc(Apoth.BuiltInRegs.LOOT_CATEGORY.getKey(category).toString().replace(':', '/')),
                config.apply(RarityOverride.builder(category)).build(), new NotCondition(new ModLoadedCondition("ancientreforging")));
    }

    private void addAncientOverride(LootCategory category, UnaryOperator<RarityOverride.Builder> config) {
        this.addConditionally(AncientReforging.loc(Apoth.BuiltInRegs.LOOT_CATEGORY.getKey(category).toString().replace(':', '/')),
                config.apply(RarityOverride.builder(category)).build(), new ModLoadedCondition("ancientreforging"));
    }

    private static LootRarity rarity(String path) {
        return Preconditions.checkNotNull(RarityRegistry.INSTANCE.getValue(Apotheosis.loc(path)));
    }

    private static LootRarity ancientRarity(String path) {
        return Preconditions.checkNotNull(RarityRegistry.INSTANCE.getValue(AncientReforging.loc(path)));
    }
}