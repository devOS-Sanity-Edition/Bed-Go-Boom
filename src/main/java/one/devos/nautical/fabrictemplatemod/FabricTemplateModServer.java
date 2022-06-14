package one.devos.nautical.fabrictemplatemod;

import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FabricTemplateModServer implements DedicatedServerModInitializer {
	public static final String MOD_ID = "fabrictemplatemod";
	public static final String VERSION = FabricLoader.getInstance().getModContainer(MOD_ID).get().getMetadata().getVersion().getFriendlyString();
	public static final String MOD_NAME = FabricLoader.getInstance().getModContainer(MOD_ID).get().getMetadata().getName();

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

	@Override
	public void onInitializeServer() {
		LOGGER.info("[" + MOD_NAME + "] Version " + VERSION + " loaded." );
		LOGGER.info("[" + MOD_NAME + "] " + "Insert witty text here");
	}
}
