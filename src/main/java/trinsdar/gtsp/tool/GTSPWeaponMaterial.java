package trinsdar.gtsp.tool;

import com.oblivioussp.spartanweaponry.api.WeaponMaterial;
import com.oblivioussp.spartanweaponry.api.WeaponTraits;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import muramasa.antimatter.Data;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.tool.AntimatterItemTier;
import muramasa.antimatter.util.TagUtils;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;

public class GTSPWeaponMaterial extends WeaponMaterial {

    private final Material primary;
    private final Material secondary;

    public static final GTSPWeaponMaterial NULL = new GTSPWeaponMaterial(Data.NULL, Data.NULL);

    private static final Int2ObjectMap<GTSPWeaponMaterial> TIERS_LOOKUP = new Int2ObjectOpenHashMap<>();

    static {
        TIERS_LOOKUP.put(NULL.hashCode(), NULL);
    }

    GTSPWeaponMaterial(@Nonnull Material primary, @Nonnull Material secondary) {
        super(primary.getId(), primary.getDomain(), primary.getRGB(), secondary.getRGB(), primary.getToolQuality(), primary.getToolDurability() + secondary.getHandleDurability(), primary.getToolSpeed() + secondary.getHandleSpeed(), primary.getToolDamage(), (int) (primary.getToolQuality() + primary.getToolSpeed() + secondary.getToolSpeed()), null);
        this.primary = primary;
        this.secondary = secondary;
        if (primary.getId().contains("silver")) {
            this.traits = Collections.singletonList(WeaponTraits.EXTRA_DAMAGE_50P_UNDEAD);
        } else if (primary.getId().equals("lead")){
            this.traits = Collections.singletonList(WeaponTraits.HEAVY);
        } else if (primary.getId().equals("netherite") || primary.getId().equals("netherized_diamond")){
            this.traits = Collections.singletonList(WeaponTraits.FIREPROOF);
        }
    }

    @Override
    public String getModId() {
        return primary.getDomain();
    }

    public static Optional<GTSPWeaponMaterial> get(int key) {
        return Optional.ofNullable(TIERS_LOOKUP.get(key));
    }

    public static GTSPWeaponMaterial getOrCreate(String primaryName, String secondaryName) {
        return TIERS_LOOKUP.computeIfAbsent(Objects.hash(primaryName, secondaryName), m -> new GTSPWeaponMaterial(Material.get(primaryName), Material.get(secondaryName)));
    }

    public static GTSPWeaponMaterial getOrCreate(Material primary, Material secondary) {
        return TIERS_LOOKUP.computeIfAbsent(Objects.hash(primary.hashCode(), secondary.hashCode()), m -> new GTSPWeaponMaterial(primary, secondary));
    }

    @Override
    public Ingredient getRepairMaterial() {
        if (primary.has(Data.GEM)) {
            return Ingredient.fromTag(TagUtils.getForgeItemTag("gems/".concat(primary.getId())));
        }
        else if (primary.has(Data.INGOT)) {
            return Ingredient.fromTag(TagUtils.getForgeItemTag("ingots/".concat(primary.getId())));
        }
        else if (primary.has(Data.DUST)) {
            return Ingredient.fromTag(TagUtils.getForgeItemTag("dusts/".concat(primary.getId())));
        }
        else if (ItemTags.getCollection().get(new ResourceLocation("forge", "blocks/".concat(primary.getId()))) != null) {
            return Ingredient.fromTag(TagUtils.getForgeItemTag("blocks/".concat(primary.getId())));
        }
        return Ingredient.EMPTY;
        // return null;
    }

    public Material getPrimary() {
        return primary;
    }

    public Material getSecondary() {
        return secondary;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        GTSPWeaponMaterial tier = (GTSPWeaponMaterial) obj;
        return primary == tier.getPrimary() && secondary == tier.getSecondary();
    }

    @Override
    public int hashCode() {
        return Objects.hash(primary.hashCode(), secondary.hashCode());
    }

    @Override
    public boolean hasAnyWeaponTrait() {
        return primary != Data.NULL && secondary != Data.NULL && super.hasAnyWeaponTrait();
    }
}
