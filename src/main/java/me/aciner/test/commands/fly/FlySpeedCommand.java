package me.aciner.test.commands.fly;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

@CommandAlias("flyspeed")
@CommandPermission("test.flyspeed")
public class FlySpeedCommand extends BaseCommand {

    @Default
    @Description("Sets your flight speed.")
    @Syntax("<1-10>")
    public void onCommand(Player player, @Optional Float speed) {

        if (speed == null) {
            player.sendMessage(ChatColor.GREEN + "Your flight speed is currently: " + ChatColor.YELLOW + (player.getFlySpeed() * 10));
        } else if ((speed) < 10 && speed > 0) {
            player.sendMessage(ChatColor.GREEN + "Your flight speed has been set to: " + ChatColor.YELLOW + speed);
            player.setFlySpeed((speed/10));
        } else {
            player.sendMessage(ChatColor.YELLOW + "Usage: " + ChatColor.GREEN + "/flyspeed " + ChatColor.WHITE + "<1-10>");
        }

    }
}
