package org.gtreimagined.gtspartan.loader.crafting;

import com.oblivioussp.spartanweaponry.api.SpartanWeaponryAPI;
import com.oblivioussp.spartanweaponry.init.ModItems;
import muramasa.antimatter.data.AntimatterDefaultTools;
import muramasa.antimatter.datagen.providers.AntimatterRecipeProvider;
import muramasa.antimatter.util.TagUtils;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.gtreimagined.gtspartan.GTSPConfig;
import org.gtreimagined.gtspartan.GTSpartan;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static com.google.common.collect.ImmutableMap.of;
import static muramasa.antimatter.data.AntimatterDefaultTools.SCYTHE;
import static muramasa.antimatter.data.AntimatterMaterialTypes.*;
import static muramasa.antimatter.data.AntimatterMaterials.*;
import static muramasa.antimatter.data.AntimatterMaterials.Diamond;
import static muramasa.antimatter.material.MaterialTags.TOOLS;
import static org.gtreimagined.gtspartan.data.MaterialTypes.HANDLE;
import static org.gtreimagined.gtspartan.data.MaterialTypes.POLE;
import static org.gtreimagined.gtspartan.data.Tools.*;
import static org.gtreimagined.gtspartan.data.Tools.LONGSWORD;

public class ToolCrafting {

    public static void removeSpartanWeaponryRecipes(Consumer<FinishedRecipe> consumer, AntimatterRecipeProvider provider) {
        if (GTSPConfig.REMOVE_MODDED_WEAPONS.get()){
            List<String> materials = new ArrayList<>();
            for (String material : GTSPConfig.HIDDEN_MODDED_TOOL_MATERIALS.get()){
                if (GTSPConfig.DEFAULT_MODDED_TOOL_MATERIALS.contains(material)){
                    materials.add(material);
                }
            }
            if (GTSPConfig.REMOVE_WOODEN_WEAPONS.get()){
                materials.add("wooden");
            }
            List<String> tools = List.of("dagger", "parrying_dagger", "longsword", "katana",
                    "saber", "rapier", "greatsword", "battle_hammer", "warhammer", "spear", "halberd", "pike", "lance",
                    "longbow", "heavy_crossbow", "throwing_knife", "tomahawk", "javelin", "boomerang", "battleaxe", "flanged_mace", "glaive",
                    "quarterstaff", "scythe");
            for (String material : materials) {
                for (String tool : tools) {
                    if (material.equals("wooden") && (tool.equals("longbow") || tool.equals("heavy_crossbow"))){
                        continue;
                    }
                    provider.removeRecipe(new ResourceLocation(SpartanWeaponryAPI.MOD_ID, material + "_" + tool));
                }
            }

        }
    }

    public static void loadStandardToolRecipes(Consumer<FinishedRecipe> consumer, AntimatterRecipeProvider provider){
        TOOLS.getAll().forEach((m, t) -> {
            TagKey<Item> handleAny = t.handleMaterial() != Wood && t.handleMaterial().has(HANDLE) ? HANDLE.getMaterialTag(t.handleMaterial()) : TagUtils.getItemTag(new ResourceLocation(SpartanWeaponryAPI.MOD_ID, "handles"));
            TagKey<Item> poleAny = t.handleMaterial() != Wood && t.handleMaterial().has(POLE) ? POLE.getMaterialTag(t.handleMaterial()) : TagUtils.getItemTag(new ResourceLocation(SpartanWeaponryAPI.MOD_ID, "poles"));
            Object handle = t.handleMaterial() != Wood && t.handleMaterial().has(HANDLE) ? HANDLE.getMaterialTag(t.handleMaterial()) : ModItems.HANDLE.get();
            Object pole = t.handleMaterial() != Wood && t.handleMaterial().has(POLE) ? POLE.getMaterialTag(t.handleMaterial()) : ModItems.POLE.get();
            TagKey<Item> rod = t.handleMaterial().has(ROD) ? ROD.getMaterialTag(t.handleMaterial()) : ROD.getMaterialTag(Wood);
            boolean replaceVanilla = (m != Iron && m != Gold && m != Diamond) || GTSPConfig.OVERRIDE_VANILLA_SPARTAN_RECIPES.get();
            if ((m.has(INGOT) || m.has(GEM)) && replaceVanilla){
                TagKey<Item> plateGem = m.has(GEM) ? GEM.getMaterialTag(m) : m.has(PLATE) ? PLATE.getMaterialTag(m) : INGOT.getMaterialTag(m);
                if (t.toolTypes().contains(DAGGER)){
                    if (m.has(GEM)){
                        provider.addStackRecipe(consumer, GTSpartan.ID, "", "", DAGGER.getToolStack(m),
                                of('R', handleAny, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag()), "FP", " R");
                    } else {
                        provider.addStackRecipe(consumer, GTSpartan.ID, "", "", DAGGER.getToolStack(m),
                                of('R', handleAny, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag(), 'H', AntimatterDefaultTools.HAMMER.getTag()), "FP", "HR");
                    }
                }
                if (t.toolTypes().contains(PARRYING_DAGGER)){
                    if (m.has(GEM)){
                        provider.addStackRecipe(consumer, GTSpartan.ID, "", "", PARRYING_DAGGER.getToolStack(m),
                                of('R', handle, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag()), "FP", "PR");
                    } else {
                        provider.addStackRecipe(consumer, GTSpartan.ID, "", "", PARRYING_DAGGER.getToolStack(m),
                                of('R', handle, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag(), 'H', AntimatterDefaultTools.HAMMER.getTag()), "FPH", "PR ");
                    }
                }
                if (t.toolTypes().contains(LONGSWORD)){
                    if (m.has(GEM)){
                        provider.addStackRecipe(consumer, GTSpartan.ID, "", "", LONGSWORD.getToolStack(m),
                                of('R', handle, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag()), "FP ", " P ", "PRP");
                    } else {
                        provider.addStackRecipe(consumer, GTSpartan.ID, "", "", LONGSWORD.getToolStack(m),
                                of('R', handle, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag(), 'H', AntimatterDefaultTools.HAMMER.getTag()), "FPH", " P ", "PRP");
                    }
                }
                if (t.toolTypes().contains(KATANA)){
                    if (m.has(GEM)){
                        provider.addStackRecipe(consumer, GTSpartan.ID, "", "", KATANA.getToolStack(m),
                                of('R', handle, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag()), " FP", " P ", "R  ");
                    } else {
                        provider.addStackRecipe(consumer, GTSpartan.ID, "", "", KATANA.getToolStack(m),
                                of('R', handle, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag(), 'H', AntimatterDefaultTools.HAMMER.getTag()), " FP", " PH", "R  ");
                    }
                }
                if (t.toolTypes().contains(SABER)){
                    if (m.has(GEM)){
                        provider.addStackRecipe(consumer, GTSpartan.ID, "", "", SABER.getToolStack(m),
                                of('R', handle, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag()), "FP ", " P ", "PR ");
                    } else {
                        provider.addStackRecipe(consumer, GTSpartan.ID, "", "", SABER.getToolStack(m),
                                of('R', handle, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag(), 'H', AntimatterDefaultTools.HAMMER.getTag()), "FPH", " P ", "PR ");
                    }
                }
                if (t.toolTypes().contains(RAPIER)){
                    if (m.has(GEM)){
                        provider.addStackRecipe(consumer, GTSpartan.ID, "", "", RAPIER.getToolStack(m),
                                of('R', handle, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag()), " FP", " P ", "R  ");
                    } else {
                        provider.addStackRecipe(consumer, GTSpartan.ID, "", "", RAPIER.getToolStack(m),
                                of('R', handle, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag(), 'H', AntimatterDefaultTools.HAMMER.getTag()), " FP", "PPH", "RP ");
                    }
                }
                if (t.toolTypes().contains(GREATSWORD)){
                    if (m.has(GEM)){
                        provider.addStackRecipe(consumer, GTSpartan.ID, "", "", GREATSWORD.getToolStack(m),
                                of('R', handle, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag()), "FP ", "PPP", "PRP");
                    } else {
                        provider.addStackRecipe(consumer, GTSpartan.ID, "", "", GREATSWORD.getToolStack(m),
                                of('R', handle, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag(), 'H', AntimatterDefaultTools.HAMMER.getTag()), "FPH", "PPP", "PRP");
                    }
                }
                if (t.toolTypes().contains(BATTLE_HAMMER)){
                    if (m.has(GEM)){
                        provider.addStackRecipe(consumer, GTSpartan.ID, "", "", BATTLE_HAMMER.getToolStack(m),
                                of('R', handle, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag()), "PPP", "PPP", "FR ");
                    } else {
                        provider.addStackRecipe(consumer, GTSpartan.ID, "", "", BATTLE_HAMMER.getToolStack(m),
                                of('R', handle, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag(), 'H', AntimatterDefaultTools.HAMMER.getTag()), "PPP", "PPP", "FRH");
                    }
                }
                if (t.toolTypes().contains(WARHAMMER)){
                    if (m.has(GEM)){
                        provider.addStackRecipe(consumer, GTSpartan.ID, "", "", WARHAMMER.getToolStack(m),
                                of('R', handle, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag()), "FP", "PP", " R");
                    } else {
                        provider.addStackRecipe(consumer, GTSpartan.ID, "", "", WARHAMMER.getToolStack(m),
                                of('R', handle, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag(), 'H', AntimatterDefaultTools.HAMMER.getTag()), "FPH", "PP ", " R ");
                    }
                }
                if (t.toolTypes().contains(SPEAR)){
                    if (m.has(GEM)){
                        provider.addStackRecipe(consumer, GTSpartan.ID, "", "", SPEAR.getToolStack(m),
                                of('R', poleAny, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag()), "FP", " R");
                    } else {
                        provider.addStackRecipe(consumer, GTSpartan.ID, "", "", SPEAR.getToolStack(m),
                                of('R', poleAny, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag(), 'H', AntimatterDefaultTools.HAMMER.getTag()), "FP", "HR");
                    }
                }
                if (t.toolTypes().contains(HALBERD)){
                    if (m.has(GEM)){
                        provider.addStackRecipe(consumer, GTSpartan.ID, "", "", HALBERD.getToolStack(m),
                                of('R', pole, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag()), "FP", "PP", "PR");
                    } else {
                        provider.addStackRecipe(consumer, GTSpartan.ID, "", "", HALBERD.getToolStack(m),
                                of('R', pole, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag(), 'H', AntimatterDefaultTools.HAMMER.getTag()), "FPH", "PP ", "PR ");
                    }
                }
                if (t.toolTypes().contains(PIKE)){
                    if (m.has(GEM)){
                        provider.addStackRecipe(consumer, GTSpartan.ID, "", "", PIKE.getToolStack(m),
                                of('R', pole, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag()), "FP", " R", " R");
                    } else {
                        provider.addStackRecipe(consumer, GTSpartan.ID, "", "", PIKE.getToolStack(m),
                                of('R', pole, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag(), 'H', AntimatterDefaultTools.HAMMER.getTag()), "FPH", " R ", " R ");
                    }
                }
                if (t.toolTypes().contains(LANCE)){
                    if (m.has(GEM)){
                        provider.addStackRecipe(consumer, GTSpartan.ID, "", "", LANCE.getToolStack(m),
                                of('p', pole, 'R', handle, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag()), " FP", "Pp ", "RP ");
                    } else {
                        provider.addStackRecipe(consumer, GTSpartan.ID, "", "", LANCE.getToolStack(m),
                                of('p', pole, 'R', handle, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag(), 'H', AntimatterDefaultTools.HAMMER.getTag()), " FP", "PpH", "RP ");
                    }
                }
                if (t.toolTypes().contains(BATTLEAXE)){
                    if (m.has(GEM)){
                        provider.addStackRecipe(consumer, GTSpartan.ID, "", "", BATTLEAXE.getToolStack(m),
                                of('h', handle, 'R', rod, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag()), "PPP", "PRP", "Fh ");
                    } else {
                        provider.addStackRecipe(consumer, GTSpartan.ID, "", "", BATTLEAXE.getToolStack(m),
                                of('h', handle, 'R', rod, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag(), 'H', AntimatterDefaultTools.HAMMER.getTag()), "PPP", "PRP", "FhH");
                    }
                }
                if (t.toolTypes().contains(FLANGED_MACE)){
                    if (m.has(GEM)){
                        provider.addStackRecipe(consumer, GTSpartan.ID, "", "", FLANGED_MACE.getToolStack(m),
                                of('h', handle, 'R', rod, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag()), "FPP", " RP", "h  ");
                    } else {
                        provider.addStackRecipe(consumer, GTSpartan.ID, "", "", FLANGED_MACE.getToolStack(m),
                                of('h', handle, 'R', rod, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag(), 'H', AntimatterDefaultTools.HAMMER.getTag()), "FPP", " RP", "h H");
                    }
                }
                if (t.toolTypes().contains(GLAIVE)){
                    if (m.has(GEM)){
                        provider.addStackRecipe(consumer, GTSpartan.ID, "", "", GLAIVE.getToolStack(m),
                                of('R', pole, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag()), "FP", " P", " R");
                    } else {
                        provider.addStackRecipe(consumer, GTSpartan.ID, "", "", GLAIVE.getToolStack(m),
                                of('R', pole, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag(), 'H', AntimatterDefaultTools.HAMMER.getTag()), "FPH", " P ", " R ");
                    }
                }
                if (t.toolTypes().contains(QUARTERSTAFF)){
                    if (m.has(GEM)){
                        provider.addStackRecipe(consumer, GTSpartan.ID, "", "", QUARTERSTAFF.getToolStack(m),
                                of('R', pole, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag()), " FP", " R ", "P  ");
                    } else {
                        provider.addStackRecipe(consumer, GTSpartan.ID, "", "", QUARTERSTAFF.getToolStack(m),
                                of('R', pole, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag(), 'H', AntimatterDefaultTools.HAMMER.getTag()), " FP", " R ", "PH ");
                    }
                }
                if (t.toolTypes().contains(SCYTHE)){
                    if (m.has(GEM)){
                        provider.addStackRecipe(consumer, GTSpartan.ID, "", "", SCYTHE.getToolStack(m),
                                of('R', pole, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag()), "PPF", "  P", " R ");
                    } else {
                        provider.addStackRecipe(consumer, GTSpartan.ID, "", "", SCYTHE.getToolStack(m),
                                of('R', pole, 'P', plateGem,'F', AntimatterDefaultTools.FILE.getTag(), 'H', AntimatterDefaultTools.HAMMER.getTag()), "PPF", " HP", " R ");
                    }
                }
            }
        });
    }
}
