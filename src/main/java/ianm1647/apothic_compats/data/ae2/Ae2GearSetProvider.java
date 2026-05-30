package ianm1647.apothic_compats.data.ae2;

import appeng.core.definitions.AEItems;
import dev.shadowsoffire.apotheosis.data.GearSetProvider;
import ianm1647.apothic_compats.ApothicCompats;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.HolderLookup.RegistryLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.enchantment.Enchantment;

import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

public class Ae2GearSetProvider extends GearSetProvider {

    public Ae2GearSetProvider(PackOutput output, CompletableFuture<Provider> registries) {
        super(output, registries);
    }

    String mod = "ae2";

    @Override
    public String getName() {
        return "Applied Energistics Gear Sets";
    }

    @Override
    public void generate() {
        Provider registries = this.lookupProvider.join();
        RegistryLookup<Enchantment> enchants = registries.lookup(Registries.ENCHANTMENT).get();

        // Frontier Sets
        addSet("frontier/ae2/quartz", 25, 0, c -> c
                .mainhand(new ItemStackTemplate(AEItems.NETHER_QUARTZ_SWORD.get()), 10)
                .mainhand(new ItemStackTemplate(AEItems.NETHER_QUARTZ_AXE.get()), 10)
                .mainhand(new ItemStackTemplate(AEItems.NETHER_QUARTZ_PICK.get()), 10)
                .mainhand(new ItemStackTemplate(AEItems.NETHER_QUARTZ_SHOVEL.get()), 10)
                .tag("frontier_melee"));

        // Ascent Sets
        addSet("ascent/ae2/certus", 15, 2.5F, c -> c
                .mainhand(new ItemStackTemplate(AEItems.CERTUS_QUARTZ_SWORD.get()), 10)
                .mainhand(new ItemStackTemplate(AEItems.CERTUS_QUARTZ_AXE.get()), 10)
                .mainhand(new ItemStackTemplate(AEItems.CERTUS_QUARTZ_PICK.get()), 10)
                .mainhand(new ItemStackTemplate(AEItems.CERTUS_QUARTZ_SHOVEL.get()), 10)
                .tag("ascent_melee"));

        addSet("ascent/ae2/fluix", 15, 2.5F, c -> c
                .mainhand(new ItemStackTemplate(AEItems.FLUIX_SWORD.get()), 10)
                .mainhand(new ItemStackTemplate(AEItems.FLUIX_AXE.get()), 10)
                .mainhand(new ItemStackTemplate(AEItems.FLUIX_PICK.get()), 10)
                .mainhand(new ItemStackTemplate(AEItems.FLUIX_SHOVEL.get()), 10)
                .tag("ascent_melee"));
    }

    @Override
    protected void addSet(String name, int weight, float quality, UnaryOperator<GSBuilder> config) {
        this.addConditionally(ApothicCompats.loc(name), config.apply(new GSBuilder(weight, quality)).build());
    }

}
