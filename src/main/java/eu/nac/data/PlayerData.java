package eu.nac.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.UUID;

@RequiredArgsConstructor
public class PlayerData {
    @Getter private final UUID uniqueId;
    @Getter private boolean alerts;

    public String getName() { return getPlayer().getName(); }

    public Player getPlayer() { return Bukkit.getPlayer(uniqueId); }

    public void sendMessage(final String message) {
        getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    public void toggleAlerts() {
        sendMessage("&8[&aNAC&8] &aAlerts &7are now &a" + ((alerts = !alerts) ? "on" : "off") + "&7.");
    }
}
