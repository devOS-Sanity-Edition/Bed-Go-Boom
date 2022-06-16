package one.devos.nautical.bedgoboom;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Boom implements ModInitializer {
    public static BoomConfig CONFIG;

    public static final String MOD_ID = "bedgoboom";
    public static final String VERSION = FabricLoader.getInstance().getModContainer(MOD_ID).get().getMetadata().getVersion().getFriendlyString();
    public static final String MOD_NAME = FabricLoader.getInstance().getModContainer(MOD_ID).get().getMetadata().getName();

    public static final Logger LOGGER = LogManager.getLogger(MOD_NAME);

    @Override
    public void onInitialize() {
        LOGGER.info("[" + MOD_NAME + "] Version " + VERSION + " loaded." );
        LOGGER.info("[" + MOD_NAME + "] " + "https://www.youtube.com/watch?v=uL4l1yRhTRY");

        CONFIG = new BoomConfig(FabricLoader.getInstance().getConfigDir().resolve("bedgoboom.properties"));
        try {
            CONFIG.initialize();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
