package trinsdar.gtsp.datagen;

import muramasa.antimatter.Data;
import muramasa.antimatter.datagen.ExistingFileHelperOverride;
import muramasa.antimatter.datagen.providers.AntimatterItemTagProvider;
import muramasa.antimatter.tool.AntimatterToolType;
import muramasa.antimatter.util.TagUtils;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.system.CallbackI;
import trinsdar.gtsp.Ref;
import trinsdar.gtsp.data.Tools;
import trinsdar.gtsp.tool.GTSPToolType;

public class GTSPItemTagProvider extends AntimatterItemTagProvider {
    public GTSPItemTagProvider(String providerDomain, String providerName, boolean replace, DataGenerator gen, BlockTagsProvider p, ExistingFileHelperOverride fh) {
        super(providerDomain, providerName, replace, gen, p, fh);
    }

    @Override
    public void registerTags() {
        super.registerTags();
        addToolTag(Tools.DAGGER);
        addToolTag(Tools.LONGSWORD);
        addToolTag(Tools.KATANA);
        addToolTag(Tools.SABER);
        addToolTag(Tools.RAPIER);
        addToolTag(Tools.GREATSWORD);
        addToolTag(Tools.BATTLE_HAMMER);
        addToolTag(Tools.WARHAMMER);
        addToolTag(Tools.SPEAR);
        addToolTag(Tools.HALBERD);
        addToolTag(Tools.PIKE);
        addToolTag(Tools.LANCE);
        addToolTag(Tools.BATTLEAXE);
        addToolTag(Tools.FLANGED_MACE);
        addToolTag(Tools.GLAIVE);
        this.getOrCreateBuilder(TagUtils.getItemTag(new ResourceLocation("spartanweaponry", "quarterstaves"))).add(Tools.QUARTERSTAFF.getToolStack(Data.NULL, Data.NULL).getItem());
    }

    public void addToolTag(AntimatterToolType tool){
        this.getOrCreateBuilder(TagUtils.getItemTag(new ResourceLocation("spartanweaponry", tool.getId() + "s"))).add(tool.getToolStack(Data.NULL, Data.NULL).getItem());
    }

}
