package ianm1647.apothic_compats.data.allthemodium;

import dev.shadowsoffire.apotheosis.data.AffixLootEntryProvider;
import dev.shadowsoffire.apotheosis.loot.AffixLootEntry;
import dev.shadowsoffire.apotheosis.tiers.Constraints;
import dev.shadowsoffire.apotheosis.tiers.TieredWeights;
import dev.shadowsoffire.apotheosis.tiers.WorldTier;
import ianm1647.apothic_compats.ApothicCompats;
import net.allthemods.allthemodium.core.registry.ATMItems;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.*;
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
        addTools(ALLTHEMODIUM,
                ATMItems.ALLTHEMODIUM_SWORD.get(),
                ATMItems.ALLTHEMODIUM_PICKAXE.get(),
                ATMItems.ALLTHEMODIUM_AXE.get(),
                ATMItems.ALLTHEMODIUM_SHOVEL.get(),
                ATMItems.ALLTHEMODIUM_MACE.get(),
                ATMItems.ALLTHEMODIUM_BOW.get());

        addTools(VIBRANIUM,
                ATMItems.VIBRANIUM_SWORD.get(),
                ATMItems.VIBRANIUM_PICKAXE.get(),
                ATMItems.VIBRANIUM_AXE.get(),
                ATMItems.VIBRANIUM_SHOVEL.get(),
                ATMItems.VIBRANIUM_MACE.get());

        addTools(UNOBTAINIUM,
                ATMItems.UNOBTAINIUM_SWORD.get(),
                ATMItems.UNOBTAINIUM_PICKAXE.get(),
                ATMItems.UNOBTAINIUM_AXE.get(),
                ATMItems.UNOBTAINIUM_SHOVEL.get(),
                ATMItems.UNOBTAINIUM_MACE.get(),
                ATMItems.UNOBTAINIUM_CROSSBOW.get());

        addArmor(ALLTHEMODIUM,
                ATMItems.ALLTHEMODIUM_HELMET.get(),
                ATMItems.ALLTHEMODIUM_CHESTPLATE.get(),
                ATMItems.ALLTHEMODIUM_LEGGINGS.get(),
                ATMItems.ALLTHEMODIUM_BOOTS.get());

        addArmor(VIBRANIUM,
                ATMItems.VIBRANIUM_HELMET.get(),
                ATMItems.VIBRANIUM_CHESTPLATE.get(),
                ATMItems.VIBRANIUM_LEGGINGS.get(),
                ATMItems.VIBRANIUM_BOOTS.get());

        addArmor(UNOBTAINIUM,
                ATMItems.UNOBTAINIUM_HELMET.get(),
                ATMItems.UNOBTAINIUM_CHESTPLATE.get(),
                ATMItems.UNOBTAINIUM_LEGGINGS.get(),
                ATMItems.UNOBTAINIUM_BOOTS.get());
    }

    @Override
    public String getName() {
        return "Allthemodium Loot Entries";
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
