package trinsdar.gtsp.items;

import com.oblivioussp.spartanweaponry.api.SpartanWeaponryAPI;
import muramasa.antimatter.datagen.providers.AntimatterItemModelProvider;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.material.MaterialItem;
import muramasa.antimatter.material.MaterialType;
import muramasa.antimatter.texture.Texture;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
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

    @Override
    public void onItemModelBuild(IItemProvider item, AntimatterItemModelProvider prov) {
        /*ItemModelBuilder builder = prov.getBuilder(item);
        builder.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(this.getParent())));
        for (int i = 0; i < getTextures().length; i++) {
            builder.texture("layer" + i, getTextures()[i]);
        }*/
    }
}
