package org.gtreimagined.gtspartan;

import com.oblivioussp.spartanweaponry.api.SpartanWeaponryAPI;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import org.gtreimagined.gtlib.GTMod;
import org.gtreimagined.gtlib.registration.RegistrationEvent;
import org.gtreimagined.gtspartan.data.MaterialTypes;

public class SpartanRegistrar extends GTMod {
    @Override
    public void onRegistrationEvent(RegistrationEvent event, Dist side) {
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
