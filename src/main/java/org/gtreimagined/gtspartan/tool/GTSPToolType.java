package org.gtreimagined.gtspartan.tool;

import com.oblivioussp.spartanweaponry.api.SpartanWeaponryAPI;
import com.oblivioussp.spartanweaponry.util.WeaponArchetype;
import muramasa.antimatter.data.AntimatterDefaultTools;
import muramasa.antimatter.data.AntimatterMaterials;
import muramasa.antimatter.tool.AntimatterToolType;
import muramasa.antimatter.util.TagUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import org.gtreimagined.gtspartan.items.MaterialSwordSpartan;
import org.gtreimagined.gtspartan.items.MaterialThrowingWeapon;

public class GTSPToolType extends AntimatterToolType {

    private final WeaponArchetype archetype;

    public GTSPToolType(String domain, String id, float baseAttackDamage, float weaponDamageMultiplier, float baseAttackSpeed, WeaponArchetype archetype) {
        super(domain, id, 2, 1, 10, baseAttackDamage, baseAttackSpeed, false);
        this.archetype = archetype;
        if (!id.equals("boomerang")) {
            this.setOverlayLayers(2);
        }
        this.setToolSupplier((domain2, toolType, tier, properties) -> {
            if (tier.getPrimary() == AntimatterMaterials.NetherizedDiamond) properties.fireResistant();
            if (archetype == WeaponArchetype.THROWING_KNIFE || archetype == WeaponArchetype.TOMAHAWK || archetype == WeaponArchetype.JAVELIN || archetype == WeaponArchetype.BOOMERANG){
                int maxAmmo = archetype == WeaponArchetype.THROWING_KNIFE ? 16 : archetype == WeaponArchetype.TOMAHAWK ? 8 : archetype == WeaponArchetype.JAVELIN ? 4 : 1;
                int chargeTicks = archetype == WeaponArchetype.TOMAHAWK ? 8 : archetype == WeaponArchetype.JAVELIN ? 10 : 5;
                return new MaterialThrowingWeapon(domain2, toolType, tier, properties, archetype, weaponDamageMultiplier, maxAmmo, chargeTicks);
            }
            return new MaterialSwordSpartan(domain2, toolType, tier, properties, archetype, weaponDamageMultiplier);
        });
        String tagString = id.equals("quarterstaff") ? "quarterstaves" : id.endsWith("s") ? id : id + "s";
        this.tag = TagUtils.getItemTag(new ResourceLocation(SpartanWeaponryAPI.MOD_ID, tagString));
        this.addEffectiveBlocks(Blocks.COBWEB).setType(AntimatterDefaultTools.SWORD);
        if (id.equals("battleaxe")) addTags("axe");
    }
}
