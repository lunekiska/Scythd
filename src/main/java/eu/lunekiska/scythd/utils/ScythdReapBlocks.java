package eu.lunekiska.scythd.utils;

import corgiaoc.byg.core.BYGBlocks;
import mod.beethoven92.betterendforge.common.init.ModBlocks;
import net.abyss.addon.thebeginning.block.RamusGrass2Block;
import net.abyss.addon.thebeginning.block.RamusGrass3Block;
import net.abyss.addon.thebeginning.block.RamusGrassBlock;
import net.abyss.addon.thebeginning.block.RomasGrassBlock;
import net.minecraft.block.Blocks;
import net.yezon.theabyss.block.*;
import quek.undergarden.registry.UGBlocks;

import static eu.lunekiska.scythd.ScytheTool.block;

public class ScythdReapBlocks
{
        public static boolean rBPost =
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
                        block.equals(UGBlocks.TALL_DEEPTURF.get());
}
