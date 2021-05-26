package trinsdar.gtsp.data;

import com.oblivioussp.spartanweaponry.init.ModItems;
import muramasa.antimatter.Antimatter;
import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.Data;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.material.MaterialItem;
import muramasa.antimatter.material.MaterialTag;
import muramasa.antimatter.material.MaterialType;
import muramasa.antimatter.material.MaterialTypeItem;
import muramasa.antimatter.material.TextureSet;
import muramasa.antimatter.util.TagUtils;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import trinsdar.gtsp.Ref;
import trinsdar.gtsp.items.MaterialItemToolPart;
import trinsdar.gtsp.items.MaterialTypeItemHandle;

import static com.google.common.collect.ImmutableMap.of;
import static muramasa.antimatter.Data.*;
import static muramasa.antimatter.Data.KNIFE;
import static muramasa.antimatter.Data.MORTAR;
import static muramasa.antimatter.Data.PLATE;
import static muramasa.antimatter.material.Element.Fe;
import static net.minecraft.item.ItemTier.IRON;

public class Materials {
    public static MaterialTypeItem<?> POLE = new MaterialTypeItem<>("pole", 1, true, muramasa.antimatter.Ref.U * 2, (domain, type, material) -> new MaterialItemToolPart(Ref.ID, type, material, new Item.Properties().group(muramasa.antimatter.Ref.TAB_MATERIALS)));
    //public static MaterialTypeItem<MaterialTypeItemHandle> HANDLE = new MaterialTypeItemHandle("handle_sp", 1, true, muramasa.antimatter.Ref.U * 2, (domain, type, material) -> new MaterialItemToolPart(Ref.ID, type, material, new Item.Properties().group(muramasa.antimatter.Ref.TAB_MATERIALS)));
    public static MaterialTypeItem<?> HANDLE = new MaterialTypeItem<>("handle", 1, true, muramasa.antimatter.Ref.U * 2, (domain, type, material) -> new MaterialItemToolPart(Ref.ID, type, material, new Item.Properties().group(muramasa.antimatter.Ref.TAB_MATERIALS)));

    //public static Material Iron = new Material(Ref.ID, "iron", 0xc8c8c8, TextureSet.NONE, Fe).asMetal(1811, 500, ORE, PLATE, ROD).asPlasma().addTools(IRON.getAttackDamage(), IRON.getEfficiency(), 256, IRON.getHarvestLevel());
    //public static Material TungstenSteel = new Material(Ref.ID, "tungstensteel", 0x6464a0, TextureSet.NONE).asMetal(3000, 3000, PLATE, ROD, GEAR).addTools(6.0F, 10.0F, 5120, 4);
    //public static Material Flint = new Material(Ref.ID, "flint", 0x002040, TextureSet.NONE).asDust(GEM).addTools(1.25F, 2.5F, 128, 1, of(Enchantments.FIRE_ASPECT, 1), PICKAXE, AXE, SHOVEL, SWORD, HOE, MORTAR, KNIFE);
    //public static Material Wood = new Material(Ref.ID, "wood", 0x643200, TextureSet.NONE).asDust(PLATE).addHandleStat(12, 0.0F);


    public static void init(){
        Data.Stone.flags(HANDLE, POLE);
        MaterialTag.HANDLE.all().forEach(m -> {
            if (m.getId().equals("wood") || m == Data.NULL) return;
            m.flags(HANDLE, POLE);
        });
    }
}