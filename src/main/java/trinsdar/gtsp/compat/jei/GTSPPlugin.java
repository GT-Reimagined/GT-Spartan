package trinsdar.gtsp.compat.jei;

import com.oblivioussp.spartanweaponry.api.SpartanWeaponryAPI;
import com.oblivioussp.spartanweaponry.api.tags.ModItemTags;
import com.oblivioussp.spartanweaponry.init.ModItems;
import com.oblivioussp.spartanweaponry.util.Config;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.runtime.IJeiRuntime;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.ForgeRegistries;
import trinsdar.gtsp.GTSPConfig;
import trinsdar.gtsp.GTSPRef;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@JeiPlugin
public class GTSPPlugin implements IModPlugin {
    static final ResourceLocation ID = new ResourceLocation(GTSPRef.ID, "jei_plugin");
    @Override
    public ResourceLocation getPluginUid() {
        return ID;
    }

    @Override
    public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {
        if (GTSPConfig.REMOVE_WOODEN_WEAPONS.get()){
            List<String> tools = List.of("dagger", "parrying_dagger", "longsword", "katana",
                                "saber", "rapier", "greatsword", "battle_hammer", "warhammer", "spear", "halberd", "pike", "lance",
                                "throwing_knife", "tomahawk", "javelin", "boomerang", "battleaxe", "flanged_mace", "glaive",
                                "quarterstaff", "scythe");
            List<ItemStack> toolList = new ArrayList<>();
            for (String tool : tools) {
                toolList.add(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(SpartanWeaponryAPI.MOD_ID, "wooden_" + tool))));

            }
            jeiRuntime.getIngredientManager().removeIngredientsAtRuntime(VanillaTypes.ITEM_STACK, toolList);
        }
        if (GTSPConfig.REMOVE_MODDED_WEAPONS.get()){
            List<String> list = List.of(GTSPConfig.HIDDEN_MODDED_TOOL_MATERIALS.get());
            if (list.contains("copper"))
                removeItemTagFromJEI(jeiRuntime, ModItemTags.COPPER_WEAPONS);
            if (list.contains("tin"))
                removeItemTagFromJEI(jeiRuntime, ModItemTags.TIN_WEAPONS);
            if (list.contains("bronze"))
                removeItemTagFromJEI(jeiRuntime, ModItemTags.BRONZE_WEAPONS);
            if (list.contains("steel"))
                removeItemTagFromJEI(jeiRuntime, ModItemTags.STEEL_WEAPONS);
            if (list.contains("silver"))
                removeItemTagFromJEI(jeiRuntime, ModItemTags.SILVER_WEAPONS);
            if (list.contains("electrum"))
                removeItemTagFromJEI(jeiRuntime, ModItemTags.ELECTRUM_WEAPONS);
            if (list.contains("lead"))
                removeItemTagFromJEI(jeiRuntime, ModItemTags.LEAD_WEAPONS);
            if (list.contains("nickel"))
                removeItemTagFromJEI(jeiRuntime, ModItemTags.NICKEL_WEAPONS);
            if (list.contains("invar"))
                removeItemTagFromJEI(jeiRuntime, ModItemTags.INVAR_WEAPONS);
            if (list.contains("constantan"))
                removeItemTagFromJEI(jeiRuntime, ModItemTags.CONSTANTAN_WEAPONS);
            if (list.contains("platinum"))
                removeItemTagFromJEI(jeiRuntime, ModItemTags.PLATINUM_WEAPONS);
            if (list.contains("aluminum"))
                removeItemTagFromJEI(jeiRuntime, ModItemTags.ALUMINUM_WEAPONS);
        }
    }

    private void removeItemTagFromJEI(IJeiRuntime jeiRuntime, TagKey<Item> tag) {
        jeiRuntime.getIngredientManager().removeIngredientsAtRuntime(VanillaTypes.ITEM_STACK, Arrays.asList(Ingredient.of(tag).getItems()));
    }
}
