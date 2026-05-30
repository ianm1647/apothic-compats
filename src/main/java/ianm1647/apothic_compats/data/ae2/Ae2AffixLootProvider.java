package ianm1647.apothic_compats.data.ae2;

import appeng.core.ConventionTags;
import appeng.core.definitions.AEItems;
import appeng.items.tools.fluix.FluixToolType;
import dev.shadowsoffire.apotheosis.data.AffixLootEntryProvider;
import dev.shadowsoffire.apotheosis.loot.AffixLootEntry;
import dev.shadowsoffire.apotheosis.tiers.TieredWeights;
import dev.shadowsoffire.apotheosis.tiers.WorldTier;
import ianm1647.ancientreforging.AncientReforging;
import ianm1647.apothic_compats.ApothicCompats;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.concurrent.CompletableFuture;

public class Ae2AffixLootProvider extends AffixLootEntryProvider {

    String mod = "ae2";

    public Ae2AffixLootProvider(PackOutput output, CompletableFuture<Provider> registries) {
        super(output, registries);
    }

    protected static final TieredWeights QUARTZ = TieredWeights.builder()
        .with(WorldTier.FRONTIER, 10, 0)
        .with(WorldTier.ASCENT, 5, 0)
        .build();
    protected static final TieredWeights CERTUS = TieredWeights.builder()
        .with(WorldTier.ASCENT, 10, 0)
        .with(WorldTier.SUMMIT, 5, 0)
        .build();
    protected static final TieredWeights FLUIX = TieredWeights.builder()
        .with(WorldTier.ASCENT, 10, 0)
        .with(WorldTier.SUMMIT, 10, 0)
        .build();

    @Override
    public void generate() {
        addTools(QUARTZ, AEItems.NETHER_QUARTZ_SWORD.get(), AEItems.NETHER_QUARTZ_AXE.get(), AEItems.NETHER_QUARTZ_PICK.get(), AEItems.NETHER_QUARTZ_SHOVEL.get());
        addTools(CERTUS, AEItems.CERTUS_QUARTZ_SWORD.get(), AEItems.CERTUS_QUARTZ_AXE.get(), AEItems.CERTUS_QUARTZ_PICK.get(), AEItems.CERTUS_QUARTZ_SHOVEL.get());
        addTools(FLUIX, AEItems.FLUIX_SWORD.get(), AEItems.FLUIX_AXE.get(), AEItems.FLUIX_PICK.get(), AEItems.FLUIX_SHOVEL.get());
    }

    @Override
    public String getName() {
        return "Applied Energistics Loot Entries";
    }


    protected void addTools(TieredWeights weights, Item... tools) {
        for (Item tool : tools) {
            this.addEntry(new AffixLootEntry(weights, new ItemStackTemplate(tool)));
        }
    }

    protected void addArmor(TieredWeights weights, Item... pieces) {
        for (Item piece : pieces) {
            this.addEntry(new AffixLootEntry(weights, new ItemStackTemplate(piece)));
        }
    }

    protected void addEntry(AffixLootEntry entry) {
        Identifier key = ApothicCompats.loc(mod + "/" + BuiltInRegistries.ITEM.getKey(entry.stackTemplate().item().value()).getPath());
        this.addConditionally(key, entry, new ModLoadedCondition(mod));
    }
}
