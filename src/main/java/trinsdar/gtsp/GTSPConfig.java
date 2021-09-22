package trinsdar.gtsp;

import muramasa.antimatter.Ref;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GTSPConfig {

    public static final Data DATA = new Data();
    //public static final ModCompatibility MOD_COMPAT = new ModCompatibility();

    public static final CommonConfig COMMON_CONFIG;
    public static final ForgeConfigSpec COMMON_SPEC;

    static {

        final Pair<CommonConfig, ForgeConfigSpec> COMMON_PAIR = new ForgeConfigSpec.Builder().configure(CommonConfig::new);
        COMMON_CONFIG = COMMON_PAIR.getLeft();
        COMMON_SPEC = COMMON_PAIR.getRight();

    }

    @SubscribeEvent
    public static void onModConfigEvent(final ModConfig.ModConfigEvent e) {
        if (e.getConfig().getSpec() == COMMON_SPEC) bakeCommonConfig();

    }

    public static class Data {

        /** @see CommonConfig **/

        public boolean ALL_MATERIAL_ITEMS, ITEM_REPLACEMENTS;

    }

    public static class Gameplay {
    }

    public static class CommonConfig {
        public CommonConfig(ForgeConfigSpec.Builder builder) {


        }

    }

    private static void bakeCommonConfig() {

    }
}
