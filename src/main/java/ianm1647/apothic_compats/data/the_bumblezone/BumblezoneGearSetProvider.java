package ianm1647.apothic_compats.data.the_bumblezone;

import cn.leolezury.eternalstarlight.common.registry.ESItems;
import com.hollingsworth.arsnouveau.setup.registry.ItemsRegistry;
import com.telepathicgrunt.the_bumblezone.modinit.BzItems;
import dev.shadowsoffire.apotheosis.data.GearSetProvider;
import ianm1647.apothic_compats.ApothicCompats;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

public class BumblezoneGearSetProvider extends GearSetProvider {

    public BumblezoneGearSetProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    String mod = "the_bumblezone";

    @Override
    public String getName() {
        return "The Bumblezone Gear Sets";
    }

    @Override
    public void generate() {
        HolderLookup.Provider registries = this.lookupProvider.join();
        HolderLookup.RegistryLookup<Enchantment> enchants = registries.lookup(Registries.ENCHANTMENT).get();

        // Frontier Sets

        addSet("frontier/the_bumblezone/bee", 25, 0, c -> c
                .mainhand(new ItemStack(BzItems.STINGER_SPEAR.get()), 10)
                .helmet(new ItemStack(BzItems.STINGLESS_BEE_HELMET_1.get()), 10)
                .helmet(new ItemStack(BzItems.STINGLESS_BEE_HELMET_2.get()), 10)
                .chestplate(new ItemStack(BzItems.BUMBLE_BEE_CHESTPLATE_1.get()), 10)
                .chestplate(new ItemStack(BzItems.BUMBLE_BEE_CHESTPLATE_2.get()), 10)
                .chestplate(new ItemStack(BzItems.TRANS_BUMBLE_BEE_CHESTPLATE_1.get()), 10)
                .chestplate(new ItemStack(BzItems.TRANS_BUMBLE_BEE_CHESTPLATE_2.get()), 10)
                .leggings(new ItemStack(BzItems.HONEY_BEE_LEGGINGS_1.get()), 10)
                .leggings(new ItemStack(BzItems.HONEY_BEE_LEGGINGS_2.get()), 10)
                .boots(new ItemStack(BzItems.CARPENTER_BEE_BOOTS_1.get()), 10)
                .boots(new ItemStack(BzItems.CARPENTER_BEE_BOOTS_2.get()), 10)
                .offhand(new ItemStack(BzItems.HONEY_CRYSTAL_SHIELD.get()), 10)
                .tag("frontier_melee"));

    }

    @Override
    protected void addSet(String name, int weight, float quality, UnaryOperator<GSBuilder> config) {
        this.addConditionally(ApothicCompats.loc(name), config.apply(new GSBuilder(weight, quality)).build(), new ModLoadedCondition(mod));
    }
}