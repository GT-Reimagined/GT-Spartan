package trinsdar.gtsp.datagen;

import com.oblivioussp.spartanweaponry.init.ModItems;
import muramasa.antimatter.datagen.providers.AntimatterBlockTagProvider;
import muramasa.antimatter.datagen.providers.AntimatterItemTagProvider;
import muramasa.antimatter.tool.AntimatterToolType;
import muramasa.antimatter.util.TagUtils;

public class GTSPItemTagProvider extends AntimatterItemTagProvider {
    public GTSPItemTagProvider(String providerDomain, String providerName, boolean replace, AntimatterBlockTagProvider p) {
        super(providerDomain, providerName, replace, p);
    }

    @Override
    protected void processTags(String domain) {
        super.processTags(domain);
        //addToolTag(Tools.DAGGER);
        //addToolTag(Tools.LONGSWORD);
        //addToolTag(Tools.KATANA);
        //addToolTag(Tools.SABER);
        //addToolTag(Tools.RAPIER);
        //addToolTag(Tools.GREATSWORD);
        //addToolTag(Tools.BATTLE_HAMMER);
        //addToolTag(Tools.WARHAMMER);
        //addToolTag(Tools.SPEAR);
        //addToolTag(Tools.HALBERD);
        //addToolTag(Tools.PIKE);
        //addToolTag(Tools.LANCE);
        //addToolTag(Tools.BATTLEAXE);
        //addToolTag(Tools.FLANGED_MACE);
        //addToolTag(Tools.GLAIVE);
        //this.tag(TagUtils.getItemTag(new ResourceLocation(GTSPRef.MOD_SPARTAN_WEAPONRY, "quarterstaves"))).add(Tools.QUARTERSTAFF.getToolStack(Data.NULL, Data.NULL).getItem());
        this.tag(TagUtils.getForgelikeItemTag("handles/wood")).add(ModItems.HANDLE.get());
        this.tag(TagUtils.getForgelikeItemTag("poles/wood")).add(ModItems.POLE.get());
    }

    public void addToolTag(AntimatterToolType tool){
        //this.tag(TagUtils.getItemTag(new ResourceLocation(GTSPRef.MOD_SPARTAN_WEAPONRY, tool.getId() + "s"))).add(tool.getToolStack(Data.NULL, Data.NULL).getItem());
    }

}
