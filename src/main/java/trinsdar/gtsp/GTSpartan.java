package trinsdar.gtsp;

import com.oblivioussp.spartanweaponry.item.HeavyCrossbowItem;
import com.oblivioussp.spartanweaponry.item.LongbowItem;
import muramasa.antimatter.Antimatter;
import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.AntimatterDynamics;
import muramasa.antimatter.AntimatterMod;
import muramasa.antimatter.Data;
import muramasa.antimatter.datagen.ExistingFileHelperOverride;
import muramasa.antimatter.datagen.providers.AntimatterBlockTagProvider;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.proxy.IProxyHandler;
import muramasa.antimatter.recipe.loader.IRecipeRegistrate;
import muramasa.antimatter.registration.RegistrationEvent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import trinsdar.gtsp.data.Tools;
import trinsdar.gtsp.datagen.GTSPItemModelProvider;
import trinsdar.gtsp.datagen.GTSPItemTagProvider;
import trinsdar.gtsp.datagen.GTSPLocalizations;
import trinsdar.gtsp.datagen.GTSPRecipes;
import trinsdar.gtsp.proxy.ClientHandler;
import trinsdar.gtsp.proxy.CommonHandler;
import trinsdar.gtsp.proxy.ServerHandler;

import static trinsdar.gtsp.data.Materials.HANDLE;
import static trinsdar.gtsp.data.Materials.POLE;


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

        AntimatterDynamics.addProvider(Ref.ID, g -> new GTSPItemModelProvider(Ref.ID, Ref.NAME + " Item Models", g));
        AntimatterDynamics.addProvider(Ref.ID, g -> {
            p[0] = new AntimatterBlockTagProvider(Ref.ID, Ref.NAME.concat(" Block Tags"), false, g, new ExistingFileHelperOverride());
            return p[0];
        });
        AntimatterDynamics.addProvider(Ref.ID, g -> new GTSPItemTagProvider(Ref.ID, Ref.NAME.concat(" Item Tags"), false, g, p[0], new ExistingFileHelperOverride()));
        AntimatterDynamics.addProvider(Ref.ID, g -> new GTSPRecipes(Ref.ID, Ref.NAME.concat(" Recipes"), g));
        AntimatterDynamics.addProvider(Ref.ID, GTSPLocalizations.en_US::new);

        registerRecipeLoaders();
        AntimatterAPI.addRegistrar(new SpartanRegistrar());
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
    }

    private void registerRecipeLoaders() {
        IRecipeRegistrate loader = AntimatterAPI.getRecipeRegistrate();
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
            if (wood != Data.NULL){
                Antimatter.LOGGER.info("Overriding wood");
                HANDLE.forceOverride(wood, ForgeRegistries.ITEMS.getValue(new ResourceLocation(Ref.MOD_SPARTAN_WEAPONRY, "handle")));
                POLE.forceOverride(wood, ForgeRegistries.ITEMS.getValue(new ResourceLocation(Ref.MOD_SPARTAN_WEAPONRY, "pole")));
            }
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
