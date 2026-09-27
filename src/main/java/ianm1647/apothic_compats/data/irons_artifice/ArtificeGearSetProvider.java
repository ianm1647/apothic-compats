package ianm1647.apothic_compats.data.irons_artifice;

import dev.shadowsoffire.apotheosis.data.GearSetProvider;
import ianm1647.apothic_compats.ApothicCompats;
import io.redspace.irons_artifice.registry.ItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
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
                .mainhand(new ItemStackTemplate(ItemRegistry.FLINTLOCK_PISTOL.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.MUSKET.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.BLUNDERBUSS.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.BLACKPOWDER_REVOLVER.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.SIX_SHOOTER.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.ARQUEBUS.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.CLOCKWORK_RIFLE.get()), 10)
                .helmet(new ItemStackTemplate(Items.CHAINMAIL_HELMET), 10)
                .chestplate(new ItemStackTemplate(Items.CHAINMAIL_CHESTPLATE), 10)
                .leggings(new ItemStackTemplate(Items.CHAINMAIL_LEGGINGS), 10)
                .boots(new ItemStackTemplate(Items.CHAINMAIL_BOOTS), 10)
                .tag("haven_ranged").tag("haven_melee").tag("haven_gun"));

        addSet("haven/irons_artifice/gun_iron", 25, 0, c -> c
                .mainhand(new ItemStackTemplate(ItemRegistry.FLINTLOCK_PISTOL.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.MUSKET.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.BLUNDERBUSS.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.BLACKPOWDER_REVOLVER.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.SIX_SHOOTER.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.ARQUEBUS.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.CLOCKWORK_RIFLE.get()), 10)
                .helmet(new ItemStackTemplate(Items.IRON_HELMET), 10)
                .chestplate(new ItemStackTemplate(Items.IRON_CHESTPLATE), 10)
                .leggings(new ItemStackTemplate(Items.IRON_LEGGINGS), 10)
                .boots(new ItemStackTemplate(Items.IRON_BOOTS), 10)
                .tag("haven_ranged").tag("haven_melee").tag("haven_gun"));

        // Frontier Sets
        addSet("frontier/irons_artifice/gun_iron", 25, 0, c -> c
                .mainhand(new ItemStackTemplate(ItemRegistry.FLINTLOCK_PISTOL.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.MUSKET.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.BLUNDERBUSS.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.BLACKPOWDER_REVOLVER.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.SIX_SHOOTER.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.ARQUEBUS.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.CLOCKWORK_RIFLE.get()), 10)
                .helmet(new ItemStackTemplate(Items.IRON_HELMET), 10)
                .chestplate(new ItemStackTemplate(Items.IRON_CHESTPLATE), 10)
                .leggings(new ItemStackTemplate(Items.IRON_LEGGINGS), 10)
                .boots(new ItemStackTemplate(Items.IRON_BOOTS), 10)
                .tag("frontier_ranged").tag("frontier_melee").tag("frontier_gun"));

        addSet("frontier/irons_artifice/gun_gold", 25, 0, c -> c
                .mainhand(new ItemStackTemplate(ItemRegistry.FLINTLOCK_PISTOL.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.MUSKET.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.BLUNDERBUSS.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.BLACKPOWDER_REVOLVER.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.SIX_SHOOTER.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.ARQUEBUS.get()), 10)
                .helmet(buffedItem(Items.GOLDEN_HELMET, enchants, Enchantments.PROTECTION, 3, 0.5F), 10)
                .chestplate(buffedItem(Items.GOLDEN_CHESTPLATE, enchants, Enchantments.PROTECTION, 3, 0.5F), 10)
                .leggings(buffedItem(Items.GOLDEN_LEGGINGS, enchants, Enchantments.PROTECTION, 3, 0.5F), 10)
                .boots(buffedItem(Items.GOLDEN_BOOTS, enchants, Enchantments.PROTECTION, 3, 0.5F), 10)
                .tag("frontier_ranged").tag("frontier_melee").tag("frontier_gun"));

        // Ascent Sets
        addSet("ascent/irons_artifice/gun_iron", 25, 0, c -> c
                .mainhand(new ItemStackTemplate(ItemRegistry.FLINTLOCK_PISTOL.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.MUSKET.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.BLUNDERBUSS.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.BLACKPOWDER_REVOLVER.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.SIX_SHOOTER.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.ARQUEBUS.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.CLOCKWORK_RIFLE.get()), 10)
                .helmet(buffedItem(Items.IRON_HELMET, enchants, Enchantments.PROTECTION, 3, 0.35F), 10)
                .chestplate(buffedItem(Items.IRON_CHESTPLATE, enchants, Enchantments.PROTECTION, 3, 0.35F), 10)
                .leggings(buffedItem(Items.IRON_LEGGINGS, enchants, Enchantments.PROTECTION, 3, 0.35F), 10)
                .boots(buffedItem(Items.IRON_BOOTS, enchants, Enchantments.PROTECTION, 3, 0.35F), 10)
                .tag("ascent_ranged").tag("ascent_melee").tag("ascent_gun"));

        addSet("ascent/irons_artifice/gun_gold", 25, 0, c -> c
                .mainhand(new ItemStackTemplate(ItemRegistry.FLINTLOCK_PISTOL.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.MUSKET.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.BLUNDERBUSS.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.BLACKPOWDER_REVOLVER.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.SIX_SHOOTER.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.ARQUEBUS.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.CLOCKWORK_RIFLE.get()), 10)
                .helmet(buffedItem(Items.GOLDEN_HELMET, enchants, Enchantments.PROTECTION, 3, 0.5F), 10)
                .chestplate(buffedItem(Items.GOLDEN_CHESTPLATE, enchants, Enchantments.PROTECTION, 3, 0.5F), 10)
                .leggings(buffedItem(Items.GOLDEN_LEGGINGS, enchants, Enchantments.PROTECTION, 3, 0.5F), 10)
                .boots(buffedItem(Items.GOLDEN_BOOTS, enchants, Enchantments.PROTECTION, 3, 0.5F), 10)
                .tag("ascent_ranged").tag("ascent_melee").tag("ascent_gun"));

        addSet("ascent/irons_artifice/gun_diamond", 25, 0, c -> c
                .mainhand(new ItemStackTemplate(ItemRegistry.FLINTLOCK_PISTOL.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.MUSKET.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.BLUNDERBUSS.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.BLACKPOWDER_REVOLVER.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.SIX_SHOOTER.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.ARQUEBUS.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.CLOCKWORK_RIFLE.get()), 10)
                .helmet(new ItemStackTemplate(Items.DIAMOND_HELMET), 10)
                .chestplate(new ItemStackTemplate(Items.DIAMOND_CHESTPLATE), 10)
                .leggings(new ItemStackTemplate(Items.DIAMOND_LEGGINGS), 10)
                .boots(new ItemStackTemplate(Items.DIAMOND_BOOTS), 10)
                .tag("ascent_ranged").tag("ascent_melee").tag("ascent_gun"));

        //Summit Sets
        addSet("summit/irons_artifice/gun_diamond", 25, 0, c -> c
                .mainhand(new ItemStackTemplate(ItemRegistry.FLINTLOCK_PISTOL.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.MUSKET.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.BLUNDERBUSS.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.BLACKPOWDER_REVOLVER.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.SIX_SHOOTER.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.ARQUEBUS.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.CLOCKWORK_RIFLE.get()), 10)
                .helmet(buffedItem(Items.DIAMOND_HELMET, enchants, Enchantments.PROTECTION, 2, 0.21F), 10)
                .chestplate(buffedItem(Items.DIAMOND_CHESTPLATE, enchants, Enchantments.PROTECTION, 2, 0.21F), 10)
                .leggings(buffedItem(Items.DIAMOND_LEGGINGS, enchants, Enchantments.PROTECTION, 2, 0.21F), 10)
                .boots(buffedItem(Items.DIAMOND_BOOTS, enchants, Enchantments.PROTECTION, 2, 0.21F), 10)
                .tag("summit_ranged").tag("summit_melee").tag("summit_gun"));

        addSet("summit/irons_artifice/gun_netherite", 25, 0, c -> c
                .mainhand(new ItemStackTemplate(ItemRegistry.FLINTLOCK_PISTOL.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.MUSKET.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.BLUNDERBUSS.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.BLACKPOWDER_REVOLVER.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.SIX_SHOOTER.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.ARQUEBUS.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.CLOCKWORK_RIFLE.get()), 10)
                .helmet(new ItemStackTemplate(Items.NETHERITE_HELMET), 10)
                .chestplate(new ItemStackTemplate(Items.NETHERITE_CHESTPLATE), 10)
                .leggings(new ItemStackTemplate(Items.NETHERITE_LEGGINGS), 10)
                .boots(new ItemStackTemplate(Items.NETHERITE_BOOTS), 10)
                .tag("summit_ranged").tag("summit_melee").tag("summit_gun"));

        //Pinnacle Sets
        addSet("pinnacle/irons_artifice/gun_diamond", 100, 0, c -> c
                .mainhand(new ItemStackTemplate(ItemRegistry.FLINTLOCK_PISTOL.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.MUSKET.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.BLUNDERBUSS.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.BLACKPOWDER_REVOLVER.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.SIX_SHOOTER.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.ARQUEBUS.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.CLOCKWORK_RIFLE.get()), 10)
                .helmet(buffedItem(Items.DIAMOND_HELMET, enchants, Enchantments.PROTECTION, 3, 0.35F), 10)
                .chestplate(buffedItem(Items.DIAMOND_CHESTPLATE, enchants, Enchantments.PROTECTION, 3, 0.35F), 10)
                .leggings(buffedItem(Items.DIAMOND_LEGGINGS, enchants, Enchantments.PROTECTION, 3, 0.35F), 10)
                .boots(buffedItem(Items.DIAMOND_BOOTS, enchants, Enchantments.PROTECTION, 3, 0.35F), 10)
                .tag("pinnacle_ranged").tag("pinnacle_melee").tag("pinnacle_gun"));

        addSet("pinnacle/irons_artifice/gun_netherite", 100, 0, c -> c
                .mainhand(new ItemStackTemplate(ItemRegistry.FLINTLOCK_PISTOL.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.MUSKET.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.BLUNDERBUSS.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.BLACKPOWDER_REVOLVER.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.SIX_SHOOTER.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.ARQUEBUS.get()), 10)
                .mainhand(new ItemStackTemplate(ItemRegistry.CLOCKWORK_RIFLE.get()), 10)
                .helmet(buffedItem(Items.NETHERITE_HELMET, enchants, Enchantments.PROTECTION, 6, 0.7F), 10)
                .chestplate(buffedItem(Items.NETHERITE_CHESTPLATE, enchants, Enchantments.PROTECTION, 6, 0.7F), 10)
                .leggings(buffedItem(Items.NETHERITE_LEGGINGS, enchants, Enchantments.PROTECTION, 6, 0.7F), 10)
                .boots(buffedItem(Items.NETHERITE_BOOTS, enchants, Enchantments.PROTECTION, 6, 0.7F), 10)
                .tag("pinnacle_ranged").tag("pinnacle_melee").tag("pinnacle_gun"));
    }

    @Override
    protected void addSet(String name, int weight, float quality, UnaryOperator<GSBuilder> config) {
        this.addConditionally(ApothicCompats.loc(name), config.apply(new GSBuilder(weight, quality)).build(), new ModLoadedCondition(mod));
    }

}