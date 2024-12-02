package trinsdar.gtsp.data;

import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.tool.AntimatterToolType;
import trinsdar.gtsp.GTSPRef;


public class Tools {

    public static AntimatterToolType DAGGER = AntimatterAPI.register(AntimatterToolType.class, new AntimatterToolType(GTSPRef.ID, "dagger", 2, 1, 10, 1.5f, -1.5f, false));
    public static AntimatterToolType PARRYING_DAGGER = AntimatterAPI.register(AntimatterToolType.class, new AntimatterToolType(GTSPRef.ID, "parrying_dagger", 2, 1, 10, 1.5f, -1.5f, false));
    public static AntimatterToolType LONGSWORD = AntimatterAPI.register(AntimatterToolType.class, new AntimatterToolType(GTSPRef.ID, "longsword", 2, 1, 10, 4.5f, -2.6f, false));
    public static AntimatterToolType KATANA = AntimatterAPI.register(AntimatterToolType.class, new AntimatterToolType(GTSPRef.ID, "katana", 2, 1, 10, 1.5f, -2.0f, false));
    public static AntimatterToolType SABER = AntimatterAPI.register(AntimatterToolType.class, new AntimatterToolType(GTSPRef.ID, "saber", 2, 1, 10, 0.0f, -1.6f, false));
    public static AntimatterToolType RAPIER = AntimatterAPI.register(AntimatterToolType.class, new AntimatterToolType(GTSPRef.ID, "rapier", 2, 1, 10, 1.5f, -1.5f, false));
    public static AntimatterToolType GREATSWORD = AntimatterAPI.register(AntimatterToolType.class, new AntimatterToolType(GTSPRef.ID, "greatsword", 2, 1, 10, 4.0f, -2.6f, false));
    public static AntimatterToolType BATTLE_HAMMER = AntimatterAPI.register(AntimatterToolType.class, new AntimatterToolType(GTSPRef.ID, "battle_hammer", 2, 1, 10, 6.0f, -3.2f, false));
    public static AntimatterToolType WARHAMMER = AntimatterAPI.register(AntimatterToolType.class, new AntimatterToolType(GTSPRef.ID, "warhammer", 2, 1, 10, 4.0f, -2.9f, false));
    /*public static AntimatterToolType DAGGER = new GTSPToolType(GTSPRef.ID, "dagger", 2, 1, 10, 1.5F, -1.5F, WeaponTraits.THROWABLE).setToolClass(MaterialSwordSp.class).addEffectiveBlocks(Blocks.COBWEB).addToolTypes("sword");
    public static AntimatterToolType LONGSWORD = new GTSPToolType(GTSPRef.ID, "longsword", 2, 1, 10, 4.5F, -2.6F, WeaponTraits.TWO_HANDED_1, WeaponTraits.SWEEP_DAMAGE_NORMAL).setToolClass(MaterialSwordSp.class).addEffectiveBlocks(Blocks.COBWEB).addToolTypes("sword");
    public static AntimatterToolType KATANA = new GTSPToolType(GTSPRef.ID, "katana", 2, 1, 10, 1.5F, -2.0F, WeaponTraits.TWO_HANDED_1, WeaponTraits.EXTRA_DAMAGE_2_CHEST, WeaponTraits.SWEEP_DAMAGE_NORMAL).setToolClass(MaterialSwordSp.class).addEffectiveBlocks(Blocks.COBWEB).addToolTypes("sword");
    public static AntimatterToolType SABER = new GTSPToolType(GTSPRef.ID, "saber", 2, 1, 10, 1.5F, -2.4F, WeaponTraits.DAMAGE_ABSORB_25, WeaponTraits.EXTRA_DAMAGE_2_CHEST, WeaponTraits.SWEEP_DAMAGE_NORMAL).setToolClass(MaterialSwordSp.class).addEffectiveBlocks(Blocks.COBWEB).addToolTypes("sword");
    public static AntimatterToolType RAPIER = new GTSPToolType(GTSPRef.ID, "rapier", 2, 1, 10, 0.0F, -1.6F, WeaponTraits.DAMAGE_ABSORB_25, WeaponTraits.EXTRA_DAMAGE_3_NO_ARMOUR).setToolClass(MaterialSwordSp.class).addEffectiveBlocks(Blocks.COBWEB).addToolTypes("sword");
    public static AntimatterToolType GREATSWORD = new GTSPToolType(GTSPRef.ID, "greatsword", 2, 1, 10, 4.0F, -2.6F, WeaponTraits.TWO_HANDED_2, WeaponTraits.REACH_1, WeaponTraits.SWEEP_DAMAGE_FULL).setToolClass(MaterialSwordSp.class).addEffectiveBlocks(Blocks.COBWEB).addToolTypes("sword");
    public static AntimatterToolType BATTLE_HAMMER = new GTSPToolType(GTSPRef.ID, "battle_hammer", 2, 1, 10, 6.0F, -3.2F, WeaponTraits.KNOCKBACK, WeaponTraits.NAUSEA).setToolClass(MaterialSwordSp.class);
    public static AntimatterToolType WARHAMMER = new GTSPToolType(GTSPRef.ID, "warhammer", 2, 1, 10, 4.0F, -2.9f, WeaponTraits.TWO_HANDED_1, WeaponTraits.ARMOUR_PIERCING_50).setToolClass(MaterialSwordSp.class);
    public static AntimatterToolType SPEAR = new GTSPToolType(GTSPRef.ID, "spear", 2, 1, 10, 3.5F, -2.6F, WeaponTraits.REACH_1).setToolClass(MaterialSwordSp.class).addEffectiveBlocks(Blocks.COBWEB).addToolTypes("sword");
    public static AntimatterToolType HALBERD = new GTSPToolType(GTSPRef.ID, "halberd", 2, 1, 10, 5.0F, -2.8F, WeaponTraits.TWO_HANDED_2, WeaponTraits.REACH_1, WeaponTraits.SHIELD_BREACH).setToolClass(MaterialSwordSp.class).addEffectiveBlocks(Blocks.COBWEB).addToolTypes("sword");
    public static AntimatterToolType PIKE = new GTSPToolType(GTSPRef.ID, "pike", 2, 1, 10, 3.0F, -2.6F, WeaponTraits.TWO_HANDED_1, WeaponTraits.REACH_2).setToolClass(MaterialSwordSp.class).addEffectiveBlocks(Blocks.COBWEB).addToolTypes("sword");
    public static AntimatterToolType LANCE = new GTSPToolType(GTSPRef.ID, "lance", 2, 1, 10, 3.0F, -3F, WeaponTraits.TWO_HANDED_2, WeaponTraits.REACH_1, WeaponTraits.SHIELD_BREACH).setToolClass(MaterialSwordSp.class).addEffectiveBlocks(Blocks.COBWEB).addToolTypes("sword");
    public static AntimatterToolType BATTLEAXE = new GTSPToolType(GTSPRef.ID, "battleaxe", 2, 1, 10, 5.0F, -3F, WeaponTraits.TWO_HANDED_1, WeaponTraits.VERSATILE).setToolClass(MaterialSwordSp.class).addToolTypes("axe").setTag(AXE).addEffectiveMaterials(WOOD, PLANT, REPLACEABLE_PLANT, BAMBOO);
    public static AntimatterToolType FLANGED_MACE = new GTSPToolType(GTSPRef.ID, "flanged_mace", 2, 1, 10, 3.0F, -2.8F, WeaponTraits.EXTRA_DAMAGE_50P_UNDEAD).setToolClass(MaterialSwordSp.class);
    public static AntimatterToolType GLAIVE = new GTSPToolType(GTSPRef.ID, "glaive", 2, 1, 10, 4.0F, -3F, WeaponTraits.TWO_HANDED_1, WeaponTraits.REACH_1, WeaponTraits.SWEEP_DAMAGE_NORMAL).setToolClass(MaterialSwordSp.class).addEffectiveBlocks(Blocks.COBWEB).addToolTypes("sword");
    public static AntimatterToolType QUARTERSTAFF = new GTSPToolType(GTSPRef.ID, "quarterstaff", 2, 1, 10, 3.0F, -2.6F, WeaponTraits.TWO_HANDED_1, WeaponTraits.SWEEP_DAMAGE_HALF).setToolClass(MaterialSwordSp.class);*/





    //TODO:
    /**  Longbow
     *   Heavy Crossbow
     *   Throwing Knife
     *   Tomahawk
     *   Javelin
     *   Boomerang
     * */

    public static void init(){
        //BATTLEAXE.addBehaviour(BehaviourLogStripping.INSTANCE, BehaviourTreeFelling.INSTANCE);
    }
}
