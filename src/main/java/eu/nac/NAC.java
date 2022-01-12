package eu.nac;

import eu.nac.config.Configuration;
import eu.nac.data.PlayerDataManager;
import eu.nac.event.EventListener;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.Plugin;

public enum NAC {
    INSTANCE;

    @Getter private Plugin              plugin;
    @Getter private PlayerDataManager   playerDataManager;
    @Getter private EventListener       eventListener;
    @Getter private Configuration       configuration;

    public void start(final Plugin plugin) {
        this.plugin             = plugin;
        this.playerDataManager  = new PlayerDataManager();
        this.eventListener      = new EventListener();
        this.configuration      = new Configuration();
        Bukkit.getPluginManager().registerEvents(eventListener, plugin);
        configuration.load(plugin.getConfig());
        plugin.saveDefaultConfig();
    }

    public void stop(final Plugin plugin) {
        this.plugin = plugin;
        HandlerList.unregisterAll(plugin);
    }
}
