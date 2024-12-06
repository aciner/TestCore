package me.aciner.test.commands.misc;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import org.bukkit.entity.Player;
import org.bukkit.inventory.CraftingInventory;

@CommandAlias("craft")
public class CraftCommand extends BaseCommand {

    public void onCraftCommand(Player player) {

        player.openWorkbench(player.getLocation(), true);

    }

}
