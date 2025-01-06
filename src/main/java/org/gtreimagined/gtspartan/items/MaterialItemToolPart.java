package org.gtreimagined.gtspartan.items;

import com.oblivioussp.spartanweaponry.api.SpartanWeaponryAPI;
import muramasa.antimatter.datagen.providers.AntimatterItemModelProvider;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.material.MaterialItem;
import muramasa.antimatter.material.MaterialType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;

import static org.gtreimagined.gtspartan.data.MaterialTypes.POLE;


public class MaterialItemToolPart extends MaterialItem implements IMaterialItemSpartan {
    public MaterialItemToolPart(String domain, MaterialType<?> type, Material material, Properties properties) {
        super(domain, type, material, properties);
    }

    @Override
    public String getParent() {
        if (type == POLE){
            return SpartanWeaponryAPI.MOD_ID + ":item/pole";
        }
        return "minecraft:item/handheld";
    }

    @Override
    public void onItemModelBuild(ItemLike item, AntimatterItemModelProvider prov) {
        var builder = prov.getAntimatterBuilder(item);
        builder.parent(new ResourceLocation(getParent()));
        for (int i = 0; i < getTextures().length; i++) {
            builder.texture("layer" + i, getTextures()[i]);
        }
    }
}
