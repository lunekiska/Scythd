package eu.lunekiska.scythd.compat.registries;

import eu.lunekiska.scythd.Scythd;
import eu.lunekiska.scythd.compat.tooldefs.MekanismScytheTool;
import mekanism.tools.common.config.MekanismToolsConfig;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MekanismSupport
{
    public static final DeferredRegister<Item> MEKANISM_SUP_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Scythd.MODID);

    public static final RegistryObject<ToolItem> BRONZE_SCYTHE = MEKANISM_SUP_ITEMS.register("bronze_scythe", () -> new MekanismScytheTool(MekanismToolsConfig.tools.bronze, 4/2, -1.5f, 3, true, new Item.Properties().group(Scythd.scythes).maxStackSize(1)));
    public static final RegistryObject<ToolItem> OSMIUM_SCYTHE = MEKANISM_SUP_ITEMS.register("osmium_scythe", () -> new MekanismScytheTool(MekanismToolsConfig.tools.osmium, 4/2, -1.5f, 2, true, new Item.Properties().group(Scythd.scythes).maxStackSize(1)));
    public static final RegistryObject<ToolItem> REFINED_GLOWSTONE_SCYTHE = MEKANISM_SUP_ITEMS.register("refined_glowstone_scythe", () -> new MekanismScytheTool(MekanismToolsConfig.tools.refinedGlowstone, 2/2, -1.5f, 2, false, new Item.Properties().group(Scythd.scythes).maxStackSize(1)));
    public static final RegistryObject<ToolItem> REFINED_OBSIDIAN_SCYTHE = MEKANISM_SUP_ITEMS.register("refined_obsidian_scythe", () -> new MekanismScytheTool(MekanismToolsConfig.tools.refinedObsidian, 4/2, -1.5f, 5, true, new Item.Properties().group(Scythd.scythes).maxStackSize(1)));
    public static final RegistryObject<ToolItem> STEEL_SCYTHE = MEKANISM_SUP_ITEMS.register("steel_scythe", () -> new MekanismScytheTool(MekanismToolsConfig.tools.steel, 4/2, -1.5f, 2, false, new Item.Properties().group(Scythd.scythes).maxStackSize(1)));
}
