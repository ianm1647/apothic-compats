package ianm1647.apothic_compats.data.deeperdarker;

import com.hollingsworth.arsnouveau.setup.registry.ItemsRegistry;
import com.kyanite.deeperdarker.content.DDItems;
import dev.shadowsoffire.apotheosis.Apoth;
import dev.shadowsoffire.apotheosis.data.GearSetProvider;
import ianm1647.apothic_compats.ApothicCompats;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

public class DeeperDarkerGearSetProvider extends GearSetProvider {

    public DeeperDarkerGearSetProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    String mod = "deeperdarker";

    @Override
    public String getName() {
        return "Deeper Darker Gear Sets";
    }

    @Override
    public void generate() {
        HolderLookup.Provider registries = this.lookupProvider.join();
        HolderLookup.RegistryLookup<Enchantment> enchants = registries.lookup(Registries.ENCHANTMENT).get();

        // Ascent Sets
        addSet("ascent/deeperdarker/resonarium", 15, 0, c -> c
                .mainhand(new ItemStack(DDItems.RESONARIUM_SWORD.get()), 10)
                .mainhand(new ItemStack(DDItems.RESONARIUM_PICKAXE.get()), 10)
                .mainhand(new ItemStack(DDItems.RESONARIUM_AXE.get()), 10)
                .mainhand(new ItemStack(DDItems.RESONARIUM_SHOVEL.get()), 10)
                .helmet(new ItemStack(DDItems.RESONARIUM_HELMET.get()), 10)
                .chestplate(new ItemStack(DDItems.RESONARIUM_CHESTPLATE.get()), 10)
                .leggings(new ItemStack(DDItems.RESONARIUM_LEGGINGS.get()), 10)
                .boots(new ItemStack(DDItems.RESONARIUM_BOOTS.get()), 10)
                .tag("ascent_melee"));

        // Summit Sets
        addSet("summit/deeperdarker/warden", 15, 0, c -> c
                .mainhand(new ItemStack(DDItems.WARDEN_SWORD.get()), 10)
                .mainhand(new ItemStack(DDItems.WARDEN_PICKAXE.get()), 10)
                .mainhand(new ItemStack(DDItems.WARDEN_AXE.get()), 10)
                .mainhand(new ItemStack(DDItems.WARDEN_SHOVEL.get()), 10)
                .helmet(new ItemStack(DDItems.WARDEN_HELMET.get()), 10)
                .chestplate(new ItemStack(DDItems.WARDEN_CHESTPLATE.get()), 10)
                .leggings(new ItemStack(DDItems.WARDEN_LEGGINGS.get()), 10)
                .boots(new ItemStack(DDItems.WARDEN_BOOTS.get()), 10)
                .tag("summit_melee"));
    }

    @Override
    protected void addSet(String name, int weight, float quality, UnaryOperator<GSBuilder> config) {
        this.addConditionally(ApothicCompats.loc(name), config.apply(new GSBuilder(weight, quality)).build(), new ModLoadedCondition(mod));
    }
}