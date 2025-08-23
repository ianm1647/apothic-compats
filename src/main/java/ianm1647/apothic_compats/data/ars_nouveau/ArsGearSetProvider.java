package ianm1647.apothic_compats.data.ars_nouveau;

import com.hollingsworth.arsnouveau.setup.registry.ItemsRegistry;
import dev.shadowsoffire.apotheosis.data.GearSetProvider;
import ianm1647.apothic_compats.ApothicCompats;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

public class ArsGearSetProvider extends GearSetProvider {

    public ArsGearSetProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    String mod = "ars_nouveau";

    @Override
    public String getName() {
        return "Ars Nouveau Gear Sets";
    }

    @Override
    public void generate() {
        HolderLookup.Provider registries = this.lookupProvider.join();
        HolderLookup.RegistryLookup<Enchantment> enchants = registries.lookup(Registries.ENCHANTMENT).get();

        // Frontier Sets
        addSet("frontier/ars_nouveau/sorcerer", 15, 0, c -> c
                .mainhand(new ItemStack(ItemsRegistry.ENCHANTERS_SWORD), 10)
                .helmet(new ItemStack(ItemsRegistry.SORCERER_HOOD), 10)
                .chestplate(new ItemStack(ItemsRegistry.SORCERER_ROBES), 10)
                .leggings(new ItemStack(ItemsRegistry.SORCERER_LEGGINGS), 10)
                .boots(new ItemStack(ItemsRegistry.SORCERER_BOOTS), 10)
                .offhand(new ItemStack(ItemsRegistry.ENCHANTERS_SHIELD), 10)
                .tag("frontier_melee"));

        addSet("frontier/ars_nouveau/arcanist", 15, 0, c -> c
                .mainhand(new ItemStack(ItemsRegistry.ENCHANTERS_SWORD), 10)
                .helmet(new ItemStack(ItemsRegistry.ARCANIST_HOOD), 10)
                .chestplate(new ItemStack(ItemsRegistry.ARCANIST_ROBES), 10)
                .leggings(new ItemStack(ItemsRegistry.ARCANIST_LEGGINGS), 10)
                .boots(new ItemStack(ItemsRegistry.ARCANIST_BOOTS), 10)
                .offhand(new ItemStack(ItemsRegistry.ENCHANTERS_SHIELD), 10)
                .tag("frontier_melee"));

        // Ascent Sets

        addSet("ascent/ars_nouveau/battlemage", 15, 0, c -> c
                .mainhand(new ItemStack(ItemsRegistry.ENCHANTERS_SWORD), 10)
                .helmet(new ItemStack(ItemsRegistry.BATTLEMAGE_HOOD), 10)
                .chestplate(new ItemStack(ItemsRegistry.BATTLEMAGE_ROBES), 10)
                .leggings(new ItemStack(ItemsRegistry.BATTLEMAGE_LEGGINGS), 10)
                .boots(new ItemStack(ItemsRegistry.BATTLEMAGE_BOOTS), 10)
                .offhand(new ItemStack(ItemsRegistry.ENCHANTERS_SHIELD), 10)
                .tag("ascent_melee"));
    }

    @Override
    protected void addSet(String name, int weight, float quality, UnaryOperator<GSBuilder> config) {
        this.addConditionally(ApothicCompats.loc(name), config.apply(new GSBuilder(weight, quality)).build(), new ModLoadedCondition(mod));
    }
}