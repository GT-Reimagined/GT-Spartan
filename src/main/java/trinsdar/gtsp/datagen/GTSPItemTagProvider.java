package trinsdar.gtsp.datagen;

import com.oblivioussp.spartanweaponry.init.ModItems;
import muramasa.antimatter.Data;
import muramasa.antimatter.datagen.ExistingFileHelperOverride;
import muramasa.antimatter.datagen.providers.AntimatterItemTagProvider;
import muramasa.antimatter.tool.AntimatterToolType;
import muramasa.antimatter.util.TagUtils;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import trinsdar.gtsp.Ref;
import trinsdar.gtsp.data.Tools;

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
        this.getOrCreateBuilder(TagUtils.getItemTag(new ResourceLocation(Ref.MOD_SPARTAN_WEAPONRY, "quarterstaves"))).add(Tools.QUARTERSTAFF.getToolStack(Data.NULL, Data.NULL).getItem());
        this.getOrCreateBuilder(TagUtils.getForgeItemTag("handles/wood")).add(ModItems.handle);
        this.getOrCreateBuilder(TagUtils.getForgeItemTag("poles/wood")).add(ModItems.pole);
    }

    public void addToolTag(AntimatterToolType tool){
        this.getOrCreateBuilder(TagUtils.getItemTag(new ResourceLocation(Ref.MOD_SPARTAN_WEAPONRY, tool.getId() + "s"))).add(tool.getToolStack(Data.NULL, Data.NULL).getItem());
    }

}
