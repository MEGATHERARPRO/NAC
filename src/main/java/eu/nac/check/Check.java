package eu.nac.check;

import eu.nac.NAC;
import eu.nac.data.PlayerData;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public abstract class Check {
    @Getter protected final PlayerData data;
    @Getter private final String name;
    private final int max;
    protected double vl;

    public Check(final PlayerData data) {
        this.data = data;

        final CheckInfo info = this.getClass().getAnnotation(CheckInfo.class);
        name = info.name();
        max  = info.max();
    }

    public void debug(final String message) {
        data.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&aNAC&8] &7" + message));
    }

    public void fail() {
        vl++;
        NAC.INSTANCE.getPlayerDataManager().list().forEach(data -> { if (NAC.INSTANCE.getConfiguration().isTestingMode() || data.isAlerts()) data.sendMessage("&8[&aNAC&8] &a" + data.getName() + "&7 failed &a" + name + " &8(&ax" + (int) vl + "&8)"); });
        if (vl >= max) {
            vl = 0;
            Bukkit.getScheduler().runTask(NAC.INSTANCE.getPlugin(), () -> data.getPlayer().kickPlayer(ChatColor.translateAlternateColorCodes('&', "&8[&aNAC&8] &aUnfair Advantage")));
        }
    }
}
