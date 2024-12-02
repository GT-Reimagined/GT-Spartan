package trinsdar.gtsp;

import muramasa.antimatter.AntimatterMod;
import muramasa.antimatter.datagen.providers.AntimatterBlockTagProvider;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.proxy.IProxyHandler;
import muramasa.antimatter.registration.RegistrationEvent;
import muramasa.antimatter.registration.Side;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import trinsdar.gtsp.data.Tools;
import trinsdar.gtsp.proxy.ClientHandler;
import trinsdar.gtsp.proxy.CommonHandler;
import trinsdar.gtsp.proxy.ServerHandler;


@Mod(Ref.ID)
public class GTSpartan extends AntimatterMod {

    public static GTSpartan INSTANCE;
    public static IProxyHandler PROXY;
    public static Logger LOGGER = LogManager.getLogger(Ref.ID);

    public GTSpartan() {
        super();
        INSTANCE = this;
        PROXY = DistExecutor.runForDist(() -> ClientHandler::new, () -> ServerHandler::new); // todo: scheduled to change in new Forge
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::serverSetup);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, GTSPConfig.COMMON_SPEC);
        MinecraftForge.EVENT_BUS.register(this);
        //GregTechAPI.addRegistrar(new ForestryRegistrar());
        //GregTechAPI.addRegistrar(new GalacticraftRegistrar());
        //if (ModList.get().isLoaded(Ref.MOD_UB)) GregTechAPI.addRegistrar(new UndergroundBiomesRegistrar());
        final AntimatterBlockTagProvider[] p = new AntimatterBlockTagProvider[1];

        /*AntimatterDynamics.addProvider(Ref.ID, g -> new AntimatterItemModelProvider(Ref.ID, Ref.NAME + " Item Models", g));
        AntimatterDynamics.addProvider(Ref.ID, g -> {
            p[0] = new AntimatterBlockTagProvider(Ref.ID, Ref.NAME.concat(" Block Tags"), false, g, new ExistingFileHelperOverride());
            return p[0];
        });
        AntimatterDynamics.addProvider(Ref.ID, g -> new GTSPItemTagProvider(Ref.ID, Ref.NAME.concat(" Item Tags"), false, g, p[0], new ExistingFileHelperOverride()));
        AntimatterDynamics.addProvider(Ref.ID, g -> new AntimatterLanguageProvider(Ref.ID, Ref.NAME + " en_us Localization", "en_us", g));

        AntimatterAPI.addRegistrar(new SpartanRegistrar());
        MinecraftForge.EVENT_BUS.addListener(GTSpartan::registerCraftingLoaders);*/
    }

    /*private static void registerCraftingLoaders(AntimatterCraftingEvent event){
        event.addLoader(ToolCrafting::loadRecipes);
        event.addLoader(MaterialCrafting::loadRecipes);
    }

    //@SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event){
        if (event.phase == TickEvent.Phase.END){
            PlayerEntity player = event.player;
            ItemStack stack = player.getHeldItemMainhand();
            if (stack.getItem() instanceof LongbowItem || stack.getItem() instanceof HeavyCrossbowItem){
                if (stack.hasTag()){
                    //noinspection ConstantConditions
                    Antimatter.LOGGER.info(stack.getTag().toString());
                }
            }
        }
    }*/

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
                HANDLE.forceOverride(wood, ForgeRegistries.ITEMS.getValue(new ResourceLocation(Ref.MOD_SPARTAN_WEAPONRY, "handle")));
                POLE.forceOverride(wood, ForgeRegistries.ITEMS.getValue(new ResourceLocation(Ref.MOD_SPARTAN_WEAPONRY, "pole")));
            }*/
        }
    }

    public int getPriority() {
        return 4000;
    }

    @Override
    public String getId() {
        return Ref.ID;
    }
}
