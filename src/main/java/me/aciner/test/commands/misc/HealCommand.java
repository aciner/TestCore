package me.aciner.test.commands.misc;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import co.aikar.commands.annotation.Optional;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class HealCommand extends BaseCommand {
    @Default
    @CommandAlias("heal")
    @Description("Heals the player.")
    public void onCommand(Player player, @Optional OnlinePlayer target) {
        if (target != null) {

            target.getPlayer().setHealth(target.getPlayer().getMaxHealth());
            target.getPlayer().setFoodLevel(20);
            target.getPlayer().sendMessage(ChatColor.LIGHT_PURPLE + "Healed!");
            player.sendMessage(ChatColor.LIGHT_PURPLE + "Healed the requested player!");

        } else {

            player.getPlayer().setHealth(target.getPlayer().getMaxHealth());
            player.getPlayer().setFoodLevel(20);
            player.getPlayer().sendMessage(ChatColor.LIGHT_PURPLE + "Healed!");

        }
    }
}
