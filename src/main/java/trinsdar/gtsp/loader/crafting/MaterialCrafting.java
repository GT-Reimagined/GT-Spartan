package trinsdar.gtsp.loader.crafting;

import muramasa.antimatter.datagen.providers.AntimatterRecipeProvider;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

import static muramasa.antimatter.data.AntimatterMaterialTypes.ROD;
import static muramasa.antimatter.data.AntimatterMaterials.Wood;
import static trinsdar.gtsp.data.MaterialTypes.HANDLE;
import static trinsdar.gtsp.data.MaterialTypes.POLE;


public class MaterialCrafting {
    public static void loadRecipes(Consumer<FinishedRecipe> output, AntimatterRecipeProvider provider){
        HANDLE.all().forEach(m -> {
            if (m.has(ROD) && m != Wood){
                TagKey<Item> rod = ROD.getMaterialTag(m);
                provider.shapeless(output, "handle_" + m.getId() + "_4", "handles", HANDLE.get(m, 4), rod, rod, rod, rod, ItemTags.WOOL);
                provider.shapeless(output, "handle_" + m.getId() + "_1", "handles", HANDLE.get(m, 1), rod, Tags.Items.STRING);
                provider.shapeless(output, "handle_" + m.getId() + "_4l", "handles", HANDLE.get(m, 4), rod, rod, rod, rod, Tags.Items.LEATHER);
            }
        });

        POLE.all().forEach(m -> {
            if (m.has(ROD) && m != Wood){
                TagKey<Item> rod = ROD.getMaterialTag(m);
                provider.shapeless(output, "pole_" + m.getId() + "_4", "handles", POLE.get(m, 4), rod, rod, rod, rod, rod, rod, rod, rod, ItemTags.WOOL);
                provider.shapeless(output, "pole_" + m.getId() + "_1", "handles", "has_string", POLE.get(m, 1), rod, rod, rod, Tags.Items.STRING);
                provider.shapeless(output, "pole_" + m.getId() + "_4l", "handles", "has_leather", POLE.get(m, 4), rod, rod, rod, rod, rod, rod, rod, rod, Tags.Items.LEATHER);
            }
        });
    }
}
