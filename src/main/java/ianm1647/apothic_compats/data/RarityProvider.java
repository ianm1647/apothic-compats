package ianm1647.apothic_compats.data;

import com.ianm1647.ancientreforging.AncientReforging;
import com.ianm1647.ancientreforging.AncientReforgingRegistry;
import dev.shadowsoffire.apotheosis.Apoth;
import dev.shadowsoffire.apotheosis.Apoth.Components;
import dev.shadowsoffire.apotheosis.Apoth.Items;
import dev.shadowsoffire.apotheosis.Apotheosis;
import dev.shadowsoffire.apotheosis.affix.AffixType;
import dev.shadowsoffire.apotheosis.loot.LootCategory;
import dev.shadowsoffire.apotheosis.loot.LootRarity;
import dev.shadowsoffire.apotheosis.loot.LootRule;
import dev.shadowsoffire.apotheosis.loot.LootRule.*;
import dev.shadowsoffire.apotheosis.loot.RarityRegistry;
import dev.shadowsoffire.apotheosis.tiers.TieredWeights;
import dev.shadowsoffire.apotheosis.tiers.WorldTier;
import dev.shadowsoffire.placebo.color.GradientColor;
import dev.shadowsoffire.placebo.util.data.DynamicRegistryProvider;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.Unbreakable;
import org.spongepowered.include.com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

public class RarityProvider extends DynamicRegistryProvider<LootRarity> {

    public RarityProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, RarityRegistry.INSTANCE);
    }

    @Override
    public String getName() {
        return "Rarities";
    }

    @Override
    public void generate() {
        // Common, high rarity early, dropping to 0% later
        // One stat, with a low chance for a second.
        this.addRarity("common", TextColor.fromRgb(0x808080), Items.COMMON_MATERIAL, b -> b
            .sortIndex(300)
            .weights(TieredWeights.builder()
                .with(WorldTier.HAVEN, 600, 0)
                .with(WorldTier.FRONTIER, 290, 0)
                .with(WorldTier.ASCENT, 100, 0)
                .with(WorldTier.SUMMIT, 0, 0)
                .with(WorldTier.PINNACLE, 0, 0))
            .rule(new AffixLootRule(AffixType.STAT))
            .rule(new ChancedLootRule(0.25F, new AffixLootRule(AffixType.STAT))));

        // Uncommon, reasonable rarity until the final tier.
        // Two stats, with a chance for a basic effect. Opportunity for a socket.
        this.addRarity("uncommon", TextColor.fromRgb(0x33FF33), Items.UNCOMMON_MATERIAL, b -> b
            .sortIndex(400)
            .weights(TieredWeights.builder()
                .with(WorldTier.HAVEN, 360, 2.5F)
                .with(WorldTier.FRONTIER, 600, 0)
                .with(WorldTier.ASCENT, 300, 0)
                .with(WorldTier.SUMMIT, 120, 0)
                .with(WorldTier.PINNACLE, 0, 0))
            .rule(new AffixLootRule(AffixType.STAT))
            .rule(new AffixLootRule(AffixType.STAT))
            .rule(new ChancedLootRule(0.5F, new AffixLootRule(AffixType.BASIC_EFFECT)))
            .rule(new SocketLootRule(0, 1)));

        // Rare - always available, but starts out with very low frequency.
        // Two stats, one basic effect, with a chance for another.
        // Chance for two sockets, and can receive durability bonuses.
        this.addRarity("rare", TextColor.fromRgb(0x5555FF), Items.RARE_MATERIAL, b -> b
            .sortIndex(500)
            .weights(TieredWeights.builder()
                .with(WorldTier.HAVEN, 40, 5)
                .with(WorldTier.FRONTIER, 100, 5)
                .with(WorldTier.ASCENT, 500, 2.5F)
                .with(WorldTier.SUMMIT, 290, 2.5F)
                .with(WorldTier.PINNACLE, 100, 0))
            .rule(new AffixLootRule(AffixType.STAT))
            .rule(new AffixLootRule(AffixType.STAT))
            .rule(new AffixLootRule(AffixType.BASIC_EFFECT))
            .rule(new ChancedLootRule(0.35F, new AffixLootRule(AffixType.BASIC_EFFECT)))
            .rule(new SocketLootRule(0, 2))
            .rule(new DurabilityLootRule(0.1F, 0.25F)));

        // Epic, not available in Haven, and exceptionally low chance on Frontier+Ascent.
        // Starts to really appear in Summit, and is the most common rarity in Apotheosis.
        // Three stats, a basic effect, an ability, and a chance for a second basic effect.
        // Guaranteed to receive a socket, and receives a good durability bonus.
        this.addRarity("epic", TextColor.fromRgb(0xBB00BB), Items.EPIC_MATERIAL, b -> b
            .sortIndex(600)
            .weights(TieredWeights.builder()
                .with(WorldTier.HAVEN, 0, 0)
                .with(WorldTier.FRONTIER, 10, 0)
                .with(WorldTier.ASCENT, 100, 5)
                .with(WorldTier.SUMMIT, 540, 5)
                .with(WorldTier.PINNACLE, 650, 2.5F))
            .rule(new AffixLootRule(AffixType.STAT))
            .rule(new AffixLootRule(AffixType.STAT))
            .rule(new AffixLootRule(AffixType.STAT))
            .rule(new AffixLootRule(AffixType.BASIC_EFFECT))
            .rule(new ChancedLootRule(0.25F, new AffixLootRule(AffixType.BASIC_EFFECT)))
            .rule(new AffixLootRule(AffixType.ABILITY))
            .rule(new SocketLootRule(1, 3))
            .rule(new DurabilityLootRule(0.25F, 0.55F)));

        // Mythic, the pinnacle rarity. Does not appear until summit, and has very low rarity until Apotheosis.
        // Four stats, two basic effects, one ability, guaranteed sockets and high durability bonuses.
        // Has a very low chance to receive 4 sockets, and be Unbreakable.
        this.addRarity("mythic", TextColor.fromRgb(0xED7014), Items.MYTHIC_MATERIAL, b -> b
            .sortIndex(700)
            .weights(TieredWeights.builder()
                .with(WorldTier.HAVEN, 0, 0)
                .with(WorldTier.FRONTIER, 0, 0)
                .with(WorldTier.ASCENT, 0, 0)
                .with(WorldTier.SUMMIT, 50, 5)
                .with(WorldTier.PINNACLE, 250, 10))
            .rule(new AffixLootRule(AffixType.STAT))
            .rule(new AffixLootRule(AffixType.STAT))
            .rule(new AffixLootRule(AffixType.STAT))
            .rule(new AffixLootRule(AffixType.STAT))
            .rule(new AffixLootRule(AffixType.BASIC_EFFECT))
            .rule(new AffixLootRule(AffixType.BASIC_EFFECT))
            .rule(new AffixLootRule(AffixType.ABILITY))
            .rule(new SelectLootRule(0.95F, // 95% chance for 1-3 sockets, 5% chance for guaranteed 4 sockets.
                new SocketLootRule(1, 3),
                new SocketLootRule(4, 4)))
            .rule(new SelectLootRule(0.99F, // 99% chance to roll a durability bonus, 1% to be unbreakable.
                new DurabilityLootRule(0.45F, 0.75F),
                new ComponentLootRule(DataComponentPatch.builder()
                    .set(DataComponents.UNBREAKABLE, new Unbreakable(true))
                    .remove(Components.DURABILITY_BONUS)
                    .build()))));

        this.addAncient("ancient", GradientColor.RAINBOW, AncientReforgingRegistry.Items.ANCIENT_MATERIAL, b -> b
                .sortIndex(800)
                .weights(TieredWeights.builder()
                        .with(WorldTier.HAVEN, 0, 0)
                        .with(WorldTier.FRONTIER, 0, 0)
                        .with(WorldTier.ASCENT, 0, 0)
                        .with(WorldTier.SUMMIT, 0, 0)
                        .with(WorldTier.PINNACLE, 10, 2))
                .rule(new LootRule.AffixLootRule(AffixType.STAT))
                .rule(new LootRule.AffixLootRule(AffixType.STAT))
                .rule(new LootRule.AffixLootRule(AffixType.STAT))
                .rule(new LootRule.AffixLootRule(AffixType.STAT))
                .rule(new LootRule.AffixLootRule(AffixType.STAT))
                .rule(new LootRule.AffixLootRule(AffixType.BASIC_EFFECT))
                .rule(new LootRule.AffixLootRule(AffixType.BASIC_EFFECT))
                .rule(new LootRule.AffixLootRule(AffixType.BASIC_EFFECT))
                .rule(new LootRule.AffixLootRule(AffixType.ABILITY))
                .rule(new LootRule.AffixLootRule(AffixType.ABILITY))
                .rule(new LootRule.SelectLootRule(0.85F, // 95% chance for 3-4 sockets, 5% chance for guaranteed 5 sockets.
                        new LootRule.SocketLootRule(3, 4),
                        new LootRule.SocketLootRule(5, 5)))
                .rule(new LootRule.SelectLootRule(0.95F, // 99% chance to roll a durability bonus, 1% to be unbreakable.
                        new LootRule.DurabilityLootRule(0.6F, 0.9F),
                        new LootRule.ComponentLootRule(DataComponentPatch.builder()
                                .set(DataComponents.UNBREAKABLE, new Unbreakable(true))
                                .set(Apoth.Components.DURABILITY_BONUS, 0F)
                                .build()))));
    }

    static <T> LootRule componentRule(DataComponentType<T> type, T value) {
        return new ComponentLootRule(DataComponentPatch.builder().set(type, value).build());
    }

    void addRarity(String id, TextColor color, Holder<Item> material, UnaryOperator<RarityBuilder> config) {
        this.add(Apotheosis.loc(id), config.apply(builder(color, material)).build());
    }

    void addAncient(String id, TextColor color, Holder<Item> material, UnaryOperator<RarityBuilder> config) {
        this.add(AncientReforging.loc(id), config.apply(builder(color, material)).build());
    }

    public static RarityBuilder builder(TextColor color, Holder<Item> material) {
        return new RarityBuilder(color, material);
    }

    public static class RarityBuilder {

        private final TextColor color;
        private final Holder<Item> material;
        private TieredWeights weights;
        private final List<LootRule> rules = new ArrayList<>();
        private final Map<LootCategory, List<LootRule>> overrides = new IdentityHashMap<>();
        private int index = 1000;

        public RarityBuilder(TextColor color, Holder<Item> material) {
            this.color = color;
            this.material = material;
        }

        public RarityBuilder weights(TieredWeights.Builder builder) {
            this.weights = builder.build();
            return this;
        }

        public RarityBuilder rule(LootRule rule) {
            this.rules.add(rule);
            return this;
        }

        public RarityBuilder override(LootCategory category, UnaryOperator<RuleListBuilder> config) {
            List<LootRule> list = new ArrayList<>();
            config.apply(new RuleListBuilder(){

                @Override
                public RuleListBuilder rule(LootRule rule) {
                    list.add(rule);
                    return this;
                }

            });
            this.overrides.put(category, list);
            return this;
        }

        public RarityBuilder sortIndex(int index) {
            this.index = index;
            return this;
        }

        public LootRarity build() {
            Preconditions.checkNotNull(this.weights);
            Preconditions.checkArgument(this.rules.size() > 0);
            return new LootRarity(this.color, this.material, this.weights, this.rules, this.overrides, this.index);
        }

    }

    public static interface RuleListBuilder {
        RuleListBuilder rule(LootRule rule);
    }

}
