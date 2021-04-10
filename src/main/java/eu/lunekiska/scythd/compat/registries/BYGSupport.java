package eu.lunekiska.scythd.compat.registries;

import corgiaoc.byg.common.properties.items.itemtiers.BYGItemTiers;
import eu.lunekiska.scythd.Scythd;
import eu.lunekiska.scythd.compat.tooldefs.BYGScytheTool;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BYGSupport
{
    public static final DeferredRegister<Item> BYG_SUP_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Scythd.MODID);

    public static final RegistryObject<ToolItem> PENDORITE_SCYTHE = BYG_SUP_ITEMS.register("pendorite_scythe", () -> new BYGScytheTool(BYGItemTiers.PENDORITE, 6/2, -1.5f, 4, true, new Item.Properties().group(Scythd.scythes).maxStackSize(1)));

}
