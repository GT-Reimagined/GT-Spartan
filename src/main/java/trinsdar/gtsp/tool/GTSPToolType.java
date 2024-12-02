package trinsdar.gtsp.tool;

import com.oblivioussp.spartanweaponry.api.trait.WeaponTrait;
import com.oblivioussp.spartanweaponry.util.WeaponArchetype;
import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.tool.AntimatterItemTier;
import muramasa.antimatter.tool.AntimatterToolType;
import muramasa.antimatter.tool.IAntimatterTool;
import muramasa.antimatter.util.Utils;
import net.minecraft.world.item.Item.Properties;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;
import java.util.function.Supplier;

public class GTSPToolType  extends AntimatterToolType {

    private final WeaponArchetype archetype;

    public GTSPToolType(String domain, String id, int useDurability, int attackDurability, int craftingDurability, float baseAttackDamage, float baseAttackSpeed, WeaponArchetype archetype) {
        super(domain, id, useDurability, attackDurability, craftingDurability, baseAttackDamage, baseAttackSpeed, false);
        this.archetype = archetype;
        if (!id.equals("boomerang")) {
            this.setOverlayLayers(2);
        }
    }

    /*@Override
    public IAntimatterTool instantiateTools(String domain) {
        if (this.getToolClass() == MaterialSwordSp.class) return new MaterialSwordSp(domain, this, prepareInstantiation(domain));
        return super.instantiateTools(domain);
    }

    @Override
    public IAntimatterTool instantiateTools(String domain, Supplier<Item.Properties> properties) {
        if (this.getToolClass() == MaterialSwordSp.class) return new MaterialSwordSp(domain, this, properties.get());
        return super.instantiateTools(domain, properties);
    }

    private Item.Properties prepareInstantiation(String domain) {
        if (domain.isEmpty()) Utils.onInvalidData("An AntimatterToolType was instantiated with an empty domain name!");
        Item.Properties properties = new Item.Properties().group(getItemGroup());
        if (!getRepairability()) properties.setNoRepair();
        return properties;
    }

    @Override
    public ItemStack getToolStack(Material primary, Material secondary) {
        return Objects.requireNonNull(AntimatterAPI.get(IAntimatterTool.class, getId(), getDomain())).asItemStack(primary, secondary);
    }*/
}
