package eu.lunekiska.scythd.compat.tooldefs;

import eu.lunekiska.scythd.compat.tiers.CreateItemTiers;
import eu.lunekiska.scythd.utils.ScythdReapBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class CreateScytheTool extends HoeItem
{
    protected int harvestRadius;
    protected boolean circleHarvest;
    private int mineLevel = -1;

    public CreateScytheTool(CreateItemTiers material, int attackDamage, float attackSpeed, Properties properties)
    {
        this(material, attackDamage, attackSpeed, getRadius(material), shouldBeCircle(material), properties);
        this.mineLevel = material.getHarvestLevel();
    }

    public CreateScytheTool(CreateItemTiers material, int attackDamage, float attackSpeed, int harvestRadius, boolean circleHarvest, Properties properties)
    {
        super(material, attackDamage, attackSpeed, properties);
        this.harvestRadius = harvestRadius;
        this.circleHarvest = circleHarvest;
    }

    private static int getRadius(CreateItemTiers material)
    {
        return (int) (Math.floor(material.getHarvestLevel()/2.0) + 1);
    }

    private static boolean shouldBeCircle(CreateItemTiers material)
    {
        return material.getHarvestLevel() % 2 == 0;
    }

    public @Nonnull ActionResult<ItemStack> onItemRightClick(@Nonnull World world, @Nonnull PlayerEntity user, @Nonnull Hand hand)
    {
        return ScythdReapBlocks.harvest(this.harvestRadius, this.circleHarvest, world, user, hand);
    }

    @Nonnull
    @Override
    public ActionResultType onItemUse(@Nonnull ItemUseContext context)
    {
        ActionResultType result = super.onItemUse(context);
        if (result.isSuccessOrConsume())
        {
            World world = context.getWorld();
            BlockPos pos = context.getPos();
            BlockState state = world.getBlockState(pos);
            if (state.hasProperty(FarmlandBlock.MOISTURE))
            {
                world.setBlockState(pos, state.with(FarmlandBlock.MOISTURE, 0));
            }
        }
        return result;
    }

    public int getHarvestRadius()
    {
        return this.harvestRadius;
    }

    public boolean hasCircleHarvest()
    {
        return this.circleHarvest;
    }

}
