package trinsdar.gtsp.items;

import com.oblivioussp.spartanweaponry.api.WeaponMaterial;
import com.oblivioussp.spartanweaponry.api.trait.WeaponTrait;
import muramasa.antimatter.tool.AntimatterItemTier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class WeaponMaterialWrapper extends WeaponMaterial {
    private AntimatterItemTier tier;
    public WeaponMaterialWrapper(String nameIn, String modIdIn, AntimatterItemTier itemTierIn, TagKey<Item> tagIn, TagKey<WeaponTrait> traitsTagIn) {
        super(nameIn, modIdIn, itemTierIn, tagIn, traitsTagIn);
    }

    @Override
    public Ingredient getRepairIngredient() {
       return tier.getRepairIngredient();
    }
}
