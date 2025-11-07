package ianm1647.apothic_compats.loot;

import com.aetherteam.aether.item.combat.DartShooterItem;
import com.hollingsworth.arsnouveau.api.item.ArsNouveauCurio;
import com.sammy.malum.common.item.curiosities.weapons.scythe.MalumScytheItem;
import com.sammy.malum.common.item.curiosities.weapons.staff.AbstractStaffItem;
import com.simibubi.create.content.equipment.potatoCannon.PotatoCannonItem;
import dev.shadowsoffire.apotheosis.Apoth;
import dev.shadowsoffire.apotheosis.loot.LootCategory;
import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import dev.shadowsoffire.apothic_attributes.modifiers.EntitySlotGroup;
import dev.shadowsoffire.placebo.registry.DeferredHelper;
import ianm1647.apothic_compats.ApothicCompats;
import ianm1647.apothic_compats.util.ModSlotGroups;
import ianm1647.apothic_compats.util.ModTags;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import top.theillusivec4.curios.api.CuriosTags;

import java.util.function.Predicate;

public class ModLootCategories {
    public static final DeferredHelper R = DeferredHelper.create(ApothicCompats.MODID);

    public static LootCategory DART_SHOOTER;

    public static LootCategory POTATO_CANNON;

    public static LootCategory SCYTHE;
    public static LootCategory STAFF;

    public static LootCategory BACK;
    public static LootCategory BELT;
    public static LootCategory BODY;
    public static LootCategory BRACELET;
    public static LootCategory CHARM;
    public static LootCategory CURIO;
    public static LootCategory FEET;
    public static LootCategory HANDS;
    public static LootCategory HEAD;
    public static LootCategory NECKLACE;
    public static LootCategory RING;

    public static LootCategory AN_FOCUS;

    public static LootCategory BROOCH;
    public static LootCategory RUNE;

    public static void registerLootCategories(IEventBus bus) {
        bus.register(R);
        if (ModList.get().isLoaded("aether")) {
            DART_SHOOTER = register("dart_shooter",
                    s -> s.getItem() instanceof DartShooterItem, ALObjects.EquipmentSlotGroups.MAINHAND);
        }

        if (ModList.get().isLoaded("ars_nouveau")) {
            AN_FOCUS = register("an_focus",
                    s -> s.is(ModTags.Curios.AN_FOCUS), ModSlotGroups.Groups.AN_FOCUS);
        }

        if (ModList.get().isLoaded("create")) {
            POTATO_CANNON = register("potato_cannon",
                    s -> s.getItem() instanceof PotatoCannonItem, ALObjects.EquipmentSlotGroups.MAINHAND);
        }

        if (ModList.get().isLoaded("malum")) {
            SCYTHE = register("scythe",
                    s -> s.getItem() instanceof MalumScytheItem, ALObjects.EquipmentSlotGroups.MAINHAND);
            STAFF = register("staff",
                    s -> s.getItem() instanceof AbstractStaffItem, ALObjects.EquipmentSlotGroups.MAINHAND);
            BROOCH = register("brooch", s -> s.is(ModTags.Curios.BROOCH), ModSlotGroups.Groups.BROOCH);
            RUNE = register("rune", s -> s.is(ModTags.Curios.RUNE), ModSlotGroups.Groups.RUNE);
        }

        if (ModList.get().isLoaded("curios")) {
            BACK = register("back", s -> s.is(CuriosTags.BACK), ModSlotGroups.Groups.BACK);
            BELT = register("belt", s -> s.is(CuriosTags.BELT), ModSlotGroups.Groups.BELT);
            BODY = register("body", s -> s.is(CuriosTags.BODY), ModSlotGroups.Groups.BODY);
            BRACELET = register("bracelet", s -> s.is(CuriosTags.BRACELET), ModSlotGroups.Groups.BRACELET);
            CHARM = register("charm", s -> s.is(CuriosTags.CHARM), ModSlotGroups.Groups.CHARM);
            CURIO = register("curio", s -> s.is(CuriosTags.CURIO), ModSlotGroups.Groups.CURIO);
            FEET = register("feet", s -> s.is(ModTags.Curios.FEET), ModSlotGroups.Groups.FEET);
            HANDS = register("hands", s -> s.is(CuriosTags.HANDS), ModSlotGroups.Groups.HANDS);
            HEAD = register("head", s -> s.is(CuriosTags.HEAD), ModSlotGroups.Groups.HEAD);
            NECKLACE = register("necklace", s -> s.is(CuriosTags.NECKLACE), ModSlotGroups.Groups.NECKLACE);
            RING = register("ring", s -> s.is(CuriosTags.RING), ModSlotGroups.Groups.RING);
        }
    }

    public static boolean isDartShooter(LootCategory cat) {
        return cat == DART_SHOOTER;
    }

    public static boolean isPotatoCannon(LootCategory cat) {
        return cat == POTATO_CANNON;
    }

    public static boolean isScythe(LootCategory cat) {
        return cat == SCYTHE;
    }

    public static boolean isStaff(LootCategory cat) {
        return cat == STAFF;
    }

    private static LootCategory register(String path, Predicate<ItemStack> filter, EntitySlotGroup slots, int priority) {
        return R.custom(path, Apoth.BuiltInRegs.LOOT_CATEGORY.key(), new LootCategory(filter, slots, priority));
    }

    private static LootCategory register(String path, Predicate<ItemStack> filter, EntitySlotGroup slots) {
        return register(path, filter, slots, 1000);
    }

}
