package ianm1647.apothic_compats.data.irons_artifice;

import dev.shadowsoffire.apotheosis.data.GearSetProvider;
import ianm1647.apothic_compats.ApothicCompats;
import io.redspace.irons_artifice.registry.ItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

public class ArtificeGearSetProvider extends GearSetProvider {

    public ArtificeGearSetProvider(PackOutput output, CompletableFuture<Provider> registries) {
        super(output, registries);
    }

    String mod = "irons_artifice";

    @Override
    public String getName() {
        return "Artifice Gear Sets";
    }

    @Override
    public void generate() {
        HolderLookup.Provider registries = this.lookupProvider.join();
        HolderLookup.RegistryLookup<Enchantment> enchants = registries.lookup(Registries.ENCHANTMENT).get();

        // Haven Sets
        addSet("haven/irons_artifice/gun_chainmail", 25, 0, c -> c
                .mainhand(new ItemStack(ItemRegistry.FLINTLOCK_PISTOL.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.MUSKET.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.BLUNDERBUSS.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.BLACKPOWDER_REVOLVER.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.SIX_SHOOTER.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.ARQUEBUS.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.CLOCKWORK_RIFLE.get()), 10)
                .helmet(new ItemStack(Items.CHAINMAIL_HELMET), 10)
                .chestplate(new ItemStack(Items.CHAINMAIL_CHESTPLATE), 10)
                .leggings(new ItemStack(Items.CHAINMAIL_LEGGINGS), 10)
                .boots(new ItemStack(Items.CHAINMAIL_BOOTS), 10)
                .tag("haven_ranged").tag("haven_melee").tag("haven_gun"));

        addSet("haven/irons_artifice/gun_iron", 25, 0, c -> c
                .mainhand(new ItemStack(ItemRegistry.FLINTLOCK_PISTOL.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.MUSKET.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.BLUNDERBUSS.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.BLACKPOWDER_REVOLVER.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.SIX_SHOOTER.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.ARQUEBUS.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.CLOCKWORK_RIFLE.get()), 10)
                .helmet(new ItemStack(Items.IRON_HELMET), 10)
                .chestplate(new ItemStack(Items.IRON_CHESTPLATE), 10)
                .leggings(new ItemStack(Items.IRON_LEGGINGS), 10)
                .boots(new ItemStack(Items.IRON_BOOTS), 10)
                .tag("haven_ranged").tag("haven_melee").tag("haven_gun"));

        // Frontier Sets
        addSet("frontier/irons_artifice/gun_iron", 25, 0, c -> c
                .mainhand(new ItemStack(ItemRegistry.FLINTLOCK_PISTOL.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.MUSKET.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.BLUNDERBUSS.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.BLACKPOWDER_REVOLVER.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.SIX_SHOOTER.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.ARQUEBUS.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.CLOCKWORK_RIFLE.get()), 10)
                .helmet(new ItemStack(Items.IRON_HELMET), 10)
                .chestplate(new ItemStack(Items.IRON_CHESTPLATE), 10)
                .leggings(new ItemStack(Items.IRON_LEGGINGS), 10)
                .boots(new ItemStack(Items.IRON_BOOTS), 10)
                .tag("frontier_ranged").tag("frontier_ranged").tag("frontier_gun"));

        addSet("frontier/irons_artifice/gun_gold", 25, 0, c -> c
                .mainhand(new ItemStack(ItemRegistry.FLINTLOCK_PISTOL.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.MUSKET.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.BLUNDERBUSS.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.BLACKPOWDER_REVOLVER.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.SIX_SHOOTER.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.ARQUEBUS.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.CLOCKWORK_RIFLE.get()), 10)
                .helmet(buffedGoldItem(Items.GOLDEN_HELMET, enchants), 10)
                .chestplate(buffedGoldItem(Items.GOLDEN_CHESTPLATE, enchants), 10)
                .leggings(buffedGoldItem(Items.GOLDEN_LEGGINGS, enchants), 10)
                .boots(buffedGoldItem(Items.GOLDEN_BOOTS, enchants), 10)
                .tag("frontier_ranged").tag("frontier_ranged").tag("frontier_gun"));

        // Ascent Sets
        addSet("ascent/irons_artifice/gun_iron", 25, 0, c -> c
                .mainhand(new ItemStack(ItemRegistry.FLINTLOCK_PISTOL.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.MUSKET.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.BLUNDERBUSS.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.BLACKPOWDER_REVOLVER.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.SIX_SHOOTER.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.ARQUEBUS.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.CLOCKWORK_RIFLE.get()), 10)
                .helmet(buffedItem(Items.IRON_HELMET, enchants, 1F), 10)
                .chestplate(buffedItem(Items.IRON_CHESTPLATE, enchants, 1F), 10)
                .leggings(buffedItem(Items.IRON_LEGGINGS, enchants, 1F), 10)
                .boots(buffedItem(Items.IRON_BOOTS, enchants, 1F), 10)
                .tag("ascent_ranged").tag("ascent_ranged").tag("ascent_gun"));

        addSet("ascent/irons_artifice/gun_gold", 25, 0, c -> c
                .mainhand(new ItemStack(ItemRegistry.FLINTLOCK_PISTOL.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.MUSKET.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.BLUNDERBUSS.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.BLACKPOWDER_REVOLVER.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.SIX_SHOOTER.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.ARQUEBUS.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.CLOCKWORK_RIFLE.get()), 10)
                .helmet(buffedGoldItem(Items.GOLDEN_HELMET, enchants), 10)
                .chestplate(buffedGoldItem(Items.GOLDEN_CHESTPLATE, enchants), 10)
                .leggings(buffedGoldItem(Items.GOLDEN_LEGGINGS, enchants), 10)
                .boots(buffedGoldItem(Items.GOLDEN_BOOTS, enchants), 10)
                .tag("ascent_ranged").tag("ascent_ranged").tag("ascent_gun"));

        addSet("ascent/irons_artifice/gun_diamond", 25, 0, c -> c
                .mainhand(new ItemStack(ItemRegistry.FLINTLOCK_PISTOL.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.MUSKET.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.BLUNDERBUSS.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.BLACKPOWDER_REVOLVER.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.SIX_SHOOTER.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.ARQUEBUS.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.CLOCKWORK_RIFLE.get()), 10)
                .helmet(new ItemStack(Items.DIAMOND_HELMET), 10)
                .chestplate(new ItemStack(Items.DIAMOND_CHESTPLATE), 10)
                .leggings(new ItemStack(Items.DIAMOND_LEGGINGS), 10)
                .boots(new ItemStack(Items.DIAMOND_BOOTS), 10)
                .tag("ascent_ranged").tag("ascent_ranged").tag("ascent_gun"));

        //Summit Sets
        addSet("summit/irons_artifice/gun_diamond", 25, 0, c -> c
                .mainhand(new ItemStack(ItemRegistry.FLINTLOCK_PISTOL.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.MUSKET.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.BLUNDERBUSS.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.BLACKPOWDER_REVOLVER.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.SIX_SHOOTER.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.ARQUEBUS.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.CLOCKWORK_RIFLE.get()), 10)
                .helmet(buffedItem(Items.DIAMOND_HELMET, enchants, 1F), 10)
                .chestplate(buffedItem(Items.DIAMOND_CHESTPLATE, enchants, 1F), 10)
                .leggings(buffedItem(Items.DIAMOND_LEGGINGS, enchants, 1F), 10)
                .boots(buffedItem(Items.DIAMOND_BOOTS, enchants, 1F), 10)
                .tag("summit_ranged").tag("summit_ranged").tag("summit_gun"));

        addSet("summit/irons_artifice/gun_netherite", 25, 0, c -> c
                .mainhand(new ItemStack(ItemRegistry.FLINTLOCK_PISTOL.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.MUSKET.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.BLUNDERBUSS.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.BLACKPOWDER_REVOLVER.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.SIX_SHOOTER.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.ARQUEBUS.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.CLOCKWORK_RIFLE.get()), 10)
                .helmet(new ItemStack(Items.NETHERITE_HELMET), 10)
                .chestplate(new ItemStack(Items.NETHERITE_CHESTPLATE), 10)
                .leggings(new ItemStack(Items.NETHERITE_LEGGINGS), 10)
                .boots(new ItemStack(Items.NETHERITE_BOOTS), 10)
                .tag("summit_ranged").tag("summit_ranged").tag("summit_gun"));

        //Pinnacle Sets
        addSet("pinnacle/irons_artifice/gun_diamond", 25, 0, c -> c
                .mainhand(new ItemStack(ItemRegistry.FLINTLOCK_PISTOL.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.MUSKET.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.BLUNDERBUSS.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.BLACKPOWDER_REVOLVER.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.SIX_SHOOTER.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.ARQUEBUS.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.CLOCKWORK_RIFLE.get()), 10)
                .helmet(buffedItem(Items.DIAMOND_HELMET, enchants, 1F), 10)
                .chestplate(buffedItem(Items.DIAMOND_CHESTPLATE, enchants, 1F), 10)
                .leggings(buffedItem(Items.DIAMOND_LEGGINGS, enchants, 1F), 10)
                .boots(buffedItem(Items.DIAMOND_BOOTS, enchants, 1F), 10)
                .tag("pinnacle_ranged").tag("pinnacle_ranged").tag("pinnacle_gun"));

        addSet("pinnacle/irons_artifice/gun_netherite", 25, 0, c -> c
                .mainhand(new ItemStack(ItemRegistry.FLINTLOCK_PISTOL.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.MUSKET.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.BLUNDERBUSS.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.BLACKPOWDER_REVOLVER.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.SIX_SHOOTER.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.ARQUEBUS.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.CLOCKWORK_RIFLE.get()), 10)
                .helmet(buffedItem(Items.NETHERITE_HELMET, enchants, 2F), 10)
                .chestplate(buffedItem(Items.NETHERITE_CHESTPLATE, enchants, 2F), 10)
                .leggings(buffedItem(Items.NETHERITE_LEGGINGS, enchants, 2F), 10)
                .boots(buffedItem(Items.NETHERITE_BOOTS, enchants, 2F), 10)
                .tag("pinnacle_ranged").tag("pinnacle_ranged").tag("pinnacle_gun"));
    }

    @Override
    protected void addSet(String name, int weight, float quality, UnaryOperator<GSBuilder> config) {
        this.addConditionally(ApothicCompats.loc(name), config.apply(new GSBuilder(weight, quality)).build(), new ModLoadedCondition(mod));
    }

}
