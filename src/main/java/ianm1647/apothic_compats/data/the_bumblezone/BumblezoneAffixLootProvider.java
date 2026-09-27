package ianm1647.apothic_compats.data.the_bumblezone;

import com.telepathicgrunt.the_bumblezone.modinit.BzArmorMaterials;
import com.telepathicgrunt.the_bumblezone.modinit.BzItems;
import dev.shadowsoffire.apotheosis.data.AffixLootEntryProvider;
import dev.shadowsoffire.apotheosis.loot.AffixLootEntry;
import dev.shadowsoffire.apotheosis.tiers.Constraints;
import dev.shadowsoffire.apotheosis.tiers.TieredWeights;
import dev.shadowsoffire.apotheosis.tiers.WorldTier;
import ianm1647.apothic_compats.ApothicCompats;
import mekanism.tools.common.registries.ToolsItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class BumblezoneAffixLootProvider extends AffixLootEntryProvider {

    String mod = "the_bumblezone";

    private static ResourceKey<Level> BUMBLEZONE = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("the_bumblezone:the_bumblezone"));

    public BumblezoneAffixLootProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    protected static final TieredWeights BEE = TieredWeights.builder()
            .with(WorldTier.FRONTIER, 10, 0)
            .with(WorldTier.ASCENT, 5, 0)
            .build();

    @Override
    public void generate() {
        BzItems.ITEMS.getEntries().forEach(item -> {
            if (item.get() instanceof ArmorItem a) {
                if (a.getMaterial() == BzArmorMaterials.BEE_MATERIAL.holder()) {
                    addArmor(BEE, a);
                }
            }
        });

        addTools(BEE, BzItems.STINGER_SPEAR.get());
        addTools(BEE, BzItems.HONEY_CRYSTAL_SHIELD.get());
    }

    @Override
    public String getName() {
        return "The Bumblezone Affix Loot Entries";
    }

    protected void addTools(TieredWeights weights, Item... tools) {
        for (Item tool : tools) {
            this.addEntry(new AffixLootEntry(weights, Constraints.forDimension(BUMBLEZONE), new ItemStack(tool), Set.of()));
        }
    }

    protected void addArmor(TieredWeights weights, Item... pieces) {
        for (Item piece : pieces) {
            this.addEntry(new AffixLootEntry(weights, Constraints.forDimension(BUMBLEZONE), new ItemStack(piece), Set.of()));
        }
    }

    protected void addEntry(AffixLootEntry entry) {
        ResourceLocation key = ApothicCompats.loc(mod + "/" + BuiltInRegistries.ITEM.getKey(entry.stack().getItem()).getPath());
        this.addConditionally(key, entry, new ModLoadedCondition(mod));
    }
}
