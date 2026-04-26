package ianm1647.apothic_compats.data.ae2;

import dev.shadowsoffire.apotheosis.data.AffixLootEntryProvider;
import dev.shadowsoffire.apotheosis.loot.AffixLootEntry;
import dev.shadowsoffire.apotheosis.tiers.TieredWeights;
import dev.shadowsoffire.apotheosis.tiers.WorldTier;
import ianm1647.ancientreforging.AncientReforging;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.*;

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
//        toolWeights.put(QuartzToolType.NETHER.getToolTier(), QUARTZ);
//        toolWeights.put(QuartzToolType.CERTUS.getToolTier(), CERTUS);
//        toolWeights.put(FluixToolType.FLUIX.getToolTier(), FLUIX);
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
        this.add(AncientReforging.loc(BuiltInRegistries.ITEM.getKey(entry.stackTemplate().item().value()).getPath()), entry);
    }
}
