package me.aciner.test.utils;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;

public class Hex {
    private final TextComponent base;

    public Hex() {
        this.base = new TextComponent();
    }

    public Hex append(String text, String hexColor, boolean bold, boolean underline) {
        TextComponent part = new TextComponent(text);
        part.setColor(ChatColor.of(hexColor));
        part.setBold(bold);
        part.setUnderlined(underline);
        this.base.addExtra(part);
        return this;
    }


    public TextComponent build() {
        return base;
    }
}

/* usage example
import org.bukkit.entity.Player;

public class Fly {

    public void sendHexMessage(Player player) {
        TextComponent message = new HexMessageBuilder()
                .append("Hi ", "#FF2113", false, false)   // Red
                .append("wsg", "#FFFF13", false, true)  // Yellow underline
                .append("!", "#00FF00", true, false)   // Green bold
                .build();

        player.spigot().sendMessage(message);
    }
}
*/