package me.aciner.test.commands.fly;

import co.aikar.commands.BaseCommand;
import me.aciner.test.utils.Hex;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public class FlyCommand extends BaseCommand {

    @Default
    @CommandAlias("fly")
    @Description("Toggles your fly.")
    public void onCommand(Player player) {

        TextComponent messageFalse = new Hex()
                .append("Toggled flight to ", "#3BA7D9", false, false)
                .append("False", "#fa5050", false, true)
                .build();

        TextComponent messageTrue = new Hex()
                .append("Toggled flight to ", "#3BA7D9", false, false)
                .append("True", "#50fa69", false, false)
                .build();

        if (player.getAllowFlight()) {
            player.setAllowFlight(false);
            player.sendMessage(messageFalse);
        } else {
            player.setAllowFlight(true);
            player.sendMessage(messageTrue);
        }
    }
}
