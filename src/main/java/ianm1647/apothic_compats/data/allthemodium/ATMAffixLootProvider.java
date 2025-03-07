package ianm1647.apothic_compats.data.allthemodium;

import appeng.items.tools.fluix.FluixToolType;
import appeng.items.tools.quartz.QuartzToolType;
import com.thevortex.allthemodium.blocks.UNOB_Block;
import com.thevortex.allthemodium.material.ATMTier;
import com.thevortex.allthemodium.registry.ArmorRegistries;
import com.thevortex.allthemodium.registry.ModRegistry;
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
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ATMAffixLootProvider extends AffixLootEntryProvider {

    String mod = "allthemodium";

    public Map<Holder<ArmorMaterial>, TieredWeights> armorWeights = new HashMap<>();
    public Map<Tier, TieredWeights> toolWeights = new HashMap<>();
    public Map<Item, TieredWeights> itemWeights = new HashMap<>();

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
        armorWeights.put(ArmorRegistries.ATM, ALLTHEMODIUM);
        armorWeights.put(ArmorRegistries.VIB, VIBRANIUM);
        armorWeights.put(ArmorRegistries.UNOB, UNOBTAINIUM);

        toolWeights.put(ATMTier.ALLTHEMODIUM, ALLTHEMODIUM);
        toolWeights.put(ATMTier.VIBRANIUM, VIBRANIUM);
        toolWeights.put(ATMTier.UNOBTAINIUM, UNOBTAINIUM);

        addEntry(ALLTHEMODIUM, ModRegistry.ATM_MACE.get().getDefaultInstance());
        addEntry(ALLTHEMODIUM, ModRegistry.ATM_BOW.get().getDefaultInstance());
        addEntry(VIBRANIUM, ModRegistry.VIB_MACE.get().getDefaultInstance());
        addEntry(UNOBTAINIUM, ModRegistry.UNO_MACE.get().getDefaultInstance());
        addEntry(UNOBTAINIUM, ModRegistry.UNO_BOW.get().getDefaultInstance());

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
        }
    }

    @Override
    public String getName() {
        return "Allthemodium Loot Entries";
    }


    protected void addEntry(TieredWeights weights, ItemStack stack) {
        ResourceLocation key = ApothicCompats.loc(mod + "/" + BuiltInRegistries.ITEM.getKey(stack.getItem()).getPath());
        this.addConditionally(key, new AffixLootEntry(weights, Constraints.forDimension(Level.OVERWORLD), stack, Set.of()), new ModLoadedCondition(mod));
    }
}
