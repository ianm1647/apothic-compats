package ianm1647.apothic_compats.data;

import dev.shadowsoffire.apotheosis.Apoth;
import dev.shadowsoffire.apotheosis.Apotheosis;
import dev.shadowsoffire.apotheosis.affix.AffixType;
import dev.shadowsoffire.apotheosis.loot.*;
import dev.shadowsoffire.placebo.util.data.DynamicRegistryProvider;
import ianm1647.ancientreforging.AncientReforging;
import ianm1647.apothic_compats.ApothicCompats;
import ianm1647.apothic_compats.loot.ModLootCategories;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
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

        addOverride(ModLootCategories.BACK, b -> b
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

        addAncientOverride(ModLootCategories.BACK, b -> b
                .override(ancient, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.1F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(2, 3))));

        addOverride(ModLootCategories.BELT, b -> b
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

        addAncientOverride(ModLootCategories.BELT, b -> b
                .override(ancient, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.1F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(2, 3))));

        addOverride(ModLootCategories.BODY, b -> b
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

        addAncientOverride(ModLootCategories.BODY, b -> b
                .override(ancient, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.1F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(2, 3))));

        addOverride(ModLootCategories.BRACELET, b -> b
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

        addAncientOverride(ModLootCategories.BRACELET, b -> b
                .override(ancient, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.1F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(2, 3))));

        addOverride(ModLootCategories.CHARM, b -> b
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

        addAncientOverride(ModLootCategories.CHARM, b -> b
                .override(ancient, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.1F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(2, 3))));

        addOverride(ModLootCategories.CURIO, b -> b
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

        addAncientOverride(ModLootCategories.CURIO, b -> b
                .override(ancient, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.1F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(2, 3))));

        addOverride(ModLootCategories.FEET, b -> b
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

        addAncientOverride(ModLootCategories.FEET, b -> b
                .override(ancient, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.1F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(2, 3))));

        addOverride(ModLootCategories.HANDS, b -> b
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

        addAncientOverride(ModLootCategories.HANDS, b -> b
                .override(ancient, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.1F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(2, 3))));

        addOverride(ModLootCategories.HEAD, b -> b
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

        addAncientOverride(ModLootCategories.HEAD, b -> b
                .override(ancient, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.1F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(2, 3))));

        addOverride(ModLootCategories.NECKLACE, b -> b
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

        addAncientOverride(ModLootCategories.NECKLACE, b -> b
                .override(ancient, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.1F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(2, 3))));

        addOverride(ModLootCategories.RING, b -> b
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

        addAncientOverride(ModLootCategories.RING, b -> b
                .override(ancient, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.1F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(2, 3))));

        addOverride(ModLootCategories.AN_FOCUS, b -> b
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

        addAncientOverride(ModLootCategories.AN_FOCUS, b -> b
                .override(ancient, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.1F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(2, 3))));

        addOverride(ModLootCategories.BROOCH, b -> b
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

        addAncientOverride(ModLootCategories.BROOCH, b -> b
                .override(ancient, c -> c
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.AffixLootRule(AffixType.STAT))
                        .rule(new LootRule.ChancedLootRule(0.1F, new LootRule.AffixLootRule(AffixType.STAT)))
                        .rule(new LootRule.SocketLootRule(2, 3))));

        addOverride(ModLootCategories.RUNE, b -> b
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

        addAncientOverride(ModLootCategories.RUNE, b -> b
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
        this.add(ApothicCompats.loc("curios/" + Apoth.BuiltInRegs.LOOT_CATEGORY.getKey(category).getPath()),
                config.apply(RarityOverride.builder(category)).build());
    }

    private void addAncientOverride(LootCategory category, UnaryOperator<RarityOverride.Builder> config) {
        this.addConditionally(ApothicCompats.loc("curios/ancient/" + Apoth.BuiltInRegs.LOOT_CATEGORY.getKey(category).getPath()),
                config.apply(RarityOverride.builder(category)).build(), new ModLoadedCondition("ancientreforging"));
    }

    private static LootRarity rarity(String path) {
        return Preconditions.checkNotNull(RarityRegistry.INSTANCE.getValue(Apotheosis.loc(path)));
    }

    private static LootRarity ancientRarity(String path) {
        return Preconditions.checkNotNull(RarityRegistry.INSTANCE.getValue(AncientReforging.loc(path)));
    }
}