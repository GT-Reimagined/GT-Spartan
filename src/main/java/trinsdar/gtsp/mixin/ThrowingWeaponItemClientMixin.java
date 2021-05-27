package trinsdar.gtsp.mixin;

import com.oblivioussp.spartanweaponry.api.WeaponMaterial;
import com.oblivioussp.spartanweaponry.item.ThrowingWeaponItem;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import trinsdar.gtsp.items.MaterialThrowingWeapon;

import java.util.List;

@Mixin(ThrowingWeaponItem.class)
public abstract class ThrowingWeaponItemClientMixin extends Item {

    @Shadow
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
    }
}
