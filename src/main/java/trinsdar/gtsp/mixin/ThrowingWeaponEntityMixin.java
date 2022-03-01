package trinsdar.gtsp.mixin;

import com.oblivioussp.spartanweaponry.api.IWeaponTraitContainer;
import com.oblivioussp.spartanweaponry.api.WeaponMaterial;
import com.oblivioussp.spartanweaponry.entity.projectile.ThrowingWeaponEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import trinsdar.gtsp.items.MaterialSwordSp;

@Mixin(ThrowingWeaponEntity.class)
public abstract class ThrowingWeaponEntityMixin extends AbstractArrowEntity {
    @Shadow
    ItemStack weapon;
    protected ThrowingWeaponEntityMixin(EntityType<? extends AbstractArrowEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Redirect(method = "onEntityHit", at = @At(value = "INVOKE", target = "Lcom/oblivioussp/spartanweaponry/api/IWeaponTraitContainer;getMaterial()Lcom/oblivioussp/spartanweaponry/api/WeaponMaterial;"))
    public WeaponMaterial getMaterial(IWeaponTraitContainer<Item> container){
        if (weapon.getItem() instanceof MaterialSwordSp){
           return  ((MaterialSwordSp) weapon.getItem()).getMaterial(weapon);
        }
        return container.getMaterial();
    }

    @Override
    protected void doPostHurtEffects(LivingEntity living) {
        super.doPostHurtEffects(living);
        if (weapon.getItem().canBeDepleted()){
            if (weapon.hurt(1, this.level.getRandom(), null)){
                weapon.shrink(1);
                this.level.playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.ITEM_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);
                this.remove();
            }
        }
    }
}
