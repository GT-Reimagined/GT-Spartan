package trinsdar.gtsp;

import muramasa.antimatter.registration.IAntimatterRegistrar;
import muramasa.antimatter.registration.RegistrationEvent;
import net.minecraftforge.api.distmarker.Dist;
import trinsdar.gtsp.data.Materials;
import trinsdar.gtsp.data.Tools;

public class SpartanRegistrar implements IAntimatterRegistrar {
    @Override
    public void onRegistrationEvent(RegistrationEvent event, Dist side) {
        if (event == RegistrationEvent.DATA_INIT) {
            Materials.init();
        }
    }

    @Override
    public String getId() {
        return Ref.MOD_SPARTAN_WEAPONRY;
    }
}
