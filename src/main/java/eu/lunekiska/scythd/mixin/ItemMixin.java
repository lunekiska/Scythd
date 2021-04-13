package eu.lunekiska.scythd.mixin;

import eu.lunekiska.scythd.utils.ScythdReapBlocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public abstract class ItemMixin
{
    @Inject(method = "onItemRightClick", at = @At("HEAD"), cancellable = true)
    void onItemRightClick(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<ActionResult<ItemStack>> cir)
    {
        CompoundNBT nbt = user.getHeldItemMainhand().getChildTag("ScythdProperties");
        if (nbt != null)
        {
            int radius = nbt.getInt("HarvestRadius");
            boolean circle = nbt.getBoolean("CircleHarvest");
            cir.setReturnValue(ScythdReapBlocks.harvest(radius, circle, world, user, hand));
            cir.cancel();
        }
    }

}
