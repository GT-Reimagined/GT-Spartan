package trinsdar.gtsp.data;

import muramasa.antimatter.material.Material;
import muramasa.antimatter.material.MaterialItem;
import muramasa.antimatter.material.MaterialType;
import muramasa.antimatter.material.MaterialTypeItem;
import muramasa.antimatter.tool.AntimatterToolType;
import muramasa.antimatter.util.TagUtils;
import muramasa.antimatter.util.Utils;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import trinsdar.gtsp.Ref;
import trinsdar.gtsp.items.MaterialItemToolPart;
import trinsdar.gtsp.items.MaterialSwordBig;
import trinsdar.gtsp.tool.GTSPToolType;


public class Tools {

    public static MaterialTypeItem<?> POLE = new MaterialTypeItem<>("pole", 1, true, muramasa.antimatter.Ref.U * 2, new MaterialTypeItem.ItemSupplier() {
        @Override
        public MaterialItem supply(String domain, MaterialType<?> type, Material material) {
            return new MaterialItemToolPart(domain, type, material, new Item.Properties().group(muramasa.antimatter.Ref.TAB_MATERIALS));
        }
    });

    public static MaterialTypeItem<?> HANDLE = new MaterialTypeItem<>("handle_sp", 1, true, muramasa.antimatter.Ref.U * 2, new MaterialTypeItem.ItemSupplier() {
        @Override
        public MaterialItem supply(String domain, MaterialType<?> type, Material material) {
            return new MaterialItemToolPart(domain, type, material, new Item.Properties().group(muramasa.antimatter.Ref.TAB_MATERIALS));
        }
    });
    public static AntimatterToolType GREATSWORD = new GTSPToolType(Ref.ID, "greatsword", 2, 1, 10, 4.0F, -2.6F).setToolClass(MaterialSwordBig.class).addEffectiveBlocks(Blocks.COBWEB).addToolTypes("sword");
    public static AntimatterToolType KATANA = new GTSPToolType(Ref.ID, "katana", 2, 1, 10, 1.5F, -2.0F).setToolClass(MaterialSwordBig.class).addEffectiveBlocks(Blocks.COBWEB).addToolTypes("sword");
    public static AntimatterToolType LONGSWORD = new GTSPToolType(Ref.ID, "longsword", 2, 1, 10, 4.5F, -2.6F).setToolClass(MaterialSwordBig.class).addEffectiveBlocks(Blocks.COBWEB).addToolTypes("sword");
    public static AntimatterToolType SABER = new GTSPToolType(Ref.ID, "saber", 2, 1, 10, 1.5F, -2.4F).setToolClass(MaterialSwordBig.class).addEffectiveBlocks(Blocks.COBWEB).addToolTypes("sword");

    public static void init(){

    }
}
