package eu.lunekiska.scythd.compat.tiers;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.yezon.theabyss.item.*;

import javax.annotation.Nonnull;

public enum ScythdTheAbyssItemTiers implements IItemTier
{

    ABYSS_DIAMOND(1000, 3.0F, 8,Ingredient.fromItems(AbyssDiamondItem.block)),
    ULTRA_ABYSS_DIAMOND(1200, 4.0F, 8, Ingredient.fromItems(UltraAbyssDiamondItem.block)),
    FUSION(1600, 6.0F, 14, Ingredient.fromItems(FusionIngotItem.block)),
    UNKNOWN(2000, 4.0F, 42, Ingredient.fromItems(UnknownDiamondItem.block)),
    PHANTOM(3000, 6.0F, 50, Ingredient.fromItems(PhantomIngotItem.block)),
    GARNITE(1800, 4.0F, 28, Ingredient.fromItems(GarniteIngotItem.block)),
    UNORITHE(3000, 8.0F, 51, Ingredient.fromItems(UnoritheIngotItem.block)),
    KNIGHT(4000, 12.0F, 51, Ingredient.fromItems(KnightHoeItem.block));

    private final int uses;
    private final float damage;
    private final int enchantmentValue;
    private final Ingredient repairIngredient;

    ScythdTheAbyssItemTiers(int uses, float damage, int enchantmentValue, Ingredient repairIngredient) {
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
