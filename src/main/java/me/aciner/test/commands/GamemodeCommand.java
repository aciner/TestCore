package me.aciner.test.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

@CommandPermission("test.gamemode")
public class GamemodeCommand extends BaseCommand {

    @Default
    @CommandCompletion("Creative|Survival|Spectator|Adventure @players")
    @CommandAlias("gamemode|gm")
    public void onCommand(Player player, String arg, @Optional OnlinePlayer target) {

        if (target != null) {
            if (player.hasPermission("test.gamemode.others")) {
                target.getPlayer().sendMessage(gm(target.getPlayer(), arg));
                player.sendMessage(ChatColor.GREEN + "You have succesfully set the gamemode of " + ChatColor.YELLOW + target.getPlayer().getName());
            } else {
                player.sendMessage(ChatColor.RED + "No Permission.");
            }
        } else {
            player.sendMessage(gm(player, arg));
        }
    }

    public String gm(Player target, String gamemode) {
         if (gamemode.equalsIgnoreCase("s") || gamemode.equalsIgnoreCase("survival")) {
            target.setGameMode(GameMode.SURVIVAL);
            return(ChatColor.GREEN + "Your Gamemode has been set to " + ChatColor.YELLOW + "Survival.");
        } else if (gamemode.equalsIgnoreCase("sp") || gamemode.equalsIgnoreCase("spectator")) {
            target.setGameMode(GameMode.SPECTATOR);
             return(ChatColor.GREEN + "Your Gamemode has been set to " + ChatColor.YELLOW + "Spectator.");
        } else if (gamemode.equalsIgnoreCase("c") || gamemode.equalsIgnoreCase("creative")) {
            target.setGameMode(GameMode.CREATIVE);
             return(ChatColor.GREEN + "Your Gamemode has been set to " + ChatColor.YELLOW + "Creative.");
        } else if (gamemode.equalsIgnoreCase("a") || gamemode.equalsIgnoreCase("adventure")) {
            target.setGameMode(GameMode.ADVENTURE);
             return(ChatColor.GREEN + "Your Gamemode has been set to " + ChatColor.YELLOW + "Adventure.");
        } else {
             return(ChatColor.RED + "Invalid Gamemode.");
        }
    }

    @CommandAlias("gmc")
    @CommandPermission("test.gamemode")
    public void onGMC(Player player, @Optional Player targetName) {
        player.sendMessage(gm(player, "c"));
    }

    @CommandAlias("gms")
    @CommandPermission("test.gamemode")
    public void onGMS(Player player) {
        player.sendMessage(gm(player, "s"));
    }

    @CommandAlias("gmsp")
    @CommandPermission("test.gamemode")
    public void onGMSP(Player player) {
        player.sendMessage(gm(player, "sp"));
    }

    @CommandAlias("gma")
    @CommandPermission("test.gamemode")
    public void onGMA(Player player) {
        player.sendMessage(gm(player, "a"));
    }
}