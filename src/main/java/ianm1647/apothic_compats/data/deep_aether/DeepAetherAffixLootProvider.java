package ianm1647.apothic_compats.data.deep_aether;

import com.aetherteam.aether.item.AetherItems;
import com.aetherteam.aether.item.combat.AetherArmorMaterials;
import com.aetherteam.aether.item.combat.AetherItemTiers;
import com.kyanite.deeperdarker.util.DDArmorMaterials;
import dev.shadowsoffire.apotheosis.data.AffixLootEntryProvider;
import dev.shadowsoffire.apotheosis.loot.AffixLootEntry;
import dev.shadowsoffire.apotheosis.loot.LootCategory;
import dev.shadowsoffire.apotheosis.tiers.Constraints;
import dev.shadowsoffire.apotheosis.tiers.TieredWeights;
import dev.shadowsoffire.apotheosis.tiers.WorldTier;
import ianm1647.apothic_compats.ApothicCompats;
import io.github.razordevs.deep_aether.init.DAItems;
import io.github.razordevs.deep_aether.init.DATiers;
import io.github.razordevs.deep_aether.item.gear.DAArmorMaterials;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import org.checkerframework.checker.units.qual.A;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class DeepAetherAffixLootProvider extends AffixLootEntryProvider {

    String mod = "deep_aether";

    private static ResourceKey<Level> AETHER = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("aether:the_aether"));

    public Map<Holder<ArmorMaterial>, TieredWeights> armorWeights = new HashMap<>();
    public Map<Tier, TieredWeights> toolWeights = new HashMap<>();
    public Map<Item, TieredWeights> itemWeights = new HashMap<>();

    public DeepAetherAffixLootProvider(PackOutput output, CompletableFuture<Provider> registries) {
        super(output, registries);
    }

    protected static final TieredWeights SKYJADE = TieredWeights.builder()
        .with(WorldTier.ASCENT, 5, 0)
        .with(WorldTier.SUMMIT, 10, 0)
        .build();
    protected static final TieredWeights STRATUS = TieredWeights.builder()
        .with(WorldTier.SUMMIT, 5, 0)
        .with(WorldTier.PINNACLE, 10, 0)
        .build();
    protected static final TieredWeights STORMFORGED = TieredWeights.builder()
        .with(WorldTier.SUMMIT, 5, 0)
        .with(WorldTier.PINNACLE, 10, 0)
        .build();

    @Override
    public void generate() {
        armorWeights.put(DAArmorMaterials.SKYJADE, SKYJADE);
        armorWeights.put(DAArmorMaterials.STRATUS, STRATUS);
        armorWeights.put(DAArmorMaterials.STORMFORGED, STORMFORGED);

        toolWeights.put(DATiers.SKYJADE, SKYJADE);
        toolWeights.put(DATiers.STRATUS, STRATUS);
        toolWeights.put(DATiers.STORM, STORMFORGED);

        addEntry(new AffixLootEntry(STORMFORGED, DAItems.STORM_BOW.toStack()));

        for (Item i : BuiltInRegistries.ITEM) {
            if (!mod.equals(BuiltInRegistries.ITEM.getKey(i).getNamespace())) {
                continue;
            }

            LootCategory cat = LootCategory.forItem(i.getDefaultInstance());
            if (cat.isNone()) {
                continue;
            }

            if (i instanceof TieredItem t) {
                TieredWeights weights = toolWeights.get(t.getTier());
                if (weights != null) {
                    this.addEntry(weights, new ItemStack(i));
                }
            }
            else if (i instanceof ArmorItem a && a.getType() != ArmorItem.Type.BODY) {
                TieredWeights weights = armorWeights.get(a.getMaterial());
                if (weights != null) {
                    this.addEntry(weights, new ItemStack(i));
                }
            }
            else if (i instanceof Item t) {
                TieredWeights weights = itemWeights.get(t);
                if (weights != null) {
                    this.addEntry(weights, new ItemStack(i));
                }
            }
        }
    }

    @Override
    public String getName() {
        return "Deep Aether Affix Loot Entries";
    }


    protected void addEntry(TieredWeights weights, ItemStack stack) {
        ResourceLocation key = ResourceLocation.fromNamespaceAndPath(ApothicCompats.MODID,mod + "/" + BuiltInRegistries.ITEM.getKey(stack.getItem()).getPath());
        this.addConditionally(key, new AffixLootEntry(weights, Constraints.forDimension(AETHER), stack, Set.of()), new ModLoadedCondition(mod));
    }
}
