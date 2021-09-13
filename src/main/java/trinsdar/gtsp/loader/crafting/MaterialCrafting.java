package trinsdar.gtsp.loader.crafting;

import muramasa.antimatter.datagen.providers.AntimatterRecipeProvider;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

import static muramasa.antimatter.Data.ROD;
import static trinsdar.gtsp.data.Materials.HANDLE;
import static trinsdar.gtsp.data.Materials.POLE;

public class MaterialCrafting {
    public static void loadRecipes(Consumer<IFinishedRecipe> output, AntimatterRecipeProvider provider){
        HANDLE.all().forEach(m -> {
            if (m.has(ROD) && !m.getId().equals("wood")){
                ITag.INamedTag<Item> rod = ROD.getMaterialTag(m);
                provider.shapeless(output, "handle_" + m.getId() + "_4", "handles", "has_wool", provider.hasSafeItem(ItemTags.WOOL), HANDLE.get(m, 4), rod, rod, rod, rod, ItemTags.WOOL);
                provider.shapeless(output, "handle_" + m.getId() + "_1", "handles", "has_string", provider.hasSafeItem(Tags.Items.STRING), HANDLE.get(m, 1), rod, Tags.Items.STRING);
                provider.shapeless(output, "handle_" + m.getId() + "_4l", "handles", "has_leather", provider.hasSafeItem(Tags.Items.LEATHER), HANDLE.get(m, 4), rod, rod, rod, rod, Tags.Items.LEATHER);
            }
        });

        POLE.all().forEach(m -> {
            if (m.has(ROD) && !m.getId().equals("wood")){
                ITag.INamedTag<Item> rod = ROD.getMaterialTag(m);
                provider.shapeless(output, "pole_" + m.getId() + "_4", "handles", "has_wool", provider.hasSafeItem(ItemTags.WOOL), POLE.get(m, 4), rod, rod, rod, rod, rod, rod, rod, rod, ItemTags.WOOL);
                provider.shapeless(output, "pole_" + m.getId() + "_1", "handles", "has_string", provider.hasSafeItem(Tags.Items.STRING), POLE.get(m, 1), rod, rod, rod, Tags.Items.STRING);
                provider.shapeless(output, "pole_" + m.getId() + "_4l", "handles", "has_leather", provider.hasSafeItem(Tags.Items.LEATHER), POLE.get(m, 4), rod, rod, rod, rod, rod, rod, rod, rod, Tags.Items.LEATHER);
            }
        });
    }
}
