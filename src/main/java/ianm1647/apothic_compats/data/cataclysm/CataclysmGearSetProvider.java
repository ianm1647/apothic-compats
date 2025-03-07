package ianm1647.apothic_compats.data.cataclysm;

import com.github.L_Ender.cataclysm.init.ModItems;
import dev.shadowsoffire.apotheosis.data.GearSetProvider;
import ianm1647.apothic_compats.ApothicCompats;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

public class CataclysmGearSetProvider extends GearSetProvider {

    public CataclysmGearSetProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    String mod = "cataclysm";

    @Override
    public String getName() {
        return "Cataclysm Gear Sets";
    }

    @Override
    public void generate() {
        HolderLookup.Provider registries = this.lookupProvider.join();
        HolderLookup.RegistryLookup<Enchantment> enchants = registries.lookup(Registries.ENCHANTMENT).get();

        // Ascent Sets
        addSet("ascent/cataclysm/black_steel", 10, 0, c -> c
                .mainhand(new ItemStack(ModItems.BLACK_STEEL_SWORD.asItem()), 10)
                .mainhand(new ItemStack(ModItems.BLACK_STEEL_AXE.asItem()), 10)
                .mainhand(new ItemStack(ModItems.BLACK_STEEL_PICKAXE.asItem()), 10)
                .mainhand(new ItemStack(ModItems.BLACK_STEEL_SHOVEL.asItem()), 10)
                .offhand(new ItemStack(ModItems.BLACK_STEEL_TARGE.asItem()), 10)
                .tag("ascent_melee"));
    }

    @Override
    protected void addSet(String name, int weight, float quality, UnaryOperator<GSBuilder> config) {
        this.addConditionally(ApothicCompats.loc(name), config.apply(new GSBuilder(weight, quality)).build(), new ModLoadedCondition(mod));
    }
}