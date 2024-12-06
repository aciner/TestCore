package me.aciner.test.commands.misc;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import co.aikar.commands.annotation.Optional;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class FeedCommand extends BaseCommand {
    @Default
    @CommandAlias("feed")
    @Description("Feeds the player.")
    public void onCommand(Player player, @Optional OnlinePlayer target) {
        if (target != null) {

            target.getPlayer().setFoodLevel(20);
            target.getPlayer().sendMessage(ChatColor.LIGHT_PURPLE + "Fed!");
            player.sendMessage(ChatColor.LIGHT_PURPLE + "Fed the requested player!");

        } else {

            player.getPlayer().setFoodLevel(20);
            player.getPlayer().sendMessage(ChatColor.LIGHT_PURPLE + "Fed!");

        }
    }
}
