package eu.nac.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

@RequiredArgsConstructor
public class PlayerData {
    @Getter private final UUID uniqueId;

    public String getName() { return getPlayer().getName(); }

    public Player getPlayer() { return Bukkit.getPlayer(uniqueId); }
}
