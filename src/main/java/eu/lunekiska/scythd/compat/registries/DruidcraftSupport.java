package eu.lunekiska.scythd.compat.registries;

import com.vulp.druidcraft.registry.ToolMaterialRegistry;
import eu.lunekiska.scythd.Scythd;
import eu.lunekiska.scythd.compat.tooldefs.DruidcraftScytheTool;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DruidcraftSupport
{
       public static final DeferredRegister<Item> DRUIDCRAFT_SUP_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Scythd.MODID);

       public static final RegistryObject<ToolItem> MOONSTONE_SCYTHE = DRUIDCRAFT_SUP_ITEMS.register("moonstone_scythe", () -> new DruidcraftScytheTool(ToolMaterialRegistry.moonstone, 4/2, -1.5f, 3, false, new Item.Properties().group(Scythd.scythes).maxStackSize(1)));
}
