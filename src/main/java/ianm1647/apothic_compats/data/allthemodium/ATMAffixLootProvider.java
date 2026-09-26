package ianm1647.apothic_compats.data.allthemodium;

import com.thevortex.allthemodium.material.ATMTier;
import com.thevortex.allthemodium.registry.ArmorRegistries;
import com.thevortex.allthemodium.registry.ModRegistry;
import dev.shadowsoffire.apotheosis.data.AffixLootEntryProvider;
import dev.shadowsoffire.apotheosis.loot.AffixLootEntry;
import dev.shadowsoffire.apotheosis.tiers.Constraints;
import dev.shadowsoffire.apotheosis.tiers.TieredWeights;
import dev.shadowsoffire.apotheosis.tiers.WorldTier;
import ianm1647.apothic_compats.ApothicCompats;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ATMAffixLootProvider extends AffixLootEntryProvider {

    String mod = "allthemodium";

    public ATMAffixLootProvider(PackOutput output, CompletableFuture<Provider> registries) {
        super(output, registries);
    }

    protected static final TieredWeights ALLTHEMODIUM = TieredWeights.builder()
        .with(WorldTier.PINNACLE, 5, 0)
        .build();
    protected static final TieredWeights VIBRANIUM = TieredWeights.builder()
        .with(WorldTier.PINNACLE, 2, 0)
        .build();
    protected static final TieredWeights UNOBTAINIUM = TieredWeights.builder()
        .with(WorldTier.PINNACLE, 1, 0)
        .build();

    @Override
    public void generate() {
        ModRegistry.ITEMS.getEntries().forEach(item -> {
            if (item.get() instanceof TieredItem i) {
                if (i.getTier() == ATMTier.ALLTHEMODIUM) {
                    addTools(ALLTHEMODIUM, i);
                }
                if (i.getTier() == ATMTier.VIBRANIUM) {
                    addTools(VIBRANIUM, i);
                }
                if (i.getTier() == ATMTier.UNOBTAINIUM) {
                    addTools(UNOBTAINIUM, i);
                }
            }

            if (item.get() instanceof ArmorItem a) {
                if (a.getMaterial() == ArmorRegistries.ATM) {
                    addArmor(ALLTHEMODIUM, a);
                }
                if (a.getMaterial() == ArmorRegistries.VIB) {
                    addArmor(VIBRANIUM, a);
                }
                if (a.getMaterial() == ArmorRegistries.UNOB) {
                    addArmor(UNOBTAINIUM, a);
                }
            }
        });

        addTools(ALLTHEMODIUM, ModRegistry.ATM_MACE.get());
        addTools(VIBRANIUM, ModRegistry.VIB_MACE.get());
        addTools(UNOBTAINIUM, ModRegistry.UNO_MACE.get());
    }

    @Override
    public String getName() {
        return "Allthemodium Loot Entries";
    }


    protected void addTools(TieredWeights weights, Item... tools) {
        for (Item tool : tools) {
            this.addEntry(new AffixLootEntry(weights, Constraints.forDimension(Level.OVERWORLD), new ItemStack(tool), Set.of()));
        }
    }

    protected void addArmor(TieredWeights weights, Item... pieces) {
        for (Item piece : pieces) {
            this.addEntry(new AffixLootEntry(weights, Constraints.forDimension(Level.OVERWORLD), new ItemStack(piece), Set.of()));
        }
    }

    protected void addEntry(AffixLootEntry entry) {
        ResourceLocation key = ApothicCompats.loc(mod + "/" + BuiltInRegistries.ITEM.getKey(entry.stack().getItem()).getPath());
        this.addConditionally(key, entry, new ModLoadedCondition(mod));
    }
}
