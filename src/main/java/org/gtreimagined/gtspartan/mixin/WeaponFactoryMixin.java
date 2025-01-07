package org.gtreimagined.gtspartan.mixin;

import com.oblivioussp.spartanweaponry.api.SpartanWeaponryAPI;
import com.oblivioussp.spartanweaponry.api.WeaponMaterial;
import com.oblivioussp.spartanweaponry.item.SwordBaseItem;
import com.oblivioussp.spartanweaponry.util.WeaponArchetype;
import com.oblivioussp.spartanweaponry.util.WeaponFactory;
import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.tool.AntimatterItemTier;
import muramasa.antimatter.tool.AntimatterToolType;
import net.minecraft.world.item.Item.Properties;
import org.gtreimagined.gtspartan.GTSpartan;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.gtreimagined.gtspartan.GTSPConfig;
import org.gtreimagined.gtspartan.items.MaterialSwordSpartan;

@Mixin(WeaponFactory.class)
public class WeaponFactoryMixin {
    @Redirect(method = {"lambda$static$0", "lambda$static$1", "lambda$static$2", "lambda$static$3", "lambda$static$4", "lambda$static$5", "lambda$static$6",
            "lambda$static$7", "lambda$static$8", "lambda$static$9", "lambda$static$10", "lambda$static$11", "lambda$static$12", "lambda$static$19", "lambda$static$20",
            "lambda$static$21", "lambda$static$22", "lambda$static$23"},
            at = @At(value = "NEW", target = "(Lnet/minecraft/world/item/Item$Properties;Lcom/oblivioussp/spartanweaponry/api/WeaponMaterial;Lcom/oblivioussp/spartanweaponry/util/WeaponArchetype;FFDLjava/lang/String;)Lcom/oblivioussp/spartanweaponry/item/SwordBaseItem;"))
    private static SwordBaseItem gtsp_$redirectDagger(Properties prop, WeaponMaterial materialIn, WeaponArchetype archetypeIn, float weaponBaseDamage, float weaponDamageMultiplier, double weaponSpeed, String customDisplayNameIn){
        if (materialIn.getMaterialName().equals("iron") || materialIn.getMaterialName().equals("gold") || materialIn.getMaterialName().equals("diamond")){
            if (GTSPConfig.ENABLE_SPARTAN_TOOL_MODIFICATIONS.get()){
                return new MaterialSwordSpartan(SpartanWeaponryAPI.MOD_ID, gtsp_$getToolType(archetypeIn), AntimatterItemTier.getOrCreate(Material.get(materialIn.getMaterialName()), Material.NULL), prop, archetypeIn, weaponBaseDamage, weaponDamageMultiplier, (float) weaponSpeed, true, customDisplayNameIn);
            }
        }
        return new SwordBaseItem(prop, materialIn, archetypeIn, weaponBaseDamage, weaponDamageMultiplier, weaponSpeed, customDisplayNameIn);
    }

    @Unique
    private static AntimatterToolType gtsp_$getToolType(WeaponArchetype archetype){
        return AntimatterAPI.get(AntimatterToolType.class, ((WeaponArchetypeAccessor)archetype).getTraitsTag().location().getPath(), GTSpartan.ID);
    }
}
