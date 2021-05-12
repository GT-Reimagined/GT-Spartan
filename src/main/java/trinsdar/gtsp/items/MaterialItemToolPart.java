package trinsdar.gtsp.items;

import muramasa.antimatter.material.Material;
import muramasa.antimatter.material.MaterialItem;
import muramasa.antimatter.material.MaterialType;
import muramasa.antimatter.texture.Texture;
import trinsdar.gtsp.Ref;

public class MaterialItemToolPart extends MaterialItem {
    public MaterialItemToolPart(String domain, MaterialType<?> type, Material material, Properties properties) {
        super(domain, type, material, properties);
    }

    public Texture[] getTextures() {
        return new Texture[]{new Texture(Ref.ID, "material/" + type.getId()), new Texture(Ref.ID, "material/" + type.getId() + "_overlay")};
    }
}
