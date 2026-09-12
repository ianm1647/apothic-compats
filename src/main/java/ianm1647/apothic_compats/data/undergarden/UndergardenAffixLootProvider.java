package ianm1647.apothic_compats.data.undergarden;

import dev.shadowsoffire.apotheosis.Apotheosis;
import dev.shadowsoffire.apotheosis.data.AffixLootEntryProvider;
import dev.shadowsoffire.apotheosis.loot.AffixLootEntry;
import dev.shadowsoffire.apotheosis.tiers.Constraints;
import dev.shadowsoffire.apotheosis.tiers.TieredWeights;
import dev.shadowsoffire.apotheosis.tiers.WorldTier;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import quek.undergarden.registry.UGArmorMaterials;
import quek.undergarden.registry.UGItemTiers;
import quek.undergarden.registry.UGItems;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class UndergardenAffixLootProvider extends AffixLootEntryProvider {

    String mod = "undergarden";

    private static ResourceKey<Level> UNDERGARDEN = ResourceKey.create(Registries.DIMENSION, Identifier.parse("undergarden:undergarden"));

    public UndergardenAffixLootProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    protected static final TieredWeights CLOGGRUM = TieredWeights.builder()
            .with(WorldTier.FRONTIER, 15, 0)
            .with(WorldTier.ASCENT, 25, 0)
            .build();

    protected static final TieredWeights ANCIENT = TieredWeights.builder()
            .with(WorldTier.FRONTIER, 15, 0)
            .with(WorldTier.ASCENT, 25, 0)
            .build();

    protected static final TieredWeights FROSTSTEEL = TieredWeights.builder()
            .with(WorldTier.ASCENT, 15, 0)
            .with(WorldTier.SUMMIT, 25, 0)
            .build();

    protected static final TieredWeights UTHERIUM = TieredWeights.builder()
            .with(WorldTier.SUMMIT, 15, 0)
            .with(WorldTier.PINNACLE, 25, 0)
            .build();

    protected static final TieredWeights FORGOTTEN = TieredWeights.builder()
            .with(WorldTier.SUMMIT, 15, 0)
            .with(WorldTier.PINNACLE, 25, 0)
            .build();

    @Override
    public void generate() {
        this.addArmor(CLOGGRUM, UGItems.CLOGGRUM_HELMET.get(), UGItems.CLOGGRUM_CHESTPLATE.get(), UGItems.CLOGGRUM_LEGGINGS.get(), UGItems.CLOGGRUM_BOOTS.get());
        this.addArmor(ANCIENT, UGItems.ANCIENT_HELMET.get(), UGItems.ANCIENT_CHESTPLATE.get(), UGItems.ANCIENT_LEGGINGS.get());
        this.addArmor(FROSTSTEEL, UGItems.FROSTSTEEL_HELMET.get(), UGItems.FROSTSTEEL_CHESTPLATE.get(), UGItems.FROSTSTEEL_LEGGINGS.get(), UGItems.FROSTSTEEL_BOOTS.get());
        this.addArmor(UTHERIUM, UGItems.UTHERIUM_HELMET.get(), UGItems.UTHERIUM_CHESTPLATE.get(), UGItems.UTHERIUM_LEGGINGS.get(), UGItems.UTHERIUM_BOOTS.get());

        this.addTools(CLOGGRUM, UGItems.CLOGGRUM_SWORD.get(), UGItems.CLOGGRUM_PICKAXE.get(), UGItems.CLOGGRUM_AXE.get(), UGItems.CLOGGRUM_SHOVEL.get());
        this.addTools(FROSTSTEEL, UGItems.FROSTSTEEL_SWORD.get(), UGItems.FROSTSTEEL_PICKAXE.get(), UGItems.FROSTSTEEL_AXE.get(), UGItems.FROSTSTEEL_SHOVEL.get());
        this.addTools(UTHERIUM, UGItems.UTHERIUM_SWORD.get(), UGItems.UTHERIUM_PICKAXE.get(), UGItems.UTHERIUM_AXE.get(), UGItems.UTHERIUM_SHOVEL.get());
        this.addTools(FORGOTTEN, UGItems.FORGOTTEN_SWORD.get(), UGItems.FORGOTTEN_PICKAXE.get(), UGItems.FORGOTTEN_AXE.get(), UGItems.FORGOTTEN_SHOVEL.get());
    }

    @Override
    public String getName() {
        return "Undergarden Affix Loot Entries";
    }

    protected void addTools(TieredWeights weights, Item... tools) {
        for (Item tool : tools) {
            this.addEntry(new AffixLootEntry(weights, Constraints.forDimension(UNDERGARDEN), new ItemStackTemplate(tool), Set.of()));
        }
    }

    protected void addArmor(TieredWeights weights, Item... pieces) {
        for (Item piece : pieces) {
            this.addEntry(new AffixLootEntry(weights, Constraints.forDimension(UNDERGARDEN), new ItemStackTemplate(piece), Set.of()));
        }
    }

    protected void addEntry(AffixLootEntry entry) {
        Identifier key = Apotheosis.loc(mod + "/" + BuiltInRegistries.ITEM.getKey(entry.stackTemplate().item().value()).getPath());
        this.addConditionally(key, entry, new ModLoadedCondition(mod));
    }
}
