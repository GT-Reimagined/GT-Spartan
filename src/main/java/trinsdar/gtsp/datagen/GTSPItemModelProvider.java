package trinsdar.gtsp.datagen;

import muramasa.antimatter.datagen.providers.AntimatterItemModelProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import trinsdar.gtsp.items.IMaterialItemSpartan;

public class GTSPItemModelProvider extends AntimatterItemModelProvider {

    public GTSPItemModelProvider(String providerDomain, String providerName, DataGenerator gen, String... domains) {
        super(providerDomain, providerName, gen, domains);
    }

    public ItemModelBuilder tex(IItemProvider item, String parent, ResourceLocation... textures) {
        if (item.asItem() instanceof IMaterialItemSpartan){
            ItemModelBuilder builder = getBuilder(item);
            builder.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(((IMaterialItemSpartan)item.asItem()).getParent())));
            for (int i = 0; i < textures.length; i++) {
                builder.texture("layer" + i, textures[i]);
            }
            return builder;
        }
        return super.tex(item, parent, textures);
    }
}
