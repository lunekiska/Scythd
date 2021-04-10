package eu.lunekiska.scythd.compat.tooldefs;

import corgiaoc.byg.core.BYGBlocks;
import eu.lunekiska.scythd.EnchantsRegistry;
import eu.lunekiska.scythd.compat.tiers.ScythdTheAbyssItemTiers;
import eu.lunekiska.scythd.utils.MiscUtils;
import eu.lunekiska.scythd.utils.RoundUtil;
import mod.beethoven92.betterendforge.common.init.ModBlocks;
import net.abyss.addon.thebeginning.block.RamusGrass2Block;
import net.abyss.addon.thebeginning.block.RamusGrass3Block;
import net.abyss.addon.thebeginning.block.RamusGrassBlock;
import net.abyss.addon.thebeginning.block.RomasGrassBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.yezon.theabyss.block.*;
import quek.undergarden.registry.UGBlocks;

import javax.annotation.Nonnull;

public class TheAbyssScytheTool extends HoeItem
{
    protected int harvestRadius;
    protected boolean circleHarvest;
    private int mineLevel = -1;

    public TheAbyssScytheTool(ScythdTheAbyssItemTiers material, int attackDamage, float attackSpeed, Properties properties)
    {
        this(material, attackDamage, attackSpeed, getRadius(material), shouldBeCircle(material), properties);
        this.mineLevel = material.getHarvestLevel();
    }

    public TheAbyssScytheTool(ScythdTheAbyssItemTiers material, int attackDamage, float attackSpeed, int harvestRadius, boolean circleHarvest, Properties properties)
    {
        super(material, attackDamage, attackSpeed, properties);
        this.harvestRadius = harvestRadius;
        this.circleHarvest = circleHarvest;
    }

    private static int getRadius(ScythdTheAbyssItemTiers material)
    {
        return (int) (Math.floor(material.getHarvestLevel()/2.0) + 1);
    }

    private static boolean shouldBeCircle(ScythdTheAbyssItemTiers material)
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

        int lvl = EnchantmentHelper.getEnchantmentLevel(EnchantsRegistry.CROP_REAPER.get(), user.getHeldItemMainhand());
        int radius = (int) (Math.floor(lvl/2.0) + harvestRadius);
        circleHarvest = (harvestRadius + lvl) % 2 == 0;

        for (int x = -radius; x <= radius; ++x)
        {
            for (int y = -1; y <= 1; ++y)
            {
                for (int z = -radius; z <= radius; ++z) {
                    BlockPos newBlockPos = new BlockPos(blockPos.getX() + x, blockPos.getY() + y, blockPos.getZ() + z);
                    if (circleHarvest &&
                            ((y == -1 && newBlockPos.manhattanDistance(blockPos.up()) > radius) ||
                                    (y == 0 && newBlockPos.manhattanDistance(blockPos) > radius) ||
                                    (y == 1 && newBlockPos.manhattanDistance(blockPos.down()) > radius))) {
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
                    else if (
                        //Vanilla
                            block.equals(Blocks.GRASS) ||
                                    block.equals(Blocks.TALL_GRASS) ||
                                    block.equals(Blocks.FERN) ||
                                    block.equals(Blocks.LARGE_FERN) ||

                                    block.equals(Blocks.CRIMSON_ROOTS) ||
                                    block.equals(Blocks.WARPED_ROOTS) ||
                                    block.equals(Blocks.NETHER_SPROUTS) ||

                                    //BYG
                                    block.equals(BYGBlocks.WAILING_GRASS) ||
                                    block.equals(BYGBlocks.ETHER_GRASS) ||
                                    block.equals(BYGBlocks.PRAIRIE_GRASS) ||
                                    block.equals(BYGBlocks.SHORT_GRASS) ||
                                    block.equals(BYGBlocks.WINTER_GRASS) ||
                                    block.equals(BYGBlocks.WEED_GRASS) ||
                                    block.equals(BYGBlocks.SHORT_BEACH_GRASS) ||
                                    block.equals(BYGBlocks.BEACH_GRASS) ||

                                    block.equals(BYGBlocks.TALL_ETHER_GRASS) ||
                                    block.equals(BYGBlocks.TALL_PRAIRIE_GRASS) ||

                                    block.equals(BYGBlocks.TALL_CRIMSON_ROOTS) ||
                                    block.equals(BYGBlocks.SYTHIAN_ROOTS) ||
                                    block.equals(BYGBlocks.EMBUR_ROOTS) ||
                                    block.equals(BYGBlocks.TALL_EMBUR_ROOTS) ||
                                    block.equals(BYGBlocks.IVIS_ROOTS) ||
                                    block.equals(BYGBlocks.NIGHTSHADE_ROOTS) ||
                                    block.equals(BYGBlocks.LAMENT_SPROUTS) ||
                                    block.equals(BYGBlocks.SYTHIAN_SPROUT) ||
                                    block.equals(BYGBlocks.EMBUR_SPROUTS) ||
                                    block.equals(BYGBlocks.IVIS_SPROUT) ||
                                    block.equals(BYGBlocks.BULBIS_SPROUTS) ||
                                    block.equals(BYGBlocks.NIGHTSHADE_SPROUTS) ||

                                    //BetterEnd
                                    block.equals(ModBlocks.CHORUS_GRASS.get()) ||
                                    block.equals(ModBlocks.CAVE_GRASS.get()) ||
                                    block.equals(ModBlocks.CRYSTAL_GRASS.get()) ||
                                    block.equals(ModBlocks.AMBER_GRASS.get()) ||
                                    block.equals(ModBlocks.BUSHY_GRASS.get()) ||
                                    block.equals(ModBlocks.JUNGLE_GRASS.get()) ||

                                    block.equals(ModBlocks.VAIOLUSH_FERN.get()) ||
                                    block.equals(ModBlocks.JUNGLE_FERN.get()) ||

                                    //The Abyss
                                    block.equals(TheAbyssPlainGrassBlock.block) ||
                                    block.equals(DeadGrassGlowBlock.block) ||
                                    block.equals(DeadGrassSmallBlock.block) ||
                                    block.equals(BigGrassBlock.block) ||
                                    block.equals(MiddleGrassBlock.block) ||
                                    block.equals(SmallGrassBlock.block) ||
                                    block.equals(LoranGrassBlock.block) ||
                                    block.equals(LoranGrass2Block.block) ||

                                    block.equals(AbyssWartRootsBlock.block) ||
                                    block.equals(AbyssKranRootsBlock.block) ||

                                    // The Beginning -> The Abyss addon
                                    block.equals(RamusGrassBlock.block) ||
                                    block.equals(RamusGrass2Block.block) ||
                                    block.equals(RamusGrass3Block.block) ||
                                    block.equals(RomasGrassBlock.block) ||

                                    // The Undergarden
                                    block.equals(UGBlocks.DEEPTURF.get()) ||
                                    block.equals(UGBlocks.ASHEN_DEEPTURF.get()) ||
                                    block.equals(UGBlocks.TALL_DEEPTURF.get())
                    )
                    {
                        world.destroyBlock(newBlockPos, true, user);
                        damageTool = 1;
                    }
                    if (damageTool > 0)
                    {
                        int unbreaking = EnchantmentHelper.getEnchantmentLevel(Enchantments.UNBREAKING, user.getHeldItemMainhand());
                        if (MiscUtils.getRandomIntInRange(0, unbreaking) > 0)
                        {
                            continue;
                        }
                        user.getHeldItemMainhand().damageItem(damageTool, (LivingEntity) user, ((e) -> e.sendBreakAnimation(EquipmentSlotType.MAINHAND)));
                        if (user.getHeldItemMainhand().getItem() != item) {
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
