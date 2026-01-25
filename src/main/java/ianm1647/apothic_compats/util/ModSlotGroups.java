package ianm1647.apothic_compats.util;

import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import dev.shadowsoffire.apothic_attributes.compat.CurioEquipmentSlot;
import dev.shadowsoffire.apothic_attributes.modifiers.EntityEquipmentSlot;
import dev.shadowsoffire.apothic_attributes.modifiers.EntitySlotGroup;
import dev.shadowsoffire.placebo.registry.DeferredHelper;
import ianm1647.apothic_compats.ApothicCompats;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.neoforged.bus.api.IEventBus;

public class ModSlotGroups {

    public static final DeferredHelper R = DeferredHelper.create(ApothicCompats.MODID);

    public static void register(IEventBus bus) {
        bus.register(R);
        Slots.bootstrap();
        Groups.bootstrap();
    }

    public static class Slots {
        public static final Holder<EntityEquipmentSlot> BACK = slot("back");
        public static final Holder<EntityEquipmentSlot> BELT = slot("belt");
        public static final Holder<EntityEquipmentSlot> BODY = slot("body");
        public static final Holder<EntityEquipmentSlot> BRACELET = slot("bracelet");
        public static final Holder<EntityEquipmentSlot> CHARM = slot("charm");
        public static final Holder<EntityEquipmentSlot> CURIO = slot("curio");
        public static final Holder<EntityEquipmentSlot> FEET = slot("feet");
        public static final Holder<EntityEquipmentSlot> HANDS = slot("hands");
        public static final Holder<EntityEquipmentSlot> HEAD = slot("head");
        public static final Holder<EntityEquipmentSlot> NECKLACE = slot("necklace");
        public static final Holder<EntityEquipmentSlot> RING = slot("ring");

        public static final Holder<EntityEquipmentSlot> AN_FOCUS = slot("an_focus");

        public static final Holder<EntityEquipmentSlot> BROOCH = slot("brooch");
        public static final Holder<EntityEquipmentSlot> RUNE = slot("rune");

        private static Holder<EntityEquipmentSlot> slot(String slot) {
            return R.customDH(slot, ALObjects.BuiltInRegs.ENTITY_EQUIPMENT_SLOT.key(), () -> new CurioEquipmentSlot(slot));
        }

        public static void bootstrap() {}
    }

    public static class Groups {
        public static final EntitySlotGroup BACK = group("back", HolderSet.direct(Slots.BACK));
        public static final EntitySlotGroup BELT = group("belt", HolderSet.direct(Slots.BELT));
        public static final EntitySlotGroup BODY = group("body", HolderSet.direct(Slots.BODY));
        public static final EntitySlotGroup BRACELET = group("bracelet", HolderSet.direct(Slots.BRACELET));
        public static final EntitySlotGroup CHARM = group("charm", HolderSet.direct(Slots.CHARM));
        public static final EntitySlotGroup CURIO = group("curio", HolderSet.direct(Slots.CURIO));
        public static final EntitySlotGroup FEET = group("feet", HolderSet.direct(Slots.FEET));
        public static final EntitySlotGroup HANDS = group("hands", HolderSet.direct(Slots.HANDS));
        public static final EntitySlotGroup HEAD = group("head", HolderSet.direct(Slots.HEAD));
        public static final EntitySlotGroup NECKLACE = group("necklace", HolderSet.direct(Slots.NECKLACE));
        public static final EntitySlotGroup RING = group("ring", HolderSet.direct(Slots.RING));

        public static final EntitySlotGroup AN_FOCUS = group("an_focus", HolderSet.direct(Slots.AN_FOCUS));

        public static final EntitySlotGroup BROOCH = group("brooch", HolderSet.direct(Slots.BROOCH));
        public static final EntitySlotGroup RUNE = group("rune", HolderSet.direct(Slots.RUNE));

        public static final EntitySlotGroup CURIOS = group("curios", HolderSet.direct(
                Slots.BACK, Slots.BELT, Slots.BODY, Slots.BRACELET, Slots.CHARM,
                Slots.CURIO, Slots.FEET, Slots.HANDS, Slots.HEAD, Slots.NECKLACE, Slots.RING));

        private static EntitySlotGroup group(String path, HolderSet<EntityEquipmentSlot> slots) {
            return R.custom(path, ALObjects.BuiltInRegs.ENTITY_SLOT_GROUP.key(), new EntitySlotGroup(ApothicCompats.loc(path), slots));
        }

        public static void bootstrap() {}
    }
}
