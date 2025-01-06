package org.gtreimagined.gtspartan;

import com.oblivioussp.spartanweaponry.api.SpartanWeaponryAPI;
import muramasa.antimatter.AntimatterMod;
import muramasa.antimatter.registration.RegistrationEvent;
import muramasa.antimatter.registration.Side;
import org.gtreimagined.gtspartan.data.MaterialTypes;

public class SpartanRegistrar extends AntimatterMod {
    @Override
    public void onRegistrationEvent(RegistrationEvent event, Side side) {
        if (event == RegistrationEvent.DATA_INIT) {
            MaterialTypes.init();
        }
    }

    @Override
    public String getId() {
        return SpartanWeaponryAPI.MOD_ID;
    }

    public int getPriority() {
        return Integer.MIN_VALUE;
    }
}
