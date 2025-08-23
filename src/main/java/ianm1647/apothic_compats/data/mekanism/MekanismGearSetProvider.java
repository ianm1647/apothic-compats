package ianm1647.apothic_compats.data.mekanism;

import dev.shadowsoffire.apotheosis.data.GearSetProvider;
import ianm1647.apothic_compats.ApothicCompats;
import mekanism.tools.common.registries.ToolsItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

public class MekanismGearSetProvider extends GearSetProvider {

    public MekanismGearSetProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    String mod = "mekanismtools";

    @Override
    public String getName() {
        return "Mekanism Gear Sets";
    }

    @Override
    public void generate() {
        HolderLookup.Provider registries = this.lookupProvider.join();
        HolderLookup.RegistryLookup<Enchantment> enchants = registries.lookup(Registries.ENCHANTMENT).get();

        // Frontier Sets

        addSet("frontier/mekanism/lapis", 25, 0, c -> c
                .mainhand(new ItemStack(ToolsItems.LAPIS_LAZULI_SWORD.get()), 10)
                .mainhand(new ItemStack(ToolsItems.LAPIS_LAZULI_AXE.get()), 10)
                .mainhand(new ItemStack(ToolsItems.LAPIS_LAZULI_PICKAXE.get()), 10)
                .mainhand(new ItemStack(ToolsItems.LAPIS_LAZULI_SHOVEL.get()), 10)
                .mainhand(new ItemStack(ToolsItems.LAPIS_LAZULI_PAXEL.get()), 10)
                .offhand(new ItemStack(ToolsItems.LAPIS_LAZULI_SHIELD.get()), 8)
                .helmet(new ItemStack(ToolsItems.LAPIS_LAZULI_HELMET.get()), 10)
                .chestplate(new ItemStack(ToolsItems.LAPIS_LAZULI_CHESTPLATE.get()), 10)
                .leggings(new ItemStack(ToolsItems.LAPIS_LAZULI_LEGGINGS.get()), 10)
                .boots(new ItemStack(ToolsItems.LAPIS_LAZULI_BOOTS.get()), 10)
                .tag("frontier_melee"));

        // Ascent Sets

        addSet("ascent/mekanism/osmium", 15, 0, c -> c
                .mainhand(new ItemStack(ToolsItems.OSMIUM_SWORD.get()), 10)
                .mainhand(new ItemStack(ToolsItems.OSMIUM_AXE.get()), 10)
                .mainhand(new ItemStack(ToolsItems.OSMIUM_PICKAXE.get()), 10)
                .mainhand(new ItemStack(ToolsItems.OSMIUM_SHOVEL.get()), 10)
                .mainhand(new ItemStack(ToolsItems.OSMIUM_PAXEL.get()), 10)
                .offhand(new ItemStack(ToolsItems.OSMIUM_SHIELD.get()), 8)
                .helmet(new ItemStack(ToolsItems.OSMIUM_HELMET.get()), 10)
                .chestplate(new ItemStack(ToolsItems.OSMIUM_CHESTPLATE.get()), 10)
                .leggings(new ItemStack(ToolsItems.OSMIUM_LEGGINGS.get()), 10)
                .boots(new ItemStack(ToolsItems.OSMIUM_BOOTS.get()), 10)
                .tag("ascent_melee"));

        addSet("ascent/mekanism/bronze", 15, 0, c -> c
                .mainhand(new ItemStack(ToolsItems.BRONZE_SWORD.get()), 10)
                .mainhand(new ItemStack(ToolsItems.BRONZE_AXE.get()), 10)
                .mainhand(new ItemStack(ToolsItems.BRONZE_PICKAXE.get()), 10)
                .mainhand(new ItemStack(ToolsItems.BRONZE_SHOVEL.get()), 10)
                .mainhand(new ItemStack(ToolsItems.BRONZE_PAXEL.get()), 10)
                .offhand(new ItemStack(ToolsItems.BRONZE_SHIELD.get()), 8)
                .helmet(new ItemStack(ToolsItems.BRONZE_HELMET.get()), 10)
                .chestplate(new ItemStack(ToolsItems.BRONZE_CHESTPLATE.get()), 10)
                .leggings(new ItemStack(ToolsItems.BRONZE_LEGGINGS.get()), 10)
                .boots(new ItemStack(ToolsItems.BRONZE_BOOTS.get()), 10)
                .tag("ascent_melee"));

        // Summit Sets

        addSet("summit/mekanism/steel", 10, 0, c -> c
                .mainhand(new ItemStack(ToolsItems.STEEL_SWORD.get()), 10)
                .mainhand(new ItemStack(ToolsItems.STEEL_AXE.get()), 10)
                .mainhand(new ItemStack(ToolsItems.STEEL_PICKAXE.get()), 10)
                .mainhand(new ItemStack(ToolsItems.STEEL_SHOVEL.get()), 10)
                .mainhand(new ItemStack(ToolsItems.STEEL_PAXEL.get()), 10)
                .offhand(new ItemStack(ToolsItems.STEEL_SHIELD.get()), 8)
                .helmet(new ItemStack(ToolsItems.STEEL_HELMET.get()), 10)
                .chestplate(new ItemStack(ToolsItems.STEEL_CHESTPLATE.get()), 10)
                .leggings(new ItemStack(ToolsItems.STEEL_LEGGINGS.get()), 10)
                .boots(new ItemStack(ToolsItems.STEEL_BOOTS.get()), 10)
                .tag("summit_melee"));

        // Pinnacle Sets

        addSet("ascent/mekanism/refined_glowstone", 5, 0, c -> c
                .mainhand(new ItemStack(ToolsItems.REFINED_GLOWSTONE_SWORD.get()), 10)
                .mainhand(new ItemStack(ToolsItems.REFINED_GLOWSTONE_AXE.get()), 10)
                .mainhand(new ItemStack(ToolsItems.REFINED_GLOWSTONE_PICKAXE.get()), 10)
                .mainhand(new ItemStack(ToolsItems.REFINED_GLOWSTONE_SHOVEL.get()), 10)
                .mainhand(new ItemStack(ToolsItems.REFINED_GLOWSTONE_PAXEL.get()), 10)
                .offhand(new ItemStack(ToolsItems.REFINED_GLOWSTONE_SHIELD.get()), 8)
                .helmet(new ItemStack(ToolsItems.REFINED_GLOWSTONE_HELMET.get()), 10)
                .chestplate(new ItemStack(ToolsItems.REFINED_GLOWSTONE_CHESTPLATE.get()), 10)
                .leggings(new ItemStack(ToolsItems.REFINED_GLOWSTONE_LEGGINGS.get()), 10)
                .boots(new ItemStack(ToolsItems.REFINED_GLOWSTONE_BOOTS.get()), 10)
                .tag("ascent_melee"));

        addSet("ascent/mekanism/refined_obsidian", 5, 0, c -> c
                .mainhand(new ItemStack(ToolsItems.REFINED_OBSIDIAN_SWORD.get()), 10)
                .mainhand(new ItemStack(ToolsItems.REFINED_OBSIDIAN_AXE.get()), 10)
                .mainhand(new ItemStack(ToolsItems.REFINED_OBSIDIAN_PICKAXE.get()), 10)
                .mainhand(new ItemStack(ToolsItems.REFINED_OBSIDIAN_SHOVEL.get()), 10)
                .mainhand(new ItemStack(ToolsItems.REFINED_OBSIDIAN_PAXEL.get()), 10)
                .offhand(new ItemStack(ToolsItems.REFINED_OBSIDIAN_SHIELD.get()), 8)
                .helmet(new ItemStack(ToolsItems.REFINED_OBSIDIAN_HELMET.get()), 10)
                .chestplate(new ItemStack(ToolsItems.REFINED_OBSIDIAN_CHESTPLATE.get()), 10)
                .leggings(new ItemStack(ToolsItems.REFINED_OBSIDIAN_LEGGINGS.get()), 10)
                .boots(new ItemStack(ToolsItems.REFINED_OBSIDIAN_BOOTS.get()), 10)
                .tag("ascent_melee"));

    }

    @Override
    protected void addSet(String name, int weight, float quality, UnaryOperator<GSBuilder> config) {
        this.addConditionally(ApothicCompats.loc(name), config.apply(new GSBuilder(weight, quality)).build(), new ModLoadedCondition(mod));
    }
}