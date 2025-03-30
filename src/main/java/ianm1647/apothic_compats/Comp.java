package ianm1647.apothic_compats;

import ianm1647.apothic_compats.item.ModCurioItem;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Comp {

    public static void register(IEventBus bus) {
        if (ModList.get().isLoaded("curios")) {
            Curios.ITEM.register(bus);
        }
    }

    public class Curios {
        public static DeferredRegister<Item> ITEM;

        public static Holder<Item> BACK_PLATE;
        public static Holder<Item> FLORID_BELT;
        public static Holder<Item> BODY_CHAIN;
        public static Holder<Item> FLASHY_BRACELET;
        public static Holder<Item> FANCY_CHARM;
        public static Holder<Item> EMBELLISHED_CURIO;
        public static Holder<Item> ADORNED_BOOTS;
        public static Holder<Item> SHOWY_GLOVES;
        public static Holder<Item> HEAD_COVER;
        public static Holder<Item> ORNAMENTED_NECKLACE;
        public static Holder<Item> ORNATE_RING;

        static {
            ITEM = DeferredRegister.create(Registries.ITEM, ApothicCompats.MODID);

            BACK_PLATE = ITEM.register("back_plate", ModCurioItem::new);
            FLORID_BELT = ITEM.register("florid_belt", ModCurioItem::new);
            BODY_CHAIN = ITEM.register("body_chain", ModCurioItem::new);
            FLASHY_BRACELET = ITEM.register("flashy_bracelet", ModCurioItem::new);
            FANCY_CHARM = ITEM.register("fancy_charm", ModCurioItem::new);
            EMBELLISHED_CURIO = ITEM.register("embellished_curio", ModCurioItem::new);
            ADORNED_BOOTS = ITEM.register("adorned_boots", ModCurioItem::new);
            SHOWY_GLOVES = ITEM.register("showy_gloves", ModCurioItem::new);
            HEAD_COVER = ITEM.register("head_cover", ModCurioItem::new);
            ORNAMENTED_NECKLACE = ITEM.register("ornamented_necklace", ModCurioItem::new);
            ORNATE_RING = ITEM.register("ornate_ring", ModCurioItem::new);
        }
    }
}
