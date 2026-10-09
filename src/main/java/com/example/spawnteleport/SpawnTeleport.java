package com.example.spawnteleport;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class SpawnTeleport extends JavaPlugin implements Listener {

    private static final String WORLD_NAME = "spawn";
    private static final double X = 0.500;
    private static final double Y = 97.00000;
    private static final double Z = 0.500;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("SpawnTeleport enabled: players will be sent to world '" + WORLD_NAME + "' on join.");
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        // Run one tick later so the player is fully loaded in before being teleported.
        getServer().getScheduler().runTask(this, () -> {
            if (!player.isOnline()) {
                return;
            }

            World world = getServer().getWorld(WORLD_NAME);
            if (world == null) {
                getLogger().warning("World '" + WORLD_NAME + "' is not loaded; cannot teleport " + player.getName() + ".");
                return;
            }

            // Keep the player's current facing direction.
            Location current = player.getLocation();
            Location target = new Location(world, X, Y, Z, current.getYaw(), current.getPitch());
            player.teleport(target);
        });
    }
}
