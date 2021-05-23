package trinsdar.gtsp.loader.crafting;

import com.google.common.collect.ImmutableMap;
import com.sun.jna.platform.win32.WinDef;
import muramasa.antimatter.datagen.providers.AntimatterRecipeProvider;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.recipe.ingredient.PropertyIngredient;
import muramasa.antimatter.tool.AntimatterToolType;
import muramasa.antimatter.tool.IAntimatterTool;
import net.minecraft.advancements.ICriterionInstance;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import trinsdar.gtsp.Ref;
import trinsdar.gtsp.data.Tools;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

import static com.google.common.collect.ImmutableMap.of;
import static muramasa.antimatter.Data.*;
import static muramasa.antimatter.Data.AXE;
import static muramasa.antimatter.Data.NULL;
import static muramasa.antimatter.Data.SWORD;
import static muramasa.antimatter.material.MaterialTag.HANDLE;
import static trinsdar.gtsp.data.Tools.*;

public class ToolCrafting {
    public static void loadRecipes(Consumer<IFinishedRecipe> output, AntimatterRecipeProvider provider){
        loadOtherRecipes(output, provider);
    }

    private static void loadOtherRecipes(Consumer<IFinishedRecipe> output, AntimatterRecipeProvider provider){
        ICriterionInstance in = provider.hasSafeItem(FILE.getTag());

        Function<AntimatterToolType, ImmutableMap<Character, Object>> map2 = type -> of('R', PropertyIngredient.builder("secondary").types(Tools.HANDLE).build(), 'P', PropertyIngredient.builder("primary").types(PLATE, GEM).tags(TOOLS).build(), 'F', FILE.getTag(), 'H', HAMMER.getTag());

        Function<AntimatterToolType, ImmutableMap<Character, Object>> map1 = type -> of('R', PropertyIngredient.builder("secondary").types(Tools.POLE).build(), 'P', PropertyIngredient.builder("primary").types(PLATE, GEM).tags(TOOLS).build(), 'F', FILE.getTag(), 'H', HAMMER.getTag());

        String[] strings1 = new String[]{"PII", "FRH", " R "};
        String[] strings3 = new String[]{" P ", "FPH", " R "};

        String[] strings2 = new String[]{"FPH", " R ", " R "};
        String[] strings2Gem = new String[]{"FGH", " R ", " R "};

        provider.addToolRecipe(TOOL_BUILDER.get(DAGGER.getId()), output, Ref.ID, DAGGER.getId() + "_with" , "gtsp_weapons",
                "has_wrench", in, DAGGER.getToolStack(NULL, NULL), map2.apply(DAGGER), "FPH", " R ");
        provider.addToolRecipe(TOOL_BUILDER.get(LONGSWORD.getId()), output, Ref.ID, LONGSWORD.getId() + "_with" , "gtsp_weapons",
                "has_wrench", in, LONGSWORD.getToolStack(NULL, NULL), map2.apply(LONGSWORD), " P ", "FPH", "PRP");
        provider.addToolRecipe(TOOL_BUILDER.get(KATANA.getId()), output, Ref.ID, KATANA.getId() + "_with" , "gtsp_weapons",
                "has_wrench", in, KATANA.getToolStack(NULL, NULL), map2.apply(KATANA), "  P", "FPH", "R  ");
        provider.addToolRecipe(TOOL_BUILDER.get(SABER.getId()), output, Ref.ID, SABER.getId() + "_with" , "gtsp_weapons",
                "has_wrench", in, SABER.getToolStack(NULL, NULL), map2.apply(SABER), " P ", "FPH", "PR ");
        provider.addToolRecipe(TOOL_BUILDER.get(RAPIER.getId()), output, Ref.ID, RAPIER.getId() + "_with" , "gtsp_weapons",
                "has_wrench", in, RAPIER.getToolStack(NULL, NULL), map2.apply(RAPIER), " FP", "PPH", "RP ");
        provider.addToolRecipe(TOOL_BUILDER.get(GREATSWORD.getId()), output, Ref.ID, GREATSWORD.getId() + "_with" , "gtsp_weapons",
                "has_wrench", in, GREATSWORD.getToolStack(NULL, NULL), map2.apply(GREATSWORD), "FPH", "PPP", "PRP");
        provider.addToolRecipe(TOOL_BUILDER.get(BATTLE_HAMMER.getId()), output, Ref.ID, BATTLE_HAMMER.getId() + "_with" , "gtsp_weapons",
                "has_wrench", in, BATTLE_HAMMER.getToolStack(NULL, NULL), map2.apply(BATTLE_HAMMER), "PPP", "PPP", "FRH");
        provider.addToolRecipe(TOOL_BUILDER.get(WARHAMMER.getId()), output, Ref.ID, WARHAMMER.getId() + "_with" , "gtsp_weapons",
                "has_wrench", in, WARHAMMER.getToolStack(NULL, NULL), map2.apply(WARHAMMER), " P ", "PPH", "FR ");
        provider.addToolRecipe(TOOL_BUILDER.get(SPEAR.getId()), output, Ref.ID, SPEAR.getId() + "_with" , "gtsp_weapons",
                "has_wrench", in, SPEAR.getToolStack(NULL, NULL), map1.apply(SPEAR), "FPH", " R ");
        provider.addToolRecipe(TOOL_BUILDER.get(HALBERD.getId()), output, Ref.ID, HALBERD.getId() + "_with" , "gtsp_weapons",
                "has_wrench", in, HALBERD.getToolStack(NULL, NULL), map1.apply(HALBERD), "FP ", "PPH", "PR ");
        provider.addToolRecipe(TOOL_BUILDER.get(PIKE.getId()), output, Ref.ID, PIKE.getId() + "_with" , "gtsp_weapons",
                "has_wrench", in, PIKE.getToolStack(NULL, NULL), map1.apply(PIKE), "FPH", " R ", " R ");
        provider.addToolRecipe(TOOL_BUILDER.get(LANCE.getId()), output, Ref.ID, LANCE.getId() + "_with" , "gtsp_weapons",
                "has_wrench", in, LANCE.getToolStack(NULL, NULL), of('R', PropertyIngredient.builder("secondary").types(Tools.POLE).build(), 'r', PropertyIngredient.builder("secondary").types(Tools.HANDLE).build(), 'P', PropertyIngredient.builder("primary").types(PLATE, GEM).tags(TOOLS).build(), 'H', HAMMER.getTag(), 'F', FILE.getTag()), " FP", "PRH", "rP ");


        ImmutableMap<Character, Object> map3 = of('R', PropertyIngredient.builder("secondary").types(Tools.POLE).build(), 'r', PropertyIngredient.builder("secondary").types(ROD).tags(HANDLE).build(), 'P', PropertyIngredient.builder("primary").types(PLATE, GEM).tags(TOOLS).build(), 'H', HAMMER.getTag(), 'F', FILE.getTag());
        provider.addToolRecipe(TOOL_BUILDER.get(BATTLEAXE.getId()), output, Ref.ID, BATTLEAXE.getId() + "_with" , "gtsp_weapons",
                "has_wrench", in, BATTLEAXE.getToolStack(NULL, NULL), map3, "PPP", "PrP", "FRH");
        provider.addToolRecipe(TOOL_BUILDER.get(FLANGED_MACE.getId()), output, Ref.ID, FLANGED_MACE.getId() + "_with" , "gtsp_weapons",
                "has_wrench", in, FLANGED_MACE.getToolStack(NULL, NULL), map3, "FPP", " rP", "R H");
        provider.addToolRecipe(TOOL_BUILDER.get(GLAIVE.getId()), output, Ref.ID, GLAIVE.getId() + "_with" , "gtsp_weapons",
                "has_wrench", in, GLAIVE.getToolStack(NULL, NULL), map1.apply(GLAIVE), " P ", "FPH", " R ");
        provider.addToolRecipe(TOOL_BUILDER.get(QUARTERSTAFF.getId()), output, Ref.ID, QUARTERSTAFF.getId() + "_with" , "gtsp_weapons",
                "has_wrench", in, QUARTERSTAFF.getToolStack(NULL, NULL), map1.apply(QUARTERSTAFF), "FRH", " P ");
    }


    public static ItemStack resolveStack(IAntimatterTool tool, Material primary, Material secondary, long startingEnergy, long maxEnergy) {
        ItemStack stack = new ItemStack(tool.getItem());
        tool.validateTag(stack, primary, secondary, startingEnergy, maxEnergy);
        Map<Enchantment, Integer> mainEnchants = primary.getEnchantments();
        if (!mainEnchants.isEmpty()) {
            mainEnchants.entrySet().stream().filter(e -> e.getKey().canApply(stack)).forEach(e -> stack.addEnchantment(e.getKey(), e.getValue()));
        }
        return stack;
    }
}
