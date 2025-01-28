package ianm1647.apothic_compats.data.aether;

import com.aetherteam.aether.item.AetherItems;
import dev.shadowsoffire.apotheosis.data.GearSetProvider;
import ianm1647.apothic_compats.ApothicCompats;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.HolderLookup.RegistryLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

public class AetherGearSetProvider extends GearSetProvider {

    public AetherGearSetProvider(PackOutput output, CompletableFuture<Provider> registries) {
        super(output, registries);
    }

    String mod = "aether";

    @Override
    public String getName() {
        return "Aether Gear Sets";
    }

    @Override
    public void generate() {
        Provider registries = this.lookupProvider.join();
        RegistryLookup<Enchantment> enchants = registries.lookup(Registries.ENCHANTMENT).get();

        // Haven Sets

        // Frontier Sets
        addSet("frontier/aether/skyroot", 25, 0, c -> c
                .mainhand(new ItemStack(AetherItems.SKYROOT_SWORD.value()), 10)
                .mainhand(new ItemStack(AetherItems.SKYROOT_AXE.value()), 10)
                .mainhand(new ItemStack(AetherItems.SKYROOT_PICKAXE.value()), 10)
                .mainhand(new ItemStack(AetherItems.SKYROOT_SHOVEL.value()), 10)
                .tag("frontier_melee"));

        addSet("frontier/ranged/aether/skyroot", 25, 0, c -> c
                .mainhand(new ItemStack(AetherItems.GOLDEN_DART_SHOOTER.value()), 10)
                .mainhand(new ItemStack(AetherItems.POISON_DART_SHOOTER.value()), 10)
                .mainhand(new ItemStack(AetherItems.ENCHANTED_DART_SHOOTER.value()), 10)
                .tag("frontier_ranged"));

        addSet("frontier/aether/holystone", 20, 0, c -> c
                .mainhand(new ItemStack(AetherItems.HOLYSTONE_SWORD.value()), 10)
                .mainhand(new ItemStack(AetherItems.HOLYSTONE_AXE.value()), 10)
                .mainhand(new ItemStack(AetherItems.HOLYSTONE_PICKAXE.value()), 10)
                .mainhand(new ItemStack(AetherItems.HOLYSTONE_SHOVEL.value()), 10)
                .tag("frontier_melee"));

        //Ascent Sets

        addSet("ascent/aether/zanite", 15, 2.5F, c -> c
                .mainhand(new ItemStack(AetherItems.ZANITE_SWORD.value()), 10)
                .mainhand(new ItemStack(AetherItems.ZANITE_AXE.value()), 10)
                .mainhand(new ItemStack(AetherItems.ZANITE_PICKAXE.value()), 10)
                .mainhand(new ItemStack(AetherItems.ZANITE_SHOVEL.value()), 10)
                .helmet(new ItemStack(AetherItems.ZANITE_HELMET.value()), 10)
                .chestplate(new ItemStack(AetherItems.ZANITE_CHESTPLATE.value()), 10)
                .leggings(new ItemStack(AetherItems.ZANITE_LEGGINGS.value()), 10)
                .boots(new ItemStack(AetherItems.ZANITE_BOOTS.value()), 10)
                .tag("ascent_melee"));

        // Summit Sets

        addSet("summit/aether/gravitite", 10, 2.5F, c -> c
                .mainhand(new ItemStack(AetherItems.GRAVITITE_SWORD.value()), 10)
                .mainhand(new ItemStack(AetherItems.GRAVITITE_AXE.value()), 10)
                .mainhand(new ItemStack(AetherItems.GRAVITITE_PICKAXE.value()), 10)
                .mainhand(new ItemStack(AetherItems.GRAVITITE_SHOVEL.value()), 10)
                .helmet(new ItemStack(AetherItems.GRAVITITE_HELMET.value()), 10)
                .chestplate(new ItemStack(AetherItems.GRAVITITE_CHESTPLATE.value()), 10)
                .leggings(new ItemStack(AetherItems.GRAVITITE_LEGGINGS.value()), 10)
                .boots(new ItemStack(AetherItems.GRAVITITE_BOOTS.value()), 10)
                .tag("summit_melee"));

        // Pinnacle Sets

        addSet("pinnacle/aether/valkyrie", 5, 2.5F, c -> c
                .mainhand(new ItemStack(AetherItems.VALKYRIE_LANCE.value()), 10)
                .mainhand(new ItemStack(AetherItems.VALKYRIE_AXE.value()), 10)
                .mainhand(new ItemStack(AetherItems.VALKYRIE_PICKAXE.value()), 10)
                .mainhand(new ItemStack(AetherItems.VALKYRIE_SHOVEL.value()), 10)
                .offhand(new ItemStack(AetherItems.SHIELD_OF_REPULSION.value()), 10)
                .helmet(new ItemStack(AetherItems.VALKYRIE_HELMET.value()), 10)
                .chestplate(new ItemStack(AetherItems.VALKYRIE_CHESTPLATE.value()), 10)
                .leggings(new ItemStack(AetherItems.VALKYRIE_LEGGINGS.value()), 10)
                .boots(new ItemStack(AetherItems.VALKYRIE_BOOTS.value()), 10)
                .tag("apotheosis_melee"));

        addSet("pinnacle/aether/obsidian", 5, 2.5F, c -> c
                .helmet(new ItemStack(AetherItems.OBSIDIAN_HELMET.value()), 10)
                .chestplate(new ItemStack(AetherItems.OBSIDIAN_CHESTPLATE.value()), 10)
                .leggings(new ItemStack(AetherItems.OBSIDIAN_LEGGINGS.value()), 10)
                .boots(new ItemStack(AetherItems.OBSIDIAN_BOOTS.value()), 10)
                .tag("apotheosis_melee"));

        addSet("pinnacle/aether/neptune", 5, 2.5F, c -> c
                .helmet(new ItemStack(AetherItems.NEPTUNE_HELMET.value()), 10)
                .chestplate(new ItemStack(AetherItems.NEPTUNE_CHESTPLATE.value()), 10)
                .leggings(new ItemStack(AetherItems.NEPTUNE_LEGGINGS.value()), 10)
                .boots(new ItemStack(AetherItems.NEPTUNE_BOOTS.value()), 10)
                .tag("apotheosis_melee"));

        addSet("pinnacle/aether/phoenix", 5, 2.5F, c -> c
                .mainhand(new ItemStack(AetherItems.FLAMING_SWORD.value()), 10)
                .helmet(new ItemStack(AetherItems.PHOENIX_HELMET.value()), 10)
                .chestplate(new ItemStack(AetherItems.PHOENIX_CHESTPLATE.value()), 10)
                .leggings(new ItemStack(AetherItems.PHOENIX_LEGGINGS.value()), 10)
                .boots(new ItemStack(AetherItems.PHOENIX_BOOTS.value()), 10)
                .tag("apotheosis_melee"));

        addSet("pinnacle/ranged/aether/phoenix", 5, 2.5F, c -> c
                .mainhand(new ItemStack(AetherItems.PHOENIX_BOW.value()), 10)
                .helmet(new ItemStack(AetherItems.PHOENIX_HELMET.value()), 10)
                .chestplate(new ItemStack(AetherItems.PHOENIX_CHESTPLATE.value()), 10)
                .leggings(new ItemStack(AetherItems.PHOENIX_LEGGINGS.value()), 10)
                .boots(new ItemStack(AetherItems.PHOENIX_BOOTS.value()), 10)
                .tag("apotheosis_ranged"));

        addSet("pinnacle/aether/boss_crate", 5, 2.5F, c -> c
                .mainhand(new ItemStack(AetherItems.CANDY_CANE_SWORD.value()), 10)
                .mainhand(new ItemStack(AetherItems.HOLY_SWORD.value()), 10)
                .mainhand(new ItemStack(AetherItems.VAMPIRE_BLADE.value()), 10)
                .mainhand(new ItemStack(AetherItems.LIGHTNING_SWORD.value()), 10)
                .mainhand(new ItemStack(AetherItems.LIGHTNING_KNIFE.value()), 10)
                .boots(new ItemStack(AetherItems.SENTRY_BOOTS.value()), 10)
                .tag("apotheosis_melee"));
    }

    @Override
    protected void addSet(String name, int weight, float quality, UnaryOperator<GSBuilder> config) {
        this.addConditionally(ResourceLocation.fromNamespaceAndPath(ApothicCompats.MODID, name), config.apply(new GSBuilder(weight, quality)).build(), new ModLoadedCondition(mod));
    }

}
