package trinsdar.gtsp.items;

import com.oblivioussp.spartanweaponry.api.SpartanWeaponryAPI;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.material.MaterialItem;
import muramasa.antimatter.material.MaterialType;
import muramasa.antimatter.texture.Texture;
import muramasa.antimatter.util.TagUtils;
import muramasa.antimatter.util.Utils;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import trinsdar.gtsp.Ref;

import static trinsdar.gtsp.data.Materials.POLE;

public class MaterialItemToolPart extends MaterialItem implements IMaterialItemSpartan {
    public MaterialItemToolPart(String domain, MaterialType<?> type, Material material, Properties properties) {
        super(domain, type, material, properties);
    }

    public Texture[] getTextures() {
        return new Texture[]{new Texture(Ref.ID, "material/" + type.getId()), new Texture(Ref.ID, "material/" + type.getId() + "_overlay")};
    }

    @Override
    public String getParent() {
        if (type == POLE){
            return SpartanWeaponryAPI.MOD_ID + ":item/pole";
        }
        return "minecraft:item/handheld";
    }

    public ITag.INamedTag<Item> getTag() {
        return TagUtils.getForgeItemTag(String.join("", Utils.getConventionalMaterialType(type), "/", material.getId()).replace("_sp", ""));
    }
}
