package ianm1647.apothic_compats.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class ModCurioItem extends Item implements ICurioItem {
    public ModCurioItem() {
        super(new Item.Properties().stacksTo(1));
    }

    public boolean canEquipFromUse(SlotContext slotContext, ItemStack stack) {
        return true;
    }
}
