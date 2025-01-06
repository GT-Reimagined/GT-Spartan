package org.gtreimagined.gtspartan;

import muramasa.antimatter.AntimatterMod;
import muramasa.antimatter.datagen.providers.AntimatterBlockTagProvider;
import muramasa.antimatter.event.forge.AntimatterCraftingEvent;
import muramasa.antimatter.event.forge.AntimatterProvidersEvent;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.proxy.IProxyHandler;
import muramasa.antimatter.registration.RegistrationEvent;
import muramasa.antimatter.registration.Side;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.gtreimagined.gtspartan.data.Tools;
import org.gtreimagined.gtspartan.datagen.GTSPItemTagProvider;
import org.gtreimagined.gtspartan.datagen.GTSPWeaponTraitTagProvider;
import org.gtreimagined.gtspartan.loader.crafting.MaterialCrafting;
import org.gtreimagined.gtspartan.loader.crafting.ToolCrafting;
import org.gtreimagined.gtspartan.proxy.ClientHandler;
import org.gtreimagined.gtspartan.proxy.CommonHandler;
import org.gtreimagined.gtspartan.proxy.ServerHandler;


@Mod(GTSpartan.ID)
public class GTSpartan extends AntimatterMod {

    public static final String NAME = "GT Spartan";
    public static GTSpartan INSTANCE;
    public static IProxyHandler PROXY;
    /** Mod Data **/
    public static final String ID = "gtspartan";
    public static Logger LOGGER = LogManager.getLogger(ID);

    public GTSpartan() {
        super();
        INSTANCE = this;
        PROXY = DistExecutor.runForDist(() -> ClientHandler::new, () -> ServerHandler::new); // todo: scheduled to change in new Forge
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::serverSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onProviders);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::registerCraftingLoaders);
        MinecraftForge.EVENT_BUS.register(this);
        new SpartanRegistrar();
        GTSPConfig.createConfig();
    }

    public void registerCraftingLoaders(AntimatterCraftingEvent event){
        event.addLoader(ToolCrafting::loadStandardToolRecipes);
        event.addLoader(ToolCrafting::removeSpartanWeaponryRecipes);
        event.addLoader(MaterialCrafting::loadRecipes);
    }

    private void onProviders(AntimatterProvidersEvent ev){
        ev.addProvider(ID, () -> new GTSPWeaponTraitTagProvider(ID, NAME + " Weapon Trait Tags"));
        final AntimatterBlockTagProvider[] p = new AntimatterBlockTagProvider[1];
        ev.addProvider(ID, () -> {
            p[0] = new AntimatterBlockTagProvider(ID, NAME.concat(" Block Tags"), false);
            return p[0];
        });
        ev.addProvider(ID, () -> new GTSPItemTagProvider(ID, NAME.concat(" Item Tags"), false, p[0]));
    }

    private void clientSetup(final FMLClientSetupEvent e) {
        ClientHandler.setup(e);
    }

    private void setup(final FMLCommonSetupEvent e) {
        CommonHandler.setup(e);

    }

    private void serverSetup(final FMLDedicatedServerSetupEvent event){

    }

    @Override
    public void onRegistrationEvent(RegistrationEvent event, Side side) {
        if (event == RegistrationEvent.DATA_INIT) {
            Tools.init();
        }
        if (event == RegistrationEvent.DATA_READY){
            Material wood = Material.get("wood");
            /*if (wood != Data.NULL){
                Antimatter.LOGGER.info("Overriding wood");
                HANDLE.forceOverride(wood, ForgeRegistries.ITEMS.getValue(new ResourceLocation(GTSPRef.MOD_SPARTAN_WEAPONRY, "handle")));
                POLE.forceOverride(wood, ForgeRegistries.ITEMS.getValue(new ResourceLocation(GTSPRef.MOD_SPARTAN_WEAPONRY, "pole")));
            }*/
        }
    }

    public int getPriority() {
        return 4000;
    }

    @Override
    public String getId() {
        return ID;
    }
}
