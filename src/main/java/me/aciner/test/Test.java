package me.aciner.test;

import co.aikar.commands.PaperCommandManager;
import me.aciner.test.commands.GamemodeCommand;
import me.aciner.test.commands.fly.FlyCommand;
import me.aciner.test.commands.fly.FlySpeedCommand;
import me.aciner.test.commands.misc.CraftCommand;
import me.aciner.test.commands.misc.FeedCommand;
import me.aciner.test.commands.misc.HealCommand;
import me.aciner.test.events.JoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;

public final class Test extends JavaPlugin {


    public static File getPlayerDataFolder(JavaPlugin plugin) {
        return new File(plugin.getDataFolder(), "playerdata");
    }

    @Override
    public void onEnable() {
        if (!this.getDataFolder().exists()) {
            this.getDataFolder().mkdirs();
        }

        File playerDataFolder = getPlayerDataFolder(this);

        if (!playerDataFolder.exists()) {
            playerDataFolder.mkdirs();
        }

        System.out.println("[TEST] HAS BEEN ENABLED");

        getServer().getPluginManager().registerEvents(new JoinEvent(this), this);

        PaperCommandManager manager = new PaperCommandManager(this);
        manager.registerCommand(new FlyCommand());
        manager.registerCommand(new FlySpeedCommand());
        manager.registerCommand(new GamemodeCommand());
        manager.registerCommand(new HealCommand());
        manager.registerCommand(new FeedCommand());
        manager.registerCommand(new CraftCommand());
    }



    @Override
    public void onDisable() {
        System.out.println("[TEST] HAS BEEN DISABLED");
    }
}
