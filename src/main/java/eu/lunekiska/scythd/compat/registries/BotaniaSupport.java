package eu.lunekiska.scythd.compat.registries;

import eu.lunekiska.scythd.Scythd;
import eu.lunekiska.scythd.compat.tiers.BotaniaItemTiers;
import eu.lunekiska.scythd.compat.tooldefs.BotaniaElementiumScytheTool;
import eu.lunekiska.scythd.compat.tooldefs.BotaniaManasteelScytheTool;
import eu.lunekiska.scythd.compat.tooldefs.BotaniaTerrasteelScytheTool;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraft.item.ToolItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BotaniaSupport
{
    public static final DeferredRegister<Item> BOTANIA_SUP_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Scythd.MODID);

    public static final RegistryObject<ToolItem> MANASTEEL_SCYTHE = BOTANIA_SUP_ITEMS.register("manasteel_scythe", () -> new BotaniaManasteelScytheTool(BotaniaItemTiers.MANASTEEL, 2/2, -1.5f, 2, true, new Item.Properties().group(Scythd.scythes).maxStackSize(1)));
    public static final RegistryObject<ToolItem> ELEMENTIUM_SCYTHE = BOTANIA_SUP_ITEMS.register("elementium_scythe", () -> new BotaniaElementiumScytheTool(BotaniaItemTiers.ELEMENTIUM, 2/2, -1.5f, 3, true, new Item.Properties().group(Scythd.scythes).maxStackSize(1)));
    public static final RegistryObject<ToolItem> TERRASTEEL_SCYTHE = BOTANIA_SUP_ITEMS.register("terrasteel_scythe", () -> new BotaniaTerrasteelScytheTool(BotaniaItemTiers.TERRASTEEL, 3/2, -1.5f, 2, false, new Item.Properties().group(Scythd.scythes).maxStackSize(1).isImmuneToFire().rarity(Rarity.UNCOMMON)));
}
