package eu.nac.config;

import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;

public class Configuration {
    @Getter private boolean testingMode;

    public void load(final FileConfiguration config) {
        testingMode = config.getBoolean("testing-mode");
    }
}
