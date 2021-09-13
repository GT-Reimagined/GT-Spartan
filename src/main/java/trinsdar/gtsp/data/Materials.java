package trinsdar.gtsp.data;

import muramasa.antimatter.Data;
import muramasa.antimatter.material.MaterialTag;
import muramasa.antimatter.material.MaterialTypeItem;
import net.minecraft.item.Item;
import trinsdar.gtsp.Ref;
import trinsdar.gtsp.items.MaterialItemToolPart;

public class Materials {
    public static MaterialTypeItem<?> POLE = new MaterialTypeItem<>("pole", 1, true, muramasa.antimatter.Ref.U * 2, (domain, type, material) -> new MaterialItemToolPart(Ref.ID, type, material, new Item.Properties().group(muramasa.antimatter.Ref.TAB_MATERIALS)));
    public static MaterialTypeItem<?> HANDLE = new MaterialTypeItem<>("handle", 1, true, muramasa.antimatter.Ref.U * 2, (domain, type, material) -> new MaterialItemToolPart(Ref.ID, type, material, new Item.Properties().group(muramasa.antimatter.Ref.TAB_MATERIALS)));

    //public static Material Iron = new Material(Ref.ID, "iron", 0xc8c8c8, TextureSet.NONE, Fe).asMetal(1811, 500, ORE, PLATE, ROD).asPlasma().addTools(IRON.getAttackDamage(), IRON.getEfficiency(), 256, IRON.getHarvestLevel());
    //public static Material TungstenSteel = new Material(Ref.ID, "tungstensteel", 0x6464a0, TextureSet.NONE).asMetal(3000, 3000, PLATE, ROD, GEAR).addTools(6.0F, 10.0F, 5120, 4);
    //public static Material Flint = new Material(Ref.ID, "flint", 0x002040, TextureSet.NONE).asDust(GEM).addTools(1.25F, 2.5F, 128, 1, of(Enchantments.FIRE_ASPECT, 1), PICKAXE, AXE, SHOVEL, SWORD, HOE, MORTAR, KNIFE);
    //public static Material Wood = new Material(Ref.ID, "wood", 0x643200, TextureSet.NONE).asDust(PLATE).addHandleStat(12, 0.0F);
    //public static Material Netherite = new Material(Ref.ID, "netherite", 0x504650, TextureSet.NONE).asMetal(2246,1300, PLATE, ROD).addTools(3.0F, 10, 500, NETHERITE.getHarvestLevel(), of(Enchantments.FIRE_ASPECT, 3)).addArmor(new int[]{0, 1, 1, 0}, 0.5F, 0.1F, 20);

    public static void init(){
        Data.Stone.flags(HANDLE, POLE);
        MaterialTag.HANDLE.all().forEach(m -> {
            if (m.getId().equals("wood") || m == Data.NULL) return;
            m.flags(HANDLE, POLE);
        });
    }
}
