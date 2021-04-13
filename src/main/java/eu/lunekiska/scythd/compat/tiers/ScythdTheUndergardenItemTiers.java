package eu.lunekiska.scythd.compat.tiers;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import quek.undergarden.registry.UGItems;

import javax.annotation.Nonnull;

public enum ScythdTheUndergardenItemTiers implements IItemTier
{
    CLOGGRUM(286, 4.0F, 10, Ingredient.fromItems(UGItems.CLOGGRUM_INGOT.get())),
    FROSTSTEEL(575, 3.0F, 15,Ingredient.fromItems(UGItems.FROSTSTEEL_INGOT.get())),
    UTHERIC(1279, 4.0F, 13, Ingredient.fromItems(UGItems.UTHERIUM_INGOT.get())),
    FORGOTTEN(63, 6.0F,0, Ingredient.fromItems(UGItems.FORGOTTEN_INGOT.get()));

    private final int uses;
    private final float damage;
    private final int enchantmentValue;
    private final Ingredient repairIngredient;

    ScythdTheUndergardenItemTiers(int uses, float damage, int enchantmentValue, Ingredient repairIngredient)
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
        return this.enchantmentValue;
    }

    @Nonnull
    @Override
    public Ingredient getRepairMaterial() {
        return repairIngredient;
    }
}
