package org.gtreimagined.gtspartan.data;

import com.oblivioussp.spartanweaponry.api.SpartanWeaponryAPI;
import com.oblivioussp.spartanweaponry.util.WeaponArchetype;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import org.gtreimagined.gtlib.GTAPI;
import org.gtreimagined.gtlib.data.GTLibMaterials;
import org.gtreimagined.gtlib.data.GTTools;
import org.gtreimagined.gtlib.tool.GTToolType;
import org.gtreimagined.gtlib.tool.behaviour.BehaviourLogStripping;
import org.gtreimagined.gtlib.tool.behaviour.BehaviourTreeFelling;
import org.jetbrains.annotations.NotNull;
import org.gtreimagined.gtspartan.GTSpartan;
import org.gtreimagined.gtspartan.items.MaterialSwordSpartan;
import org.gtreimagined.gtspartan.tool.GTSPToolType;

import java.util.List;


public class Tools {

    private static final List<GTToolType> tools = new ObjectArrayList<>();

    public static GTToolType DAGGER = register(new GTSPToolType(GTSpartan.ID, "dagger", 2.5f, 1.0f, -1.5f, WeaponArchetype.DAGGER));
    public static GTToolType PARRYING_DAGGER = register(new GTSPToolType(GTSpartan.ID, "parrying_dagger", 2.5f, 1.0f, -1.5f, WeaponArchetype.PARRYING_DAGGER));
    public static GTToolType LONGSWORD = register(new GTSPToolType(GTSpartan.ID, "longsword", 4.5f, 1.5f, -2.6f, WeaponArchetype.LONGSWORD));
    public static GTToolType KATANA = register(new GTSPToolType(GTSpartan.ID, "katana", 3.5f, 0.5f, -2.0f, WeaponArchetype.KATANA));
    public static GTToolType SABER = register(new GTSPToolType(GTSpartan.ID, "saber", 3.5f, 0.5f, -1.6f, WeaponArchetype.SABER));
    public static GTToolType RAPIER = register(new GTSPToolType(GTSpartan.ID, "rapier", 2.0f, 0.5f, -1.5f, WeaponArchetype.RAPIER));
    public static GTToolType GREATSWORD = register(new GTSPToolType(GTSpartan.ID, "greatsword", 4.0f, 1.5f, -2.6f, WeaponArchetype.GREATSWORD));

    public static GTToolType BATTLE_HAMMER = register(new GTSPToolType(GTSpartan.ID, "battle_hammer", 5.0f, 2.0f, -3.2f, WeaponArchetype.BATTLE_HAMMER));
    public static GTToolType WARHAMMER = register(new GTSPToolType(GTSpartan.ID, "warhammer", 4.0f, 1.5f, -2.9f, WeaponArchetype.WARHAMMER));
    public static GTToolType SPEAR = register(new GTSPToolType(GTSpartan.ID, "spear", 5.5f, 0.5f, -2.6f, WeaponArchetype.SPEAR));
    public static GTToolType HALBERD = register(new GTSPToolType(GTSpartan.ID, "halberd", 5.0f, 1.5f, -2.8f, WeaponArchetype.HALBERD));
    public static GTToolType PIKE = register(new GTSPToolType(GTSpartan.ID, "pike", 4.0f, 1.0f, -3f, WeaponArchetype.PIKE));
    public static GTToolType LANCE = register(new GTSPToolType(GTSpartan.ID, "lance", 4.0f, 1.0f, -3f, WeaponArchetype.LANCE));
    //TODO:
    /**  Longbow
     *   Heavy Crossbow
     * */
    public static GTToolType THROWING_KNIFE = register(new GTSPToolType(GTSpartan.ID, "throwing_knife", 1.5f, 1.0f, -1.5f, WeaponArchetype.THROWING_KNIFE));
    public static GTToolType TOMAHAWK = register(new GTSPToolType(GTSpartan.ID, "tomahawk", 2.0f, 1.5f, -3.1f, WeaponArchetype.TOMAHAWK));
    public static GTToolType JAVELIN = register(new GTSPToolType(GTSpartan.ID, "javelin", 1.5f, 1.0f, -2.8f, WeaponArchetype.JAVELIN));
    public static GTToolType BOOMERANG = register(new GTSPToolType(GTSpartan.ID, "boomerang", 4.0f, 1.0f, -2.0f, WeaponArchetype.BOOMERANG)).setHasSecondary(false);
    public static GTToolType BATTLEAXE = register(new GTSPToolType(GTSpartan.ID, "battleaxe", 4.0f, 2.0f, -3f, WeaponArchetype.BATTLEAXE));
    public static GTToolType FLANGED_MACE = register(new GTSPToolType(GTSpartan.ID, "flanged_mace", 3.0f, 1.5f, -2.8f, WeaponArchetype.FLANGED_MACE));
    public static GTToolType GLAIVE = register(new GTSPToolType(GTSpartan.ID, "glaive", 4.0f, 1.5f, -3f, WeaponArchetype.GLAIVE));
    public static GTToolType QUARTERSTAFF = register(new GTSPToolType(GTSpartan.ID, "quarterstaff", 3.0f, 1.5f, -2.6f, WeaponArchetype.QUARTERSTAFF));





    public static void init(){
        BATTLEAXE.addBehaviour(BehaviourLogStripping.INSTANCE, BehaviourTreeFelling.INSTANCE);
        GTTools.SCYTHE.setOverlayLayers(2).setToolSupplier((domain2, toolType, tier, properties) -> {
            if (tier.getPrimary() == GTLibMaterials.NetherizedDiamond) properties.fireResistant();
            return new MaterialSwordSpartan(domain2, toolType, tier, properties, WeaponArchetype.SCYTHE, 1.0f);
        }).setUseDurability(1).setAttackDurability(1).setBaseAttackDamage(5.0f).setBaseAttackSpeed(-3.0f);
        tools.add(GTTools.SCYTHE);
        tools.forEach(t -> {
            t.addReplacement(GTLibMaterials.Iron, () -> ForgeRegistries.ITEMS.getValue(new ResourceLocation(SpartanWeaponryAPI.MOD_ID, "iron_" + t.getId())));
            t.addReplacement(GTLibMaterials.Gold, () -> ForgeRegistries.ITEMS.getValue(new ResourceLocation(SpartanWeaponryAPI.MOD_ID, "golden_" + t.getId())));
            t.addReplacement(GTLibMaterials.Diamond, () -> ForgeRegistries.ITEMS.getValue(new ResourceLocation(SpartanWeaponryAPI.MOD_ID, "diamond_" + t.getId())));
        });
    }

    private static GTToolType register(@NotNull GTToolType toolType){
        toolType = GTAPI.register(GTToolType.class, toolType);
        tools.add(toolType);
        return toolType;
    }
}
