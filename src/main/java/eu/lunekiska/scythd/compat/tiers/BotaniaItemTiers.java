package eu.lunekiska.scythd.compat.tiers;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import vazkii.botania.common.item.ModItems;

import javax.annotation.Nonnull;

public enum BotaniaItemTiers implements IItemTier
{
    MANASTEEL(300, 2.0F, 20, Ingredient.fromItems(ModItems.manaSteel)),
    ELEMENTIUM(720, 2.0F, 20, Ingredient.fromItems(ModItems.elementium)),
    TERRASTEEL(2300, 3.0F, 26, Ingredient.fromItems(ModItems.terrasteel));

    private final int uses;
    private final float damage;
    private final int enchantmentValue;
    private final Ingredient repairIngredient;

    BotaniaItemTiers(int uses, float damage, int enchantmentValue, Ingredient repairIngredient)
    {
        this.uses = uses;
        this.damage = damage;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = repairIngredient;
    }

    public int getUses() {
        return this.uses;
    }

    public float getSpeed() {
        return 0;
    }

    public float getAttackDamageBonus() {
        return this.damage;
    }

    public int getLevel() {
        return 0;
     }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
     }

    @Nonnull
    public Ingredient getRepairIngredient() {
        return this.repairIngredient;
     }

    @Override
    public int getMaxUses() {
        return this.uses;
     }

    @Override
    public float getEfficiency() {
        return 0;
     }

    @Override
    public float getAttackDamage() {
        return 0;
     }

    @Override
    public int getHarvestLevel() {
        return 0;
      }

    @Override
    public int getEnchantability() {
        return 0;
       }

    @Nonnull
    @Override
    public Ingredient getRepairMaterial() {
        return repairIngredient;
        }
}
