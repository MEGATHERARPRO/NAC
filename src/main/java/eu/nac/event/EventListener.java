package eu.nac.event;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import eu.nac.NAC;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class EventListener implements Listener {
    public EventListener() {
        ProtocolLibrary.getProtocolManager().addPacketListener(new PacketAdapter(
                NAC.INSTANCE.getPlugin(),
                PacketType.Play.Client.FLYING,
                PacketType.Play.Client.POSITION,
                PacketType.Play.Client.LOOK,
                PacketType.Play.Client.POSITION_LOOK
        ) {
            @Override
            public void onPacketReceiving(final PacketEvent e) {

            }

            @Override
            public void onPacketSending(final PacketEvent e) {

            }
        });
    }

    @EventHandler
    public void onJoin(final PlayerJoinEvent e) {
        NAC.INSTANCE.getPlayerDataManager().add(e.getPlayer());
    }

    @EventHandler
    public void onQuit(final PlayerQuitEvent e) {
        NAC.INSTANCE.getPlayerDataManager().remove(e.getPlayer());
    }
}
