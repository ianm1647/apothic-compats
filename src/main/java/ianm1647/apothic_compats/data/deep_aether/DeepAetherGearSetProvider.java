package ianm1647.apothic_compats.data.deep_aether;

import com.aetherteam.aether.item.AetherItems;
import dev.shadowsoffire.apotheosis.data.GearSetProvider;
import ianm1647.apothic_compats.ApothicCompats;
import io.github.razordevs.deep_aether.init.DAItems;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.HolderLookup.RegistryLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

public class DeepAetherGearSetProvider extends GearSetProvider {

    public DeepAetherGearSetProvider(PackOutput output, CompletableFuture<Provider> registries) {
        super(output, registries);
    }

    String mod = "deep_aether";

    @Override
    public String getName() {
        return "Deep Aether Gear Sets";
    }

    @Override
    public void generate() {
        Provider registries = this.lookupProvider.join();
        RegistryLookup<Enchantment> enchants = registries.lookup(Registries.ENCHANTMENT).get();

        // Summit Sets
        addSet("summit/deep_aether/skyjade", 25, 0, c -> c
                .mainhand(new ItemStack(DAItems.SKYJADE_TOOLS_SWORD.value()), 10)
                .mainhand(new ItemStack(DAItems.SKYJADE_TOOLS_AXE.value()), 10)
                .mainhand(new ItemStack(DAItems.SKYJADE_TOOLS_PICKAXE.value()), 10)
                .mainhand(new ItemStack(DAItems.SKYJADE_TOOLS_SHOVEL.value()), 10)
                .helmet(new ItemStack(DAItems.SKYJADE_HELMET.value()), 10)
                .chestplate(new ItemStack(DAItems.SKYJADE_CHESTPLATE.value()), 10)
                .leggings(new ItemStack(DAItems.SKYJADE_LEGGINGS.value()), 10)
                .boots(new ItemStack(DAItems.SKYJADE_BOOTS.value()), 10)
                .tag("summit_melee"));

        // Pinnacle Sets

        addSet("pinnacle/deep_aether/stratus", 15, 2.5F, c -> c
                .mainhand(new ItemStack(DAItems.STRATUS_SWORD.value()), 10)
                .mainhand(new ItemStack(DAItems.STRATUS_AXE.value()), 10)
                .mainhand(new ItemStack(DAItems.STRATUS_PICKAXE.value()), 10)
                .mainhand(new ItemStack(DAItems.STRATUS_SHOVEL.value()), 10)
                .helmet(new ItemStack(DAItems.STRATUS_HELMET.value()), 10)
                .chestplate(new ItemStack(DAItems.STRATUS_CHESTPLATE.value()), 10)
                .leggings(new ItemStack(DAItems.STRATUS_LEGGINGS.value()), 10)
                .boots(new ItemStack(DAItems.STRATUS_BOOTS.value()), 10)
                .tag("apotheosis_melee"));

        addSet("pinnacle/deep_aether/stormforged", 5, 2.5F, c -> c
                .mainhand(new ItemStack(DAItems.STORM_SWORD.value()), 10)
                .helmet(new ItemStack(DAItems.STORMFORGED_HELMET.value()), 10)
                .chestplate(new ItemStack(DAItems.STORMFORGED_CHESTPLATE.value()), 10)
                .leggings(new ItemStack(DAItems.STORMFORGED_LEGGINGS.value()), 10)
                .boots(new ItemStack(DAItems.STORMFORGED_BOOTS.value()), 10)
                .tag("apotheosis_melee"));

        addSet("pinnacle/ranged/deep_aether/stormforged", 5, 2.5F, c -> c
                .mainhand(new ItemStack(DAItems.STORM_BOW.value()), 10)
                .helmet(new ItemStack(DAItems.STORMFORGED_HELMET.value()), 10)
                .chestplate(new ItemStack(DAItems.STORMFORGED_CHESTPLATE.value()), 10)
                .leggings(new ItemStack(DAItems.STORMFORGED_LEGGINGS.value()), 10)
                .boots(new ItemStack(DAItems.STORMFORGED_BOOTS.value()), 10)
                .tag("apotheosis_ranged"));
    }

    @Override
    protected void addSet(String name, int weight, float quality, UnaryOperator<GSBuilder> config) {
        this.addConditionally(ApothicCompats.loc(name), config.apply(new GSBuilder(weight, quality)).build(), new ModLoadedCondition(mod));
    }

}
