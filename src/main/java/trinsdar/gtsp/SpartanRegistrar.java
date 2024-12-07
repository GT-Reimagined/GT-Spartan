package trinsdar.gtsp;

import muramasa.antimatter.AntimatterMod;
import muramasa.antimatter.registration.IAntimatterRegistrar;
import muramasa.antimatter.registration.RegistrationEvent;
import muramasa.antimatter.registration.Side;
import trinsdar.gtsp.data.MaterialTypes;

public class SpartanRegistrar extends AntimatterMod {
    @Override
    public void onRegistrationEvent(RegistrationEvent event, Side side) {
        if (event == RegistrationEvent.DATA_INIT) {
            MaterialTypes.init();
        }
    }

    @Override
    public String getId() {
        return GTSPRef.MOD_SPARTAN_WEAPONRY;
    }

    public int getPriority() {
        return Integer.MIN_VALUE;
    }
}
