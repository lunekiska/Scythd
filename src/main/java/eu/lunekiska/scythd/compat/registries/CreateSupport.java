package eu.lunekiska.scythd.compat.registries;

import eu.lunekiska.scythd.Scythd;
import eu.lunekiska.scythd.compat.tiers.CreateItemTiers;
import eu.lunekiska.scythd.compat.tooldefs.CreateScytheTool;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CreateSupport
{
    public static final DeferredRegister<Item> CREATE_SUP_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Scythd.MODID);

    public static final RegistryObject<ToolItem> BRASS_SCYTHE = CREATE_SUP_ITEMS.register("brass_scythe", () -> new CreateScytheTool(CreateItemTiers.BRASS, 3/2, -1.5f, 2, false, new Item.Properties().group(Scythd.scythes).maxStackSize(1)));
    public static final RegistryObject<ToolItem> SHADOW_STEEL_SCYTHE = CREATE_SUP_ITEMS.register("shadow_steel_scythe", () -> new CreateScytheTool(CreateItemTiers.SHADOW_STEEL, 6/2, -1.5f, 3, true, new Item.Properties().group(Scythd.scythes).maxStackSize(1)));

}
