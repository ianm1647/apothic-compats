package ianm1647.apothic_compats.data.irons_artifice;

import dev.shadowsoffire.apotheosis.data.GearSetProvider;
import ianm1647.apothic_compats.ApothicCompats;
import io.redspace.irons_artifice.registry.ItemRegistry;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.ItemStack;
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
        Provider registries = this.lookupProvider.join();

        // Haven Sets
        addSet("haven/irons_artifice/gun", 25, 0, c -> c
                .mainhand(new ItemStack(ItemRegistry.FLINTLOCK_PISTOL.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.MUSKET.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.BLUNDERBUSS.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.BLACKPOWDER_REVOLVER.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.SIX_SHOOTER.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.ARQUEBUS.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.CLOCKWORK_RIFLE.get()), 10)
                .tag("haven_ranged").tag("haven_melee").tag("haven_gun"));

        // Frontier Sets
        addSet("frontier/irons_artifice/gun", 25, 0, c -> c
                .mainhand(new ItemStack(ItemRegistry.FLINTLOCK_PISTOL.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.MUSKET.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.BLUNDERBUSS.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.BLACKPOWDER_REVOLVER.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.SIX_SHOOTER.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.ARQUEBUS.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.CLOCKWORK_RIFLE.get()), 10)
                .tag("frontier_ranged").tag("frontier_ranged").tag("frontier_gun"));

        // Ascent Sets
        addSet("ascent/irons_artifice/gun", 25, 0, c -> c
                .mainhand(new ItemStack(ItemRegistry.FLINTLOCK_PISTOL.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.MUSKET.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.BLUNDERBUSS.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.BLACKPOWDER_REVOLVER.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.SIX_SHOOTER.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.ARQUEBUS.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.CLOCKWORK_RIFLE.get()), 10)
                .tag("ascent_ranged").tag("ascent_ranged").tag("ascent_gun"));

        //Summit Sets
        addSet("summit/irons_artifice/gun", 25, 0, c -> c
                .mainhand(new ItemStack(ItemRegistry.FLINTLOCK_PISTOL.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.MUSKET.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.BLUNDERBUSS.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.BLACKPOWDER_REVOLVER.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.SIX_SHOOTER.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.ARQUEBUS.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.CLOCKWORK_RIFLE.get()), 10)
                .tag("summit_ranged").tag("summit_ranged").tag("summit_gun"));

        //Pinnacle Sets
        addSet("pinnacle/irons_artifice/gun", 25, 0, c -> c
                .mainhand(new ItemStack(ItemRegistry.FLINTLOCK_PISTOL.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.MUSKET.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.BLUNDERBUSS.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.BLACKPOWDER_REVOLVER.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.SIX_SHOOTER.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.ARQUEBUS.get()), 10)
                .mainhand(new ItemStack(ItemRegistry.CLOCKWORK_RIFLE.get()), 10)
                .tag("pinnacle_ranged").tag("pinnacle_ranged").tag("pinnacle_gun"));
    }

    @Override
    protected void addSet(String name, int weight, float quality, UnaryOperator<GSBuilder> config) {
        this.addConditionally(ApothicCompats.loc(name), config.apply(new GSBuilder(weight, quality)).build(), new ModLoadedCondition(mod));
    }

}
