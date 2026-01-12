package ianm1647.apothic_compats.data.aether;

import com.aetherteam.aether.item.AetherItems;
import com.aetherteam.aether.item.combat.AetherArmorMaterials;
import com.aetherteam.aether.item.combat.AetherItemTiers;
import dev.shadowsoffire.apotheosis.data.AffixLootEntryProvider;
import dev.shadowsoffire.apotheosis.loot.AffixLootEntry;
import dev.shadowsoffire.apotheosis.loot.LootCategory;
import dev.shadowsoffire.apotheosis.tiers.Constraints;
import dev.shadowsoffire.apotheosis.tiers.TieredWeights;
import dev.shadowsoffire.apotheosis.tiers.WorldTier;
import ianm1647.apothic_compats.ApothicCompats;
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

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class AetherAffixLootProvider extends AffixLootEntryProvider {

    String mod = "aether";

    private static ResourceKey<Level> AETHER = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("aether:the_aether"));

    public Map<Holder<ArmorMaterial>, TieredWeights> armorWeights = new HashMap<>();
    public Map<Tier, TieredWeights> toolWeights = new HashMap<>();
    public Map<Item, TieredWeights> itemWeights = new HashMap<>();

    public AetherAffixLootProvider(PackOutput output, CompletableFuture<Provider> registries) {
        super(output, registries);
    }

    protected static final TieredWeights SKYROOT = TieredWeights.builder()
        .with(WorldTier.HAVEN, 25, 1)
        .with(WorldTier.FRONTIER, 10, 0)
        .with(WorldTier.ASCENT, 5, 0)
        .build();
    protected static final TieredWeights HOLYSTONE = TieredWeights.builder()
        .with(WorldTier.FRONTIER, 25, 1)
        .with(WorldTier.ASCENT, 10, 0)
        .with(WorldTier.SUMMIT, 5, 0)
        .build();
    protected static final TieredWeights ZANITE = TieredWeights.builder()
        .with(WorldTier.ASCENT, 25, 0)
        .with(WorldTier.SUMMIT, 15, 0)
        .with(WorldTier.PINNACLE, 5, 0)
        .build();
    protected static final TieredWeights GRAVITITE = TieredWeights.builder()
        .with(WorldTier.ASCENT, 25, 0)
        .with(WorldTier.SUMMIT, 15, 0)
        .with(WorldTier.PINNACLE, 5, 0)
        .build();
    protected static final TieredWeights VALKYRIE = TieredWeights.builder()
            .with(WorldTier.SUMMIT, 10, 0)
            .with(WorldTier.PINNACLE, 25, 0)
            .build();


    protected static final TieredWeights OBSIDIAN = TieredWeights.builder()
            .with(WorldTier.SUMMIT, 10, 0)
            .with(WorldTier.PINNACLE, 25, 0)
            .build();
    protected static final TieredWeights NEPTUNE = TieredWeights.builder()
            .with(WorldTier.SUMMIT, 10, 0)
            .with(WorldTier.PINNACLE, 25, 0)
            .build();
    protected static final TieredWeights PHOENIX = TieredWeights.builder()
            .with(WorldTier.SUMMIT, 10, 0)
            .with(WorldTier.PINNACLE, 25, 0)
            .build();
    protected static final TieredWeights SENTRY = TieredWeights.builder()
            .with(WorldTier.SUMMIT, 10, 0)
            .with(WorldTier.PINNACLE, 25, 0)
            .build();

    protected static final TieredWeights CANDY_CANE = TieredWeights.builder()
            .with(WorldTier.SUMMIT, 10, 0)
            .with(WorldTier.PINNACLE, 25, 0)
            .build();
    protected static final TieredWeights VAMPIRE = TieredWeights.builder()
            .with(WorldTier.SUMMIT, 10, 0)
            .with(WorldTier.PINNACLE, 25, 0)
            .build();
    protected static final TieredWeights HOLY = TieredWeights.builder()
            .with(WorldTier.SUMMIT, 10, 0)
            .with(WorldTier.PINNACLE, 25, 0)
            .build();
    protected static final TieredWeights LIGHTNING = TieredWeights.builder()
            .with(WorldTier.SUMMIT, 10, 0)
            .with(WorldTier.PINNACLE, 25, 0)
            .build();
    protected static final TieredWeights FLAMING = TieredWeights.builder()
            .with(WorldTier.SUMMIT, 10, 0)
            .with(WorldTier.PINNACLE, 25, 0)
            .build();


    protected static final TieredWeights BOWS = TieredWeights.builder()
            .with(WorldTier.SUMMIT, 7, 1)
            .with(WorldTier.PINNACLE, 10, 1)
            .build();

    protected static final TieredWeights SHIELDS = TieredWeights.builder()
            .with(WorldTier.SUMMIT, 7, 1)
            .with(WorldTier.PINNACLE, 10, 1)
            .build();

    @Override
    public void generate() {
        armorWeights.put(AetherArmorMaterials.ZANITE, ZANITE);
        armorWeights.put(AetherArmorMaterials.GRAVITITE, GRAVITITE);
        armorWeights.put(AetherArmorMaterials.VALKYRIE, VALKYRIE);
        armorWeights.put(AetherArmorMaterials.OBSIDIAN, OBSIDIAN);
        armorWeights.put(AetherArmorMaterials.NEPTUNE, NEPTUNE);
        armorWeights.put(AetherArmorMaterials.PHOENIX, PHOENIX);
        armorWeights.put(AetherArmorMaterials.SENTRY, SENTRY);

        toolWeights.put(AetherItemTiers.SKYROOT, SKYROOT);
        toolWeights.put(AetherItemTiers.HOLYSTONE, HOLYSTONE);
        toolWeights.put(AetherItemTiers.ZANITE, ZANITE);
        toolWeights.put(AetherItemTiers.GRAVITITE, GRAVITITE);
        toolWeights.put(AetherItemTiers.VALKYRIE, VALKYRIE);

        toolWeights.put(AetherItemTiers.CANDY_CANE, CANDY_CANE);
        toolWeights.put(AetherItemTiers.VAMPIRE, VAMPIRE);
        toolWeights.put(AetherItemTiers.HOLY, HOLY);
        toolWeights.put(AetherItemTiers.LIGHTNING, LIGHTNING);
        toolWeights.put(AetherItemTiers.FLAMING, FLAMING);

        itemWeights.put(AetherItems.PHOENIX_BOW.get(), BOWS);

        addEntry(BOWS, new ItemStack(AetherItems.POISON_DART_SHOOTER.get()));
        addEntry(BOWS, new ItemStack(AetherItems.ENCHANTED_DART_SHOOTER.get()));
        addEntry(BOWS, new ItemStack(AetherItems.GOLDEN_DART_SHOOTER.get()));

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
        return "Aether Affix Loot Entries";
    }


    protected void addEntry(TieredWeights weights, ItemStack stack) {
        ResourceLocation key = ApothicCompats.loc(mod + "/" + BuiltInRegistries.ITEM.getKey(stack.getItem()).getPath());
        this.addConditionally(key, new AffixLootEntry(weights, Constraints.forDimension(AETHER), stack, Set.of()), new ModLoadedCondition(mod));
    }
}
