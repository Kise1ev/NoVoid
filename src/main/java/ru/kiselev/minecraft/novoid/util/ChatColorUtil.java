package ru.kiselev.minecraft.novoid.util;

import lombok.experimental.UtilityClass;
import org.bukkit.ChatColor;

@UtilityClass
public class ChatColorUtil {

    public static String translateCodes(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
}