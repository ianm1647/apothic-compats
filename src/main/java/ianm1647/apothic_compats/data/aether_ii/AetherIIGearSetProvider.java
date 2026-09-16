package ianm1647.apothic_compats.data.aether_ii;

import com.aetherteam.aetherii.item.AetherIIItems;
import dev.shadowsoffire.apotheosis.data.GearSetProvider;
import ianm1647.ancientreforging.AncientReforging;
import ianm1647.apothic_compats.ApothicCompats;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.HolderLookup.RegistryLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.enchantment.Enchantment;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

public class AetherIIGearSetProvider extends GearSetProvider {

    public AetherIIGearSetProvider(PackOutput output, CompletableFuture<Provider> registries) {
        super(output, registries);
    }

    String mod = "aether_ii";

    @Override
    public String getName() {
        return "Aether II Gear Sets";
    }

    @Override
    public void generate() {
        Provider registries = this.lookupProvider.join();
        RegistryLookup<Enchantment> enchants = registries.lookup(Registries.ENCHANTMENT).get();

        // Haven Sets

        // Frontier Sets
        addSet("frontier/aether_ii/skyroot", 25, 0, c -> c
                .mainhand(new ItemStackTemplate(AetherIIItems.SKYROOT_SHORTSWORD.value()), 10)
                .mainhand(new ItemStackTemplate(AetherIIItems.SKYROOT_PIKE.value()), 10)
                .mainhand(new ItemStackTemplate(AetherIIItems.SKYROOT_HAMMER.value()), 10)
                .mainhand(new ItemStackTemplate(AetherIIItems.SKYROOT_AXE.value()), 10)
                .mainhand(new ItemStackTemplate(AetherIIItems.SKYROOT_PICKAXE.value()), 10)
                .mainhand(new ItemStackTemplate(AetherIIItems.SKYROOT_SHOVEL.value()), 10)
                .offhand(new ItemStackTemplate(AetherIIItems.SKYROOT_SHIELD.value()), 10)
                .helmet(new ItemStackTemplate(AetherIIItems.BEAST_PELT_HELMET.value()), 10)
                .chestplate(new ItemStackTemplate(AetherIIItems.BEAST_PELT_CHESTPLATE.value()), 10)
                .leggings(new ItemStackTemplate(AetherIIItems.BEAST_PELT_LEGGINGS.value()), 10)
                .boots(new ItemStackTemplate(AetherIIItems.BEAST_PELT_BOOTS.value()), 10)
                .tag("frontier_melee"));

        addSet("frontier/ranged/aether_ii/skyroot", 25, 0, c -> c
                .mainhand(new ItemStackTemplate(AetherIIItems.SKYROOT_CROSSBOW.value()), 10)
                .helmet(new ItemStackTemplate(AetherIIItems.BEAST_PELT_HELMET.value()), 10)
                .chestplate(new ItemStackTemplate(AetherIIItems.BEAST_PELT_CHESTPLATE.value()), 10)
                .leggings(new ItemStackTemplate(AetherIIItems.BEAST_PELT_LEGGINGS.value()), 10)
                .boots(new ItemStackTemplate(AetherIIItems.BEAST_PELT_BOOTS.value()), 10)
                .tag("frontier_ranged"));

        addSet("frontier/aether_ii/holystone", 20, 0, c -> c
                .mainhand(new ItemStackTemplate(AetherIIItems.HOLYSTONE_SHORTSWORD.value()), 10)
                .mainhand(new ItemStackTemplate(AetherIIItems.HOLYSTONE_PIKE.value()), 10)
                .mainhand(new ItemStackTemplate(AetherIIItems.HOLYSTONE_HAMMER.value()), 10)
                .mainhand(new ItemStackTemplate(AetherIIItems.HOLYSTONE_AXE.value()), 10)
                .mainhand(new ItemStackTemplate(AetherIIItems.HOLYSTONE_PICKAXE.value()), 10)
                .mainhand(new ItemStackTemplate(AetherIIItems.HOLYSTONE_SHOVEL.value()), 10)
                .helmet(new ItemStackTemplate(AetherIIItems.BURRUKAI_PLATE_HELMET.value()), 10)
                .chestplate(new ItemStackTemplate(AetherIIItems.BURRUKAI_PLATE_CHESTPLATE.value()), 10)
                .leggings(new ItemStackTemplate(AetherIIItems.BURRUKAI_PLATE_LEGGINGS.value()), 10)
                .boots(new ItemStackTemplate(AetherIIItems.BURRUKAI_PLATE_BOOTS.value()), 10)
                .tag("frontier_melee"));

        addSet("frontier/ranged/aether_ii/holystone", 20, 0, c -> c
                .mainhand(new ItemStackTemplate(AetherIIItems.HOLYSTONE_CROSSBOW.value()), 10)
                .helmet(new ItemStackTemplate(AetherIIItems.BURRUKAI_PLATE_HELMET.value()), 10)
                .chestplate(new ItemStackTemplate(AetherIIItems.BURRUKAI_PLATE_CHESTPLATE.value()), 10)
                .leggings(new ItemStackTemplate(AetherIIItems.BURRUKAI_PLATE_LEGGINGS.value()), 10)
                .boots(new ItemStackTemplate(AetherIIItems.BURRUKAI_PLATE_BOOTS.value()), 10)
                .tag("frontier_ranged"));

        //Ascent Sets

        addSet("ascent/aether_ii/zanite", 15, 2.5F, c -> c
                .mainhand(new ItemStackTemplate(AetherIIItems.ZANITE_SHORTSWORD.value()), 10)
                .mainhand(new ItemStackTemplate(AetherIIItems.ZANITE_PIKE.value()), 10)
                .mainhand(new ItemStackTemplate(AetherIIItems.ZANITE_HAMMER.value()), 10)
                .mainhand(new ItemStackTemplate(AetherIIItems.ZANITE_AXE.value()), 10)
                .mainhand(new ItemStackTemplate(AetherIIItems.ZANITE_PICKAXE.value()), 10)
                .mainhand(new ItemStackTemplate(AetherIIItems.ZANITE_SHOVEL.value()), 10)
                .offhand(new ItemStackTemplate(AetherIIItems.ZANITE_SHIELD.value()), 10)
                .helmet(new ItemStackTemplate(AetherIIItems.ZANITE_HELMET.value()), 10)
                .chestplate(new ItemStackTemplate(AetherIIItems.ZANITE_CHESTPLATE.value()), 10)
                .leggings(new ItemStackTemplate(AetherIIItems.ZANITE_LEGGINGS.value()), 10)
                .boots(new ItemStackTemplate(AetherIIItems.ZANITE_BOOTS.value()), 10)
                .tag("ascent_melee"));

        addSet("ascent/ranged/aether_ii/zanite", 15, 2.5F, c -> c
                .mainhand(new ItemStackTemplate(AetherIIItems.ZANITE_CROSSBOW.value()), 10)
                .helmet(new ItemStackTemplate(AetherIIItems.ZANITE_HELMET.value()), 10)
                .chestplate(new ItemStackTemplate(AetherIIItems.ZANITE_CHESTPLATE.value()), 10)
                .leggings(new ItemStackTemplate(AetherIIItems.ZANITE_LEGGINGS.value()), 10)
                .boots(new ItemStackTemplate(AetherIIItems.ZANITE_BOOTS.value()), 10)
                .tag("ascent_ranged"));

        // Summit Sets

        addSet("summit/aether_ii/arkenium", 10, 2.5F, c -> c
                .mainhand(new ItemStackTemplate(AetherIIItems.ARKENIUM_SHORTSWORD.value()), 10)
                .mainhand(new ItemStackTemplate(AetherIIItems.ARKENIUM_PIKE.value()), 10)
                .mainhand(new ItemStackTemplate(AetherIIItems.ARKENIUM_HAMMER.value()), 10)
                .mainhand(new ItemStackTemplate(AetherIIItems.ARKENIUM_AXE.value()), 10)
                .mainhand(new ItemStackTemplate(AetherIIItems.ARKENIUM_PICKAXE.value()), 10)
                .mainhand(new ItemStackTemplate(AetherIIItems.ARKENIUM_SHOVEL.value()), 10)
                .offhand(new ItemStackTemplate(AetherIIItems.ARKENIUM_SHIELD.value()), 10)
                .helmet(new ItemStackTemplate(AetherIIItems.ARKENIUM_HELMET.value()), 10)
                .chestplate(new ItemStackTemplate(AetherIIItems.ARKENIUM_CHESTPLATE.value()), 10)
                .leggings(new ItemStackTemplate(AetherIIItems.ARKENIUM_LEGGINGS.value()), 10)
                .boots(new ItemStackTemplate(AetherIIItems.ARKENIUM_BOOTS.value()), 10)
                .tag("summit_melee"));

        addSet("summit/ranged/aether_ii/arkenium", 10, 2.5F, c -> c
                .mainhand(new ItemStackTemplate(AetherIIItems.ARKENIUM_CROSSBOW.value()), 10)
                .helmet(new ItemStackTemplate(AetherIIItems.ARKENIUM_HELMET.value()), 10)
                .chestplate(new ItemStackTemplate(AetherIIItems.ARKENIUM_CHESTPLATE.value()), 10)
                .leggings(new ItemStackTemplate(AetherIIItems.ARKENIUM_LEGGINGS.value()), 10)
                .boots(new ItemStackTemplate(AetherIIItems.ARKENIUM_BOOTS.value()), 10)
                .tag("summit_ranged"));

        // Pinnacle Sets

        addSet("summit/aether_ii/gravitite", 10, 2.5F, c -> c
                .mainhand(new ItemStackTemplate(AetherIIItems.GRAVITITE_SHORTSWORD.value()), 10)
                .mainhand(new ItemStackTemplate(AetherIIItems.GRAVITITE_PIKE.value()), 10)
                .mainhand(new ItemStackTemplate(AetherIIItems.GRAVITITE_HAMMER.value()), 10)
                .mainhand(new ItemStackTemplate(AetherIIItems.GRAVITITE_AXE.value()), 10)
                .mainhand(new ItemStackTemplate(AetherIIItems.GRAVITITE_PICKAXE.value()), 10)
                .mainhand(new ItemStackTemplate(AetherIIItems.GRAVITITE_SHOVEL.value()), 10)
                .offhand(new ItemStackTemplate(AetherIIItems.GRAVITITE_SHIELD.value()), 10)
                .helmet(new ItemStackTemplate(AetherIIItems.GRAVITITE_HELMET.value()), 10)
                .chestplate(new ItemStackTemplate(AetherIIItems.GRAVITITE_CHESTPLATE.value()), 10)
                .leggings(new ItemStackTemplate(AetherIIItems.GRAVITITE_LEGGINGS.value()), 10)
                .boots(new ItemStackTemplate(AetherIIItems.GRAVITITE_BOOTS.value()), 10)
                .tag("pinnacle_melee"));

        addSet("summit/ranged/aether_ii/gravitite", 10, 2.5F, c -> c
                .mainhand(new ItemStackTemplate(AetherIIItems.GRAVITITE_CROSSBOW.value()), 10)
                .helmet(new ItemStackTemplate(AetherIIItems.GRAVITITE_HELMET.value()), 10)
                .chestplate(new ItemStackTemplate(AetherIIItems.GRAVITITE_CHESTPLATE.value()), 10)
                .leggings(new ItemStackTemplate(AetherIIItems.GRAVITITE_LEGGINGS.value()), 10)
                .boots(new ItemStackTemplate(AetherIIItems.GRAVITITE_BOOTS.value()), 10)
                .tag("pinnacle_ranged"));

        addSet("pinnacle/aether_ii/neptune", 5, 2.5F, c -> c
                .helmet(new ItemStackTemplate(AetherIIItems.NEPTUNE_HELMET.value()), 10)
                .chestplate(new ItemStackTemplate(AetherIIItems.NEPTUNE_CHESTPLATE.value()), 10)
                .leggings(new ItemStackTemplate(AetherIIItems.NEPTUNE_LEGGINGS.value()), 10)
                .boots(new ItemStackTemplate(AetherIIItems.NEPTUNE_BOOTS.value()), 10)
                .tag("pinnacle_melee"));

    }

    @Override
    protected void addSet(String name, int weight, float quality, UnaryOperator<GSBuilder> config) {
        this.addConditionally(ApothicCompats.loc(name), config.apply(new GSBuilder(weight, quality)).build(), new ModLoadedCondition(mod));
    }

}
