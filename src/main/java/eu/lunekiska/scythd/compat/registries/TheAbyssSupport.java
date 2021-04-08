package eu.lunekiska.scythd.compat.registries;

import eu.lunekiska.scythd.Scythd;
import eu.lunekiska.scythd.compat.tiers.ScythdTheAbyssItemTiers;
import eu.lunekiska.scythd.compat.tooldefs.TheAbyssScytheTool;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TheAbyssSupport
{
    public static final DeferredRegister<Item> THE_ABYSS_SUP_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Scythd.MODID);

    public static final RegistryObject<ToolItem> ABYSS_DIAMOND_SCYTHE = THE_ABYSS_SUP_ITEMS.register("abyss_diamond_scythe", () -> new TheAbyssScytheTool(ScythdTheAbyssItemTiers.ABYSS_DIAMOND, 3/2, -1.5f, 2, false, new Item.Properties().group(Scythd.scythes).maxStackSize(1)));
    public static final RegistryObject<ToolItem> ULTRA_ABYSS_SCYTHE = THE_ABYSS_SUP_ITEMS.register("ultra_abyss_scythe", () -> new TheAbyssScytheTool(ScythdTheAbyssItemTiers.ULTRA_ABYSS_DIAMOND, 4/2, -1.5f, 2, true, new Item.Properties().group(Scythd.scythes).maxStackSize(1)));
    public static final RegistryObject<ToolItem> FUSION_SCYTHE = THE_ABYSS_SUP_ITEMS.register("fusion_scythe", () -> new TheAbyssScytheTool(ScythdTheAbyssItemTiers.FUSION, 6/2, -1.5f, 3, false, new Item.Properties().group(Scythd.scythes).maxStackSize(1)));
    public static final RegistryObject<ToolItem> UNKNOWN_SCYTHE = THE_ABYSS_SUP_ITEMS.register("unknown_scythe", () -> new TheAbyssScytheTool(ScythdTheAbyssItemTiers.UNKNOWN, 4/2, -1.5f, 2, false, new Item.Properties().group(Scythd.scythes).maxStackSize(1)));
    public static final RegistryObject<ToolItem> PHANTOM_SCYTHE = THE_ABYSS_SUP_ITEMS.register("phantom_scythe", () -> new TheAbyssScytheTool(ScythdTheAbyssItemTiers.PHANTOM, 6/2, -1.5f, 3, true, new Item.Properties().group(Scythd.scythes).maxStackSize(1)));
    public static final RegistryObject<ToolItem> GARNITE_SCYTHE = THE_ABYSS_SUP_ITEMS.register("garnite_scythe", () -> new TheAbyssScytheTool(ScythdTheAbyssItemTiers.GARNITE, 4/2, -1.5f, 2, false, new Item.Properties().group(Scythd.scythes).maxStackSize(1)));
    public static final RegistryObject<ToolItem> UNORITHE_SCYTHE = THE_ABYSS_SUP_ITEMS.register("unorithe_scythe", () -> new TheAbyssScytheTool(ScythdTheAbyssItemTiers.UNORITHE, 8/2, -1.5f, 4, true, new Item.Properties().group(Scythd.scythes).maxStackSize(1)));
    public static final RegistryObject<ToolItem> KNIGHT_SCYTHE = THE_ABYSS_SUP_ITEMS.register("knight_scythe", () -> new TheAbyssScytheTool(ScythdTheAbyssItemTiers.KNIGHT, 12/2, -1.5f, 6, true, new Item.Properties().group(Scythd.scythes).maxStackSize(1)));
}
