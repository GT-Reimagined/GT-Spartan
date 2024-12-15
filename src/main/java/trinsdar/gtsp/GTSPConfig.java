package trinsdar.gtsp;

import carbonconfiglib.config.Config;
import carbonconfiglib.config.ConfigEntry.BoolValue;
import carbonconfiglib.config.ConfigHandler;
import carbonconfiglib.config.ConfigSection;
import carbonconfiglib.impl.ReloadMode;
import muramasa.antimatter.Ref;
import muramasa.antimatter.util.AntimatterPlatformUtils;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

public class GTSPConfig {
    static ConfigHandler CONFIG;
    public static BoolValue ENABLE_SPARTAN_TOOL_MODIFICATIONS;

    public static void createConfig() {
        Config config = new Config(GTSPRef.ID);
        ConfigSection general = config.add("general");
        ENABLE_SPARTAN_TOOL_MODIFICATIONS = general.addBool("enable_spartan_tool_modifications", false, "Enables gt spartan replacing underlying code of iron, golden, and diamond spartan weapons.").setRequiredReload(ReloadMode.GAME);
        CONFIG = AntimatterPlatformUtils.INSTANCE.createConfig(GTSPRef.ID, config);
        CONFIG.register();
    }
}
