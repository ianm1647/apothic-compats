package ianm1647.apothic_compats.data;

import appeng.core.definitions.AEItems;
import cn.leolezury.eternalstarlight.common.registry.ESItems;
import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.item.AetherItems;
import com.github.L_Ender.cataclysm.init.ModItems;
import com.hollingsworth.arsnouveau.setup.registry.ItemsRegistry;
import com.kyanite.deeperdarker.content.DDItems;
import com.sammy.malum.registry.common.item.MalumItems;
import com.thevortex.allthemodium.registry.ModRegistry;
import dev.shadowsoffire.apotheosis.affix.salvaging.SalvagingRecipe;
import dev.shadowsoffire.placebo.datagen.LegacyRecipeProvider;
import ianm1647.apothic_compats.ApothicCompats;
import io.github.razordevs.deep_aether.init.DAItems;
import mekanism.common.registries.MekanismItems;
import mekanism.tools.common.registries.ToolsItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import quek.undergarden.registry.UGItems;
import twilightforest.init.TFItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class RecipeProvider extends LegacyRecipeProvider {
    String ae2 = "ae2";
    String aether = "aether";
    String atm = "allthemodium";
    String ars = "ars_nouveau";
    String cataclysm = "cataclysm";
    String deepaether = "deep_aether";
    String deeperdarker = "deeperdarker";
    String starlight = "eternal_starlight";
    String malum = "malum";
    String mekanism = "mekanismtools";
    String twilight = "twilightforest";
    String undergarden = "undergarden";

    public RecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, ApothicCompats.MODID);
    }

    @Override
    protected void genRecipes(RecipeOutput recipeOutput, HolderLookup.Provider registries) {
        genAe2();
        genAether();
        genATM();
        genArs();
        genCataclysm();
        genDeepAether();
        genDeeperDarker();
        genStarlight();
        genMalum();
        genMekanism();
        genTwilight();
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
        addSalvaging("skyroot_tools", aether, new SalvagingRecipe.OutputData(AetherBlocks.SKYROOT_PLANKS.asItem(), 0, 1),
                AetherItems.SKYROOT_AXE.get(), AetherItems.SKYROOT_PICKAXE.get(), AetherItems.SKYROOT_SHOVEL.get(), AetherItems.SKYROOT_SWORD.get(), AetherItems.SKYROOT_HOE.get());
        addSalvaging("holystone_tools", aether, new SalvagingRecipe.OutputData(AetherBlocks.HOLYSTONE.asItem(), 0, 1),
                AetherItems.HOLYSTONE_AXE.get(), AetherItems.HOLYSTONE_PICKAXE.get(), AetherItems.HOLYSTONE_SHOVEL.get(), AetherItems.HOLYSTONE_SWORD.get(), AetherItems.HOLYSTONE_HOE.get());
        addSalvaging("zanite_tools", aether, new SalvagingRecipe.OutputData(AetherItems.ZANITE_GEMSTONE.get(), 0, 1),
                AetherItems.ZANITE_AXE.get(), AetherItems.ZANITE_PICKAXE.get(), AetherItems.ZANITE_SHOVEL.get(), AetherItems.ZANITE_SWORD.get(), AetherItems.ZANITE_HOE.get());
        addSalvaging("gravitite_tools", aether, new SalvagingRecipe.OutputData(AetherBlocks.ENCHANTED_GRAVITITE.asItem(), 0, 1),
                AetherItems.GRAVITITE_AXE.get(), AetherItems.GRAVITITE_PICKAXE.get(), AetherItems.GRAVITITE_SHOVEL.get(), AetherItems.GRAVITITE_SWORD.get(), AetherItems.GRAVITITE_HOE.get());

        addSalvaging("zanite_armor", aether, new SalvagingRecipe.OutputData(AetherItems.ZANITE_GEMSTONE.get(), 1, 3),
                AetherItems.ZANITE_HELMET.get(), AetherItems.ZANITE_CHESTPLATE.get(), AetherItems.ZANITE_LEGGINGS.get(), AetherItems.ZANITE_BOOTS.get());
        addSalvaging("gravitite_armor", aether, new SalvagingRecipe.OutputData(AetherBlocks.ENCHANTED_GRAVITITE.asItem(), 1, 3),
                AetherItems.GRAVITITE_HELMET.get(), AetherItems.GRAVITITE_CHESTPLATE.get(), AetherItems.GRAVITITE_LEGGINGS.get(), AetherItems.GRAVITITE_BOOTS.get());
    }

    private void genATM() {
        addSalvaging("allthemodium_tools", atm, new SalvagingRecipe.OutputData(ModRegistry.ALLTHEMODIUM_INGOT.get(), 1, 2),
                ModRegistry.ATM_AXE.get(), ModRegistry.ATM_PICKAXE.get(), ModRegistry.ATM_SHOVEL.get(), ModRegistry.ATM_SWORD.get(), ModRegistry.ATM_HOE.get());
        addSalvaging("vibranium_tools", atm, new SalvagingRecipe.OutputData(ModRegistry.VIBRANIUM_INGOT.get(), 1, 2),
                ModRegistry.VIB_AXE.get(), ModRegistry.VIB_PICKAXE.get(), ModRegistry.VIB_SHOVEL.get(), ModRegistry.VIB_SWORD.get(), ModRegistry.VIB_HOE.get());
        addSalvaging("unobtainium_tools", atm, new SalvagingRecipe.OutputData(ModRegistry.UNOBTAINIUM_INGOT.get(), 1, 2),
                ModRegistry.UNO_AXE.get(), ModRegistry.UNO_PICKAXE.get(), ModRegistry.UNO_SHOVEL.get(), ModRegistry.UNO_SWORD.get(), ModRegistry.UNO_HOE.get());

        addSalvaging("allthemodium_armor", atm, new SalvagingRecipe.OutputData(ModRegistry.ALLTHEMODIUM_INGOT.get(), 2, 3),
                ModRegistry.ALLTHEMODIUM_HELMET.get(), ModRegistry.ALLTHEMODIUM_CHESTPLATE.get(), ModRegistry.ALLTHEMODIUM_LEGGINGS.get(), ModRegistry.ALLTHEMODIUM_BOOTS.get());
        addSalvaging("vibranium_armor", atm, new SalvagingRecipe.OutputData(ModRegistry.VIBRANIUM_INGOT.get(), 2, 3),
                ModRegistry.VIBRANIUM_HELMET.get(), ModRegistry.VIBRANIUM_CHESTPLATE.get(), ModRegistry.VIBRANIUM_LEGGINGS.get(), ModRegistry.VIBRANIUM_BOOTS.get());
        addSalvaging("unobtainium_armor", atm, new SalvagingRecipe.OutputData(ModRegistry.UNOBTAINIUM_INGOT.get(), 2, 3),
                ModRegistry.UNOBTAINIUM_HELMET.get(), ModRegistry.UNOBTAINIUM_CHESTPLATE.get(), ModRegistry.UNOBTAINIUM_LEGGINGS.get(), ModRegistry.UNOBTAINIUM_BOOTS.get());
    }

    private void genArs() {
        addSalvaging("arcanist_armor", ars, new SalvagingRecipe.OutputData(ItemsRegistry.MAGE_FIBER.get(), 0, 1),
                ItemsRegistry.ARCANIST_HOOD.get(), ItemsRegistry.ARCANIST_ROBES.get(), ItemsRegistry.ARCANIST_LEGGINGS.get(), ItemsRegistry.ARCANIST_BOOTS.get());
        addSalvaging("sorceror_armor", ars, new SalvagingRecipe.OutputData(ItemsRegistry.MAGE_FIBER.get(), 0, 1),
                ItemsRegistry.SORCERER_HOOD.get(), ItemsRegistry.SORCERER_ROBES.get(), ItemsRegistry.SORCERER_LEGGINGS.get(), ItemsRegistry.SORCERER_BOOTS.get());
        addSalvaging("battlemage_armor", ars, new SalvagingRecipe.OutputData(ItemsRegistry.MAGE_FIBER.get(), 0, 1),
                ItemsRegistry.BATTLEMAGE_HOOD.get(), ItemsRegistry.BATTLEMAGE_ROBES.get(), ItemsRegistry.BATTLEMAGE_LEGGINGS.get(), ItemsRegistry.BATTLEMAGE_BOOTS.get());
    }

    private void genCataclysm() {
        addSalvaging("black_steel_tools", cataclysm, new SalvagingRecipe.OutputData(ModItems.BLACK_STEEL_INGOT.get(), 0, 1),
                ModItems.BLACK_STEEL_AXE.get(), ModItems.BLACK_STEEL_PICKAXE.get(), ModItems.BLACK_STEEL_SHOVEL.get(), ModItems.BLACK_STEEL_SWORD.get(), ModItems.BLACK_STEEL_HOE.get());
    }

    private void genDeepAether() {
        addSalvaging("skyjade_tools", deepaether, new SalvagingRecipe.OutputData(DAItems.SKYJADE.get(), 0, 1),
                DAItems.SKYJADE_TOOLS_AXE.get(), DAItems.SKYJADE_TOOLS_PICKAXE.get(), DAItems.SKYJADE_TOOLS_SHOVEL.get(), DAItems.SKYJADE_TOOLS_SWORD.get(), DAItems.SKYJADE_TOOLS_HOE.get());
        addSalvaging("stratus_tools", deepaether, new SalvagingRecipe.OutputData(DAItems.STRATUS_INGOT.get(), 0, 1),
                DAItems.STRATUS_AXE.get(), DAItems.STRATUS_PICKAXE.get(), DAItems.STRATUS_SHOVEL.get(), DAItems.STRATUS_SWORD.get(), DAItems.STRATUS_HOE.get());

        addSalvaging("skyjade_armor", deepaether, new SalvagingRecipe.OutputData(DAItems.SKYJADE.get(), 1, 3),
                DAItems.SKYJADE_HELMET.get(), DAItems.SKYJADE_CHESTPLATE.get(), DAItems.SKYJADE_LEGGINGS.get(), DAItems.SKYJADE_BOOTS.get());
        addSalvaging("stratus_armor", deepaether, new SalvagingRecipe.OutputData(DAItems.STRATUS_INGOT.get(), 1, 3),
                DAItems.STRATUS_HELMET.get(), DAItems.STRATUS_CHESTPLATE.get(), DAItems.STRATUS_LEGGINGS.get(), DAItems.STRATUS_BOOTS.get());
    }

    private void genDeeperDarker() {
        addSalvaging("warden_tools", deeperdarker, new SalvagingRecipe.OutputData(DDItems.REINFORCED_ECHO_SHARD.get(), 0, 2),
                DDItems.WARDEN_AXE.get(), DDItems.WARDEN_PICKAXE.get(), DDItems.WARDEN_SHOVEL.get(), DDItems.WARDEN_SWORD.get(), DDItems.WARDEN_HOE.get());
        addSalvaging("stratus_tools", deeperdarker, new SalvagingRecipe.OutputData(DDItems.RESONARIUM_PLATE.get(), 0, 2),
                DDItems.RESONARIUM_AXE.get(), DDItems.RESONARIUM_PICKAXE.get(), DDItems.RESONARIUM_SHOVEL.get(), DDItems.RESONARIUM_SWORD.get(), DDItems.RESONARIUM_HOE.get());

        addSalvaging("warden_armor", deeperdarker, new SalvagingRecipe.OutputData(DDItems.REINFORCED_ECHO_SHARD.get(), 0, 2),
                DDItems.WARDEN_HELMET.get(), DDItems.WARDEN_CHESTPLATE.get(), DDItems.WARDEN_LEGGINGS.get(), DDItems.WARDEN_BOOTS.get());
        addSalvaging("stratus_armor", deeperdarker, new SalvagingRecipe.OutputData(DDItems.RESONARIUM_PLATE.get(), 0, 2),
                DDItems.RESONARIUM_HELMET.get(), DDItems.RESONARIUM_CHESTPLATE.get(), DDItems.RESONARIUM_LEGGINGS.get(), DDItems.RESONARIUM_BOOTS.get());
    }

    private void genStarlight() {
        addSalvaging("thermal_springstone_tools", starlight, new SalvagingRecipe.OutputData(ESItems.THERMAL_SPRINGSTONE_INGOT.get(), 0, 1),
                ESItems.THERMAL_SPRINGSTONE_AXE.get(), ESItems.THERMAL_SPRINGSTONE_PICKAXE.get(), ESItems.THERMAL_SPRINGSTONE_SHOVEL.get(), ESItems.THERMAL_SPRINGSTONE_SWORD.get(), ESItems.THERMAL_SPRINGSTONE_HOE.get());
        addSalvaging("starlit_diamond_tools", starlight, new SalvagingRecipe.OutputData(ESItems.STARLIT_DIAMOND.get(), 0, 1),
                ESItems.STARLIT_DIAMOND_AXE.get(), ESItems.STARLIT_DIAMOND_PICKAXE.get(), ESItems.STARLIT_DIAMOND_SHOVEL.get(), ESItems.STARLIT_DIAMOND_SWORD.get(), ESItems.STARLIT_DIAMOND_HOE.get());
        addSalvaging("glacite_tools", starlight, new SalvagingRecipe.OutputData(ESItems.GLACITE_SHARD.get(), 0, 1),
                ESItems.GLACITE_AXE.get(), ESItems.GLACITE_PICKAXE.get(), ESItems.GLACITE_SHOVEL.get(), ESItems.GLACITE_SWORD.get(), ESItems.GLACITE_HOE.get());
        addSalvaging("deepsilver_tools", starlight, new SalvagingRecipe.OutputData(ESItems.DEEPSILVER_INGOT.get(), 0, 1),
                ESItems.DEEPSILVER_AXE.get(), ESItems.DEEPSILVER_PICKAXE.get(), ESItems.DEEPSILVER_SHOVEL.get(), ESItems.DEEPSILVER_SWORD.get(), ESItems.DEEPSILVER_HOE.get());
        addSalvaging("malarite_tools", starlight, new SalvagingRecipe.OutputData(ESItems.MALARITE.get(), 0, 1),
                ESItems.MALARITE_AXE.get(), ESItems.MALARITE_PICKAXE.get(), ESItems.MALARITE_SHOVEL.get(), ESItems.MALARITE_SWORD.get(), ESItems.MALARITE_HOE.get());
        addSalvaging("amaramber_tools", starlight, new SalvagingRecipe.OutputData(ESItems.AMARAMBER_INGOT.get(), 0, 1),
                ESItems.AMARAMBER_AXE.get(), ESItems.AMARAMBER_PICKAXE.get(), ESItems.AMARAMBER_SHOVEL.get(), ESItems.AMARAMBER_SWORD.get(), ESItems.AMARAMBER_HOE.get());
        addSalvaging("aethersent_tools", starlight, new SalvagingRecipe.OutputData(ESItems.AMARAMBER_INGOT.get(), 0, 1),
                ESItems.RAGE_OF_STARS.get());
        addSalvaging("starfire_tools", starlight, new SalvagingRecipe.OutputData(ESItems.STARFIRE.get(), 0, 2),
                ESItems.STARFIRE_AXE.get(), ESItems.STARFIRE_PICKAXE.get(), ESItems.STARFIRE_SHOVEL.get(), ESItems.STARFIRE_SWORD.get(), ESItems.STARFIRE_HOE.get());
        addSalvaging("flowglaze_tools", starlight, new SalvagingRecipe.OutputData(ESItems.FLOWGLAZE.get(), 0, 2),
                ESItems.FLOWGLAZE_AXE.get(), ESItems.FLOWGLAZE_PICKAXE.get(), ESItems.FLOWGLAZE_SHOVEL.get(), ESItems.FLOWGLAZE_SWORD.get(), ESItems.FLOWGLAZE_HOE.get());

        addSalvaging("thermal_springstone_armor", starlight, new SalvagingRecipe.OutputData(ESItems.THERMAL_SPRINGSTONE_INGOT.get(), 1, 3),
                ESItems.THERMAL_SPRINGSTONE_HELMET.get(), ESItems.THERMAL_SPRINGSTONE_CHESTPLATE.get(), ESItems.THERMAL_SPRINGSTONE_LEGGINGS.get(), ESItems.THERMAL_SPRINGSTONE_BOOTS.get());
        addSalvaging("starlit_diamond_armor", starlight, new SalvagingRecipe.OutputData(ESItems.STARLIT_DIAMOND.get(), 1, 3),
                ESItems.STARLIT_DIAMOND_HELMET.get(), ESItems.STARLIT_DIAMOND_CHESTPLATE.get(), ESItems.STARLIT_DIAMOND_LEGGINGS.get(), ESItems.STARLIT_DIAMOND_BOOTS.get());
        addSalvaging("glacite_armor", starlight, new SalvagingRecipe.OutputData(ESItems.GLACITE_SHARD.get(), 1, 3),
                ESItems.GLACITE_HELMET.get(), ESItems.GLACITE_CHESTPLATE.get(), ESItems.GLACITE_LEGGINGS.get(), ESItems.GLACITE_BOOTS.get());
        addSalvaging("deepsilver_armor", starlight, new SalvagingRecipe.OutputData(ESItems.DEEPSILVER_INGOT.get(), 1, 3),
                ESItems.DEEPSILVER_HELMET.get(), ESItems.DEEPSILVER_CHESTPLATE.get(), ESItems.DEEPSILVER_LEGGINGS.get(), ESItems.DEEPSILVER_BOOTS.get());
        addSalvaging("aethersent_armor", starlight, new SalvagingRecipe.OutputData(ESItems.AETHERSENT_INGOT.get(), 1, 3),
                ESItems.AETHERSENT_HOOD.get(), ESItems.AETHERSENT_CAPE.get(), ESItems.AETHERSENT_BOTTOMS.get(), ESItems.AETHERSENT_BOOTS.get());
        addSalvaging("amaramber_armor", starlight, new SalvagingRecipe.OutputData(ESItems.AETHERSENT_INGOT.get(), 1, 3),
                ESItems.AMARAMBER_MASK.get(), ESItems.AMARAMBER_CHESTPLATE.get());
    }

    private void genMalum() {
        addSalvaging("soulstained_tools", malum, new SalvagingRecipe.OutputData(MalumItems.SOUL_STAINED_STEEL_PLATING.get(), 1, 2),
                MalumItems.SOUL_STAINED_STEEL_AXE.get(), MalumItems.SOUL_STAINED_STEEL_PICKAXE.get(), MalumItems.SOUL_STAINED_STEEL_SHOVEL.get(), MalumItems.SOUL_STAINED_STEEL_SWORD.get(), MalumItems.SOUL_STAINED_STEEL_HOE.get(), MalumItems.SOUL_STAINED_STEEL_SCYTHE.get());

        addSalvaging("soulstained_armor", malum, new SalvagingRecipe.OutputData(MalumItems.SOUL_STAINED_STEEL_PLATING.get(), 2, 3),
                MalumItems.SOUL_STAINED_STEEL_HELMET.get(), MalumItems.SOUL_STAINED_STEEL_CHESTPLATE.get(), MalumItems.SOUL_STAINED_STEEL_LEGGINGS.get(), MalumItems.SOUL_STAINED_STEEL_BOOTS.get());
        addSalvaging("soulhunter_armor", malum, new SalvagingRecipe.OutputData(MalumItems.SOULWOVEN_SILK.get(), 2, 3),
                MalumItems.SOUL_HUNTER_CLOAK.get(), MalumItems.SOUL_HUNTER_ROBE.get(), MalumItems.SOUL_HUNTER_LEGGINGS.get(), MalumItems.SOUL_HUNTER_BOOTS.get());
        addSalvaging("malignant_stronghold_armor", malum, new SalvagingRecipe.OutputData(MalumItems.MALIGNANT_PEWTER_PLATING.get(), 2, 3),
                MalumItems.MALIGNANT_STRONGHOLD_HELMET.get(), MalumItems.MALIGNANT_STRONGHOLD_CHESTPLATE.get(), MalumItems.MALIGNANT_STRONGHOLD_LEGGINGS.get(), MalumItems.MALIGNANT_STRONGHOLD_BOOTS.get());
    }

    private void genMekanism() {
        addSalvaging("lapis_tools", mekanism, new SalvagingRecipe.OutputData(Items.LAPIS_LAZULI, 0, 1),
                ToolsItems.LAPIS_LAZULI_AXE.get(), ToolsItems.LAPIS_LAZULI_PICKAXE.get(), ToolsItems.LAPIS_LAZULI_SHOVEL.get(), ToolsItems.LAPIS_LAZULI_SWORD.get(), ToolsItems.LAPIS_LAZULI_HOE.get());
        addSalvaging("osmium_tools", mekanism, new SalvagingRecipe.OutputData(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("mekanism", "ingot_osmium")), 0, 1),
                ToolsItems.OSMIUM_AXE.get(), ToolsItems.OSMIUM_PICKAXE.get(), ToolsItems.OSMIUM_SHOVEL.get(), ToolsItems.OSMIUM_SWORD.get(), ToolsItems.OSMIUM_HOE.get());
        addSalvaging("steel_tools", mekanism, new SalvagingRecipe.OutputData(MekanismItems.STEEL_INGOT.get(), 0, 1),
                ToolsItems.STEEL_AXE.get(), ToolsItems.STEEL_PICKAXE.get(), ToolsItems.STEEL_SHOVEL.get(), ToolsItems.STEEL_SWORD.get(), ToolsItems.STEEL_HOE.get());
        addSalvaging("bronze_tools", mekanism, new SalvagingRecipe.OutputData(MekanismItems.BRONZE_INGOT.get(), 0, 1),
                ToolsItems.BRONZE_AXE.get(), ToolsItems.BRONZE_PICKAXE.get(), ToolsItems.BRONZE_SHOVEL.get(), ToolsItems.BRONZE_SWORD.get(), ToolsItems.BRONZE_HOE.get());
        addSalvaging("refined_glowstone_tools", mekanism, new SalvagingRecipe.OutputData(MekanismItems.REFINED_GLOWSTONE_INGOT.get(), 0, 1),
                ToolsItems.REFINED_GLOWSTONE_AXE.get(), ToolsItems.REFINED_GLOWSTONE_PICKAXE.get(), ToolsItems.REFINED_GLOWSTONE_SHOVEL.get(), ToolsItems.REFINED_GLOWSTONE_SWORD.get(), ToolsItems.REFINED_GLOWSTONE_HOE.get());
        addSalvaging("refined_obsidian_tools", mekanism, new SalvagingRecipe.OutputData(MekanismItems.REFINED_OBSIDIAN_INGOT.get(), 0, 1),
                ToolsItems.REFINED_OBSIDIAN_AXE.get(), ToolsItems.REFINED_OBSIDIAN_PICKAXE.get(), ToolsItems.REFINED_OBSIDIAN_SHOVEL.get(), ToolsItems.REFINED_OBSIDIAN_SWORD.get(), ToolsItems.REFINED_OBSIDIAN_HOE.get());

        addSalvaging("lapis_armor", mekanism, new SalvagingRecipe.OutputData(Items.LAPIS_LAZULI, 1, 3),
                ToolsItems.LAPIS_LAZULI_HELMET.get(), ToolsItems.LAPIS_LAZULI_CHESTPLATE.get(), ToolsItems.LAPIS_LAZULI_LEGGINGS.get(), ToolsItems.LAPIS_LAZULI_BOOTS.get());
        addSalvaging("osmium_armor", mekanism, new SalvagingRecipe.OutputData(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("mekanism", "ingot_osmium")), 1, 3),
                ToolsItems.OSMIUM_HELMET.get(), ToolsItems.OSMIUM_CHESTPLATE.get(), ToolsItems.OSMIUM_LEGGINGS.get(), ToolsItems.OSMIUM_BOOTS.get());
        addSalvaging("steel_armor", mekanism, new SalvagingRecipe.OutputData(MekanismItems.STEEL_INGOT.get(), 1, 3),
                ToolsItems.STEEL_HELMET.get(), ToolsItems.STEEL_CHESTPLATE.get(), ToolsItems.STEEL_LEGGINGS.get(), ToolsItems.STEEL_BOOTS.get());
        addSalvaging("bronze_armor", mekanism, new SalvagingRecipe.OutputData(MekanismItems.BRONZE_INGOT.get(), 1, 3),
                ToolsItems.BRONZE_HELMET.get(), ToolsItems.BRONZE_CHESTPLATE.get(), ToolsItems.BRONZE_LEGGINGS.get(), ToolsItems.BRONZE_BOOTS.get());
        addSalvaging("refined_glowstone_armor", mekanism, new SalvagingRecipe.OutputData(MekanismItems.REFINED_GLOWSTONE_INGOT.get(), 1, 3),
                ToolsItems.REFINED_GLOWSTONE_HELMET.get(), ToolsItems.REFINED_GLOWSTONE_CHESTPLATE.get(), ToolsItems.REFINED_GLOWSTONE_LEGGINGS.get(), ToolsItems.REFINED_GLOWSTONE_BOOTS.get());
        addSalvaging("refined_obsidian_armor", mekanism, new SalvagingRecipe.OutputData(MekanismItems.REFINED_OBSIDIAN_INGOT.get(), 1, 3),
                ToolsItems.REFINED_OBSIDIAN_HELMET.get(), ToolsItems.REFINED_OBSIDIAN_CHESTPLATE.get(), ToolsItems.REFINED_OBSIDIAN_LEGGINGS.get(), ToolsItems.REFINED_OBSIDIAN_BOOTS.get());
    }

    private void genTwilight() {
        addSalvaging("fiery_tools", twilight, new SalvagingRecipe.OutputData(TFItems.FIERY_INGOT.get(), 0, 1),
                TFItems.FIERY_SWORD.get(), TFItems.FIERY_PICKAXE.get());
        addSalvaging("ironwood_tools", twilight, new SalvagingRecipe.OutputData(TFItems.IRONWOOD_INGOT.get(), 0, 1),
                TFItems.IRONWOOD_AXE.get(), TFItems.IRONWOOD_PICKAXE.get(), TFItems.IRONWOOD_SHOVEL.get(), TFItems.IRONWOOD_SWORD.get(), TFItems.IRONWOOD_HOE.get());
        addSalvaging("knightmetal_tools", twilight, new SalvagingRecipe.OutputData(TFItems.KNIGHTMETAL_INGOT.get(), 0, 1),
                TFItems.KNIGHTMETAL_AXE.get(), TFItems.KNIGHTMETAL_PICKAXE.get(), TFItems.KNIGHTMETAL_SWORD.get());
        addSalvaging("steeleaf_tools", twilight, new SalvagingRecipe.OutputData(TFItems.STEELEAF_INGOT.get(), 0, 1),
                TFItems.STEELEAF_AXE.get(), TFItems.STEELEAF_PICKAXE.get(), TFItems.STEELEAF_SHOVEL.get(), TFItems.STEELEAF_SWORD.get(), TFItems.STEELEAF_HOE.get());

        addSalvaging("arctic_fur_armor", twilight, new SalvagingRecipe.OutputData(TFItems.ARCTIC_FUR.get(), 1, 3),
                TFItems.ARCTIC_HELMET.get(), TFItems.ARCTIC_CHESTPLATE.get(), TFItems.ARCTIC_LEGGINGS.get(), TFItems.ARCTIC_BOOTS.get());
        addSalvaging("alpha_yeti_armor", twilight, new SalvagingRecipe.OutputData(TFItems.ALPHA_YETI_FUR.get(), 1, 3),
                TFItems.YETI_HELMET.get(), TFItems.YETI_CHESTPLATE.get(), TFItems.YETI_LEGGINGS.get(), TFItems.YETI_BOOTS.get());
        addSalvaging("fiery_armor", twilight, new SalvagingRecipe.OutputData(TFItems.FIERY_INGOT.get(), 1, 3),
                TFItems.FIERY_HELMET.get(), TFItems.FIERY_CHESTPLATE.get(), TFItems.FIERY_LEGGINGS.get(), TFItems.FIERY_BOOTS.get());
        addSalvaging("ironwood_armor", twilight, new SalvagingRecipe.OutputData(TFItems.IRONWOOD_INGOT.get(), 1, 3),
                TFItems.IRONWOOD_HELMET.get(), TFItems.IRONWOOD_CHESTPLATE.get(), TFItems.IRONWOOD_LEGGINGS.get(), TFItems.IRONWOOD_BOOTS.get());
        addSalvaging("knightmetal_armor", twilight, new SalvagingRecipe.OutputData(TFItems.KNIGHTMETAL_INGOT.get(), 1, 3),
                TFItems.KNIGHTMETAL_HELMET.get(), TFItems.KNIGHTMETAL_CHESTPLATE.get(), TFItems.KNIGHTMETAL_LEGGINGS.get(), TFItems.KNIGHTMETAL_BOOTS.get());
        addSalvaging("steeleaf_armor", twilight, new SalvagingRecipe.OutputData(TFItems.STEELEAF_INGOT.get(), 1, 3),
                TFItems.STEELEAF_HELMET.get(), TFItems.STEELEAF_CHESTPLATE.get(), TFItems.STEELEAF_LEGGINGS.get(), TFItems.STEELEAF_BOOTS.get());
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

    private void addSalvaging(String path, String mod, SalvagingRecipe.OutputData output, Item... inputs) {
        addSalvaging("salvaging/" + mod + "/" + path, mod, Ingredient.of(inputs), List.of(output));
    }

    private void addSalvaging(String path, String mod, Ingredient input, List<SalvagingRecipe.OutputData> outputs) {
        this.recipeOutput.accept(ApothicCompats.loc(path), new SalvagingRecipe(input, outputs), null, new ModLoadedCondition(mod));
    }
}
