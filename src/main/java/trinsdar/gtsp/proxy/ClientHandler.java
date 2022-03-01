package trinsdar.gtsp.proxy;

import muramasa.antimatter.proxy.IProxyHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientHandler implements IProxyHandler {

    public ClientHandler(){

    }

    @SuppressWarnings("RedundantTypeArguments")
    public static void setup(FMLClientSetupEvent e) {
    }

    @Override
    public World getClientWorld() {
        return Minecraft.getInstance().level;
    }

    @Override
    public PlayerEntity getClientPlayer() {
        return Minecraft.getInstance().player;
    }
}
