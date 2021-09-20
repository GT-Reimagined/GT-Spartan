package trinsdar.gtsp.datagen;

import muramasa.antimatter.datagen.providers.AntimatterItemModelProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
import trinsdar.gtsp.items.IMaterialItemSpartan;

public class GTSPItemModelProvider extends AntimatterItemModelProvider {

    public GTSPItemModelProvider(String providerDomain, String providerName, DataGenerator gen, String... domains) {
        super(providerDomain, providerName, gen, domains);
    }

    public ItemModelBuilder tex(IItemProvider item, String parent, ResourceLocation... textures) {
        return super.tex(item, parent, textures);
    }
}
