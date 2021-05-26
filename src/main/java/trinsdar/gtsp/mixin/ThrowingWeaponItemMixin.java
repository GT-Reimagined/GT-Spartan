package trinsdar.gtsp.mixin;

import com.oblivioussp.spartanweaponry.api.WeaponMaterial;
import com.oblivioussp.spartanweaponry.item.SwordBaseItem;
import com.oblivioussp.spartanweaponry.item.ThrowingWeaponItem;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import trinsdar.gtsp.items.MaterialSwordSp;
import trinsdar.gtsp.items.MaterialThrowingWeapon;

import java.util.List;

@Mixin(ThrowingWeaponItem.class)
public class ThrowingWeaponItemMixin extends Item {
    @Shadow
    protected WeaponMaterial material;

    @Shadow
    protected float attackDamage;

    private ThrowingWeaponItemMixin(Properties properties) {
        super(properties);
    }

    @Redirect(method = "inventoryTick", at = @At(value = "FIELD", target = "Lcom/oblivioussp/spartanweaponry/item/ThrowingWeaponItem;material:I", opcode = Opcodes.GETFIELD))
    public WeaponMaterial getMaterial(ThrowingWeaponItem item, ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected){
        if (stack.getItem() instanceof MaterialThrowingWeapon){
            return  ((MaterialThrowingWeapon) stack.getItem()).getMaterial(stack);
        }
        return material;
    }

    @Redirect(method = "addInformation", at = @At(value = "FIELD", target = "Lcom/oblivioussp/spartanweaponry/item/ThrowingWeaponItem;material:I", opcode = Opcodes.GETFIELD))
    public WeaponMaterial getMaterial(ThrowingWeaponItem item, ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn){
        if (stack.getItem() instanceof MaterialThrowingWeapon){
            return  ((MaterialThrowingWeapon) stack.getItem()).getMaterial(stack);
        }
        return material;
    }

    @Redirect(method = "hitEntity", at = @At(value = "FIELD", target = "Lcom/oblivioussp/spartanweaponry/item/ThrowingWeaponItem;material:I", opcode = Opcodes.GETFIELD))
    public WeaponMaterial getMaterial(ThrowingWeaponItem item, ItemStack stack, LivingEntity target, LivingEntity attacker){
        if (stack.getItem() instanceof MaterialThrowingWeapon){
            return  ((MaterialThrowingWeapon) stack.getItem()).getMaterial(stack);
        }
        return material;
    }

    @Redirect(method = "onPlayerStoppedUsing", at = @At(value = "INVOKE", target = "Lcom/oblivioussp/spartanweaponry/item/ThrowingWeaponItem;getDirectAttackDamage()F"))
    public float getStackedDirectAttackDamage(ThrowingWeaponItem item, ItemStack stack, World world, LivingEntity entity, int timeLeft){
        if (item instanceof MaterialThrowingWeapon){
            return ((MaterialThrowingWeapon)item).getAntimatterToolType().getBaseAttackDamage() + ((MaterialThrowingWeapon)item).getTier(stack).getAttackDamage();
        }
        return attackDamage;
    }
}
