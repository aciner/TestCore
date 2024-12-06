package me.aciner.test.events;

import me.aciner.test.Test;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;
import java.io.IOException;

public class JoinEvent implements Listener {
    private final Test plugin;

    public JoinEvent(Test plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        File playerDataFolder = plugin.getPlayerDataFolder(plugin);

        File playerDataFile = new File(playerDataFolder, player.getUniqueId() + ".yml");

        if (!playerDataFile.exists()) {
            try {
                playerDataFile.createNewFile();
                YamlConfiguration playerConfig = YamlConfiguration.loadConfiguration(playerDataFile);
                playerConfig.set("ign", player.getName());
                playerConfig.set("joins", 0);
                playerConfig.set("money", 0);
                playerConfig.save(playerDataFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        YamlConfiguration playerConfig = YamlConfiguration.loadConfiguration(playerDataFile);

        int joins = (int) playerConfig.get("joins");

        joins++;

        String message = (joins == 1) ? String.format("You have joined %s time", joins) : String.format("You have joined %d times", joins);
        player.sendMessage(ChatColor.GOLD + message);

        playerConfig.set("joins", joins);

        try {
            playerConfig.save(playerDataFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
