package trinsdar.gtsp.mixin;

import com.oblivioussp.spartanweaponry.api.WeaponMaterial;
import com.oblivioussp.spartanweaponry.item.SwordBaseItem;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import trinsdar.gtsp.items.MaterialSwordSp;

import java.util.List;

@Mixin(SwordBaseItem.class)
public abstract class SwordBaseItemClientMixin extends SwordItem {
    public SwordBaseItemClientMixin(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }

    @Shadow
    WeaponMaterial material;


    @Redirect(method = "addInformation", at = @At(value = "FIELD", target = "Lcom/oblivioussp/spartanweaponry/item/SwordBaseItem;material:Lcom/oblivioussp/spartanweaponry/api/WeaponMaterial;", opcode = Opcodes.GETFIELD))
    public WeaponMaterial getMaterial(SwordBaseItem item, ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn){
        if (item instanceof MaterialSwordSp){
            return  ((MaterialSwordSp) item).getMaterial(stack);
        }
        return material;
    }
}
