package ru.kiselev.minecraft.novoid.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import ru.kiselev.minecraft.novoid.Plugin;
import ru.kiselev.minecraft.novoid.util.ChatColorUtil;

public class NoVoidCommand implements CommandExecutor {

    @Override
    public boolean onCommand(final CommandSender commandSender, final Command command, final String str, final String[] args) {
        final Player player = (Player) commandSender;

        final Plugin plugin = Plugin.getInstance();
        final FileConfiguration configFile = plugin.getConfig();
        final String messagePrefix = ChatColorUtil.translateCodes(configFile.getString("chat.prefix"));

        if (args.length == 1) {
            switch (args[0]) {
                case "reload":
                    if (!player.hasPermission("novoid")) {
                        player.sendMessage(messagePrefix + ChatColorUtil.translateCodes("&7NoVoid plugin is created by &eRoman Kiselev&7."));
                        player.sendMessage(messagePrefix + ChatColorUtil.translateCodes("&7Version: &e1.0.0"));
                        return true;
                    }

                    plugin.reloadConfig();
                    player.sendMessage(messagePrefix + ChatColorUtil.translateCodes(configFile.getString("command.novoid.reload.message")));
                    break;
                default:
                    player.sendMessage(messagePrefix + ChatColorUtil.translateCodes(configFile.getString("chat.command_not_found")));
                    break;
            }
            return true;
        }

        player.sendMessage(messagePrefix + ChatColorUtil.translateCodes("&7PerkSync plugin is created by &eRoman Kiselev&7."));
        player.sendMessage(messagePrefix + ChatColorUtil.translateCodes("&7Version: &e1.0.0"));

        return true;
    }
}