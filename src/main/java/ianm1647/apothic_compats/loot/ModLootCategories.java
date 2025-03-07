package ianm1647.apothic_compats.loot;

import com.aetherteam.aether.item.combat.DartShooterItem;
import com.sammy.malum.common.item.curiosities.weapons.scythe.MalumScytheItem;
import com.sammy.malum.common.item.curiosities.weapons.staff.AbstractStaffItem;
import dev.shadowsoffire.apotheosis.Apoth;
import dev.shadowsoffire.apotheosis.loot.LootCategory;
import dev.shadowsoffire.placebo.registry.DeferredHelper;
import ianm1647.apothic_compats.ApothicCompats;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;

import java.util.function.Predicate;

public class ModLootCategories {
    public static final DeferredHelper R = DeferredHelper.create(ApothicCompats.MODID);

    public static LootCategory DART_SHOOTER;
    public static LootCategory SCYTHE;
    public static LootCategory STAFF;

    public static void registerLootCategories(IEventBus bus) {
        bus.register(R);
        if (ModList.get().isLoaded("aether")) {
            DART_SHOOTER = register("dart_shooter",
                    s -> s.getItem() instanceof DartShooterItem, EquipmentSlotGroup.MAINHAND);
        }
        if (ModList.get().isLoaded("malum")) {
            SCYTHE = register("scythe",
                    s -> s.getItem() instanceof MalumScytheItem, EquipmentSlotGroup.MAINHAND);
            STAFF = register("staff",
                    s -> s.getItem() instanceof AbstractStaffItem, EquipmentSlotGroup.MAINHAND);
        }
    }

    public static boolean isDartShooter(LootCategory cat) {
        return cat == DART_SHOOTER;
    }

    public static boolean isScythe(LootCategory cat) {
        return cat == SCYTHE;
    }

    public static boolean isStaff(LootCategory cat) {
        return cat == STAFF;
    }

    private static LootCategory register(String path, Predicate<ItemStack> filter, EquipmentSlotGroup slots, int priority) {
        return R.custom(path, Apoth.BuiltInRegs.LOOT_CATEGORY.key(), new LootCategory(filter, slots, priority));
    }

    private static LootCategory register(String path, Predicate<ItemStack> filter, EquipmentSlotGroup slots) {
        return register(path, filter, slots, 1000);
    }

}
