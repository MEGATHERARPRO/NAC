package eu.nac.data;

import org.bukkit.entity.Player;

import java.util.*;

public class PlayerDataManager {
    private final Map<UUID, PlayerData> dataMap = new HashMap<>();

    public void add(final Player player) { dataMap.put(player.getUniqueId(), new PlayerData(player.getUniqueId())); }

    public void remove(final Player player) { dataMap.remove(player.getUniqueId()); }

    public boolean contains(final Player player) { return dataMap.containsKey(player.getUniqueId()); }

    public PlayerData get(final Player player) { return dataMap.get(player.getUniqueId()); }

    public List<PlayerData> list() { return new ArrayList<>(dataMap.values()); }
}
