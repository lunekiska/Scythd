package eu.lunekiska.scythd;

import eu.lunekiska.scythd.compat.registries.*;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nonnull;

@Mod(Scythd.MODID)
public class Scythd
{
    public static Scythd instance;
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "scythd";

    public static final ItemGroup scythes = (new ItemGroup("scythes") {
    @Nonnull
    @OnlyIn(Dist.CLIENT)
    public ItemStack createIcon() {
            return new ItemStack(ItemRegistry.SAMPLE_SCYTHE.get());
        }
    });

    public Scythd() {
        LOGGER.info("Loading [Scythd]");

        instance = this;

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemRegistry.ITEMS.register(modEventBus);

        ItemRegistry.NON_TIERED_ITEMS.register(modEventBus);

        EnchantsRegistry.ENCHANTMENTS.register(modEventBus);

        if (ModList.get().isLoaded("aquaculture")) AquacultureSupport.AQUACULTURE_SUP_ITEMS.register(modEventBus);

        if (ModList.get().isLoaded("betterendforge")) BetterEndSupport.BETTEREND_SUP_ITEMS.register(modEventBus);

        if (ModList.get().isLoaded("druidcraft")) DruidcraftSupport.DRUIDCRAFT_SUP_ITEMS.register(modEventBus);

        if (ModList.get().isLoaded("mekanism")) MekanismNonToolsSupport.MEKANISM_NON_TOOLS_ITEMS.register(modEventBus);

        if (ModList.get().isLoaded("mekanismtools")) MekanismSupport.MEKANISM_SUP_ITEMS.register(modEventBus);

        if (ModList.get().isLoaded("byg")) BYGSupport.BYG_SUP_ITEMS.register(modEventBus);

        if (ModList.get().isLoaded("theabyss")) TheAbyssSupport.THE_ABYSS_SUP_ITEMS.register(modEventBus);

        if (ModList.get().isLoaded("undergarden")) TheUndergardenSupport.THE_UNDERGARDEN_SUP_ITEMS.register(modEventBus);

        if (ModList.get().isLoaded("botania")) BotaniaSupport.BOTANIA_SUP_ITEMS.register(modEventBus);

        if (ModList.get().isLoaded("create")) CreateSupport.CREATE_SUP_ITEMS.register(modEventBus);

        }

    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event)
    {

    }

    @SubscribeEvent
    public static void complete(FMLLoadCompleteEvent event)
    {
        LOGGER.info("[Scythd] has successfully been loaded!");
    }
}