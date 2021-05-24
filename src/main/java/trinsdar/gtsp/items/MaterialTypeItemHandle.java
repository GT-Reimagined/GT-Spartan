package trinsdar.gtsp.items;

import muramasa.antimatter.material.Material;
import muramasa.antimatter.material.MaterialTypeItem;
import muramasa.antimatter.util.TagUtils;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;

public class MaterialTypeItemHandle extends MaterialTypeItem<MaterialTypeItemHandle> {
    public MaterialTypeItemHandle(String id, int layers, boolean visible, int unitValue, ItemSupplier itemSupplier) {
        super(id, layers, visible, unitValue, itemSupplier);
    }

    @Override
    @SuppressWarnings("unchecked")
    public ITag.INamedTag<Item> getMaterialTag(Material m) {
        return (ITag.INamedTag<Item>) this.tagFromString(String.join("", "handle", "/", m.getId()));
    }

    @Override
    protected ITag.INamedTag<?> tagFromString(String name) {
        return TagUtils.getForgeItemTag(name.replace("_sp", ""));
    }
}
