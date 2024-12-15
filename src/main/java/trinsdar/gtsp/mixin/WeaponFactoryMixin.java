package trinsdar.gtsp.mixin;

import com.oblivioussp.spartanweaponry.api.SpartanWeaponryAPI;
import com.oblivioussp.spartanweaponry.api.WeaponMaterial;
import com.oblivioussp.spartanweaponry.item.SwordBaseItem;
import com.oblivioussp.spartanweaponry.util.WeaponArchetype;
import com.oblivioussp.spartanweaponry.util.WeaponFactory;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.tool.AntimatterItemTier;
import net.minecraft.world.item.Item.Properties;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import trinsdar.gtsp.GTSPConfig;
import trinsdar.gtsp.data.Tools;
import trinsdar.gtsp.items.MaterialSwordSpartan;

@Mixin(WeaponFactory.class)
public class WeaponFactoryMixin {
    @Redirect(method = "lambda$static$0", at = @At(value = "NEW", target = "(Lnet/minecraft/world/item/Item$Properties;Lcom/oblivioussp/spartanweaponry/api/WeaponMaterial;Lcom/oblivioussp/spartanweaponry/util/WeaponArchetype;FFDLjava/lang/String;)Lcom/oblivioussp/spartanweaponry/item/SwordBaseItem;"))
    private static SwordBaseItem redirectDagger(Properties prop, WeaponMaterial materialIn, WeaponArchetype archetypeIn, float weaponBaseDamage, float weaponDamageMultiplier, double weaponSpeed, String customDisplayNameIn){
        if (materialIn.getMaterialName().equals("iron") || materialIn.getMaterialName().equals("gold") || materialIn.getMaterialName().equals("diamond")){
            if (GTSPConfig.ENABLE_SPARTAN_TOOL_MODIFICATIONS.get()){
                return new MaterialSwordSpartan(SpartanWeaponryAPI.MOD_ID, Tools.DAGGER, AntimatterItemTier.getOrCreate(Material.get(materialIn.getMaterialName()), Material.NULL), prop, archetypeIn, weaponBaseDamage, weaponDamageMultiplier, (float) weaponSpeed, true);
            }
        }
        return new SwordBaseItem(prop, materialIn, archetypeIn, weaponBaseDamage, weaponDamageMultiplier, weaponSpeed, customDisplayNameIn);
    }
}
