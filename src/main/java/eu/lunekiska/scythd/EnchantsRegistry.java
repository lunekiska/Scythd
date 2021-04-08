package eu.lunekiska.scythd;

import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EnchantsRegistry
{

    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, Scythd.MODID);

    public static final RegistryObject<Enchantment> CROP_REAPER = ENCHANTMENTS.register("crop_reaper", CropReaperEnchantment::new);
}
