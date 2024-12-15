package trinsdar.gtsp.loader.crafting;

import com.oblivioussp.spartanweaponry.api.SpartanWeaponryAPI;
import com.oblivioussp.spartanweaponry.init.ModItems;
import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.data.AntimatterDefaultTools;
import muramasa.antimatter.datagen.providers.AntimatterRecipeProvider;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.util.TagUtils;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.codehaus.plexus.util.dag.DAG;
import trinsdar.gtsp.GTSPRef;

import java.util.function.Consumer;

import static com.google.common.collect.ImmutableMap.of;
import static muramasa.antimatter.data.AntimatterDefaultTools.KNIFE;
import static muramasa.antimatter.data.AntimatterDefaultTools.SCYTHE;
import static muramasa.antimatter.data.AntimatterMaterialTypes.*;
import static muramasa.antimatter.data.AntimatterMaterials.*;
import static muramasa.antimatter.data.AntimatterMaterials.Diamond;
import static muramasa.antimatter.material.Material.NULL;
import static muramasa.antimatter.material.MaterialTags.FLINT;
import static muramasa.antimatter.material.MaterialTags.TOOLS;
import static trinsdar.gtsp.data.MaterialTypes.HANDLE;
import static trinsdar.gtsp.data.MaterialTypes.POLE;
import static trinsdar.gtsp.data.Tools.*;
import static trinsdar.gtsp.data.Tools.LONGSWORD;

public class ToolCrafting {

    public static void loadStandardToolRecipes(Consumer<FinishedRecipe> consumer, AntimatterRecipeProvider provider){
        TOOLS.getAll().forEach((m, t) -> {
            TagKey<Item> handleAny = t.handleMaterial().has(HANDLE) ? HANDLE.getMaterialTag(t.handleMaterial()) : TagUtils.getItemTag(new ResourceLocation(SpartanWeaponryAPI.MOD_ID, "handles"));
            TagKey<Item> poleAny = t.handleMaterial().has(POLE) ? POLE.getMaterialTag(t.handleMaterial()) : TagUtils.getItemTag(new ResourceLocation(SpartanWeaponryAPI.MOD_ID, "poles"));
            Object handle = t.handleMaterial().has(HANDLE) ? HANDLE.getMaterialTag(t.handleMaterial()) : ModItems.HANDLE.get();
            Object pole = t.handleMaterial().has(POLE) ? POLE.getMaterialTag(t.handleMaterial()) : ModItems.POLE.get();
            TagKey<Item> rod = t.handleMaterial().has(ROD) ? ROD.getMaterialTag(t.handleMaterial()) : ROD.getMaterialTag(Wood);
            //boolean replaceVanilla = (m != Iron && m != Gold && m != Diamond) || GTCoreConfig.VANILLA_OVERRIDES.get();
            if (m.has(INGOT) || m.has(GEM)){
                TagKey<Item> plateGem = m.has(GEM) ? GEM.getMaterialTag(m) : m.has(PLATE) ? PLATE.getMaterialTag(m) : INGOT.getMaterialTag(m);
                if (t.toolTypes().contains(DAGGER)){
                    if (m.has(GEM)){
                        provider.addStackRecipe(consumer, GTSPRef.ID, "", "", DAGGER.getToolStack(m),
                                of('R', handleAny, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag()), "FP", " R");
                    } else {
                        provider.addStackRecipe(consumer, GTSPRef.ID, "", "", DAGGER.getToolStack(m),
                                of('R', handleAny, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag(), 'H', AntimatterDefaultTools.HAMMER.getTag()), "FP", "HR");
                    }
                }
                if (t.toolTypes().contains(PARRYING_DAGGER)){
                    if (m.has(GEM)){
                        provider.addStackRecipe(consumer, GTSPRef.ID, "", "", PARRYING_DAGGER.getToolStack(m),
                                of('R', handle, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag()), "FP", "PR");
                    } else {
                        provider.addStackRecipe(consumer, GTSPRef.ID, "", "", PARRYING_DAGGER.getToolStack(m),
                                of('R', handle, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag(), 'H', AntimatterDefaultTools.HAMMER.getTag()), "FPH", "PR ");
                    }
                }
                if (t.toolTypes().contains(LONGSWORD)){
                    if (m.has(GEM)){
                        provider.addStackRecipe(consumer, GTSPRef.ID, "", "", LONGSWORD.getToolStack(m),
                                of('R', handle, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag()), "FP ", " P ", "PRP");
                    } else {
                        provider.addStackRecipe(consumer, GTSPRef.ID, "", "", LONGSWORD.getToolStack(m),
                                of('R', handle, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag(), 'H', AntimatterDefaultTools.HAMMER.getTag()), "FPH", " P ", "PRP");
                    }
                }
                if (t.toolTypes().contains(KATANA)){
                    if (m.has(GEM)){
                        provider.addStackRecipe(consumer, GTSPRef.ID, "", "", KATANA.getToolStack(m),
                                of('R', handle, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag()), " FP", " P ", "R  ");
                    } else {
                        provider.addStackRecipe(consumer, GTSPRef.ID, "", "", KATANA.getToolStack(m),
                                of('R', handle, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag(), 'H', AntimatterDefaultTools.HAMMER.getTag()), " FP", " PH", "R  ");
                    }
                }
                if (t.toolTypes().contains(SABER)){
                    if (m.has(GEM)){
                        provider.addStackRecipe(consumer, GTSPRef.ID, "", "", SABER.getToolStack(m),
                                of('R', handle, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag()), "FP ", " P ", "PR ");
                    } else {
                        provider.addStackRecipe(consumer, GTSPRef.ID, "", "", SABER.getToolStack(m),
                                of('R', handle, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag(), 'H', AntimatterDefaultTools.HAMMER.getTag()), "FPH", " P ", "PR ");
                    }
                }
                if (t.toolTypes().contains(RAPIER)){
                    if (m.has(GEM)){
                        provider.addStackRecipe(consumer, GTSPRef.ID, "", "", RAPIER.getToolStack(m),
                                of('R', handle, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag()), " FP", " P ", "R  ");
                    } else {
                        provider.addStackRecipe(consumer, GTSPRef.ID, "", "", RAPIER.getToolStack(m),
                                of('R', handle, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag(), 'H', AntimatterDefaultTools.HAMMER.getTag()), " FP", "PPH", "RP ");
                    }
                }
                if (t.toolTypes().contains(GREATSWORD)){
                    if (m.has(GEM)){
                        provider.addStackRecipe(consumer, GTSPRef.ID, "", "", GREATSWORD.getToolStack(m),
                                of('R', handle, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag()), "FP ", "PPP", "PRP");
                    } else {
                        provider.addStackRecipe(consumer, GTSPRef.ID, "", "", GREATSWORD.getToolStack(m),
                                of('R', handle, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag(), 'H', AntimatterDefaultTools.HAMMER.getTag()), "FPH", "PPP", "PRP");
                    }
                }
                if (t.toolTypes().contains(BATTLE_HAMMER)){
                    if (m.has(GEM)){
                        provider.addStackRecipe(consumer, GTSPRef.ID, "", "", BATTLE_HAMMER.getToolStack(m),
                                of('R', handle, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag()), "PPP", "PPP", "FR ");
                    } else {
                        provider.addStackRecipe(consumer, GTSPRef.ID, "", "", BATTLE_HAMMER.getToolStack(m),
                                of('R', handle, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag(), 'H', AntimatterDefaultTools.HAMMER.getTag()), "PPP", "PPP", "FRH");
                    }
                }
                if (t.toolTypes().contains(WARHAMMER)){
                    if (m.has(GEM)){
                        provider.addStackRecipe(consumer, GTSPRef.ID, "", "", WARHAMMER.getToolStack(m),
                                of('R', handle, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag()), "FP", "PP", " R");
                    } else {
                        provider.addStackRecipe(consumer, GTSPRef.ID, "", "", WARHAMMER.getToolStack(m),
                                of('R', handle, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag(), 'H', AntimatterDefaultTools.HAMMER.getTag()), "FPH", "PP ", " R ");
                    }
                }
                if (t.toolTypes().contains(SPEAR)){
                    if (m.has(GEM)){
                        provider.addStackRecipe(consumer, GTSPRef.ID, "", "", SPEAR.getToolStack(m),
                                of('R', poleAny, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag()), "FP", " R");
                    } else {
                        provider.addStackRecipe(consumer, GTSPRef.ID, "", "", SPEAR.getToolStack(m),
                                of('R', poleAny, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag(), 'H', AntimatterDefaultTools.HAMMER.getTag()), "FP", "HR");
                    }
                }
                if (t.toolTypes().contains(HALBERD)){
                    if (m.has(GEM)){
                        provider.addStackRecipe(consumer, GTSPRef.ID, "", "", HALBERD.getToolStack(m),
                                of('R', pole, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag()), "FP", "PP", "PR");
                    } else {
                        provider.addStackRecipe(consumer, GTSPRef.ID, "", "", HALBERD.getToolStack(m),
                                of('R', pole, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag(), 'H', AntimatterDefaultTools.HAMMER.getTag()), "FPH", "PP ", "PR ");
                    }
                }
                if (t.toolTypes().contains(PIKE)){
                    if (m.has(GEM)){
                        provider.addStackRecipe(consumer, GTSPRef.ID, "", "", PIKE.getToolStack(m),
                                of('R', pole, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag()), "FP", " R", " R");
                    } else {
                        provider.addStackRecipe(consumer, GTSPRef.ID, "", "", PIKE.getToolStack(m),
                                of('R', pole, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag(), 'H', AntimatterDefaultTools.HAMMER.getTag()), "FPH", " R ", " R ");
                    }
                }
                if (t.toolTypes().contains(LANCE)){
                    if (m.has(GEM)){
                        provider.addStackRecipe(consumer, GTSPRef.ID, "", "", LANCE.getToolStack(m),
                                of('p', pole, 'R', handle, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag()), " FP", "Pp ", "RP ");
                    } else {
                        provider.addStackRecipe(consumer, GTSPRef.ID, "", "", LANCE.getToolStack(m),
                                of('p', pole, 'R', handle, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag(), 'H', AntimatterDefaultTools.HAMMER.getTag()), " FP", "PpH", "RP ");
                    }
                }
                if (t.toolTypes().contains(BATTLEAXE)){
                    if (m.has(GEM)){
                        provider.addStackRecipe(consumer, GTSPRef.ID, "", "", BATTLEAXE.getToolStack(m),
                                of('h', handle, 'R', rod, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag()), "PPP", "PRP", "Fh ");
                    } else {
                        provider.addStackRecipe(consumer, GTSPRef.ID, "", "", BATTLEAXE.getToolStack(m),
                                of('h', handle, 'R', rod, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag(), 'H', AntimatterDefaultTools.HAMMER.getTag()), "PPP", "PRP", "FhH");
                    }
                }
                if (t.toolTypes().contains(FLANGED_MACE)){
                    if (m.has(GEM)){
                        provider.addStackRecipe(consumer, GTSPRef.ID, "", "", FLANGED_MACE.getToolStack(m),
                                of('h', handle, 'R', rod, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag()), "FPP", " RP", "h  ");
                    } else {
                        provider.addStackRecipe(consumer, GTSPRef.ID, "", "", FLANGED_MACE.getToolStack(m),
                                of('h', handle, 'R', rod, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag(), 'H', AntimatterDefaultTools.HAMMER.getTag()), "FPP", " RP", "h H");
                    }
                }
                if (t.toolTypes().contains(GLAIVE)){
                    if (m.has(GEM)){
                        provider.addStackRecipe(consumer, GTSPRef.ID, "", "", GLAIVE.getToolStack(m),
                                of('R', pole, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag()), "FP", " P", " R");
                    } else {
                        provider.addStackRecipe(consumer, GTSPRef.ID, "", "", GLAIVE.getToolStack(m),
                                of('R', pole, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag(), 'H', AntimatterDefaultTools.HAMMER.getTag()), "FPH", " P ", " R ");
                    }
                }
                if (t.toolTypes().contains(QUARTERSTAFF)){
                    if (m.has(GEM)){
                        provider.addStackRecipe(consumer, GTSPRef.ID, "", "", QUARTERSTAFF.getToolStack(m),
                                of('R', pole, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag()), " FP", " R ", "P  ");
                    } else {
                        provider.addStackRecipe(consumer, GTSPRef.ID, "", "", QUARTERSTAFF.getToolStack(m),
                                of('R', pole, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag(), 'H', AntimatterDefaultTools.HAMMER.getTag()), " FP", " R ", "PH ");
                    }
                }
                if (t.toolTypes().contains(SCYTHE)){
                    if (m.has(GEM)){
                        provider.addStackRecipe(consumer, GTSPRef.ID, "", "", SCYTHE.getToolStack(m),
                                of('R', pole, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag()), "PPF", "  P", " R ");
                    } else {
                        provider.addStackRecipe(consumer, GTSPRef.ID, "", "", SCYTHE.getToolStack(m),
                                of('R', pole, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag(), 'H', AntimatterDefaultTools.HAMMER.getTag()), "PPF", " HP", " R ");
                    }
                }
            }
        });
    }
}
