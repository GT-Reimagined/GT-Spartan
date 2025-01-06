package org.gtreimagined.gtspartan.datagen;

import com.oblivioussp.spartanweaponry.api.tags.ModItemTags;
import com.oblivioussp.spartanweaponry.init.ModItems;
import muramasa.antimatter.data.AntimatterDefaultTools;
import muramasa.antimatter.datagen.providers.AntimatterBlockTagProvider;
import muramasa.antimatter.datagen.providers.AntimatterItemTagProvider;
import muramasa.antimatter.util.TagUtils;

public class GTSPItemTagProvider extends AntimatterItemTagProvider {
    public GTSPItemTagProvider(String providerDomain, String providerName, boolean replace, AntimatterBlockTagProvider p) {
        super(providerDomain, providerName, replace, p);
    }

    @Override
    protected void processTags(String domain) {
        super.processTags(domain);
        this.tag(TagUtils.getForgelikeItemTag("handles/wood")).add(ModItems.HANDLE.get());
        this.tag(TagUtils.getForgelikeItemTag("poles/wood")).add(ModItems.POLE.get());
        this.tag(ModItemTags.OILABLE_WEAPONS).addTag(AntimatterDefaultTools.SWORD.getTag()).addTag(AntimatterDefaultTools.KNIFE.getTag());
    }
}
