package trinsdar.gtsp.mixin;

/*@Mixin(ThrowingWeaponEntity.class)
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
}*/
