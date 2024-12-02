package trinsdar.gtsp.data;

import com.oblivioussp.spartanweaponry.init.ModItems;
import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.material.MaterialTypeItem;
import net.minecraft.world.item.Item;
import trinsdar.gtsp.items.MaterialItemToolPart;

public class MaterialTypes {
    public static MaterialTypeItem<?> POLE = AntimatterAPI.register(MaterialTypeItem.class, new MaterialTypeItem<>("pole", 1, true, muramasa.antimatter.Ref.U * 2, (domain, type, material) -> new MaterialItemToolPart(domain, type, material, new Item.Properties().tab(muramasa.antimatter.Ref.TAB_MATERIALS))));
    public static MaterialTypeItem<?> HANDLE = AntimatterAPI.register(MaterialTypeItem.class, new MaterialTypeItem<>("handle", 1, true, muramasa.antimatter.Ref.U * 2));

    public static void init(){
        POLE.setIgnoreTextureSets();
        HANDLE.setIgnoreTextureSets();
    }
}
