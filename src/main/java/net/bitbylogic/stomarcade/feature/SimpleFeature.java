package net.bitbylogic.stomarcade.feature;

import net.bitbylogic.stomarcade.StomArcadeServer;
import org.jetbrains.annotations.NotNull;
import org.simpleyaml.configuration.file.YamlFile;

import java.io.File;
import java.io.IOException;

public abstract class SimpleFeature implements Feature {

    private final String id;

    private final YamlFile config;

    public SimpleFeature(@NotNull String id) {
        this.id = id.toLowerCase();
        File configFile = new File("configs", String.format("%s.yml", id));

        YamlFile config = null;

        try {
            configFile.getParentFile().mkdirs();
            configFile.createNewFile();

            config = new YamlFile(configFile);
            config.load();
        } catch (IOException e) {
            StomArcadeServer.LOGGER.error("Failed to create config file for feature {}", id, e);
        }

        this.config = config;
    }

    @Override
    public @NotNull String id() {
        return id;
    }

    protected YamlFile config() {
        return config;
    }

    protected void saveConfig() {
        if (config == null) {
            return;
        }

        try {
            config.save();
        } catch (IOException e) {
            StomArcadeServer.LOGGER.error("Failed to save config file for feature {}", id, e);
        }
    }

    @Override
    public void reloadConfig() {
        if (config == null) {
            return;
        }

        try {
            config.load();
        } catch (IOException e) {
            StomArcadeServer.LOGGER.error("Failed to reload config file for feature {}", id, e);
        }
    }

}
