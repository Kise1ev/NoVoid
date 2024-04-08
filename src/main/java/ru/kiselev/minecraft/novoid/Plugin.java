package ru.kiselev.minecraft.novoid;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import ru.kiselev.minecraft.novoid.command.NoVoidCommand;
import ru.kiselev.minecraft.novoid.listener.GameListener;

import java.io.File;

public class Plugin extends JavaPlugin {

    public static Plugin instance;

    @Override
    public void onEnable() {
        instance = this;

        final File configFile = new File(getDataFolder() + File.separator + "config.yml");
        if (!configFile.exists()) {
            getLogger().info("Creating file config.yml..");

            getConfig().options().copyDefaults(true);
            saveDefaultConfig();

            getLogger().info("File \"config.yml\" has been successfully created and copied!");
        }

        Bukkit.getPluginManager().registerEvents(new GameListener(), this);
        getCommand("novoid").setExecutor(new NoVoidCommand());
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public static Plugin getInstance() {
        return instance;
    }
}