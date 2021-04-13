package eu.lunekiska.scythd.compat.tooldefs;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import eu.lunekiska.scythd.utils.ScythdReapBlocks;
import mekanism.client.render.item.ISTERProvider;
import mekanism.common.item.gear.ItemAtomicDisassembler;
import mekanism.common.item.interfaces.IItemHUDProvider;
import mekanism.common.item.interfaces.IModeItem;
import mekanism.common.item.interfaces.IRadialModeItem;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class AtomicDisassemblerTool extends ItemAtomicDisassembler implements IItemHUDProvider, IModeItem, IRadialModeItem<ItemAtomicDisassembler.DisassemblerMode>
{

    public AtomicDisassemblerTool(Properties properties, int harvestRadius, boolean circleHarvest) {
        super(properties.rarity(Rarity.RARE).setNoRepair().setISTER(ISTERProvider::disassembler));
        Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -2.4D, Operation.ADDITION));
        this.harvestRadius = harvestRadius;
        this.circleHarvest = circleHarvest;
    }

    protected int harvestRadius;
    protected boolean circleHarvest;

    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(@Nonnull World world, @Nonnull PlayerEntity user, @Nonnull Hand hand)
    {
        return ScythdReapBlocks.harvest(this.harvestRadius, this.circleHarvest, world, user, hand);
    }
}