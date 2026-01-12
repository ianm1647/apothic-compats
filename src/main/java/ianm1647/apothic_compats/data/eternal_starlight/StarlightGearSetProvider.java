package ianm1647.apothic_compats.data.eternal_starlight;

import cn.leolezury.eternalstarlight.common.registry.ESItems;
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

public class StarlightGearSetProvider extends GearSetProvider {

    public StarlightGearSetProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    String mod = "eternal_starlight";

    @Override
    public String getName() {
        return "Eternal Starlight Gear Sets";
    }

    @Override
    public void generate() {
        HolderLookup.Provider registries = this.lookupProvider.join();
        HolderLookup.RegistryLookup<Enchantment> enchants = registries.lookup(Registries.ENCHANTMENT).get();

        // Frontier Sets

        addSet("frontier/eternal_starlight/amaramber", 25, 0, c -> c
                .mainhand(new ItemStack(ESItems.AMARAMBER_AXE.get()), 10)
                .mainhand(new ItemStack(ESItems.AMARAMBER_SHOVEL.get()), 10)
                .chestplate(new ItemStack(ESItems.AMARAMBER_CHESTPLATE.get()), 10)
                .tag("frontier_melee"));

        // Ascent Sets

        addSet("ascent/eternal_starlight/aethersent", 15, 0, c -> c
                .mainhand(new ItemStack(ESItems.RAGE_OF_STARS.get()), 10)
                .helmet(new ItemStack(ESItems.AETHERSENT_HOOD.get()), 10)
                .chestplate(new ItemStack(ESItems.AETHERSENT_CAPE.get()), 10)
                .leggings(new ItemStack(ESItems.AETHERSENT_BOTTOMS.get()), 10)
                .boots(new ItemStack(ESItems.AETHERSENT_BOOTS.get()), 10)
                .tag("ascent_melee"));

        addSet("ascent/ranged/eternal_starlight/aethersent", 15, 0, c -> c
                .mainhand(new ItemStack(ESItems.STARFALL_LONGBOW.get()), 10)
                .helmet(new ItemStack(ESItems.AETHERSENT_HOOD.get()), 10)
                .chestplate(new ItemStack(ESItems.AETHERSENT_CAPE.get()), 10)
                .leggings(new ItemStack(ESItems.AETHERSENT_BOTTOMS.get()), 10)
                .boots(new ItemStack(ESItems.AETHERSENT_BOOTS.get()), 10)
                .tag("ascent_ranged"));

        addSet("ascent/eternal_starlight/malarite", 10, 0, c -> c
                .mainhand(new ItemStack(ESItems.MALARITE_SWORD.get()), 10)
                .mainhand(new ItemStack(ESItems.MALARITE_AXE.get()), 10)
                .mainhand(new ItemStack(ESItems.MALARITE_PICKAXE.get()), 10)
                .mainhand(new ItemStack(ESItems.MALARITE_SHOVEL.get()), 10)
                .mainhand(new ItemStack(ESItems.MALARITE_SICKLE.get()), 10)
                .mainhand(new ItemStack(ESItems.MALARITE_SPEAR.get()), 10)
                .tag("ascent_melee"));

        // Summit Sets

        addSet("summit/eternal_starlight/deepsilver", 10, 0, c -> c
                .mainhand(new ItemStack(ESItems.DEEPSILVER_SWORD.get()), 10)
                .mainhand(new ItemStack(ESItems.DEEPSILVER_AXE.get()), 10)
                .mainhand(new ItemStack(ESItems.DEEPSILVER_PICKAXE.get()), 10)
                .mainhand(new ItemStack(ESItems.DEEPSILVER_SICKLE.get()), 10)
                .helmet(new ItemStack(ESItems.DEEPSILVER_HELMET.get()), 10)
                .chestplate(new ItemStack(ESItems.DEEPSILVER_CHESTPLATE.get()), 10)
                .leggings(new ItemStack(ESItems.DEEPSILVER_LEGGINGS.get()), 10)
                .boots(new ItemStack(ESItems.DEEPSILVER_BOOTS.get()), 10)
                .tag("summit_melee"));

        addSet("summit/eternal_starlight/petal", 10, 0, c -> c
                .mainhand(new ItemStack(ESItems.MOONRING_GREATSWORD.get()), 10)
                .mainhand(new ItemStack(ESItems.CRESCENT_SPEAR.get()), 10)
                .mainhand(new ItemStack(ESItems.PETAL_SCYTHE.get()), 10)
                .tag("summit_melee"));

        addSet("summit/ranged/eternal_starlight/petal", 10, 0, c -> c
                .mainhand(new ItemStack(ESItems.MOONRING_BOW.get()), 10)
                .tag("summit_ranged"));

        addSet("summit/eternal_starlight/thermal", 5, 0, c -> c
                .mainhand(new ItemStack(ESItems.THERMAL_SPRINGSTONE_SWORD.get()), 10)
                .mainhand(new ItemStack(ESItems.THERMAL_SPRINGSTONE_AXE.get()), 10)
                .mainhand(new ItemStack(ESItems.THERMAL_SPRINGSTONE_PICKAXE.get()), 10)
                .mainhand(new ItemStack(ESItems.THERMAL_SPRINGSTONE_SHOVEL.get()), 10)
                .mainhand(new ItemStack(ESItems.THERMAL_SPRINGSTONE_HAMMER.get()), 10)
                .mainhand(new ItemStack(ESItems.THERMAL_SPRINGSTONE_SCYTHE.get()), 10)
                .helmet(new ItemStack(ESItems.THERMAL_SPRINGSTONE_HELMET.get()), 10)
                .chestplate(new ItemStack(ESItems.THERMAL_SPRINGSTONE_CHESTPLATE.get()), 10)
                .leggings(new ItemStack(ESItems.THERMAL_SPRINGSTONE_LEGGINGS.get()), 10)
                .boots(new ItemStack(ESItems.THERMAL_SPRINGSTONE_BOOTS.get()), 10)
                .tag("summit_melee"));

        addSet("summit/eternal_starlight/glacite", 5, 0, c -> c
                .mainhand(new ItemStack(ESItems.GLACITE_SWORD.get()), 10)
                .mainhand(new ItemStack(ESItems.GLACITE_AXE.get()), 10)
                .mainhand(new ItemStack(ESItems.GLACITE_PICKAXE.get()), 10)
                .mainhand(new ItemStack(ESItems.GLACITE_SHOVEL.get()), 10)
                .mainhand(new ItemStack(ESItems.GLACITE_SCYTHE.get()), 10)
                .offhand(new ItemStack(ESItems.GLACITE_SHIELD.get()), 8)
                .helmet(new ItemStack(ESItems.GLACITE_HELMET.get()), 10)
                .chestplate(new ItemStack(ESItems.GLACITE_CHESTPLATE.get()), 10)
                .leggings(new ItemStack(ESItems.GLACITE_LEGGINGS.get()), 10)
                .boots(new ItemStack(ESItems.GLACITE_BOOTS.get()), 10)
                .tag("summit_melee"));

        // Pinnacle Sets

        addSet("pinnacle/eternal_starlight/starlit_diamond", 5, 0, c -> c
                .mainhand(new ItemStack(ESItems.STARLIT_DIAMOND_SWORD.get()), 10)
                .mainhand(new ItemStack(ESItems.STARLIT_DIAMOND_AXE.get()), 10)
                .mainhand(new ItemStack(ESItems.STARLIT_DIAMOND_PICKAXE.get()), 10)
                .mainhand(new ItemStack(ESItems.STARLIT_DIAMOND_SHOVEL.get()), 10)
                .helmet(new ItemStack(ESItems.STARLIT_DIAMOND_HELMET.get()), 10)
                .chestplate(new ItemStack(ESItems.STARLIT_DIAMOND_CHESTPLATE.get()), 10)
                .leggings(new ItemStack(ESItems.STARLIT_DIAMOND_LEGGINGS.get()), 10)
                .boots(new ItemStack(ESItems.STARLIT_DIAMOND_BOOTS.get()), 10)
                .tag("pinnacle_melee"));

        addSet("pinnacle/eternal_starlight/starfire", 5, 0, c -> c
                .mainhand(new ItemStack(ESItems.STARFIRE_SWORD.get()), 10)
                .mainhand(new ItemStack(ESItems.STARFIRE_AXE.get()), 10)
                .mainhand(new ItemStack(ESItems.STARFIRE_PICKAXE.get()), 10)
                .mainhand(new ItemStack(ESItems.STARFIRE_SHOVEL.get()), 10)
                .mainhand(new ItemStack(ESItems.STARFIRE_HAMMER.get()), 10)
                .mainhand(new ItemStack(ESItems.STARFIRE_SCYTHE.get()), 10)
                .tag("pinnacle_melee"));

        addSet("pinnacle/ranged/eternal_starlight/starfire", 5, 0, c -> c
                .mainhand(new ItemStack(ESItems.STARFIRE_CROSSBOW.get()), 10)
                .tag("pinnacle_ranged"));

        addSet("pinnacle/eternal_starlight/flowglaze", 5, 0, c -> c
                .mainhand(new ItemStack(ESItems.FLOWGLAZE_SWORD.get()), 10)
                .mainhand(new ItemStack(ESItems.FLOWGLAZE_AXE.get()), 10)
                .mainhand(new ItemStack(ESItems.FLOWGLAZE_PICKAXE.get()), 10)
                .mainhand(new ItemStack(ESItems.FLOWGLAZE_SHOVEL.get()), 10)
                .mainhand(new ItemStack(ESItems.FLOWGLAZE_SCYTHE.get()), 10)
                .offhand(new ItemStack(ESItems.FLOWGLAZE_SHIELD.get()), 10)
                .tag("pinnacle_melee"));

        addSet("pinnacle/ranged/eternal_starlight/flowglaze", 5, 0, c -> c
                .mainhand(new ItemStack(ESItems.FLOWGLAZE_BOW.get()), 10)
                .tag("pinnacle_ranged"));
    }

    @Override
    protected void addSet(String name, int weight, float quality, UnaryOperator<GSBuilder> config) {
        this.addConditionally(ApothicCompats.loc(name), config.apply(new GSBuilder(weight, quality)).build(), new ModLoadedCondition(mod));
    }
}