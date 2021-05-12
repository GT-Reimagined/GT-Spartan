package trinsdar.gtsp.items;

import com.oblivioussp.spartanweaponry.api.WeaponMaterial;
import com.oblivioussp.spartanweaponry.item.SwordBaseItem;
import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.tool.AntimatterItemTier;
import muramasa.antimatter.tool.AntimatterToolType;
import muramasa.antimatter.tool.IAntimatterTool;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ToolType;
import trinsdar.gtsp.tool.GTSPToolType;

import javax.annotation.Nonnull;
import java.util.Set;

public class MaterialSwordBig extends SwordBaseItem implements IAntimatterTool {
    GTSPToolType type;
    String domain;
    public MaterialSwordBig(String domain, GTSPToolType type, Properties prop) {
        super(type.getId(), prop, new WeaponMaterial(type.getId(), domain, AntimatterItemTier.NULL, null), type.getBaseAttackDamage(), 1, type.getBaseAttackSpeed(), type.getWeaponTraits());
        this.type = type;
        this.domain = domain;
        AntimatterAPI.register(IAntimatterTool.class, getId(), this);
    }

    @Override
    public AntimatterToolType getType() {
        return type;
    }

    @Override
    public ItemStack asItemStack(Material primary, Material secondary) {
        return type.getToolStack(primary, secondary);
    }

    @Override
    public String getId() {
        return type.getId();
    }

    @Nonnull
    @Override
    public Set<ToolType> getToolTypes(ItemStack stack) {
        return getToolTypes();
    }
}
