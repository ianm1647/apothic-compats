package ianm1647.apothic_compats.data.undergarden;

import com.telepathicgrunt.the_bumblezone.modinit.BzArmorMaterials;
import com.telepathicgrunt.the_bumblezone.modinit.BzItems;
import dev.shadowsoffire.apotheosis.data.AffixLootEntryProvider;
import dev.shadowsoffire.apotheosis.loot.AffixLootEntry;
import dev.shadowsoffire.apotheosis.loot.LootCategory;
import dev.shadowsoffire.apotheosis.tiers.TieredWeights;
import dev.shadowsoffire.apotheosis.tiers.WorldTier;
import ianm1647.apothic_compats.ApothicCompats;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import quek.undergarden.registry.UGArmorMaterials;
import quek.undergarden.registry.UGItemTiers;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class UndergardenAffixLootProvider extends AffixLootEntryProvider {

    String mod = "undergarden";

    public Map<Holder<ArmorMaterial>, TieredWeights> armorWeights = new HashMap<>();
    public Map<Tier, TieredWeights> toolWeights = new HashMap<>();
    public Map<Item, TieredWeights> itemWeights = new HashMap<>();

    public UndergardenAffixLootProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    protected static final TieredWeights CLOGGRUM = TieredWeights.builder()
            .with(WorldTier.FRONTIER, 10, 0)
            .with(WorldTier.ASCENT, 10, 0)
            .build();

    protected static final TieredWeights ANCIENT = TieredWeights.builder()
            .with(WorldTier.FRONTIER, 10, 0)
            .with(WorldTier.ASCENT, 10, 0)
            .build();

    protected static final TieredWeights FROSTSTEEL = TieredWeights.builder()
            .with(WorldTier.ASCENT, 10, 0)
            .with(WorldTier.SUMMIT, 10, 0)
            .build();

    protected static final TieredWeights UTHERIUM = TieredWeights.builder()
            .with(WorldTier.SUMMIT, 10, 0)
            .with(WorldTier.PINNACLE, 10, 0)
            .build();

    protected static final TieredWeights FORGOTTEN = TieredWeights.builder()
            .with(WorldTier.SUMMIT, 10, 0)
            .with(WorldTier.PINNACLE, 10, 0)
            .build();

    @Override
    public void generate() {
        armorWeights.put(UGArmorMaterials.CLOGGRUM, CLOGGRUM);
        armorWeights.put(UGArmorMaterials.ANCIENT, ANCIENT);
        armorWeights.put(UGArmorMaterials.FROSTSTEEL, FROSTSTEEL);
        armorWeights.put(UGArmorMaterials.UTHERIUM, UTHERIUM);

        toolWeights.put(UGItemTiers.CLOGGRUM, CLOGGRUM);
        toolWeights.put(UGItemTiers.FROSTSTEEL, FROSTSTEEL);
        toolWeights.put(UGItemTiers.UTHERIUM, UTHERIUM);
        toolWeights.put(UGItemTiers.FORGOTTEN, FORGOTTEN);

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
                    this.addEntry(new AffixLootEntry(weights, new ItemStack(i)));
                }
            }
            else if (i instanceof ArmorItem a && a.getType() != ArmorItem.Type.BODY) {
                TieredWeights weights = armorWeights.get(a.getMaterial());
                if (weights != null) {
                    this.addEntry(new AffixLootEntry(weights, new ItemStack(i)));
                }
            }
        }
    }

    @Override
    public String getName() {
        return "Undergarden Affix Loot Entries";
    }


    protected void addEntry(AffixLootEntry entry) {
        ResourceLocation key = ResourceLocation.fromNamespaceAndPath(ApothicCompats.MODID,mod + "/" + BuiltInRegistries.ITEM.getKey(entry.stack().getItem()).getPath());
        this.addConditionally(key, entry, new ModLoadedCondition(mod));
    }
}
