package com.disk.diskssimplemagic.items;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

public class EnderStaff extends Item {
    public EnderStaff(Properties properties) {
        super(properties);
    }
    
    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        BlockHitResult ray = rayTrace(world, player, ClipContext.Fluid.NONE);
        BlockPos lookPos = ray.getBlockPos().relative(ray.getDirection());
        player.setPos(lookPos.getX(), lookPos.getY(), lookPos.getZ());
        player.getCooldowns().addCooldown(this, 60); 
        player.fallDistance = 0F; //resets fall distance on use
        world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS, 1.0F, 1.0F); //play enderman tele sound

        return super.use(world, player, hand);
    }
    protected static BlockHitResult rayTrace(Level world, Player player, ClipContext.Fluid fluidMode) {
        double range = 32;

        float f = player.getXRot();
        float f1 = player.getYRot();
        Vec3 vec3 = player.getEyePosition(1.0F);
        float f2 = Mth.cos(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f3 = Mth.sin(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f4 = -Mth.cos(-f * ((float)Math.PI / 180F));
        float f5 = Mth.sin(-f * ((float)Math.PI / 180F));
        float f6 = f3 * f4;
        float f7 = f2 * f4;
        
        Vec3 vec32 = vec3.add((double)f6 * range, (double)f5 * range, (double)f7 * range);
        return world.clip(new ClipContext(vec3, vec32, ClipContext.Block.OUTLINE, fluidMode, player));
    }
}
