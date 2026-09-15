package ianm1647.apothic_compats.affix.irons_artifice;

import io.redspace.irons_artifice.entity.Bullet;
import io.redspace.irons_artifice.modifier.PostHitEffect;
import io.redspace.irons_artifice.utils.Utils;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.HitResult;

public class EffectPostHit implements PostHitEffect {
    private int durationTicks;
    private int amplifier;
    public Holder<MobEffect> effect;

    public EffectPostHit(int durationTicks, int amplifier, Holder<MobEffect> effect) {
        this.durationTicks = durationTicks;
        this.amplifier = amplifier;
        this.effect = effect;
    }

    public void addDuration(int ticks) {
        this.durationTicks += ticks;
    }

    public void addAmplifier(int amount) {
        this.amplifier += amount;
    }

    public int getDurationTicks() {
        return this.durationTicks;
    }

    public int getAmplifier() {
        return this.amplifier;
    }

    public Holder<MobEffect> getEffect() {
        return this.effect;
    }

    public void postHit(ServerLevel level, Bullet bullet, HitResult hitResult, Entity entity) {
        if (entity instanceof LivingEntity living) {
            if (Utils.canHarm(bullet.getOwner(), entity)) {
                MobEffectInstance existing = living.getEffect(this.effect);
                int duration = this.durationTicks + (existing != null ? existing.getDuration() : 0);
                int amp = existing != null ? Math.max(existing.getAmplifier(), this.amplifier) : this.amplifier;
                living.addEffect(new MobEffectInstance(this.effect, Math.min(duration, 600), Math.max(0, amp)), bullet.getOwner());
            }
        }

    }
}
