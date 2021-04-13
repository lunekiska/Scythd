package eu.lunekiska.scythd.compat.tooldefs;

import eu.lunekiska.scythd.compat.utils.BotaniaReapBlocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class BotaniaManasteelScytheTool extends BotaniaReapBlocks
{

    protected int harvestRadius;
    protected boolean circleHarvest;
    private int mineLevel = -1;

    public BotaniaManasteelScytheTool(IItemTier mat, int attackDamage, float attackSpeed, Properties properties)
    {
        this(mat, attackDamage, attackSpeed, getRadius(mat), shouldBeCircle(mat), properties);
        this.mineLevel = mat.getHarvestLevel();
    }

    public BotaniaManasteelScytheTool(IItemTier mat, int attackDamage, float attackSpeed, int harvestRadius, boolean circleHarvest, Properties properties)
    {
        super(mat, attackDamage, properties, attackSpeed);
        this.harvestRadius = harvestRadius;
        this.circleHarvest = circleHarvest;
    }

    private static int getRadius(IItemTier material)
    {
        return (int) (Math.floor(material.getHarvestLevel()/2.0) + 1);
    }

    private static boolean shouldBeCircle(IItemTier material)
    {
        return material.getHarvestLevel() % 2 == 0;
    }

    public @Nonnull
    ActionResult<ItemStack> onItemRightClick(@Nonnull World world, @Nonnull PlayerEntity user, @Nonnull Hand hand)
    {
        return BotaniaReapBlocks.harvest(this.harvestRadius, this.circleHarvest, world, user, hand);
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