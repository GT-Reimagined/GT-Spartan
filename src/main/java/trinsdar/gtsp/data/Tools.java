package trinsdar.gtsp.data;

import com.oblivioussp.spartanweaponry.api.WeaponTraits;
import muramasa.antimatter.tool.AntimatterToolType;
import muramasa.antimatter.tool.behaviour.BehaviourLogStripping;
import muramasa.antimatter.tool.behaviour.BehaviourTreeFelling;
import net.minecraft.block.Blocks;
import trinsdar.gtsp.Ref;
import trinsdar.gtsp.items.MaterialSwordSp;
import trinsdar.gtsp.tool.GTSPToolType;

import static muramasa.antimatter.Data.AXE;
import static net.minecraft.block.material.Material.BAMBOO;
import static net.minecraft.block.material.Material.PLANT;
import static net.minecraft.block.material.Material.REPLACEABLE_PLANT;
import static net.minecraft.block.material.Material.WOOD;


public class Tools {

    public static AntimatterToolType DAGGER = new GTSPToolType(Ref.ID, "dagger", 2, 1, 10, 1.5F, -1.5F, WeaponTraits.THROWABLE).setToolClass(MaterialSwordSp.class).addEffectiveBlocks(Blocks.COBWEB).addToolTypes("sword");
    public static AntimatterToolType LONGSWORD = new GTSPToolType(Ref.ID, "longsword", 2, 1, 10, 4.5F, -2.6F, WeaponTraits.TWO_HANDED_1, WeaponTraits.SWEEP_DAMAGE_NORMAL).setToolClass(MaterialSwordSp.class).addEffectiveBlocks(Blocks.COBWEB).addToolTypes("sword");
    public static AntimatterToolType KATANA = new GTSPToolType(Ref.ID, "katana", 2, 1, 10, 1.5F, -2.0F, WeaponTraits.TWO_HANDED_1, WeaponTraits.EXTRA_DAMAGE_2_CHEST, WeaponTraits.SWEEP_DAMAGE_NORMAL).setToolClass(MaterialSwordSp.class).addEffectiveBlocks(Blocks.COBWEB).addToolTypes("sword");
    public static AntimatterToolType SABER = new GTSPToolType(Ref.ID, "saber", 2, 1, 10, 1.5F, -2.4F, WeaponTraits.DAMAGE_ABSORB_25, WeaponTraits.EXTRA_DAMAGE_2_CHEST, WeaponTraits.SWEEP_DAMAGE_NORMAL).setToolClass(MaterialSwordSp.class).addEffectiveBlocks(Blocks.COBWEB).addToolTypes("sword");
    public static AntimatterToolType RAPIER = new GTSPToolType(Ref.ID, "rapier", 2, 1, 10, 0.0F, -1.6F, WeaponTraits.DAMAGE_ABSORB_25, WeaponTraits.EXTRA_DAMAGE_3_NO_ARMOUR).setToolClass(MaterialSwordSp.class).addEffectiveBlocks(Blocks.COBWEB).addToolTypes("sword");
    public static AntimatterToolType GREATSWORD = new GTSPToolType(Ref.ID, "greatsword", 2, 1, 10, 4.0F, -2.6F, WeaponTraits.TWO_HANDED_2, WeaponTraits.REACH_1, WeaponTraits.SWEEP_DAMAGE_FULL).setToolClass(MaterialSwordSp.class).addEffectiveBlocks(Blocks.COBWEB).addToolTypes("sword");
    public static AntimatterToolType BATTLE_HAMMER = new GTSPToolType(Ref.ID, "battle_hammer", 2, 1, 10, 6.0F, -3.2F, WeaponTraits.KNOCKBACK, WeaponTraits.NAUSEA).setToolClass(MaterialSwordSp.class);
    public static AntimatterToolType WARHAMMER = new GTSPToolType(Ref.ID, "warhammer", 2, 1, 10, 4.0F, -2.9f, WeaponTraits.TWO_HANDED_1, WeaponTraits.ARMOUR_PIERCING_50).setToolClass(MaterialSwordSp.class);
    public static AntimatterToolType SPEAR = new GTSPToolType(Ref.ID, "spear", 2, 1, 10, 3.5F, -2.6F, WeaponTraits.REACH_1).setToolClass(MaterialSwordSp.class).addEffectiveBlocks(Blocks.COBWEB).addToolTypes("sword");
    public static AntimatterToolType HALBERD = new GTSPToolType(Ref.ID, "halberd", 2, 1, 10, 5.0F, -2.8F, WeaponTraits.TWO_HANDED_2, WeaponTraits.REACH_1, WeaponTraits.SHIELD_BREACH).setToolClass(MaterialSwordSp.class).addEffectiveBlocks(Blocks.COBWEB).addToolTypes("sword");
    public static AntimatterToolType PIKE = new GTSPToolType(Ref.ID, "pike", 2, 1, 10, 3.0F, -2.6F, WeaponTraits.TWO_HANDED_1, WeaponTraits.REACH_2).setToolClass(MaterialSwordSp.class).addEffectiveBlocks(Blocks.COBWEB).addToolTypes("sword");
    public static AntimatterToolType LANCE = new GTSPToolType(Ref.ID, "lance", 2, 1, 10, 3.0F, -3F, WeaponTraits.TWO_HANDED_2, WeaponTraits.REACH_1, WeaponTraits.SHIELD_BREACH).setToolClass(MaterialSwordSp.class).addEffectiveBlocks(Blocks.COBWEB).addToolTypes("sword");
    public static AntimatterToolType BATTLEAXE = new GTSPToolType(Ref.ID, "battleaxe", 2, 1, 10, 5.0F, -3F, WeaponTraits.TWO_HANDED_1, WeaponTraits.VERSATILE).setToolClass(MaterialSwordSp.class).addToolTypes("axe").setTag(AXE).addEffectiveMaterials(WOOD, PLANT, REPLACEABLE_PLANT, BAMBOO);
    public static AntimatterToolType FLANGED_MACE = new GTSPToolType(Ref.ID, "flanged_mace", 2, 1, 10, 3.0F, -2.8F, WeaponTraits.EXTRA_DAMAGE_50P_UNDEAD).setToolClass(MaterialSwordSp.class);
    public static AntimatterToolType GLAIVE = new GTSPToolType(Ref.ID, "glaive", 2, 1, 10, 4.0F, -3F, WeaponTraits.TWO_HANDED_1, WeaponTraits.REACH_1, WeaponTraits.SWEEP_DAMAGE_NORMAL).setToolClass(MaterialSwordSp.class).addEffectiveBlocks(Blocks.COBWEB).addToolTypes("sword");
    public static AntimatterToolType QUARTERSTAFF = new GTSPToolType(Ref.ID, "quarterstaff", 2, 1, 10, 3.0F, -2.6F, WeaponTraits.TWO_HANDED_1, WeaponTraits.SWEEP_DAMAGE_HALF).setToolClass(MaterialSwordSp.class);





    //TODO:
    /**  Longbow
     *   Heavy Crossbow
     *   Throwing Knife
     *   Tomahawk
     *   Javelin
     *   Boomerang
     * */

    public static void init(){
        BATTLEAXE.addBehaviour(BehaviourLogStripping.INSTANCE, BehaviourTreeFelling.INSTANCE);
    }
}
