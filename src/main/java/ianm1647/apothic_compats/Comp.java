package ianm1647.apothic_compats;

import dev.shadowsoffire.apotheosis.Apoth;
import dev.shadowsoffire.apotheosis.loot.LootCategory;
import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import dev.shadowsoffire.apothic_attributes.compat.CurioEquipmentSlot;
import dev.shadowsoffire.apothic_attributes.modifiers.EntityEquipmentSlot;
import dev.shadowsoffire.apothic_attributes.modifiers.EntitySlotGroup;
import dev.shadowsoffire.placebo.registry.DeferredHelper;
import ianm1647.apothic_compats.item.ModCurioItem;
import ianm1647.apothic_compats.util.ModTags;
import io.redspace.irons_artifice.data.ShotComponents;
import io.redspace.irons_artifice.item.GunItem;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.common.PercentageAttribute;

import java.util.function.Predicate;

public class Comp {

    public static final DeferredHelper R = DeferredHelper.create(ApothicCompats.MODID);

    public static class Attributes {
        public static class Artifice {
            public static final Holder<Attribute> BULLET_SPREAD =
                    R.attribute("bullet_spread", () -> new RangedAttribute("apothic_compats:bullet_spread", ShotComponents.SPREAD.provideDefaultValue().base(), 0.0D, 2048.0D).setSyncable(true));
            public static final Holder<Attribute> FIRE_RATE =
                    R.attribute("fire_rate", () -> new RangedAttribute("apothic_compats:fire_rate", ShotComponents.FIRE_RATE.provideDefaultValue().base(), 0.0D, 2048.0D).setSyncable(true));
            public static final Holder<Attribute> GUN_DAMAGE =
                    R.attribute("gun_damage", () -> new RangedAttribute("apothic_compats:gun_damage", ShotComponents.DAMAGE.provideDefaultValue().base(), 0.0D, 2048.0D).setSyncable(true));
            public static final Holder<Attribute> BULLET_KNOCKBACK =
                    R.attribute("bullet_knockback", () -> new RangedAttribute("apothic_compats:bullet_knockback", ShotComponents.KNOCKBACK.provideDefaultValue().base(), 0.0D, 2048.0D).setSyncable(true));
            public static final Holder<Attribute> RELOAD_SPEED =
                    R.attribute("reload_speed", () -> new RangedAttribute("apothic_compats:reload_speed", ShotComponents.RELOAD_SPEED_MULTIPLIER.provideDefaultValue().base(), 0.0D, 2048.0D).setSyncable(true));
            public static final Holder<Attribute> BULLET_PIERCE =
                    R.attribute("bullet_pierce", () -> new RangedAttribute("apothic_compats:bullet_pierce", ShotComponents.PIERCING.provideDefaultValue().base(), 0.0D, 2048.0D).setSyncable(true));
            public static final Holder<Attribute> LEECH =
                    R.attribute("bullet_leech", () -> new RangedAttribute("apothic_compats:bullet_leech", ShotComponents.LEECH.provideDefaultValue().base(), 0.0D, 2048.0D).setSyncable(true));
            public static final Holder<Attribute> GUN_RECOIL =
                    R.attribute("gun_recoil", () -> new RangedAttribute("apothic_compats:gun_recoil", ShotComponents.CAMERA_RECOIL_MULTIPLIER.provideDefaultValue().base(), 0.0D, 2048.0D).setSyncable(true));

            public static void bootstrap() {}
        }

        private static void bootstrap() {
            if (ModList.get().isLoaded("irons_artifice")) {
                Artifice.bootstrap();
            }
        }
    }

    public static class Curios {
        public static final Holder<Item> BACK_PLATE = R.item("back_plate", ModCurioItem::new, p -> p.stacksTo(1));
        public static final Holder<Item> FLORID_BELT = R.item("florid_belt", ModCurioItem::new, p -> p.stacksTo(1));
        public static final Holder<Item> BODY_CHAIN = R.item("body_chain", ModCurioItem::new, p -> p.stacksTo(1));
        public static final Holder<Item> FLASHY_BRACELET = R.item("flashy_bracelet", ModCurioItem::new, p -> p.stacksTo(1));
        public static final Holder<Item> FANCY_CHARM = R.item("fancy_charm", ModCurioItem::new, p -> p.stacksTo(1));
        public static final Holder<Item> EMBELLISHED_CURIO = R.item("embellished_curio", ModCurioItem::new, p -> p.stacksTo(1));
        public static final Holder<Item> ADORNED_BOOTS = R.item("adorned_boots", ModCurioItem::new, p -> p.stacksTo(1));
        public static final Holder<Item> SHOWY_GLOVES = R.item("showy_gloves", ModCurioItem::new, p -> p.stacksTo(1));
        public static final Holder<Item> HEAD_COVER = R.item("head_cover", ModCurioItem::new, p -> p.stacksTo(1));
        public static final Holder<Item> ORNAMENTED_NECKLACE = R.item("ornamented_necklace", ModCurioItem::new, p -> p.stacksTo(1));
        public static final Holder<Item> ORNATE_RING = R.item("ornate_ring", ModCurioItem::new, p -> p.stacksTo(1));

        private static void bootstrap() {}
    }

    public static class LootCategories {

        public static class Artifice {
            public static LootCategory GUN = category("gun",
                    s -> s.getItem() instanceof GunItem, ALObjects.EquipmentSlotGroups.MAINHAND);

            public static void bootstrap() {}

            public static boolean isGun(LootCategory cat) {
                return cat == GUN;
            }
        }

        public static class Curios {
            public static final LootCategory BACK = category("back", s -> s.is(ModTags.Curios.BACK), SlotGroups.BACK);
            public static final LootCategory BELT = category("belt", s -> s.is(ModTags.Curios.BELT), SlotGroups.BELT);
            public static final LootCategory BODY = category("body", s -> s.is(ModTags.Curios.BODY), SlotGroups.BODY);
            public static final LootCategory BRACELET = category("bracelet", s -> s.is(ModTags.Curios.BRACELET), SlotGroups.BRACELET);
            public static final LootCategory CHARM = category("charm", s -> s.is(ModTags.Curios.CHARM), SlotGroups.CHARM);
            public static final LootCategory CURIO = category("curio", s -> s.is(ModTags.Curios.CURIO), SlotGroups.CURIO);
            public static final LootCategory FEET = category("feet", s -> s.is(ModTags.Curios.FEET), SlotGroups.FEET);
            public static final LootCategory HANDS = category("hands", s -> s.is(ModTags.Curios.HANDS), SlotGroups.HANDS);
            public static final LootCategory HEAD = category("head", s -> s.is(ModTags.Curios.HEAD), SlotGroups.HEAD);
            public static final LootCategory NECKLACE = category("necklace", s -> s.is(ModTags.Curios.NECKLACE), SlotGroups.NECKLACE);
            public static final LootCategory RING = category("ring", s -> s.is(ModTags.Curios.RING), SlotGroups.RING);

            public static final LootCategory AN_FOCUS = category("an_focus", s -> s.is(ModTags.Curios.AN_FOCUS), SlotGroups.AN_FOCUS);

            public static final LootCategory BROOCH = category("brooch", s -> s.is(ModTags.Curios.BROOCH), SlotGroups.BROOCH);
            public static final LootCategory RUNE = category("rune", s -> s.is(ModTags.Curios.RUNE), SlotGroups.RUNE);

            public static void bootstrap() {}
        }

        private static LootCategory category(String path, Predicate<ItemStack> filter, EntitySlotGroup group) {
            return R.custom(path, Apoth.BuiltInRegs.LOOT_CATEGORY.key(), new LootCategory(filter, group));
        }

        private static void bootstrap() {
            if (ModList.get().isLoaded("curios")) {
                Curios.bootstrap();
            }
            if (ModList.get().isLoaded("irons_artifice")) {
                Artifice.bootstrap();
            }
        }
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

        private static void bootstrap() {}
    }

    public static class SlotGroups {
        public static final EntitySlotGroup BACK = group("back", Slots.BACK);
        public static final EntitySlotGroup BELT = group("belt", Slots.BELT);
        public static final EntitySlotGroup BODY = group("body", Slots.BODY);
        public static final EntitySlotGroup BRACELET = group("bracelet", Slots.BRACELET);
        public static final EntitySlotGroup CHARM = group("charm", Slots.CHARM);
        public static final EntitySlotGroup CURIO = group("curio", Slots.CURIO);
        public static final EntitySlotGroup FEET = group("feet", Slots.FEET);
        public static final EntitySlotGroup HANDS = group("hands", Slots.HANDS);
        public static final EntitySlotGroup HEAD = group("head", Slots.HEAD);
        public static final EntitySlotGroup NECKLACE = group("necklace", Slots.NECKLACE);
        public static final EntitySlotGroup RING = group("ring", Slots.RING);

        public static final EntitySlotGroup AN_FOCUS = group("an_focus", Slots.AN_FOCUS);

        public static final EntitySlotGroup BROOCH = group("brooch", Slots.BROOCH);
        public static final EntitySlotGroup RUNE = group("rune", Slots.RUNE);

        private static EntitySlotGroup group(String path, Holder<EntityEquipmentSlot> slot) {
            return R.custom(path, ALObjects.BuiltInRegs.ENTITY_SLOT_GROUP.key(), new EntitySlotGroup(ApothicCompats.loc(path), HolderSet.direct(slot)));
        }

        private static void bootstrap() {}
    }

    public static void bootstrap(IEventBus bus) {
        bus.register(R);
        Attributes.bootstrap();
        Curios.bootstrap();
        LootCategories.bootstrap();
        Slots.bootstrap();
        SlotGroups.bootstrap();
    }
}
