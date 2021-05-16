package trinsdar.gtsp.items;

import com.oblivioussp.spartanweaponry.api.SpartanWeaponryAPI;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.material.MaterialItem;
import muramasa.antimatter.material.MaterialType;
import muramasa.antimatter.texture.Texture;
import trinsdar.gtsp.Ref;

import static trinsdar.gtsp.data.Tools.POLE;

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
}
