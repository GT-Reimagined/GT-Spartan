package trinsdar.gtsp.data;

import com.oblivioussp.spartanweaponry.api.WeaponTraits;
import com.oblivioussp.spartanweaponry.init.ModItems;
import muramasa.antimatter.Data;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.material.MaterialItem;
import muramasa.antimatter.material.MaterialType;
import muramasa.antimatter.material.MaterialTypeItem;
import muramasa.antimatter.material.TextureSet;
import muramasa.antimatter.tool.AntimatterToolType;
import muramasa.antimatter.util.TagUtils;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import trinsdar.gtsp.Ref;
import trinsdar.gtsp.items.MaterialItemToolPart;
import trinsdar.gtsp.items.MaterialSwordSp;
import trinsdar.gtsp.tool.GTSPToolType;

import static com.google.common.collect.ImmutableMap.of;
import static muramasa.antimatter.Data.*;
import static muramasa.antimatter.Data.KNIFE;
import static muramasa.antimatter.Data.MORTAR;
import static muramasa.antimatter.material.Element.Fe;
import static net.minecraft.item.ItemTier.IRON;


public class Tools {

    public static AntimatterToolType DAGGER = new GTSPToolType(Ref.ID, "dagger", 2, 1, 10, 0.5F, -1.5F, WeaponTraits.THROWABLE).setToolClass(MaterialSwordSp.class);
    public static AntimatterToolType LONGSWORD = new GTSPToolType(Ref.ID, "longsword", 2, 1, 10, 3.5F, -2.6F, WeaponTraits.TWO_HANDED_1, WeaponTraits.SWEEP_DAMAGE_NORMAL).setToolClass(MaterialSwordSp.class).addEffectiveBlocks(Blocks.COBWEB).addToolTypes("sword");
    public static AntimatterToolType KATANA = new GTSPToolType(Ref.ID, "katana", 2, 1, 10, 0.5F, -2.0F, WeaponTraits.TWO_HANDED_1, WeaponTraits.EXTRA_DAMAGE_2_CHEST, WeaponTraits.SWEEP_DAMAGE_NORMAL).setToolClass(MaterialSwordSp.class).addEffectiveBlocks(Blocks.COBWEB).addToolTypes("sword");
    public static AntimatterToolType SABER = new GTSPToolType(Ref.ID, "saber", 2, 1, 10, 0.5F, -2.4F, WeaponTraits.DAMAGE_ABSORB_25, WeaponTraits.EXTRA_DAMAGE_2_CHEST, WeaponTraits.SWEEP_DAMAGE_NORMAL).setToolClass(MaterialSwordSp.class).addEffectiveBlocks(Blocks.COBWEB).addToolTypes("sword");
    public static AntimatterToolType RAPIER = new GTSPToolType(Ref.ID, "rapier", 2, 1, 10, -1.0F, -1.6F, WeaponTraits.DAMAGE_ABSORB_25, WeaponTraits.EXTRA_DAMAGE_3_NO_ARMOUR).setToolClass(MaterialSwordSp.class);
    public static AntimatterToolType GREATSWORD = new GTSPToolType(Ref.ID, "greatsword", 2, 1, 10, 3.0F, -2.6F, WeaponTraits.TWO_HANDED_2, WeaponTraits.REACH_1, WeaponTraits.SWEEP_DAMAGE_FULL).setToolClass(MaterialSwordSp.class).addEffectiveBlocks(Blocks.COBWEB).addToolTypes("sword");
    public static AntimatterToolType BATTLE_HAMMER = new GTSPToolType(Ref.ID, "battle_hammer", 2, 1, 10, 5.0F, -3.2F, WeaponTraits.KNOCKBACK, WeaponTraits.NAUSEA).setToolClass(MaterialSwordSp.class);
    public static AntimatterToolType WARHAMMER = new GTSPToolType(Ref.ID, "warhammer", 2, 1, 10, 3.0F, -2.9f, WeaponTraits.TWO_HANDED_1, WeaponTraits.ARMOUR_PIERCING_50).setToolClass(MaterialSwordSp.class);
    public static AntimatterToolType SPEAR = new GTSPToolType(Ref.ID, "spear", 2, 1, 10, 2.5F, -2.6F, WeaponTraits.REACH_1).setToolClass(MaterialSwordSp.class);
    public static AntimatterToolType HALBERD = new GTSPToolType(Ref.ID, "halberd", 2, 1, 10, 4.0F, -2.8F, WeaponTraits.TWO_HANDED_2, WeaponTraits.REACH_1, WeaponTraits.SHIELD_BREACH).setToolClass(MaterialSwordSp.class);
    public static AntimatterToolType PIKE = new GTSPToolType(Ref.ID, "pike", 2, 1, 10, 2.0F, -2.6F, WeaponTraits.TWO_HANDED_1, WeaponTraits.REACH_2).setToolClass(MaterialSwordSp.class);
    public static AntimatterToolType LANCE = new GTSPToolType(Ref.ID, "lance", 2, 1, 10, 2.0F, -3F, WeaponTraits.TWO_HANDED_2, WeaponTraits.REACH_1, WeaponTraits.SHIELD_BREACH).setToolClass(MaterialSwordSp.class);
    public static AntimatterToolType BATTLEAXE = new GTSPToolType(Ref.ID, "battleaxe", 2, 1, 10, 4.0F, -3F, WeaponTraits.TWO_HANDED_1, WeaponTraits.VERSATILE).setToolClass(MaterialSwordSp.class).addToolTypes("axe");
    public static AntimatterToolType FLANGED_MACE = new GTSPToolType(Ref.ID, "flanged_mace", 2, 1, 10, 2.0F, -2.8F, WeaponTraits.EXTRA_DAMAGE_50P_UNDEAD).setToolClass(MaterialSwordSp.class);
    public static AntimatterToolType GLAIVE = new GTSPToolType(Ref.ID, "glaive", 2, 1, 10, 3.0F, -3F, WeaponTraits.TWO_HANDED_1, WeaponTraits.REACH_1, WeaponTraits.SWEEP_DAMAGE_NORMAL).setToolClass(MaterialSwordSp.class);
    public static AntimatterToolType QUARTERSTAFF = new GTSPToolType(Ref.ID, "quarterstaff", 2, 1, 10, 2.0F, -2.6F, WeaponTraits.TWO_HANDED_1, WeaponTraits.SWEEP_DAMAGE_HALF).setToolClass(MaterialSwordSp.class);





    //TODO:
    /**  Dagger
     *   Rapier
     *   Battle Hammer
     *   Warhammer
     *   Spear
     *   Halberd
     *   Pike
     *   Lance
     *   Longbow
     *   Heavy Crossbow
     *   Throwing Knife
     *   Tomahawk
     *   Javelin
     *   Boomerang
     *   Battleaxe
     *   Flanged Mace
     *   Glaive
     *   Quarterstaff
     * */

    public static void init(){

    }
}
