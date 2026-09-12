package ianm1647.apothic_compats.data;

import ianm1647.apothic_compats.ApothicCompats;
import ianm1647.apothic_compats.Comp;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;

public class ModelsProvider extends ModelProvider {
    public ModelsProvider(PackOutput output) {
        super(output, ApothicCompats.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        this.generateItems(itemModels);
    }

    private void generateItems(ItemModelGenerators itemModels) {
        Comp.R.getRegisteredObjects(Registries.ITEM).forEach((item) -> {
            itemModels.generateFlatItem(item.value(), ModelTemplates.FLAT_HANDHELD_ITEM);
        });
    }
}
