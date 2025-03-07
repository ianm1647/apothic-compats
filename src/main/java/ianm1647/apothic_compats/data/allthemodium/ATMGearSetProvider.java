package ianm1647.apothic_compats.data.allthemodium;

import appeng.core.definitions.AEItems;
import com.thevortex.allthemodium.registry.ModRegistry;
import dev.shadowsoffire.apotheosis.data.GearSetProvider;
import ianm1647.apothic_compats.ApothicCompats;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.HolderLookup.RegistryLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
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
                .mainhand(new ItemStack(ModRegistry.ATM_SWORD), 10)
                .mainhand(new ItemStack(ModRegistry.ATM_AXE), 10)
                .mainhand(new ItemStack(ModRegistry.ATM_PICKAXE), 10)
                .mainhand(new ItemStack(ModRegistry.ATM_SHOVEL), 10)
                .mainhand(new ItemStack(ModRegistry.ATM_MACE), 10)
                .offhand(new ItemStack(Items.SHIELD), 10)
                .helmet(new ItemStack(ModRegistry.ALLTHEMODIUM_HELMET), 10)
                .chestplate(new ItemStack(ModRegistry.ALLTHEMODIUM_CHESTPLATE), 10)
                .leggings(new ItemStack(ModRegistry.ALLTHEMODIUM_LEGGINGS), 10)
                .boots(new ItemStack(ModRegistry.ALLTHEMODIUM_BOOTS), 10)
                .tag("apotheosis_melee"));

        addSet("pinnacle/ranged/allthemodium/allthemodium", 5, 0, c -> c
                .mainhand(new ItemStack(ModRegistry.ATM_BOW), 10)
                .offhand(new ItemStack(Items.SHIELD), 10)
                .helmet(new ItemStack(ModRegistry.ALLTHEMODIUM_HELMET), 10)
                .chestplate(new ItemStack(ModRegistry.ALLTHEMODIUM_CHESTPLATE), 10)
                .leggings(new ItemStack(ModRegistry.ALLTHEMODIUM_LEGGINGS), 10)
                .boots(new ItemStack(ModRegistry.ALLTHEMODIUM_BOOTS), 10)
                .tag("apotheosis_ranged"));

        addSet("pinnacle/allthemodium/vibranium", 3, 0, c -> c
                .mainhand(new ItemStack(ModRegistry.VIB_SWORD), 10)
                .mainhand(new ItemStack(ModRegistry.VIB_AXE), 10)
                .mainhand(new ItemStack(ModRegistry.VIB_PICKAXE), 10)
                .mainhand(new ItemStack(ModRegistry.VIB_SHOVEL), 10)
                .mainhand(new ItemStack(ModRegistry.VIB_MACE), 10)
                .offhand(new ItemStack(ModRegistry.VIB_SHIELD), 10)
                .helmet(new ItemStack(ModRegistry.VIBRANIUM_HELMET), 10)
                .chestplate(new ItemStack(ModRegistry.VIBRANIUM_CHESTPLATE), 10)
                .leggings(new ItemStack(ModRegistry.VIBRANIUM_LEGGINGS), 10)
                .boots(new ItemStack(ModRegistry.VIBRANIUM_BOOTS), 10)
                .tag("apotheosis_melee"));

        addSet("pinnacle/allthemodium/unobtainium", 1, 0, c -> c
                .mainhand(new ItemStack(ModRegistry.UNO_SWORD), 10)
                .mainhand(new ItemStack(ModRegistry.UNO_AXE), 10)
                .mainhand(new ItemStack(ModRegistry.UNO_PICKAXE), 10)
                .mainhand(new ItemStack(ModRegistry.UNO_SHOVEL), 10)
                .mainhand(new ItemStack(ModRegistry.UNO_MACE), 10)
                .offhand(new ItemStack(Items.SHIELD), 10)
                .helmet(new ItemStack(ModRegistry.UNOBTAINIUM_HELMET), 10)
                .chestplate(new ItemStack(ModRegistry.UNOBTAINIUM_CHESTPLATE), 10)
                .leggings(new ItemStack(ModRegistry.UNOBTAINIUM_LEGGINGS), 10)
                .boots(new ItemStack(ModRegistry.UNOBTAINIUM_BOOTS), 10)
                .tag("apotheosis_melee"));

        addSet("pinnacle/ranged/allthemodium/unobtainium", 1, 0, c -> c
                .mainhand(new ItemStack(ModRegistry.UNO_BOW), 10)
                .offhand(new ItemStack(Items.SHIELD), 10)
                .helmet(new ItemStack(ModRegistry.UNOBTAINIUM_HELMET), 10)
                .chestplate(new ItemStack(ModRegistry.UNOBTAINIUM_CHESTPLATE), 10)
                .leggings(new ItemStack(ModRegistry.UNOBTAINIUM_LEGGINGS), 10)
                .boots(new ItemStack(ModRegistry.UNOBTAINIUM_BOOTS), 10)
                .tag("apotheosis_ranged"));
    }

    @Override
    protected void addSet(String name, int weight, float quality, UnaryOperator<GSBuilder> config) {
        this.addConditionally(ApothicCompats.loc(name), config.apply(new GSBuilder(weight, quality)).build(), new ModLoadedCondition(mod));
    }

}
