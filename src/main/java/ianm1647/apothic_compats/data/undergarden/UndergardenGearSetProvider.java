package ianm1647.apothic_compats.data.undergarden;

import dev.shadowsoffire.apotheosis.data.GearSetProvider;
import ianm1647.apothic_compats.ApothicCompats;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import quek.undergarden.registry.UGItems;

import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

public class UndergardenGearSetProvider extends GearSetProvider {

    public UndergardenGearSetProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    String mod = "undergarden";

    @Override
    public String getName() {
        return "Undergarden Gear Sets";
    }

    @Override
    public void generate() {
        HolderLookup.Provider registries = this.lookupProvider.join();
        HolderLookup.RegistryLookup<Enchantment> enchants = registries.lookup(Registries.ENCHANTMENT).get();

        // Frontier Sets

        addSet("frontier/undergarden/cloggrum", 25, 0, c -> c
                .mainhand(new ItemStack(UGItems.CLOGGRUM_SWORD.get()), 10)
                .mainhand(new ItemStack(UGItems.CLOGGRUM_AXE.get()), 10)
                .mainhand(new ItemStack(UGItems.CLOGGRUM_PICKAXE.get()), 10)
                .mainhand(new ItemStack(UGItems.CLOGGRUM_SHOVEL.get()), 10)
                .offhand(new ItemStack(UGItems.CLOGGRUM_SHIELD.get()), 8)
                .helmet(new ItemStack(UGItems.CLOGGRUM_HELMET.get()), 10)
                .chestplate(new ItemStack(UGItems.CLOGGRUM_CHESTPLATE.get()), 10)
                .leggings(new ItemStack(UGItems.CLOGGRUM_LEGGINGS.get()), 10)
                .boots(new ItemStack(UGItems.CLOGGRUM_BOOTS.get()), 10)
                .tag("frontier_melee"));

        addSet("frontier/undergarden/ancient", 25, 0, c -> c
                .helmet(new ItemStack(UGItems.ANCIENT_HELMET.get()), 10)
                .chestplate(new ItemStack(UGItems.ANCIENT_CHESTPLATE.get()), 10)
                .leggings(new ItemStack(UGItems.ANCIENT_LEGGINGS.get()), 10)
                .tag("frontier_melee"));

        // Ascent Sets

        addSet("ascent/undergarden/froststeel", 15, 0, c -> c
                .mainhand(new ItemStack(UGItems.FROSTSTEEL_SWORD.get()), 10)
                .mainhand(new ItemStack(UGItems.FROSTSTEEL_AXE.get()), 10)
                .mainhand(new ItemStack(UGItems.FROSTSTEEL_PICKAXE.get()), 10)
                .mainhand(new ItemStack(UGItems.FROSTSTEEL_SHOVEL.get()), 10)
                .helmet(new ItemStack(UGItems.FROSTSTEEL_HELMET.get()), 10)
                .chestplate(new ItemStack(UGItems.FROSTSTEEL_CHESTPLATE.get()), 10)
                .leggings(new ItemStack(UGItems.FROSTSTEEL_LEGGINGS.get()), 10)
                .boots(new ItemStack(UGItems.FROSTSTEEL_BOOTS.get()), 10)
                .tag("ascent_melee"));

        // Summit Sets

        addSet("summit/undergarden/utherium", 10, 0, c -> c
                .mainhand(new ItemStack(UGItems.UTHERIUM_SWORD.get()), 10)
                .mainhand(new ItemStack(UGItems.UTHERIUM_AXE.get()), 10)
                .mainhand(new ItemStack(UGItems.UTHERIUM_PICKAXE.get()), 10)
                .mainhand(new ItemStack(UGItems.UTHERIUM_SHOVEL.get()), 10)
                .helmet(new ItemStack(UGItems.UTHERIUM_HELMET.get()), 10)
                .chestplate(new ItemStack(UGItems.UTHERIUM_CHESTPLATE.get()), 10)
                .leggings(new ItemStack(UGItems.UTHERIUM_LEGGINGS.get()), 10)
                .boots(new ItemStack(UGItems.UTHERIUM_BOOTS.get()), 10)
                .tag("summit_melee"));

        addSet("summit/undergarden/forgotten", 10, 0, c -> c
                .mainhand(new ItemStack(UGItems.FORGOTTEN_SWORD.get()), 10)
                .mainhand(new ItemStack(UGItems.FORGOTTEN_AXE.get()), 10)
                .mainhand(new ItemStack(UGItems.FORGOTTEN_PICKAXE.get()), 10)
                .mainhand(new ItemStack(UGItems.FORGOTTEN_SHOVEL.get()), 10)
                .mainhand(new ItemStack(UGItems.FORGOTTEN_SHOVEL.get()), 10)
                .tag("summit_melee"));

    }

    @Override
    protected void addSet(String name, int weight, float quality, UnaryOperator<GSBuilder> config) {
        this.addConditionally(ApothicCompats.loc(name), config.apply(new GSBuilder(weight, quality)).build(), new ModLoadedCondition(mod));
    }
}