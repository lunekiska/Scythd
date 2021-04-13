package eu.lunekiska.scythd.utils;

import com.vulp.druidcraft.registry.BlockRegistry;
import corgiaoc.byg.core.BYGBlocks;
import eu.lunekiska.scythd.EnchantsRegistry;
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
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.yezon.theabyss.block.*;
import quek.undergarden.registry.UGBlocks;

public class ScythdReapBlocks extends HoeItem
{

    public ScythdReapBlocks(IItemTier itemTier, int attackDamage, float attackSpeed, Properties properties) {
        super(itemTier, attackDamage, attackSpeed, properties);
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

                                    //GRASS + ROOTS + SPROUTS

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
                            block.equals(UGBlocks.TALL_DEEPTURF.get()) ||

                                //FLOWERS

                            //Vanilla
                            block.equals(Blocks.DANDELION) ||
                            block.equals(Blocks.POPPY) ||
                            block.equals(Blocks.BLUE_ORCHID) ||
                            block.equals(Blocks.ALLIUM) ||
                            block.equals(Blocks.AZURE_BLUET) ||
                            block.equals(Blocks.RED_TULIP) ||
                            block.equals(Blocks.ORANGE_TULIP) ||
                            block.equals(Blocks.WHITE_TULIP) ||
                            block.equals(Blocks.PINK_TULIP) ||
                            block.equals(Blocks.OXEYE_DAISY) ||
                            block.equals(Blocks.CORNFLOWER) ||
                            block.equals(Blocks.LILY_OF_THE_VALLEY) ||
                            block.equals(Blocks.WITHER_ROSE) ||

                            block.equals(Blocks.SUNFLOWER) ||
                            block.equals(Blocks.LILAC) ||
                            block.equals(Blocks.ROSE_BUSH) ||
                            block.equals(Blocks.PEONY) ||

                            //BYG
                            block.equals(BYGBlocks.ALLIUM_FLOWER_BUSH) ||
                            block.equals(BYGBlocks.TALL_ALLIUM) ||
                            block.equals(BYGBlocks.ALPINE_BELLFLOWER) ||
                            block.equals(BYGBlocks.AMARANTH) ||
                            block.equals(BYGBlocks.ANGELICA) ||
                            block.equals(BYGBlocks.AZALEA) ||
                            block.equals(BYGBlocks.BEGONIA) ||
                            block.equals(BYGBlocks.BISTORT) ||
                            block.equals(BYGBlocks.BLACK_ROSE) ||
                            block.equals(BYGBlocks.BLUE_SAGE) ||
                            block.equals(BYGBlocks.CYAN_AMARANTH) ||
                            block.equals(BYGBlocks.CYAN_ROSE) ||
                            block.equals(BYGBlocks.CYAN_TULIP) ||
                            block.equals(BYGBlocks.DAFFODIL) ||
                            block.equals(BYGBlocks.DELPHINIUM) ||
                            block.equals(BYGBlocks.FAIRY_SLIPPER) ||
                            block.equals(BYGBlocks.FIRECRACKER_FLOWER_BUSH) ||
                            block.equals(BYGBlocks.FOXGLOVE) ||
                            block.equals(BYGBlocks.GREEN_TULIP) ||
                            block.equals(BYGBlocks.GUZMANIA) ||
                            block.equals(BYGBlocks.INCAN_LILY) ||
                            block.equals(BYGBlocks.IRIS) ||
                            block.equals(BYGBlocks.JAPANESE_ORCHID) ||
                            block.equals(BYGBlocks.KOVAN_FLOWER) ||
                            block.equals(BYGBlocks.LAZARUS_BELLFLOWER) ||
                            block.equals(BYGBlocks.LOLIPOP_FLOWER) ||
                            block.equals(BYGBlocks.MAGENTA_AMARANTH) ||
                            block.equals(BYGBlocks.MAGENTA_TULIP) ||
                            block.equals(BYGBlocks.ORANGE_AMARANTH) ||
                            block.equals(BYGBlocks.ORANGE_DAISY) ||
                            block.equals(BYGBlocks.ORSIRIA_ROSE) ||
                            block.equals(BYGBlocks.PEACH_LEATHER_FLOWER) ||
                            block.equals(BYGBlocks.PINK_ALLIUM) ||
                            block.equals(BYGBlocks.PINK_ALLIUM_FLOWER_BUSH) ||
                            block.equals(BYGBlocks.TALL_PINK_ALLIUM) ||
                            block.equals(BYGBlocks.PINK_ANEMONE) ||
                            block.equals(BYGBlocks.PINK_DAFFODIL) ||
                            block.equals(BYGBlocks.PINK_ORCHID) ||
                            block.equals(BYGBlocks.PROTEA_FLOWER) ||
                            block.equals(BYGBlocks.PURPLE_AMARANTH) ||
                            block.equals(BYGBlocks.PURPLE_ORCHID) ||
                            block.equals(BYGBlocks.PURPLE_SAGE) ||
                            block.equals(BYGBlocks.PURPLE_TULIP) ||
                            block.equals(BYGBlocks.RED_CORNFLOWER) ||
                            block.equals(BYGBlocks.RED_ORCHID) ||
                            block.equals(BYGBlocks.RICHEA) ||
                            block.equals(BYGBlocks.ROSE) ||
                            block.equals(BYGBlocks.SILVER_VASE_FLOWER) ||
                            block.equals(BYGBlocks.SNOWDROPS) ||
                            block.equals(BYGBlocks.TORCH_GINGER) ||
                            block.equals(BYGBlocks.VIOLET_LEATHER_FLOWER) ||
                            block.equals(BYGBlocks.WHITE_ANEMONE) ||
                            block.equals(BYGBlocks.WHITE_SAGE) ||
                            block.equals(BYGBlocks.WINTER_CYCLAMEN) ||
                            block.equals(BYGBlocks.WINTER_ROSE) ||
                            block.equals(BYGBlocks.WINTER_SCILLA) ||
                            block.equals(BYGBlocks.YELLOW_DAFFODIL) ||
                            block.equals(BYGBlocks.YELLOW_TULIP) ||

                            //Botania
                            block.equals(vazkii.botania.common.block.ModBlocks.whiteFlower) ||
                            block.equals(vazkii.botania.common.block.ModBlocks.orangeFlower) ||
                            block.equals(vazkii.botania.common.block.ModBlocks.magentaFlower) ||
                            block.equals(vazkii.botania.common.block.ModBlocks.lightBlueFlower) ||
                            block.equals(vazkii.botania.common.block.ModBlocks.yellowFlower) ||
                            block.equals(vazkii.botania.common.block.ModBlocks.limeFlower) ||
                            block.equals(vazkii.botania.common.block.ModBlocks.pinkFlower) ||
                            block.equals(vazkii.botania.common.block.ModBlocks.grayFlower) ||
                            block.equals(vazkii.botania.common.block.ModBlocks.lightGrayFlower) ||
                            block.equals(vazkii.botania.common.block.ModBlocks.cyanFlower) ||
                            block.equals(vazkii.botania.common.block.ModBlocks.purpleFlower) ||
                            block.equals(vazkii.botania.common.block.ModBlocks.blueFlower) ||
                            block.equals(vazkii.botania.common.block.ModBlocks.brownFlower) ||
                            block.equals(vazkii.botania.common.block.ModBlocks.greenFlower) ||
                            block.equals(vazkii.botania.common.block.ModBlocks.redFlower) ||
                            block.equals(vazkii.botania.common.block.ModBlocks.blackFlower) ||

                            //Druidcraft
                            block.equals(BlockRegistry.lavender) ||

                                    //OTHER

                            block.equals(Blocks.DEAD_BUSH)

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

}

