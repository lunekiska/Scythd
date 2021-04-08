package eu.lunekiska.scythd;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;

import javax.annotation.Nonnull;

public enum ScythdItemTiers implements IItemTier {

    AMETHYST(400, 2.0F, 20, Ingredient.EMPTY),
    EMERALD(1250, 2.0F, 22, Ingredient.fromItems(Items.EMERALD)),
    LAPIS_LAZULI(200, 2.0F, 30, Ingredient.fromItems(Items.LAPIS_LAZULI)),
    BONE(250, 0.0F, 18, Ingredient.fromItems(Items.BONE));

    private final int uses;
    private final float damage;
    private final int enchantmentValue;
    private final Ingredient repairIngredient;

    ScythdItemTiers(int uses, float damage, int enchantmentValue, Ingredient repairIngredient) {
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
        return 0;
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