package ianm1647.apothic_compats.data.the_bumblezone;

import com.hollingsworth.arsnouveau.setup.registry.ItemsRegistry;
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

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class BumblezoneAffixLootProvider extends AffixLootEntryProvider {

    String mod = "the_bumblezone";

    public Map<Holder<ArmorMaterial>, TieredWeights> armorWeights = new HashMap<>();
    public Map<Tier, TieredWeights> toolWeights = new HashMap<>();
    public Map<Item, TieredWeights> itemWeights = new HashMap<>();

    public BumblezoneAffixLootProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    protected static final TieredWeights BEE = TieredWeights.builder()
            .with(WorldTier.FRONTIER, 10, 0)
            .with(WorldTier.ASCENT, 10, 0)
            .build();

    @Override
    public void generate() {
        armorWeights.put(BzArmorMaterials.BEE_MATERIAL.holder(), BEE);
        addEntry(new AffixLootEntry(BEE, new ItemStack(BzItems.STINGER_SPEAR.get())));
        addEntry(new AffixLootEntry(BEE, new ItemStack(BzItems.HONEY_CRYSTAL_SHIELD.get())));

        for (Item i : BuiltInRegistries.ITEM) {
            if (!mod.equals(BuiltInRegistries.ITEM.getKey(i).getNamespace())) {
                continue;
            }

            LootCategory cat = LootCategory.forItem(i.getDefaultInstance());
            if (cat.isNone()) {
                continue;
            }

            if (i instanceof ArmorItem a && a.getType() != ArmorItem.Type.BODY) {
                TieredWeights weights = armorWeights.get(a.getMaterial());
                if (weights != null) {
                    this.addEntry(new AffixLootEntry(weights, new ItemStack(i)));
                }
            }
        }
    }

    @Override
    public String getName() {
        return "The Bumblezone Affix Loot Entries";
    }


    protected void addEntry(AffixLootEntry entry) {
        ResourceLocation key = ResourceLocation.fromNamespaceAndPath(ApothicCompats.MODID,mod + "/" + BuiltInRegistries.ITEM.getKey(entry.stack().getItem()).getPath());
        this.addConditionally(key, entry, new ModLoadedCondition(mod));
    }
}
