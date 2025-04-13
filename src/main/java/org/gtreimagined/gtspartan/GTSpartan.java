package org.gtreimagined.gtspartan;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.gtreimagined.gtlib.GTMod;
import org.gtreimagined.gtlib.datagen.GTLibDynamics;
import org.gtreimagined.gtlib.datagen.providers.GTBlockTagProvider;
import org.gtreimagined.gtlib.datagen.providers.GTItemModelProvider;
import org.gtreimagined.gtlib.event.GTCraftingEvent;
import org.gtreimagined.gtlib.event.GTProvidersEvent;
import org.gtreimagined.gtlib.material.Material;
import org.gtreimagined.gtlib.proxy.IProxyHandler;
import org.gtreimagined.gtlib.registration.RegistrationEvent;
import org.gtreimagined.gtspartan.data.Tools;
import org.gtreimagined.gtspartan.datagen.GTSPItemTagProvider;
import org.gtreimagined.gtspartan.datagen.GTSPWeaponTraitTagProvider;
import org.gtreimagined.gtspartan.loader.crafting.MaterialCrafting;
import org.gtreimagined.gtspartan.loader.crafting.ToolCrafting;
import org.gtreimagined.gtspartan.proxy.ClientHandler;
import org.gtreimagined.gtspartan.proxy.CommonHandler;
import org.gtreimagined.gtspartan.proxy.ServerHandler;


@Mod(GTSpartan.ID)
public class GTSpartan extends GTMod {

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
        GTLibDynamics.clientProvider(ID, () -> new GTItemModelProvider(ID, NAME + " Item Models"));
        new SpartanRegistrar();
        GTSPConfig.createConfig();
    }

    public void registerCraftingLoaders(GTCraftingEvent event){
        event.addLoader(ToolCrafting::loadStandardToolRecipes);
        event.addLoader(ToolCrafting::removeSpartanWeaponryRecipes);
        event.addLoader(MaterialCrafting::loadRecipes);
    }

    private void onProviders(GTProvidersEvent ev){
        ev.addProvider(() -> new GTSPWeaponTraitTagProvider(ID, NAME + " Weapon Trait Tags"));
        final GTBlockTagProvider[] p = new GTBlockTagProvider[1];
        ev.addProvider(() -> {
            p[0] = new GTBlockTagProvider(ID, NAME.concat(" Block Tags"), false);
            return p[0];
        });
        ev.addProvider(() -> new GTSPItemTagProvider(ID, NAME.concat(" Item Tags"), false, p[0]));
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
    public void onRegistrationEvent(RegistrationEvent event, Dist side) {
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
