package eu.nac;

import eu.nac.command.AlertsCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class NACPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        NAC.INSTANCE.start(this);
        getCommand("alerts").setExecutor(new AlertsCommand());
    }

    @Override
    public void onDisable() {
        NAC.INSTANCE.stop(this);
    }
}
