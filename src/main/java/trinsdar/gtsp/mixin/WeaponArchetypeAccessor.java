package trinsdar.gtsp.mixin;

import com.oblivioussp.spartanweaponry.api.trait.WeaponTrait;
import com.oblivioussp.spartanweaponry.util.WeaponArchetype;
import net.minecraft.tags.TagKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(WeaponArchetype.class)
public interface WeaponArchetypeAccessor {

    @Accessor
    TagKey<WeaponTrait> getTraitsTag();
}
