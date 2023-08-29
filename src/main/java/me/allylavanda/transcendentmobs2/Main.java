package me.allylavanda.transcendentmobs2;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import me.allylavanda.transcendentmobs2.utils.EventListener;

public final class Main extends JavaPlugin {
    public static FileConfiguration config;

    @Override
    public void onEnable() {
        // Plugin startup logic
        config=getConfig();
        this.saveDefaultConfig();
        System.out.println("[TranscendentMobs2] TranscendentMobs2 by allylavanda has been loaded!");
        System.out.println("[TranscendentMobs2] Plugin Version 1.0");

        getServer().getPluginManager().registerEvents(new EventListener(), this);
        config.set("debug", true);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("[TranscendentMobs2] TranscendentMobs2 has been disabled!");
        config = null;
    }
}
