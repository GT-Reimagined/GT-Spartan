package trinsdar.gtsp;

import carbonconfiglib.config.Config;
import carbonconfiglib.config.ConfigEntry.ArrayValue;
import carbonconfiglib.config.ConfigEntry.BoolValue;
import carbonconfiglib.config.ConfigHandler;
import carbonconfiglib.config.ConfigSection;
import carbonconfiglib.impl.ReloadMode;
import muramasa.antimatter.util.AntimatterPlatformUtils;

import java.util.List;

public class GTSPConfig {
    static ConfigHandler CONFIG;
    public static BoolValue ENABLE_SPARTAN_TOOL_MODIFICATIONS, REMOVE_MODDED_WEAPONS, REMOVE_WOODEN_WEAPONS, OVERRIDE_VANILLA_SPARTAN_RECIPES;
    public static ArrayValue HIDDEN_MODDED_TOOL_MATERIALS;
    public static final List<String> DEFAULT_MODDED_TOOL_MATERIALS = List.of("copper", "tin", "bronze", "steel", "silver", "electrum", "lead", "nickel", "invar", "constantan", "platinum", "aluminum");

    public static void createConfig() {
        Config config = new Config(GTSPRef.ID);
        ConfigSection general = config.add("general");
        ENABLE_SPARTAN_TOOL_MODIFICATIONS = general.addBool("enable_spartan_tool_modifications", false, "Enables gt spartan replacing underlying code of iron, golden, and diamond spartan weapons.").setRequiredReload(ReloadMode.GAME);
        REMOVE_MODDED_WEAPONS = general.addBool("remove_modded_weapons", true, "Enables gt spartan hiding and removing recipes of all the modded variants of spartan weapons added by spartan weaponry.");
        REMOVE_WOODEN_WEAPONS = general.addBool("remove_wooden_weapons", true, "Enables gt spartan hiding and removing recipes of all the spartan weaponry wood weapons, except the bows.");
        OVERRIDE_VANILLA_SPARTAN_RECIPES = general.addBool("override_vanilla_spartan_recipes", true, "Enables gt spartan replacing the iron, gold, and diamond weapon recipes with more gregified versions.");
        HIDDEN_MODDED_TOOL_MATERIALS = general.addArray("hidden_modded_tool_materials", DEFAULT_MODDED_TOOL_MATERIALS.toArray(String[]::new), "List of modded tools from spartan weaponry that gt spartan removes.", "Any additional values added will be ignored though, can only remove values.");
        CONFIG = AntimatterPlatformUtils.INSTANCE.createConfig(GTSPRef.ID, config);
        CONFIG.register();
    }
}
