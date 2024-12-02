package trinsdar.gtsp.mixin;

/*
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
*/
