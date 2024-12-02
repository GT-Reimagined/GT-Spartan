package trinsdar.gtsp.items;

import com.oblivioussp.spartanweaponry.api.WeaponMaterial;
import com.oblivioussp.spartanweaponry.api.tags.ModWeaponTraitTags;
import com.oblivioussp.spartanweaponry.item.SwordBaseItem;
import com.oblivioussp.spartanweaponry.util.WeaponArchetype;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.tool.AntimatterItemTier;
import muramasa.antimatter.tool.AntimatterToolType;
import muramasa.antimatter.tool.IAntimatterTool;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags.Items;
import org.jetbrains.annotations.Nullable;
import tesseract.api.context.TesseractItemContext;
import tesseract.api.gt.IEnergyHandlerItem;

import java.util.List;
import java.util.function.Consumer;

import static muramasa.antimatter.data.AntimatterMaterialTypes.GEM;
import static muramasa.antimatter.data.AntimatterMaterialTypes.INGOT;

public class MaterialSwordSpartan extends SwordBaseItem implements IAntimatterTool {
    private final String domain;
    @org.jetbrains.annotations.NotNull
    private final AntimatterToolType type;
    private final AntimatterItemTier tier;

    public MaterialSwordSpartan(String domain, AntimatterToolType type, AntimatterItemTier tier, Item.Properties properties, WeaponArchetype archetypeIn) {
        super(properties, new WeaponMaterialWrapper(String.join("_", tier.getPrimary().getId(), type.getId()), domain, tier, repairTag(tier.getPrimary()), ModWeaponTraitTags.create(type.getId())), archetypeIn, type.getBaseAttackDamage(), 1, type.getBaseAttackSpeed());
        this.domain = domain;
        this.type = type;
        this.tier = tier;
    }

    @Override
    public String getDomain() {
        return domain;
    }

    public static TagKey<Item> repairTag(Material material){
        return material.has(INGOT) ? INGOT.getMaterialTag(material) : material.has(GEM) ? GEM.getMaterialTag(material) : Items.INGOTS_IRON;
    }

    @Override
    public AntimatterItemTier getAntimatterItemTier() {
        return tier;
    }

    @Override
    public ItemStack asItemStack(Material primary, Material secondary) {
        return resolveStack(primary, secondary, 0, 0);
    }

    @Override
    public int getEnergyTier() {
        return 0;
    }

    @Override
    public AntimatterToolType getAntimatterToolType() {
        return type;
    }

    @Override
    public String getId() {
        return String.join("_", this.tier.getPrimary().getId(), this.type.getId());
    }

    @Override
    public IEnergyHandlerItem createEnergyHandler(TesseractItemContext tesseractItemContext) {
        return null;
    }

    @Override
    public <T extends LivingEntity> int damageItem(ItemStack stack, int amount, T entity, Consumer<T> onBroken) {
        return super.damageItem(stack, amount, entity, onBroken);
    }

    @Override
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState state){
        return genericIsCorrectToolForDrops(stack, state);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        onGenericAddInformation(stack, tooltip, flag);
        super.appendHoverText(stack, world, tooltip, flag);
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        return (int) (super.getMaxDamage(stack) * getAntimatterToolType().getDurabilityMultiplier());
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity entity) {
        return onGenericBlockDestroyed(stack, level, state, pos, entity);
    }

    @Override
    public InteractionResult useOn(UseOnContext contextIn) {
        InteractionResult result = onGenericItemUse(contextIn);
        if (result != InteractionResult.PASS) return result;
        return super.useOn(contextIn);
    }
}
