package gregtech.common.tools;

import gregtech.api.GregTechAPI;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.Arrays;
import java.util.List;

public class ToolSolderingIron extends ToolBase {

    public static final List<String> EFFECTIVE_LIST = Arrays.asList(EntityCaveSpider.class.getName(),
                                                                        EntitySpider.class.getName(),
                                                                        "EntityTFHedgeSpider",
                                                                        "EntityTFKingSpider",
                                                                        "EntityTFSwarmSpider",
                                                                        "EntityTFTowerBroodling");

    @Override
    public float getNormalDamageBonus(EntityLivingBase entity, ItemStack stack, EntityLivingBase attacker) {
        String tName = entity.getClass().getName();
        tName = tName.substring(tName.lastIndexOf('.') + 1);
        return EFFECTIVE_LIST.contains(tName) ? 2.0F : 1.0F;
    }

    @Override
    public int getToolDamagePerBlockBreak(ItemStack stack) {
        return 1000;
    }

    @Override
    public int getToolDamagePerDropConversion(ItemStack stack) {
        return 500;
    }

    @Override
    public int getToolDamagePerContainerCraft(ItemStack stack) {
        return 1000;
    }

    @Override
    public int getToolDamagePerEntityAttack(ItemStack stack) {
        return 500;
    }

    @Override
    public float getBaseDamage(ItemStack stack) {
        return 1.5F;
    }

    @Override
    public ResourceLocation getCraftingSound(ItemStack stack) {
        return GregTechAPI.soundList.get(100);
    }

    @Override
    public ResourceLocation getBreakingSound(ItemStack stack) {
        return GregTechAPI.soundList.get(0);
    }

    @Override
    public boolean isMinableBlock(IBlockState block, ItemStack stack) {
        return block.getMaterial() == Material.CIRCUITS;
    }

//    @Override
//    public void onStatsAddedToTool(MetaItem.MetaValueItem item, int ID) {
//        item.addStats(new Behaviour_Screwdriver(1, 200));
//    }

//    @Override
//    public ITextComponent getDeathMessage(EntityLivingBase player, EntityLivingBase entity) {
//        return new TextComponentString(TextFormatting.RED + "")
//                .appendSibling(entity.getDisplayName())
//                .appendText(TextFormatting.WHITE + " got soldert by " + TextFormatting.GREEN)
//                .appendSibling(player.getDisplayName());
//    }
}
