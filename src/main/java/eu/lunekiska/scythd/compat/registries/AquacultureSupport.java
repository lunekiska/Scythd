package eu.lunekiska.scythd.compat.registries;

import com.teammetallurgy.aquaculture.api.AquacultureAPI;
import eu.lunekiska.scythd.Scythd;
import eu.lunekiska.scythd.compat.tooldefs.AquacultureScytheTool;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AquacultureSupport
{
        public static final DeferredRegister<Item> AQUACULTURE_SUP_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Scythd.MODID);

        public static final RegistryObject<ToolItem> NEPTUNIUM_SCYTHE = AQUACULTURE_SUP_ITEMS.register("neptunium_scythe", () -> new AquacultureScytheTool(AquacultureAPI.MATS.NEPTUNIUM, 6/2, -1.5f, 4, true, new Item.Properties().group(Scythd.scythes).maxStackSize(1)));
}
