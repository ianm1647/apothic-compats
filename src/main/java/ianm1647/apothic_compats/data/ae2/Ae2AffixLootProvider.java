package ianm1647.apothic_compats.data.ae2;

import appeng.core.definitions.AEItems;
import appeng.items.tools.fluix.FluixToolType;
import appeng.items.tools.quartz.QuartzToolType;
import com.thevortex.allthemodium.material.ATMTier;
import com.thevortex.allthemodium.registry.ArmorRegistries;
import com.thevortex.allthemodium.registry.ModRegistry;
import dev.shadowsoffire.apotheosis.data.AffixLootEntryProvider;
import dev.shadowsoffire.apotheosis.loot.AffixLootEntry;
import dev.shadowsoffire.apotheosis.tiers.Constraints;
import dev.shadowsoffire.apotheosis.tiers.TieredWeights;
import dev.shadowsoffire.apotheosis.tiers.WorldTier;
import ianm1647.apothic_compats.ApothicCompats;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
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
        AEItems.DR.getEntries().forEach(item -> {
            String name = item.getId().getPath();
            if (item.get() instanceof TieredItem i && !name.contains("hoe")) {
                if (i.getTier() == QuartzToolType.NETHER.getToolTier()) {
                    addTools(QUARTZ, i);
                }
                if (i.getTier() == QuartzToolType.CERTUS.getToolTier()) {
                    addTools(CERTUS, i);
                }
                if (i.getTier() == FluixToolType.FLUIX.getToolTier()) {
                    addTools(FLUIX, i);
                }
            }
        });
    }

    @Override
    public String getName() {
        return "Applied Energistics Loot Entries";
    }

    protected void addTools(TieredWeights weights, Item... tools) {
        for (Item tool : tools) {
            this.addEntry(new AffixLootEntry(weights, Constraints.forDimension(Level.OVERWORLD), new ItemStack(tool), Set.of()));
        }
    }

    protected void addEntry(AffixLootEntry entry) {
        ResourceLocation key = ApothicCompats.loc(mod + "/" + BuiltInRegistries.ITEM.getKey(entry.stack().getItem()).getPath());
        this.addConditionally(key, entry, new ModLoadedCondition(mod));
    }
}
