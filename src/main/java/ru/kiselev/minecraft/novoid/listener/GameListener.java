package ru.kiselev.minecraft.novoid.listener;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import ru.kiselev.minecraft.novoid.Plugin;

public class GameListener implements Listener {

    @EventHandler
    public void onPlayerMove(final PlayerMoveEvent event) {
        final Plugin plugin = Plugin.getInstance();
        final FileConfiguration configFile = plugin.getConfig();

        final Player player = event.getPlayer();
        final int y = player.getLocation().getBlockY();
        final Location spawn = player.getWorld().getSpawnLocation();
        if (y < configFile.getInt("height")) {
            player.teleport(spawn);
        }
    }
}