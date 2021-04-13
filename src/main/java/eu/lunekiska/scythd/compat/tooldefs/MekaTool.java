package eu.lunekiska.scythd.compat.tooldefs;

import com.google.common.collect.ImmutableMultimap;
import eu.lunekiska.scythd.utils.ScythdReapBlocks;
import mekanism.common.content.gear.IModuleContainerItem;
import mekanism.common.content.gear.Modules;
import mekanism.common.item.gear.ItemMekaTool;
import mekanism.common.item.interfaces.IItemHUDProvider;
import mekanism.common.item.interfaces.IModeItem;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class MekaTool extends ItemMekaTool implements IModuleContainerItem, IModeItem, IItemHUDProvider
{

    public MekaTool(Properties properties, int harvestRadius, boolean circleHarvest)
    {
        super(properties.rarity(Rarity.EPIC).setNoRepair());
        Modules.setSupported(this, Modules.ENERGY_UNIT, Modules.ATTACK_AMPLIFICATION_UNIT, Modules.SILK_TOUCH_UNIT, Modules.VEIN_MINING_UNIT,
        Modules.FARMING_UNIT, Modules.TELEPORTATION_UNIT, Modules.EXCAVATION_ESCALATION_UNIT);
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -2.4D, AttributeModifier.Operation.ADDITION));
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
