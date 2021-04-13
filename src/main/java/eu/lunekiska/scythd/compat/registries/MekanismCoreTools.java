package eu.lunekiska.scythd.compat.registries;

import eu.lunekiska.scythd.Scythd;
import eu.lunekiska.scythd.compat.tooldefs.AtomicDisassemblerTool;
import eu.lunekiska.scythd.compat.tooldefs.MekaTool;
import mekanism.common.item.gear.ItemAtomicDisassembler;
import mekanism.common.item.gear.ItemMekaTool;
import mekanism.common.registration.impl.ItemDeferredRegister;
import mekanism.common.registration.impl.ItemRegistryObject;
import net.minecraft.item.Item;

public class MekanismCoreTools
{
    public static final ItemDeferredRegister MEKANISM_CORE_TOOLS = new ItemDeferredRegister(Scythd.MODID);

    public static final ItemRegistryObject<ItemAtomicDisassembler> ATOMIC_DISASSEMBLER_WITH_SCYTHE = MEKANISM_CORE_TOOLS.register("atom_disassembler_scyth", () -> new AtomicDisassemblerTool(new Item.Properties().group(Scythd.scythes).maxStackSize(1), 7, true));
    public static final ItemRegistryObject<ItemMekaTool> MEKA_TOOL_WITH_SCYTHE = MEKANISM_CORE_TOOLS.register("meka_tool_scyth", () -> new MekaTool(new Item.Properties().group(Scythd.scythes).maxStackSize(1).isImmuneToFire(), 7, true));
}
