package trinsdar.gtsp.mixin;

import com.oblivioussp.spartanweaponry.item.ThrowingWeaponItem;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ThrowingWeaponItem.class)
public abstract class ThrowingWeaponItemClientMixin extends Item {
    public ThrowingWeaponItemClientMixin(Properties pProperties) {
        super(pProperties);
    }

    /*@Shadow
    WeaponMaterial material;

    public ThrowingWeaponItemClientMixin(Properties properties) {
        super(properties);
    }

    @Redirect(method = "addInformation", at = @At(value = "FIELD", target = "Lcom/oblivioussp/spartanweaponry/item/ThrowingWeaponItem;material:Lcom/oblivioussp/spartanweaponry/api/WeaponMaterial;", opcode = Opcodes.GETFIELD))
    public WeaponMaterial getMaterial(ThrowingWeaponItem item, ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn){
        if (stack.getItem() instanceof MaterialThrowingWeapon){
            return  ((MaterialThrowingWeapon) stack.getItem()).getMaterial(stack);
        }
        return material;
    }*/
}
