package trinsdar.gtsp.data;

import com.oblivioussp.spartanweaponry.api.WeaponTraits;
import com.oblivioussp.spartanweaponry.util.WeaponArchetype;
import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.data.AntimatterDefaultTools;
import muramasa.antimatter.data.AntimatterMaterials;
import muramasa.antimatter.tool.AntimatterToolType;
import net.minecraft.world.level.block.Blocks;
import trinsdar.gtsp.GTSPRef;
import trinsdar.gtsp.items.MaterialSwordSpartan;
import trinsdar.gtsp.tool.GTSPToolType;


public class Tools {

    public static AntimatterToolType DAGGER = AntimatterAPI.register(AntimatterToolType.class, new GTSPToolType(GTSPRef.ID, "dagger", 2.5f, 1.0f, -1.5f, WeaponArchetype.DAGGER));
    public static AntimatterToolType PARRYING_DAGGER = AntimatterAPI.register(AntimatterToolType.class, new GTSPToolType(GTSPRef.ID, "parrying_dagger", 2.5f, 1.0f, -1.5f, WeaponArchetype.PARRYING_DAGGER));
    public static AntimatterToolType LONGSWORD = AntimatterAPI.register(AntimatterToolType.class, new GTSPToolType(GTSPRef.ID, "longsword", 4.5f, 1.5f, -2.6f, WeaponArchetype.LONGSWORD));
    public static AntimatterToolType KATANA = AntimatterAPI.register(AntimatterToolType.class, new GTSPToolType(GTSPRef.ID, "katana", 3.5f, 0.5f, -2.0f, WeaponArchetype.KATANA));
    public static AntimatterToolType SABER = AntimatterAPI.register(AntimatterToolType.class, new GTSPToolType(GTSPRef.ID, "saber", 3.5f, 0.5f, -1.6f, WeaponArchetype.SABER));
    public static AntimatterToolType RAPIER = AntimatterAPI.register(AntimatterToolType.class, new GTSPToolType(GTSPRef.ID, "rapier", 2.0f, 0.5f, -1.5f, WeaponArchetype.RAPIER));
    public static AntimatterToolType GREATSWORD = AntimatterAPI.register(AntimatterToolType.class, new GTSPToolType(GTSPRef.ID, "greatsword", 4.0f, 1.5f, -2.6f, WeaponArchetype.GREATSWORD));
    public static AntimatterToolType BATTLE_HAMMER = AntimatterAPI.register(AntimatterToolType.class, new GTSPToolType(GTSPRef.ID, "battle_hammer", 5.0f, 2.0f, -3.2f, WeaponArchetype.BATTLE_HAMMER));
    public static AntimatterToolType WARHAMMER = AntimatterAPI.register(AntimatterToolType.class, new GTSPToolType(GTSPRef.ID, "warhammer", 4.0f, 1.5f, -2.9f, WeaponArchetype.WARHAMMER));
    public static AntimatterToolType SPEAR = AntimatterAPI.register(AntimatterToolType.class, new GTSPToolType(GTSPRef.ID, "spear", 5.5f, 0.5f, -2.6f, WeaponArchetype.SPEAR));
    public static AntimatterToolType HALBERD = AntimatterAPI.register(AntimatterToolType.class, new GTSPToolType(GTSPRef.ID, "halberd", 5.0f, 1.5f, -2.8f, WeaponArchetype.HALBERD));
    public static AntimatterToolType PIKE = AntimatterAPI.register(AntimatterToolType.class, new GTSPToolType(GTSPRef.ID, "pike", 4.0f, 1.0f, -3f, WeaponArchetype.PIKE));
    public static AntimatterToolType LANCE = AntimatterAPI.register(AntimatterToolType.class, new GTSPToolType(GTSPRef.ID, "lance", 4.0f, 1.0f, -3f, WeaponArchetype.LANCE));
    //TODO:
    /**  Longbow
     *   Heavy Crossbow
     *   Throwing Knife
     *   Tomahawk
     *   Javelin
     *   Boomerang
     * */
    public static AntimatterToolType BATTLEAXE = AntimatterAPI.register(AntimatterToolType.class, new GTSPToolType(GTSPRef.ID, "battleaxe", 4.0f, 2.0f, -3f, WeaponArchetype.BATTLEAXE));
    public static AntimatterToolType FLANGED_MACE = AntimatterAPI.register(AntimatterToolType.class, new GTSPToolType(GTSPRef.ID, "flanged_mace", 3.0f, 1.5f, -2.8f, WeaponArchetype.FLANGED_MACE));
    public static AntimatterToolType GLAIVE = AntimatterAPI.register(AntimatterToolType.class, new GTSPToolType(GTSPRef.ID, "glaive", 4.0f, 1.5f, -3f, WeaponArchetype.GLAIVE));
    public static AntimatterToolType QUARTERSTAFF = AntimatterAPI.register(AntimatterToolType.class, new GTSPToolType(GTSPRef.ID, "quarterstaff", 3.0f, 1.5f, -2.6f, WeaponArchetype.QUARTERSTAFF));



    public static void init(){
        //BATTLEAXE.addBehaviour(BehaviourLogStripping.INSTANCE, BehaviourTreeFelling.INSTANCE);
        AntimatterDefaultTools.SCYTHE.setOverlayLayers(2).setToolSupplier((domain2, toolType, tier, properties) -> {
            if (tier.getPrimary() == AntimatterMaterials.NetherizedDiamond) properties.fireResistant();
            return new MaterialSwordSpartan(domain2, toolType, tier, properties, WeaponArchetype.SCYTHE, 5.0f, 1.0f, 1.0f);
        });
    }
}
