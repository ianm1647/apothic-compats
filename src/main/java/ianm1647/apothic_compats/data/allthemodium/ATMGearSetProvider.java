package ianm1647.apothic_compats.data.allthemodium;

import dev.shadowsoffire.apotheosis.data.GearSetProvider;
import ianm1647.apothic_compats.ApothicCompats;
import net.allthemods.allthemodium.core.registry.ATMItems;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.HolderLookup.RegistryLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

public class ATMGearSetProvider extends GearSetProvider {

    public ATMGearSetProvider(PackOutput output, CompletableFuture<Provider> registries) {
        super(output, registries);
    }

    String mod = "allthemodium";

    @Override
    public String getName() {
        return "Allthemodium Gear Sets";
    }

    @Override
    public void generate() {
        Provider registries = this.lookupProvider.join();
        RegistryLookup<Enchantment> enchants = registries.lookup(Registries.ENCHANTMENT).get();

        // Pinnacle Sets
        addSet("pinnacle/allthemodium/allthemodium", 5, 0, c -> c
                .mainhand(new ItemStackTemplate(ATMItems.ALLTHEMODIUM_SWORD), 10)
                .mainhand(new ItemStackTemplate(ATMItems.ALLTHEMODIUM_AXE), 10)
                .mainhand(new ItemStackTemplate(ATMItems.ALLTHEMODIUM_PICKAXE), 10)
                .mainhand(new ItemStackTemplate(ATMItems.ALLTHEMODIUM_SHOVEL), 10)
                .mainhand(new ItemStackTemplate(ATMItems.ALLTHEMODIUM_MACE), 10)
                .offhand(new ItemStackTemplate(Items.SHIELD), 10)
                .helmet(new ItemStackTemplate(ATMItems.ALLTHEMODIUM_HELMET), 10)
                .chestplate(new ItemStackTemplate(ATMItems.ALLTHEMODIUM_CHESTPLATE), 10)
                .leggings(new ItemStackTemplate(ATMItems.ALLTHEMODIUM_LEGGINGS), 10)
                .boots(new ItemStackTemplate(ATMItems.ALLTHEMODIUM_BOOTS), 10)
                .tag("pinnacle_melee"));

        addSet("pinnacle/ranged/allthemodium/allthemodium", 5, 0, c -> c
                .mainhand(new ItemStackTemplate(ATMItems.ALLTHEMODIUM_BOW), 10)
                .offhand(new ItemStackTemplate(Items.SHIELD), 10)
                .helmet(new ItemStackTemplate(ATMItems.ALLTHEMODIUM_HELMET), 10)
                .chestplate(new ItemStackTemplate(ATMItems.ALLTHEMODIUM_CHESTPLATE), 10)
                .leggings(new ItemStackTemplate(ATMItems.ALLTHEMODIUM_LEGGINGS), 10)
                .boots(new ItemStackTemplate(ATMItems.ALLTHEMODIUM_BOOTS), 10)
                .tag("pinnacle_ranged"));

        addSet("pinnacle/allthemodium/vibranium", 3, 0, c -> c
                .mainhand(new ItemStackTemplate(ATMItems.VIBRANIUM_SWORD), 10)
                .mainhand(new ItemStackTemplate(ATMItems.VIBRANIUM_AXE), 10)
                .mainhand(new ItemStackTemplate(ATMItems.VIBRANIUM_PICKAXE), 10)
                .mainhand(new ItemStackTemplate(ATMItems.VIBRANIUM_SHOVEL), 10)
                .mainhand(new ItemStackTemplate(ATMItems.VIBRANIUM_MACE), 10)
                .offhand(new ItemStackTemplate(ATMItems.VIBRANIUM_SHIELD), 10)
                .helmet(new ItemStackTemplate(ATMItems.VIBRANIUM_HELMET), 10)
                .chestplate(new ItemStackTemplate(ATMItems.VIBRANIUM_CHESTPLATE), 10)
                .leggings(new ItemStackTemplate(ATMItems.VIBRANIUM_LEGGINGS), 10)
                .boots(new ItemStackTemplate(ATMItems.VIBRANIUM_BOOTS), 10)
                .tag("pinnacle_melee"));

        addSet("pinnacle/allthemodium/unobtainium", 1, 0, c -> c
                .mainhand(new ItemStackTemplate(ATMItems.UNOBTAINIUM_SWORD), 10)
                .mainhand(new ItemStackTemplate(ATMItems.UNOBTAINIUM_AXE), 10)
                .mainhand(new ItemStackTemplate(ATMItems.UNOBTAINIUM_PICKAXE), 10)
                .mainhand(new ItemStackTemplate(ATMItems.UNOBTAINIUM_SHOVEL), 10)
                .mainhand(new ItemStackTemplate(ATMItems.UNOBTAINIUM_MACE), 10)
                .offhand(new ItemStackTemplate(Items.SHIELD), 10)
                .helmet(new ItemStackTemplate(ATMItems.UNOBTAINIUM_HELMET), 10)
                .chestplate(new ItemStackTemplate(ATMItems.UNOBTAINIUM_CHESTPLATE), 10)
                .leggings(new ItemStackTemplate(ATMItems.UNOBTAINIUM_LEGGINGS), 10)
                .boots(new ItemStackTemplate(ATMItems.UNOBTAINIUM_BOOTS), 10)
                .tag("pinnacle_melee"));

        addSet("pinnacle/ranged/allthemodium/unobtainium", 1, 0, c -> c
                .mainhand(new ItemStackTemplate(ATMItems.UNOBTAINIUM_CROSSBOW), 10)
                .offhand(new ItemStackTemplate(Items.SHIELD), 10)
                .helmet(new ItemStackTemplate(ATMItems.UNOBTAINIUM_HELMET), 10)
                .chestplate(new ItemStackTemplate(ATMItems.UNOBTAINIUM_CHESTPLATE), 10)
                .leggings(new ItemStackTemplate(ATMItems.UNOBTAINIUM_LEGGINGS), 10)
                .boots(new ItemStackTemplate(ATMItems.UNOBTAINIUM_BOOTS), 10)
                .tag("pinnacle_ranged"));
    }

    @Override
    protected void addSet(String name, int weight, float quality, UnaryOperator<GSBuilder> config) {
        this.addConditionally(ApothicCompats.loc(name), config.apply(new GSBuilder(weight, quality)).build(), new ModLoadedCondition(mod));
    }

}
