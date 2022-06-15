package one.devos.nautical.bedgoboom;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;

public class Boom implements ModInitializer {
    public static BoomConfig CONFIG;

    @Override
    public void onInitialize() {
        CONFIG = new BoomConfig(FabricLoader.getInstance().getConfigDir().resolve("bedgoboom.properties"));
        try {
            CONFIG.initialize();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
