package ianm1647.apothic_compats.data;

import appeng.core.definitions.AEItems;
import com.aetherteam.aetherii.block.AetherIIBlocks;
import com.aetherteam.aetherii.item.AetherIIItems;
import dev.shadowsoffire.apotheosis.affix.salvaging.SalvagingRecipe;
import dev.shadowsoffire.placebo.datagen.LegacyRecipeProvider;
import ianm1647.apothic_compats.ApothicCompats;
import net.allthemods.allthemodium.core.registry.ATMItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import quek.undergarden.registry.UGItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class RecipeProvider extends LegacyRecipeProvider {
    String ae2 = "ae2";
    String aetherii = "aether_ii";
    String atm = "allthemodium";
    String undergarden = "undergarden";

    public RecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, ApothicCompats.MODID);
    }

    @Override
    protected void genRecipes(RecipeOutput recipeOutput, HolderLookup.Provider registries) {
        genAe2();
        genAether();
        genATM();
        genUndergarden();
    }

    private void genAe2() {
        addSalvaging("quartz_tools", ae2, new SalvagingRecipe.OutputData(Items.QUARTZ, 0, 1),
                AEItems.NETHER_QUARTZ_AXE.get(), AEItems.NETHER_QUARTZ_PICK.get(), AEItems.NETHER_QUARTZ_SHOVEL.get(), AEItems.NETHER_QUARTZ_SWORD.get(), AEItems.NETHER_QUARTZ_HOE.get());
        addSalvaging("certus_tools", ae2, new SalvagingRecipe.OutputData(AEItems.CERTUS_QUARTZ_CRYSTAL.get(), 0, 1),
                AEItems.CERTUS_QUARTZ_AXE.get(), AEItems.CERTUS_QUARTZ_PICK.get(), AEItems.CERTUS_QUARTZ_SHOVEL.get(), AEItems.CERTUS_QUARTZ_SWORD.get(), AEItems.CERTUS_QUARTZ_HOE.get());
        addSalvaging("fluix_tools", ae2, new SalvagingRecipe.OutputData(AEItems.FLUIX_CRYSTAL.get(), 0, 1),
                AEItems.FLUIX_AXE.get(), AEItems.FLUIX_PICK.get(), AEItems.FLUIX_SHOVEL.get(), AEItems.FLUIX_SWORD.get(), AEItems.FLUIX_HOE.get());
    }

    private void genAether() {
        addSalvaging("skyroot_tools", aetherii, new SalvagingRecipe.OutputData(AetherIIBlocks.SKYROOT_PLANKS.asItem(), 0, 1),
                AetherIIItems.SKYROOT_SHORTSWORD.get(),
                AetherIIItems.SKYROOT_PIKE.get(),
                AetherIIItems.SKYROOT_HAMMER.get(),
                AetherIIItems.SKYROOT_CROSSBOW.get(),
                AetherIIItems.SKYROOT_SHOVEL.get(),
                AetherIIItems.SKYROOT_PICKAXE.get(),
                AetherIIItems.SKYROOT_AXE.get(),
                AetherIIItems.SKYROOT_TROWEL.get(),
                AetherIIItems.SKYROOT_SHIELD.get());

        addSalvaging("holystone_tools", aetherii, new SalvagingRecipe.OutputData(AetherIIBlocks.HOLYSTONE.asItem(), 0, 1),
                AetherIIItems.HOLYSTONE_SHORTSWORD.get(),
                AetherIIItems.HOLYSTONE_PIKE.get(),
                AetherIIItems.HOLYSTONE_HAMMER.get(),
                AetherIIItems.HOLYSTONE_CROSSBOW.get(),
                AetherIIItems.HOLYSTONE_SHOVEL.get(),
                AetherIIItems.HOLYSTONE_PICKAXE.get(),
                AetherIIItems.HOLYSTONE_AXE.get(),
                AetherIIItems.HOLYSTONE_TROWEL.get());

        addSalvaging("zanite_tools", aetherii, new SalvagingRecipe.OutputData(AetherIIItems.ZANITE_GEMSTONE.get(), 0, 1),
                AetherIIItems.ZANITE_SHORTSWORD.get(),
                AetherIIItems.ZANITE_PIKE.get(),
                AetherIIItems.ZANITE_HAMMER.get(),
                AetherIIItems.ZANITE_CROSSBOW.get(),
                AetherIIItems.ZANITE_SHOVEL.get(),
                AetherIIItems.ZANITE_PICKAXE.get(),
                AetherIIItems.ZANITE_AXE.get(),
                AetherIIItems.ZANITE_TROWEL.get(),
                AetherIIItems.ZANITE_SHIELD.get());

        addSalvaging("arkenium_tools", aetherii, new SalvagingRecipe.OutputData(AetherIIItems.ARKENIUM_PLATE.asItem(), 0, 1),
                AetherIIItems.ARKENIUM_SHORTSWORD.get(),
                AetherIIItems.ARKENIUM_PIKE.get(),
                AetherIIItems.ARKENIUM_HAMMER.get(),
                AetherIIItems.ARKENIUM_CROSSBOW.get(),
                AetherIIItems.ARKENIUM_SHOVEL.get(),
                AetherIIItems.ARKENIUM_PICKAXE.get(),
                AetherIIItems.ARKENIUM_AXE.get(),
                AetherIIItems.ARKENIUM_TROWEL.get(),
                AetherIIItems.ARKENIUM_SHIELD.get());

        addSalvaging("gravitite_tools", aetherii, new SalvagingRecipe.OutputData(AetherIIItems.GRAVITITE_PLATE.asItem(), 0, 1),
                AetherIIItems.GRAVITITE_SHORTSWORD.get(),
                AetherIIItems.GRAVITITE_PIKE.get(),
                AetherIIItems.GRAVITITE_HAMMER.get(),
                AetherIIItems.GRAVITITE_CROSSBOW.get(),
                AetherIIItems.GRAVITITE_SHOVEL.get(),
                AetherIIItems.GRAVITITE_PICKAXE.get(),
                AetherIIItems.GRAVITITE_AXE.get(),
                AetherIIItems.GRAVITITE_TROWEL.get(),
                AetherIIItems.GRAVITITE_SHIELD.get());

        addSalvaging("zanite_armor", aetherii, new SalvagingRecipe.OutputData(AetherIIItems.ZANITE_GEMSTONE.get(), 1, 3),
                AetherIIItems.ZANITE_HELMET.get(), AetherIIItems.ZANITE_CHESTPLATE.get(), AetherIIItems.ZANITE_LEGGINGS.get(), AetherIIItems.ZANITE_BOOTS.get());
        addSalvaging("arkenium_armor", aetherii, new SalvagingRecipe.OutputData(AetherIIItems.ARKENIUM_PLATE.get(), 1, 3),
                AetherIIItems.ARKENIUM_HELMET.get(), AetherIIItems.ARKENIUM_CHESTPLATE.get(), AetherIIItems.ARKENIUM_LEGGINGS.get(), AetherIIItems.ARKENIUM_BOOTS.get());
        addSalvaging("gravitite_armor", aetherii, new SalvagingRecipe.OutputData(AetherIIItems.GRAVITITE_PLATE.asItem(), 1, 3),
                AetherIIItems.GRAVITITE_HELMET.get(), AetherIIItems.GRAVITITE_CHESTPLATE.get(), AetherIIItems.GRAVITITE_LEGGINGS.get(), AetherIIItems.GRAVITITE_BOOTS.get());
    }

    private void genATM() {
        addSalvaging("allthemodium_tools", atm, new SalvagingRecipe.OutputData(ATMItems.ALLTHEMODIUM_INGOT.get(), 1, 2),
                ATMItems.ALLTHEMODIUM_AXE.get(), ATMItems.ALLTHEMODIUM_PICKAXE.get(), ATMItems.ALLTHEMODIUM_SHOVEL.get(), ATMItems.ALLTHEMODIUM_SWORD.get(), ATMItems.ALLTHEMODIUM_HOE.get());
        addSalvaging("vibranium_tools", atm, new SalvagingRecipe.OutputData(ATMItems.VIBRANIUM_INGOT.get(), 1, 2),
                ATMItems.VIBRANIUM_AXE.get(), ATMItems.VIBRANIUM_PICKAXE.get(), ATMItems.VIBRANIUM_SHOVEL.get(), ATMItems.VIBRANIUM_SWORD.get(), ATMItems.VIBRANIUM_HOE.get());
        addSalvaging("unobtainium_tools", atm, new SalvagingRecipe.OutputData(ATMItems.UNOBTAINIUM_INGOT.get(), 1, 2),
                ATMItems.UNOBTAINIUM_AXE.get(), ATMItems.UNOBTAINIUM_PICKAXE.get(), ATMItems.UNOBTAINIUM_SHOVEL.get(), ATMItems.UNOBTAINIUM_SWORD.get(), ATMItems.UNOBTAINIUM_HOE.get());

        addSalvaging("allthemodium_armor", atm, new SalvagingRecipe.OutputData(ATMItems.ALLTHEMODIUM_INGOT.get(), 2, 3),
                ATMItems.ALLTHEMODIUM_HELMET.get(), ATMItems.ALLTHEMODIUM_CHESTPLATE.get(), ATMItems.ALLTHEMODIUM_LEGGINGS.get(), ATMItems.ALLTHEMODIUM_BOOTS.get());
        addSalvaging("vibranium_armor", atm, new SalvagingRecipe.OutputData(ATMItems.VIBRANIUM_INGOT.get(), 2, 3),
                ATMItems.VIBRANIUM_HELMET.get(), ATMItems.VIBRANIUM_CHESTPLATE.get(), ATMItems.VIBRANIUM_LEGGINGS.get(), ATMItems.VIBRANIUM_BOOTS.get());
        addSalvaging("unobtainium_armor", atm, new SalvagingRecipe.OutputData(ATMItems.UNOBTAINIUM_INGOT.get(), 2, 3),
                ATMItems.UNOBTAINIUM_HELMET.get(), ATMItems.UNOBTAINIUM_CHESTPLATE.get(), ATMItems.UNOBTAINIUM_LEGGINGS.get(), ATMItems.UNOBTAINIUM_BOOTS.get());
    }

    private void genUndergarden() {
        addSalvaging("cloggrum_tools", undergarden, new SalvagingRecipe.OutputData(UGItems.CLOGGRUM_INGOT.get(), 0, 1),
                UGItems.CLOGGRUM_SWORD.get(), UGItems.CLOGGRUM_PICKAXE.get(), UGItems.CLOGGRUM_AXE.get(), UGItems.CLOGGRUM_SHOVEL.get(), UGItems.CLOGGRUM_HOE.get());
        addSalvaging("froststeel_tools", undergarden, new SalvagingRecipe.OutputData(UGItems.FROSTSTEEL_INGOT.get(), 0, 1),
                UGItems.FROSTSTEEL_AXE.get(), UGItems.FROSTSTEEL_PICKAXE.get(), UGItems.FROSTSTEEL_SHOVEL.get(), UGItems.FROSTSTEEL_SWORD.get(), UGItems.FROSTSTEEL_HOE.get());
        addSalvaging("utherium_tools", undergarden, new SalvagingRecipe.OutputData(UGItems.UTHERIUM_CRYSTAL.get(), 0, 1),
                UGItems.UTHERIUM_AXE.get(), UGItems.UTHERIUM_PICKAXE.get(), UGItems.UTHERIUM_SWORD.get(), UGItems.UTHERIUM_SHOVEL.get(), UGItems.UTHERIUM_HOE.get());
        addSalvaging("forgotten_tools", undergarden, new SalvagingRecipe.OutputData(UGItems.FORGOTTEN_INGOT.get(), 0, 1),
                UGItems.FORGOTTEN_AXE.get(), UGItems.FORGOTTEN_PICKAXE.get(), UGItems.FORGOTTEN_SHOVEL.get(), UGItems.FORGOTTEN_SWORD.get(), UGItems.FORGOTTEN_HOE.get());

        addSalvaging("cloggrum_armor", undergarden, new SalvagingRecipe.OutputData(UGItems.CLOGGRUM_INGOT.get(), 1, 3),
                UGItems.CLOGGRUM_HELMET.get(), UGItems.CLOGGRUM_CHESTPLATE.get(), UGItems.CLOGGRUM_LEGGINGS.get(), UGItems.CLOGGRUM_BOOTS.get());
        addSalvaging("froststeel_armor", undergarden, new SalvagingRecipe.OutputData(UGItems.FROSTSTEEL_INGOT.get(), 1, 3),
                UGItems.FROSTSTEEL_HELMET.get(), UGItems.FROSTSTEEL_CHESTPLATE.get(), UGItems.FROSTSTEEL_LEGGINGS.get(), UGItems.FROSTSTEEL_BOOTS.get());
        addSalvaging("utherium_armor", undergarden, new SalvagingRecipe.OutputData(UGItems.UTHERIUM_CRYSTAL.get(), 1, 3),
                UGItems.UTHERIUM_HELMET.get(), UGItems.UTHERIUM_CHESTPLATE.get(), UGItems.UTHERIUM_LEGGINGS.get(), UGItems.UTHERIUM_BOOTS.get());
    }

    private static ResourceKey<Recipe<?>> key(Identifier id) {
        return ResourceKey.create(Registries.RECIPE, id);
    }

    private void addSalvaging(String path, String mod, SalvagingRecipe.OutputData output, Item... inputs) {
        addSalvaging("salvaging/" + mod + "/" + path, mod, Ingredient.of(inputs), List.of(output));
    }

    private void addSalvaging(String path, String mod, Ingredient input, List<SalvagingRecipe.OutputData> outputs) {
        this.recipeOutput.accept(key(ApothicCompats.loc(path)), new SalvagingRecipe(input, outputs), null, new ModLoadedCondition(mod));
    }

    @Override
    public String getName() {
        return "Apothic Compats Recipes";
    }
}
