package org.gtreimagined.gtspartan.data;

import com.oblivioussp.spartanweaponry.init.ModItems;
import net.minecraft.world.item.Item;
import org.gtreimagined.gtlib.GTAPI;
import org.gtreimagined.gtlib.Ref;
import org.gtreimagined.gtlib.material.MaterialTypeItem;
import org.gtreimagined.gtspartan.items.MaterialItemToolPart;

import static org.gtreimagined.gtlib.data.GTLibMaterials.Wood;


public class MaterialTypes {
    public static MaterialTypeItem<?> POLE = GTAPI.register(MaterialTypeItem.class, new MaterialTypeItem<>("pole", 1, true, Ref.U * 2, (domain, type, material) -> new MaterialItemToolPart(domain, type, material, new Item.Properties().tab(Ref.TAB_MATERIALS))));
    public static MaterialTypeItem<?> HANDLE = GTAPI.register(MaterialTypeItem.class, new MaterialTypeItem<>("handle", 1, true, Ref.U * 2));

    public static void init(){
        POLE.setIgnoreTextureSets();
        HANDLE.setIgnoreTextureSets();
        HANDLE.replacement(Wood, ModItems.HANDLE);
        POLE.replacement(Wood, ModItems.POLE);
    }
}
