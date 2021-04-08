package eu.lunekiska.scythd.compat.tiers;

import com.simibubi.create.AllItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

import javax.annotation.Nonnull;

public enum CreateItemTiers implements IItemTier
{
    BRASS(800, 3.0F, 8,Ingredient.fromItems(AllItems.BRASS_INGOT.get())),
    SHADOW_STEEL(1200, 6.0F, 15,Ingredient.fromItems(AllItems.SHADOW_STEEL.get()));

    private final int uses;
    private final float damage;
    private final int enchantmentValue;
    private final Ingredient repairIngredient;

    CreateItemTiers(int uses, float damage, int enchantmentValue, Ingredient repairIngredient) {
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
