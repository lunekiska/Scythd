package eu.lunekiska.scythd;

import eu.lunekiska.scythd.compat.tooldefs.*;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;

public class CropReaperEnchantment extends Enchantment
{
    public CropReaperEnchantment()
    {
        super(Rarity.COMMON, EnchantmentType.DIGGER, new EquipmentSlotType[]{EquipmentSlotType.MAINHAND});
    }

    public boolean isAcceptableItem(ItemStack stack)
    {
        return stack.getItem() instanceof ScytheTool && stack.getItem() instanceof NonTieredScytheTool && stack.getItem() instanceof AquacultureScytheTool && stack.getItem() instanceof BetterEndScytheTool && stack.getItem() instanceof DruidcraftScytheTool && stack.getItem() instanceof MekanismScytheTool && stack.getItem() instanceof TheAbyssScytheTool && stack.getItem() instanceof TheUndergardenScytheTool && stack.getItem() instanceof BotaniaManasteelScytheTool && stack.getItem() instanceof BotaniaElementiumScytheTool && stack.getItem() instanceof BotaniaTerrasteelScytheTool;
    }

    public int getMaxLevel()
    {
        return 4;
    }
}
