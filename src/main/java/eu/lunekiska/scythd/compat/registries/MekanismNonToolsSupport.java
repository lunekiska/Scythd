package eu.lunekiska.scythd.compat.registries;

import eu.lunekiska.scythd.Scythd;
import eu.lunekiska.scythd.ScytheTool;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraft.item.ToolItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MekanismNonToolsSupport
{
    public static final DeferredRegister<Item> MEKANISM_NON_TOOLS_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Scythd.MODID);

    public static final RegistryObject<ToolItem> TIN_SCYTHE = MEKANISM_NON_TOOLS_ITEMS.register("tin_scythe", () -> new ScytheTool(ItemTier.IRON, 1/2, -1.5f, 1, false, new Item.Properties().group(Scythd.scythes).maxStackSize(1)));
    public static final RegistryObject<ToolItem> COPPER_SCYTHE = MEKANISM_NON_TOOLS_ITEMS.register("copper_scythe", () -> new ScytheTool(ItemTier.IRON, 1/2, -1.5f, 1, true, new Item.Properties().group(Scythd.scythes).maxStackSize(1)));
}
