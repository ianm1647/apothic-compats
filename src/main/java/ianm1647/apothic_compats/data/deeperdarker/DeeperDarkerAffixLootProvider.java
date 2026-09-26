package ianm1647.apothic_compats.data.deeperdarker;

import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.util.DDArmorMaterials;
import com.kyanite.deeperdarker.util.DDTiers;
import com.thevortex.allthemodium.registry.ModRegistry;
import dev.shadowsoffire.apotheosis.data.AffixLootEntryProvider;
import dev.shadowsoffire.apotheosis.loot.AffixLootEntry;
import dev.shadowsoffire.apotheosis.loot.LootCategory;
import dev.shadowsoffire.apotheosis.tiers.Constraints;
import dev.shadowsoffire.apotheosis.tiers.TieredWeights;
import dev.shadowsoffire.apotheosis.tiers.WorldTier;
import ianm1647.apothic_compats.ApothicCompats;
import io.github.razordevs.deep_aether.init.DATiers;
import io.github.razordevs.deep_aether.item.gear.DAArmorMaterials;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class DeeperDarkerAffixLootProvider extends AffixLootEntryProvider {

    String mod = "deeperdarker";

    private static ResourceKey<Level> OTHERSIDE = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("deeperdarker:otherside"));

    public DeeperDarkerAffixLootProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    protected static final TieredWeights RESONARIUM = TieredWeights.builder()
            .with(WorldTier.ASCENT, 5, 0)
            .with(WorldTier.SUMMIT, 10, 0)
            .build();

    protected static final TieredWeights WARDEN = TieredWeights.builder()
            .with(WorldTier.SUMMIT, 5, 0)
            .with(WorldTier.PINNACLE, 10, 0)
            .build();

    @Override
    public void generate() {
        DDItems.ITEMS.getEntries().forEach(item -> {
            if (item.get() instanceof TieredItem i) {
                if (i.getTier() == DDTiers.RESONARIUM) {
                    addTools(RESONARIUM, i);
                }
                if (i.getTier() == DDTiers.WARDEN) {
                    addTools(WARDEN, i);
                }
            }

            if (item.get() instanceof ArmorItem a) {
                if (a.getMaterial() == DDArmorMaterials.RESONARIUM) {
                    addArmor(RESONARIUM, a);
                }
                if (a.getMaterial() == DDArmorMaterials.WARDEN) {
                    addArmor(WARDEN, a);
                }
            }
        });
    }

    @Override
    public String getName() {
        return "Deeper Darker Affix Loot Entries";
    }

    protected void addTools(TieredWeights weights, Item... tools) {
        for (Item tool : tools) {
            this.addEntry(new AffixLootEntry(weights, Constraints.forDimension(OTHERSIDE), new ItemStack(tool), Set.of()));
        }
    }

    protected void addArmor(TieredWeights weights, Item... pieces) {
        for (Item piece : pieces) {
            this.addEntry(new AffixLootEntry(weights, Constraints.forDimension(OTHERSIDE), new ItemStack(piece), Set.of()));
        }
    }

    protected void addEntry(AffixLootEntry entry) {
        ResourceLocation key = ApothicCompats.loc(mod + "/" + BuiltInRegistries.ITEM.getKey(entry.stack().getItem()).getPath());
        this.addConditionally(key, entry, new ModLoadedCondition(mod));
    }
}
