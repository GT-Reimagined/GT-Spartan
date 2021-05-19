package trinsdar.gtsp.mixin;

import com.oblivioussp.spartanweaponry.api.IWeaponTraitContainer;
import com.oblivioussp.spartanweaponry.api.WeaponMaterial;
import com.oblivioussp.spartanweaponry.item.SwordBaseItem;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import trinsdar.gtsp.items.MaterialSwordBig;

import java.util.List;

@Mixin(SwordBaseItem.class)
public abstract class SwordBaseItemMixin extends SwordItem {
    @Shadow
    protected WeaponMaterial material;

    public SwordBaseItemMixin(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }

    @Redirect(method = "inventoryTick", at = @At(value = "FIELD", target = "Lcom/oblivioussp/spartanweaponry/item/SwordBaseItem;material:I", opcode = Opcodes.GETFIELD))
    public WeaponMaterial getMaterial(SwordBaseItem item, ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected){
        if (stack.getItem() instanceof MaterialSwordBig){
            return  ((MaterialSwordBig) stack.getItem()).getMaterial(stack);
        }
        return material;
    }

    @Redirect(method = "getDestroySpeed", at = @At(value = "FIELD", target = "Lcom/oblivioussp/spartanweaponry/item/SwordBaseItem;material:I", opcode = Opcodes.GETFIELD))
    public WeaponMaterial getMaterial(SwordBaseItem item, ItemStack stack, BlockState state){
        if (stack.getItem() instanceof MaterialSwordBig){
            return  ((MaterialSwordBig) stack.getItem()).getMaterial(stack);
        }
        return material;
    }

    @Redirect(method = "addInformation", at = @At(value = "FIELD", target = "Lcom/oblivioussp/spartanweaponry/item/SwordBaseItem;material:I", opcode = Opcodes.GETFIELD))
    public WeaponMaterial getMaterial(SwordBaseItem item, ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn){
        if (stack.getItem() instanceof MaterialSwordBig){
            return  ((MaterialSwordBig) stack.getItem()).getMaterial(stack);
        }
        return material;
    }

    @Redirect(method = "hitEntity", at = @At(value = "FIELD", target = "Lcom/oblivioussp/spartanweaponry/item/SwordBaseItem;material:I", opcode = Opcodes.GETFIELD))
    public WeaponMaterial getMaterial(SwordBaseItem item, ItemStack stack, LivingEntity target, LivingEntity attacker){
        if (stack.getItem() instanceof MaterialSwordBig){
            return  ((MaterialSwordBig) stack.getItem()).getMaterial(stack);
        }
        return material;
    }


}
