package eu.lunekiska.scythd.compat.tooldefs;

import eu.lunekiska.scythd.utils.RoundUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import vazkii.botania.api.item.ISortableTool;
import vazkii.botania.api.mana.IManaUsingItem;
import vazkii.botania.api.mana.ManaItemHandler;
import vazkii.botania.common.item.equipment.tool.ToolCommons;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

public class BotaniaManasteelScytheTool extends HoeItem implements IManaUsingItem, ISortableTool
{
    private static final int MANA_PER_DAMAGE = 60;

    protected int harvestRadius;
    protected boolean circleHarvest;
    private int mineLevel = -1;

    public BotaniaManasteelScytheTool(IItemTier material, int attackDamage, float attackSpeed, Properties properties)
    {
        this(material, attackDamage, attackSpeed, getRadius(material), shouldBeCircle(material), properties);
        this.mineLevel = material.getHarvestLevel();
    }

    public BotaniaManasteelScytheTool(IItemTier material, int attackDamage, float attackSpeed, int harvestRadius, boolean circleHarvest, Properties properties)
    {
        super(material, attackDamage, attackSpeed, properties);
        this.harvestRadius = harvestRadius;
        this.circleHarvest = circleHarvest;
    }

    public <T extends LivingEntity> int damageItem(ItemStack stack, int amount, T entity, Consumer<T> onBroken)
    {
        return ToolCommons.damageItemIfPossible(stack, amount, entity, getManaPerDamage());
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

    public int getManaPerDamage()
    {
        return MANA_PER_DAMAGE;
    }

    @Override
    public void inventoryTick(@Nonnull ItemStack stack, World world, @Nonnull Entity player, int slot, boolean selected) {
        if (!world.isRemote && player instanceof PlayerEntity && stack.getDamage() > 0 && ManaItemHandler.instance().requestManaExactForTool(stack, (PlayerEntity) player, getManaPerDamage() * 2, true)) {
            stack.setDamage(stack.getDamage() - 1);
        }
    }

    public int getHarvestRadius()
    {
        return this.harvestRadius;
    }

    public boolean hasCircleHarvest()
    {
        return this.circleHarvest;
    }

    @Override
    public boolean usesMana(ItemStack stack) {
        return true;
    }
}