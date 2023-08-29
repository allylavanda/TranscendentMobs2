package me.allylavanda.transcendentmobs2;

import me.allylavanda.transcendentmobs2.weapons.initWeps;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import me.allylavanda.transcendentmobs2.utils.EventListener;

public final class Main extends JavaPlugin {

    private static Main plugin;
    public static FileConfiguration config;
    private final initWeps initWeps = new initWeps();

    @Override
    public void onEnable() {
        // Plugin startup logic
        config=getConfig();
        plugin=this;
        this.saveDefaultConfig();
        System.out.println("[TranscendentMobs2] TranscendentMobs2 by allylavanda has been loaded!");
        System.out.println("[TranscendentMobs2] Plugin Version 1.0");
        initWeps.init();

        getServer().getPluginManager().registerEvents(new EventListener(), this);
        config.set("debug", true);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("[TranscendentMobs2] TranscendentMobs2 has been disabled!");
        config = null;
    }

    public static Main getPlugin() {
        return plugin;
    }
}
