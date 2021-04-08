package eu.lunekiska.scythd.compat.registries;

import eu.lunekiska.scythd.Scythd;
import eu.lunekiska.scythd.compat.tooldefs.BetterEndScytheTool;
import mod.beethoven92.betterendforge.common.item.ModItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BetterEndSupport
{
        public static final DeferredRegister<Item> BETTEREND_SUP_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Scythd.MODID);

        public static final RegistryObject<ToolItem> AETERNIUM_SCYTHE = BETTEREND_SUP_ITEMS.register("aeternium_scythe", () -> new BetterEndScytheTool(ModItemTier.AETERNIUM, 4/2, -1.5f, 3, true, new Item.Properties().group(Scythd.scythes).maxStackSize(1)));
        public static final RegistryObject<ToolItem> THALLASIUM_SCYTHE = BETTEREND_SUP_ITEMS.register("thallasium_scythe", () -> new BetterEndScytheTool(ModItemTier.THALLASIUM, 1/2, -1.5f, 2, false, new Item.Properties().group(Scythd.scythes).maxStackSize(1)));
        public static final RegistryObject<ToolItem> TERMINITE_SCYTHE = BETTEREND_SUP_ITEMS.register("terminite_scythe", () -> new BetterEndScytheTool(ModItemTier.TERMINITE, 3/2, -1.5f, 3, true, new Item.Properties().group(Scythd.scythes).maxStackSize(1)));
}

