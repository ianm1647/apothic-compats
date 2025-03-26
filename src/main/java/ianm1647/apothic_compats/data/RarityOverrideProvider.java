package ianm1647.apothic_compats.data;

import dev.shadowsoffire.apotheosis.Apoth;
import dev.shadowsoffire.apotheosis.Apotheosis;
import dev.shadowsoffire.apotheosis.affix.AffixType;
import dev.shadowsoffire.apotheosis.loot.*;
import dev.shadowsoffire.placebo.util.data.DynamicRegistryProvider;
import ianm1647.ancientreforging.AncientReforging;
import ianm1647.apothic_compats.loot.ModLootCategories;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
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
                        .rule(new LootRule.SocketLootRule(2, 2)))
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
                        .rule(new LootRule.SocketLootRule(2, 2)))
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
                        .rule(new LootRule.SocketLootRule(2, 2)))
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
                        .rule(new LootRule.SocketLootRule(2, 2)))
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
                        .rule(new LootRule.SocketLootRule(2, 2)))
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
                        .rule(new LootRule.SocketLootRule(2, 2)))
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
                        .rule(new LootRule.SocketLootRule(2, 2)))
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
                        .rule(new LootRule.SocketLootRule(2, 2)))
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
                        .rule(new LootRule.SocketLootRule(2, 2)))
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
                        .rule(new LootRule.SocketLootRule(2, 2)))
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
        this.add(Apotheosis.loc(Apoth.BuiltInRegs.LOOT_CATEGORY.getKey(category).toString().replace(':', '/')),
                config.apply(new RarityOverride.Builder(category)).build());
    }

    private static LootRarity rarity(String path) {
        return Preconditions.checkNotNull(RarityRegistry.INSTANCE.getValue(Apotheosis.loc(path)));
    }

    private static LootRarity ancientRarity(String path) {
        return Preconditions.checkNotNull(RarityRegistry.INSTANCE.getValue(AncientReforging.loc(path)));
    }
}