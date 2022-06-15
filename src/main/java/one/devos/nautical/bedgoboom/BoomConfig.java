package one.devos.nautical.bedgoboom;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.Properties;

public class BoomConfig {
    private static final String COMMENT =
            "This file stores configuration options for BedGoBoom";


    private boolean explodeBedInOverworld;
    private boolean allowAnchorInEnd;

    private final Path propertiesPath;

    public BoomConfig(Path propertiesPath) {
        explodeBedInOverworld = true;
        allowAnchorInEnd = true;
        this.propertiesPath = propertiesPath;
    }

    /**
     * Initializes the configuration, loading it if it is present and creating a default config otherwise.
     *
     * @throws IOException file exceptions
     */
    public void initialize() throws IOException {
        load();
        if (!Files.exists(propertiesPath)) {
            save();
        }
    }

    public boolean shouldExplodeBedInOverworld() {
        return explodeBedInOverworld;
    }

    public boolean shouldAllowAnchorInEnd() {
        return allowAnchorInEnd;
    }

    public void load() throws IOException {
        if (!Files.exists(propertiesPath)) {
            return;
        }

        Properties properties = new Properties();
        // NB: This uses ISO-8859-1 with unicode escapes as the encoding
        properties.load(Files.newInputStream(propertiesPath));
        explodeBedInOverworld = "true".equals(properties.getProperty("explodeBedInOverworld"));
        allowAnchorInEnd = "true".equals(properties.getProperty("allowAnchorInEnd"));
    }

    /**
     * Serializes the config into a file. Should be called whenever any config values are modified.
     *
     * @throws IOException file exceptions
     */
    public void save() throws IOException {
        Properties properties = new Properties();
        properties.setProperty("explodeBedInOverworld", explodeBedInOverworld ? "true" : "false");
        properties.setProperty("allowAnchorInEnd", allowAnchorInEnd ? "true" : "false");
        // NB: This uses ISO-8859-1 with unicode escapes as the encoding
        properties.store(Files.newOutputStream(propertiesPath), COMMENT);
    }
}
