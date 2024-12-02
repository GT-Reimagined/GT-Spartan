package trinsdar.gtsp.mixin;

import com.oblivioussp.spartanweaponry.item.ThrowingWeaponItem;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ThrowingWeaponItem.class)
public abstract class ThrowingWeaponItemMixin extends Item {
    public ThrowingWeaponItemMixin(Properties pProperties) {
        super(pProperties);
    }
    /*@Shadow
    protected WeaponMaterial material;

    @Shadow
    protected float attackDamage;

    private ThrowingWeaponItemMixin(Properties properties) {
        super(properties);
    }

    @Redirect(method = "inventoryTick", at = @At(value = "FIELD", target = "Lcom/oblivioussp/spartanweaponry/item/ThrowingWeaponItem;material:Lcom/oblivioussp/spartanweaponry/api/WeaponMaterial;", opcode = Opcodes.GETFIELD))
    public WeaponMaterial getMaterial(ThrowingWeaponItem item, ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected){
        if (stack.getItem() instanceof MaterialThrowingWeapon){
            return  ((MaterialThrowingWeapon) stack.getItem()).getMaterial(stack);
        }
        return material;
    }

    @Redirect(method = "hitEntity", at = @At(value = "FIELD", target = "Lcom/oblivioussp/spartanweaponry/item/ThrowingWeaponItem;material:Lcom/oblivioussp/spartanweaponry/api/WeaponMaterial;", opcode = Opcodes.GETFIELD))
    public WeaponMaterial getMaterial(ThrowingWeaponItem item, ItemStack stack, LivingEntity target, LivingEntity attacker){
        if (stack.getItem() instanceof MaterialThrowingWeapon){
            return  ((MaterialThrowingWeapon) stack.getItem()).getMaterial(stack);
        }
        return material;
    }

    @Redirect(method = "onPlayerStoppedUsing", at = @At(value = "INVOKE", target = "Lcom/oblivioussp/spartanweaponry/item/ThrowingWeaponItem;getDirectAttackDamage()F"))
    public float getStackedDirectAttackDamage(ThrowingWeaponItem item, ItemStack stack, World world, LivingEntity entity, int timeLeft){
        if (item instanceof MaterialThrowingWeapon){
            return ((MaterialThrowingWeapon)item).getAntimatterToolType().getBaseAttackDamage() + ((MaterialThrowingWeapon)item).getTier(stack).getAttackDamageBonus();
        }
        return attackDamage;
    }*/
}
