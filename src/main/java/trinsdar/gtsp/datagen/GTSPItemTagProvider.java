package trinsdar.gtsp.datagen;

import muramasa.antimatter.datagen.ExistingFileHelperOverride;
import muramasa.antimatter.datagen.providers.AntimatterItemTagProvider;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;

public class GTSPItemTagProvider extends AntimatterItemTagProvider {
    public GTSPItemTagProvider(String providerDomain, String providerName, boolean replace, DataGenerator gen, BlockTagsProvider p, ExistingFileHelperOverride fh) {
        super(providerDomain, providerName, replace, gen, p, fh);
    }

    @Override
    public void registerTags() {
        super.registerTags();

    }

}
