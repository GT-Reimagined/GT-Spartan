package org.gtreimagined.gtspartan.datagen;

import com.oblivioussp.spartanweaponry.api.WeaponTraits;
import com.oblivioussp.spartanweaponry.api.tags.ModWeaponTraitTags;
import com.oblivioussp.spartanweaponry.api.trait.WeaponTrait;
import muramasa.antimatter.datagen.providers.AntimatterTagProvider;
import muramasa.antimatter.material.MaterialTags;
import net.minecraft.core.Registry;

public class GTSPWeaponTraitTagProvider extends AntimatterTagProvider<WeaponTrait> {
    public GTSPWeaponTraitTagProvider(String providerDomain, String providerName) {
        super((Registry<WeaponTrait>) Registry.REGISTRY.get(WeaponTraits.REGISTRY_KEY.location()), providerDomain, providerName, "spartanweaponry/weapon_traits");
    }

    @Override
    protected void processTags(String domain) {
        MaterialTags.TOOLS.all().forEach(m -> {
            this.tag(ModWeaponTraitTags.create("materials/" + m.getId()));
        });
    }
}
