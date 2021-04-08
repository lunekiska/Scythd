package eu.lunekiska.scythd.compat.registries;

import eu.lunekiska.scythd.Scythd;
import eu.lunekiska.scythd.compat.tiers.ScythdTheUndergardenItemTiers;
import eu.lunekiska.scythd.compat.tooldefs.TheUndergardenScytheTool;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TheUndergardenSupport
{
    public static final DeferredRegister<Item> THE_UNDERGARDEN_SUP_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Scythd.MODID);

    public static final RegistryObject<ToolItem> CLOGGRUM_SCYTHE = THE_UNDERGARDEN_SUP_ITEMS.register("cloggrum_scythe", () -> new TheUndergardenScytheTool(ScythdTheUndergardenItemTiers.CLOGGRUM, 4/2, -1.5f, 2, false, new Item.Properties().group(Scythd.scythes).maxStackSize(1)));
    public static final RegistryObject<ToolItem> FROSTSTEEL_SCYTHE = THE_UNDERGARDEN_SUP_ITEMS.register("froststeel_scythe", () -> new TheUndergardenScytheTool(ScythdTheUndergardenItemTiers.FROSTSTEEL, 3/2, -1.5f, 2, false, new Item.Properties().group(Scythd.scythes).maxStackSize(1)));
    public static final RegistryObject<ToolItem> UTHERIUM_SCYTHE = THE_UNDERGARDEN_SUP_ITEMS.register("utherium_scythe", () -> new TheUndergardenScytheTool(ScythdTheUndergardenItemTiers.UTHERIC, 4/2, -1.5f, 2, true, new Item.Properties().group(Scythd.scythes).maxStackSize(1)));
    public static final RegistryObject<ToolItem> FORGOTTEN_SCYTHE = THE_UNDERGARDEN_SUP_ITEMS.register("forgotten_scythe", () -> new TheUndergardenScytheTool(ScythdTheUndergardenItemTiers.FORGOTTEN, 6/2, -1.5f, 3, true, new Item.Properties().group(Scythd.scythes).maxStackSize(1)));
}
