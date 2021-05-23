package trinsdar.gtsp.datagen;

import muramasa.antimatter.datagen.providers.AntimatterRecipeProvider;
import net.minecraft.data.DataGenerator;
import trinsdar.gtsp.Ref;
import trinsdar.gtsp.loader.crafting.MaterialCrafting;
import trinsdar.gtsp.loader.crafting.ToolCrafting;

public class GTSPRecipes extends AntimatterRecipeProvider {

    public GTSPRecipes(String providerDomain, String providerName, DataGenerator gen) {
        super(providerDomain, providerName, gen);
        registerCraftingLoaders();
    }

    protected void registerCraftingLoaders() {
        this.craftingLoaders.add(ToolCrafting::loadRecipes);
        this.craftingLoaders.add(MaterialCrafting::loadRecipes);
    }

    @Override
    public String getName() {
        return "GTSP Crafting Recipes";
    }

    private String fixLoc(String attach) {
        return Ref.ID.concat(":").concat(attach);
    }

}
