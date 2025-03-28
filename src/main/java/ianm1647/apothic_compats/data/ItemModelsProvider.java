package ianm1647.apothic_compats.data;

import ianm1647.apothic_compats.ApothicCompats;
import ianm1647.apothic_compats.Comp;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ItemModelsProvider extends ItemModelProvider {
    public ItemModelsProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ApothicCompats.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        Comp.Curios.ITEM.getEntries().forEach((item) -> this.basicItem(item.get()));
    }
}
