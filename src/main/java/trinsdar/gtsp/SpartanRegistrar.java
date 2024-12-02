package trinsdar.gtsp;

import muramasa.antimatter.registration.IAntimatterRegistrar;
import muramasa.antimatter.registration.RegistrationEvent;
import muramasa.antimatter.registration.Side;
import net.minecraftforge.api.distmarker.Dist;
import trinsdar.gtsp.data.MaterialTypes;
import trinsdar.gtsp.data.Materials;

public class SpartanRegistrar implements IAntimatterRegistrar {
    @Override
    public void onRegistrationEvent(RegistrationEvent event, Side side) {
        if (event == RegistrationEvent.DATA_INIT) {
            MaterialTypes.init();
        }
    }

    @Override
    public String getId() {
        return Ref.MOD_SPARTAN_WEAPONRY;
    }

    public int getPriority() {
        return Integer.MIN_VALUE;
    }

    @Override
    public void onRegistrarInit() {

    }
}
