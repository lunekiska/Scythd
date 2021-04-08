package eu.lunekiska.scythd;

import eu.lunekiska.scythd.utils.RoundUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class NonTieredScytheTool extends HoeItem
{
    protected int harvestRadius;
    protected boolean circleHarvest;
    private int mineLevel = -1;

    public NonTieredScytheTool(ScythdItemTiers material, int attackDamage, float attackSpeed, Properties properties)
    {
        this(material, attackDamage, attackSpeed, getRadius(material), shouldBeCircle(material), properties);
        this.mineLevel = material.getHarvestLevel();
    }

    public NonTieredScytheTool(ScythdItemTiers material, int attackDamage, float attackSpeed, int harvestRadius, boolean circleHarvest, Properties properties)
    {
        super(material, attackDamage, attackSpeed, properties);
        this.harvestRadius = harvestRadius;
        this.circleHarvest = circleHarvest;
    }

    private static int getRadius(ScythdItemTiers material)
    {
        return (int) (Math.floor(material.getHarvestLevel()/2.0) + 1);
    }

    private static boolean shouldBeCircle(ScythdItemTiers material)
    {
        return material.getHarvestLevel() % 2 == 0;
    }

    public @Nonnull ActionResult<ItemStack> onItemRightClick(@Nonnull World world, @Nonnull PlayerEntity user, @Nonnull Hand hand)
    {
        return harvest(this.harvestRadius, this.circleHarvest, world, user, hand);
    }

    public static ActionResult<ItemStack> harvest(int harvestRadius, boolean circleHarvest, World world, PlayerEntity user, Hand hand)
    {
        Vector3d pos = user.getPositionVec();
        BlockPos blockPos = new BlockPos(RoundUtil.roundThat(pos.x), RoundUtil.roundThat(pos.y), RoundUtil.roundThat(pos.z));
        Item item = user.getHeldItemMainhand().getItem();
        for (int x = -harvestRadius; x <= harvestRadius; ++x)
        {
            for (int y = -1; y <= 1; ++y)
            {
                for (int z = -harvestRadius; z <= harvestRadius; ++z)
                {
                    BlockPos newBlockPos = new BlockPos(blockPos.getX() + x, blockPos.getY() + y, blockPos.getZ() + z);
                    if (circleHarvest &&
                            ((y == -1 && newBlockPos.manhattanDistance(blockPos.up()) > harvestRadius) ||
                                    (y == 0 && newBlockPos.manhattanDistance(blockPos) > harvestRadius) ||
                                    (y == 1 && newBlockPos.manhattanDistance(blockPos.down()) > harvestRadius)))
                    {
                        continue;
                    }
                    BlockState blockState = world.getBlockState(newBlockPos);
                    Block block = blockState.getBlock();
                    int damageTool = 0;
                    if (block instanceof CropsBlock && ((CropsBlock) block).isMaxAge(blockState))
                    {
                        CropsBlock cropsBlock = (CropsBlock) block;
                        Block.spawnDrops(blockState, world, newBlockPos);
                        world.setBlockState(newBlockPos, cropsBlock.withAge(0));
                        damageTool = 2;
                    }
                    else if (block.equals(Blocks.GRASS) || block.equals(Blocks.TALL_GRASS) || block.equals(Blocks.FERN) || block.equals(Blocks.LARGE_FERN))
                    {
                        world.destroyBlock(newBlockPos, true, user);
                        damageTool = 1;
                    }
                    if (damageTool > 0)
                    {
                        user.getHeldItemMainhand().damageItem(damageTool, (LivingEntity) user, ((e) -> e.sendBreakAnimation(EquipmentSlotType.MAINHAND)));
                        if (user.getHeldItemMainhand().getItem() != item)
                        {
                            return ActionResult.resultSuccess(user.getHeldItemMainhand());
                        }
                    }
                }
            }
        }
        return ActionResult.resultPass(user.getHeldItemMainhand());
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
