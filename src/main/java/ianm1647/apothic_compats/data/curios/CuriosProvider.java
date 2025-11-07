package ianm1647.apothic_compats.data.curios;

import ianm1647.apothic_compats.ApothicCompats;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import top.theillusivec4.curios.api.CuriosDataProvider;

import java.util.concurrent.CompletableFuture;

public class CuriosProvider extends CuriosDataProvider {
    public CuriosProvider(PackOutput output, ExistingFileHelper fileHelper, CompletableFuture<HolderLookup.Provider> registries) {
        super(ApothicCompats.MODID, output, fileHelper, registries);
    }

    @Override
    public void generate(HolderLookup.Provider registries, ExistingFileHelper fileHelper) {
        createSlot("back")
                .size(1)
                .addCosmetic(false);
        createSlot("body")
                .size(1)
                .addCosmetic(false);
        createSlot("bracelet")
                .size(2)
                .addCosmetic(false);
        createSlot("feet")
                .size(2)
                .addCosmetic(false);
        createSlot("curio")
                .size(1)
                .addCosmetic(false);
        createSlot("charm")
                .size(4)
                .addCosmetic(false);

        createEntities("entities")
                .addPlayer()
                .addSlots("back", "body", "bracelet", "feet", "curio", "charm");

    }
}
