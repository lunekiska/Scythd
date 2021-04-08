package eu.lunekiska.scythd;

import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraft.item.ToolItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Scythd.MODID);

    public static final RegistryObject<ToolItem> SAMPLE_SCYTHE = ITEMS.register("sample_scythe", () -> new ScytheTool(ItemTier.IRON, 0, -1.5f, 0, false, new Item.Properties().group(Scythd.scythes).maxStackSize(1)));

    // Vanilla
    public static final RegistryObject<ToolItem> WOODEN_SCYTHE = ITEMS.register("wooden_scythe", () -> new ScytheTool(ItemTier.WOOD, 0/2, -1.5f, 1, true, new Item.Properties().group(Scythd.scythes).maxStackSize(1)));
    public static final RegistryObject<ToolItem> STONE_SCYTHE = ITEMS.register("stone_scythe", () -> new ScytheTool(ItemTier.STONE, 1/2, -1.5f, 1, false, new Item.Properties().group(Scythd.scythes).maxStackSize(1)));
    public static final RegistryObject<ToolItem> IRON_SCYTHE = ITEMS.register("iron_scythe", () -> new ScytheTool(ItemTier.IRON, 1/2, -1.5f, 2, true, new Item.Properties().group(Scythd.scythes).maxStackSize(1)));
    public static final RegistryObject<ToolItem> GOLDEN_SCYTHE = ITEMS.register("golden_scythe", () -> new ScytheTool(ItemTier.GOLD, 0/2, -1.5f, 2, false, new Item.Properties().group(Scythd.scythes).maxStackSize(1)));
    public static final RegistryObject<ToolItem> DIAMOND_SCYTHE = ITEMS.register("diamond_scythe", () -> new ScytheTool(ItemTier.DIAMOND, 3/2, -1.5f, 3, true, new Item.Properties().group(Scythd.scythes).maxStackSize(1)));
    public static final RegistryObject<ToolItem> NETHERITE_SCYTHE = ITEMS.register("netherite_scythe", () -> new ScytheTool(ItemTier.NETHERITE, 4/2, -1.5f, 3, false, new Item.Properties().group(Scythd.scythes).maxStackSize(1).isImmuneToFire()));

    public static final DeferredRegister<Item> NON_TIERED_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Scythd.MODID);

    // Other
    public static final RegistryObject<ToolItem> AMETHYST_SCYTHE = NON_TIERED_ITEMS.register("amethyst_scythe", () -> new NonTieredScytheTool(ScythdItemTiers.AMETHYST, 2/2, -1.5f, 2, false, new Item.Properties().group(Scythd.scythes).maxStackSize(1)));
    public static final RegistryObject<ToolItem> EMERALD_SCYTHE = NON_TIERED_ITEMS.register("emerald_scythe", () -> new NonTieredScytheTool(ScythdItemTiers.EMERALD, 2/2, -1.5f, 2, false, new Item.Properties().group(Scythd.scythes).maxStackSize(1)));
    public static final RegistryObject<ToolItem> LAPIS_LAZULI_SCYTHE = NON_TIERED_ITEMS.register("lapis_lazuli_scythe", () -> new NonTieredScytheTool(ScythdItemTiers.LAPIS_LAZULI, 2/2, -1.5f, 2, true, new Item.Properties().group(Scythd.scythes).maxStackSize(1)));
    public static final RegistryObject<ToolItem> BONE_SCYTHE = NON_TIERED_ITEMS.register("bone_scythe", () -> new NonTieredScytheTool(ScythdItemTiers.BONE, 0/2, -1.5f, 2, false, new Item.Properties().group(Scythd.scythes).maxStackSize(1)));

}