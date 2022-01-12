package eu.nac;

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

    public void start(final Plugin plugin) {
        this.plugin             = plugin;
        this.playerDataManager  = new PlayerDataManager();
        this.eventListener      = new EventListener();
        Bukkit.getPluginManager().registerEvents(eventListener, plugin);
    }

    public void stop(final Plugin plugin) {
        this.plugin = plugin;
        HandlerList.unregisterAll(plugin);
    }
}
