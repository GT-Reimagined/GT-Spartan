package org.gtreimagined.gtspartan.proxy;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.common.Mod;
import org.gtreimagined.gtlib.proxy.IProxyHandler;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class ServerHandler implements IProxyHandler {
    @Override
    public Level getClientWorld() {
        throw new IllegalStateException("Cannot call on server!");
    }

    @Override
    public Player getClientPlayer() {
        throw new IllegalStateException("Cannot call on server!");
    }
}
