package org.gtreimagined.gtspartan.datagen;

import com.oblivioussp.spartanweaponry.api.tags.ModItemTags;
import com.oblivioussp.spartanweaponry.init.ModItems;
import org.gtreimagined.gtlib.data.GTTools;
import org.gtreimagined.gtlib.datagen.providers.GTBlockTagProvider;
import org.gtreimagined.gtlib.datagen.providers.GTItemTagProvider;
import org.gtreimagined.gtlib.util.TagUtils;

public class GTSPItemTagProvider extends GTItemTagProvider {
    public GTSPItemTagProvider(String providerDomain, String providerName, boolean replace, GTBlockTagProvider p) {
        super(providerDomain, providerName, replace, p);
    }

    @Override
    protected void processTags(String domain) {
        super.processTags(domain);
        this.tag(TagUtils.getForgelikeItemTag("handles/wood")).add(ModItems.HANDLE.get());
        this.tag(TagUtils.getForgelikeItemTag("poles/wood")).add(ModItems.POLE.get());
        this.tag(ModItemTags.OILABLE_WEAPONS).addTag(GTTools.SWORD.getTag()).addTag(GTTools.KNIFE.getTag());
    }
}
