package ianm1647.apothic_compats.data;

import dev.shadowsoffire.apotheosis.Apoth;
import dev.shadowsoffire.apotheosis.Apotheosis;
import dev.shadowsoffire.apotheosis.affix.AffixType;
import dev.shadowsoffire.apotheosis.loot.*;
import dev.shadowsoffire.placebo.util.data.DynamicRegistryProvider;
import ianm1647.ancientreforging.AncientReforging;
import ianm1647.apothic_compats.ApothicCompats;
import ianm1647.apothic_compats.Comp;
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

    String curios = "curios";

    @Override
    public void generate() {
        LootRarity common = rarity("common");
        LootRarity uncommon = rarity("uncommon");
        LootRarity rare = rarity("rare");
        LootRarity epic = rarity("epic");
        LootRarity mythic = rarity("mythic");
        LootRarity ancient = ancientRarity("ancient");

        addOverride(Comp.LootCategories.Curios.BACK, curios, b -> b
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

        addAncientOverride(Comp.LootCategories.Curios.BACK, curios, b -> b
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

        addOverride(Comp.LootCategories.Curios.BELT, curios, b -> b
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

        addAncientOverride(Comp.LootCategories.Curios.BELT, curios, b -> b
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

        addOverride(Comp.LootCategories.Curios.BODY, curios, b -> b
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

        addAncientOverride(Comp.LootCategories.Curios.BODY, curios, b -> b
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

        addOverride(Comp.LootCategories.Curios.BRACELET, curios, b -> b
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

        addAncientOverride(Comp.LootCategories.Curios.BRACELET, curios, b -> b
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

        addOverride(Comp.LootCategories.Curios.CHARM, curios, b -> b
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

        addAncientOverride(Comp.LootCategories.Curios.CHARM, curios, b -> b
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

        addOverride(Comp.LootCategories.Curios.CURIO, curios, b -> b
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

        addAncientOverride(Comp.LootCategories.Curios.CURIO, curios, b -> b
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

        addOverride(Comp.LootCategories.Curios.FEET, curios, b -> b
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

        addAncientOverride(Comp.LootCategories.Curios.FEET, curios, b -> b
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

        addOverride(Comp.LootCategories.Curios.HANDS, curios, b -> b
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

        addAncientOverride(Comp.LootCategories.Curios.HANDS, curios, b -> b
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

        addOverride(Comp.LootCategories.Curios.HEAD, curios, b -> b
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

        addAncientOverride(Comp.LootCategories.Curios.HEAD, curios, b -> b
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

        addOverride(Comp.LootCategories.Curios.NECKLACE, curios, b -> b
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

        addAncientOverride(Comp.LootCategories.Curios.NECKLACE, curios, b -> b
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

        addOverride(Comp.LootCategories.Curios.RING, curios, b -> b
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

        addAncientOverride(Comp.LootCategories.Curios.RING, curios, b -> b
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

        addOverride(Comp.LootCategories.Curios.AN_FOCUS, curios, b -> b
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

        addAncientOverride(Comp.LootCategories.Curios.AN_FOCUS, curios, b -> b
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

        addOverride(Comp.LootCategories.Curios.BROOCH, curios, b -> b
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

        addAncientOverride(Comp.LootCategories.Curios.BROOCH, curios, b -> b
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

        addOverride(Comp.LootCategories.Curios.RUNE, curios, b -> b
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

        addAncientOverride(Comp.LootCategories.Curios.RUNE, curios, b -> b
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

    private void addOverride(LootCategory category, String mod, UnaryOperator<RarityOverride.Builder> config) {
        this.addConditionally(ApothicCompats.loc(Apoth.BuiltInRegs.LOOT_CATEGORY.getKey(category).toString().replace(':', '/')),
                config.apply(RarityOverride.builder(category)).build(), new ModLoadedCondition(mod), new NotCondition(new ModLoadedCondition(AncientReforging.MODID)));
    }

    private void addAncientOverride(LootCategory category, String mod, UnaryOperator<RarityOverride.Builder> config) {
        this.addConditionally(AncientReforging.loc(Apoth.BuiltInRegs.LOOT_CATEGORY.getKey(category).toString().replace(':', '/')),
                config.apply(RarityOverride.builder(category)).build(), new ModLoadedCondition(mod), new ModLoadedCondition(AncientReforging.MODID));
    }

    private static LootRarity rarity(String path) {
        return Preconditions.checkNotNull(RarityRegistry.INSTANCE.getValue(Apotheosis.loc(path)));
    }

    private static LootRarity ancientRarity(String path) {
        return Preconditions.checkNotNull(RarityRegistry.INSTANCE.getValue(AncientReforging.loc(path)));
    }
}