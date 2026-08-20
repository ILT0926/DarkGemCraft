package me.ssq.item.tool;

import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

public enum ModToolMaterial implements ToolMaterial{
    DARK_PICKAXE,
    DARK_SWORD,
    DARK_AXE,
    DARK_SHOVEL,
    DARK_HOE;

    @Override
    public float getMiningSpeedMultiplier(){
        if(this == DARK_AXE || this ==DARK_PICKAXE) {
            return 15.0F;
        }else if(this == DARK_SWORD){
            return 6.0F;
        }else if(this == DARK_SHOVEL){
            return 10.0F;
        }else{
            return 8.0F;
        }
    }

    @Override
    public int getDurability(){
        return 2000;
    }

    @Override
    public float getAttackDamage(){
        if(this == DARK_AXE || this == DARK_PICKAXE){
            return 10.0F;
        }else if(this == DARK_SWORD){
            return 8.0F;
        }else if(this == DARK_HOE || this == DARK_SHOVEL){
            return 3.0F;
        }
        return 2.0F;
    }

    @Override
    public int getEnchantability(){
        return 22;
    }

    @Override
    public TagKey<Block> getInverseTag(){
        return BlockTags.INCORRECT_FOR_NETHERITE_TOOL;
    }


    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.DARK_GEM);
    }
}


