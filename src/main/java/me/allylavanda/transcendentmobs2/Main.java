package me.allylavanda.transcendentmobs2;

import me.allylavanda.transcendentmobs2.armor.initArmor;
import me.allylavanda.transcendentmobs2.weapons.initWeps;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import me.allylavanda.transcendentmobs2.utils.EventListener;

public final class Main extends JavaPlugin {

    private static Main plugin;
    public static FileConfiguration config;
    private final initWeps initWeps = new initWeps();
    private final initArmor initArmor = new initArmor();

    @Override
    public void onEnable() {
        // Plugin startup logic
        config=getConfig();
        plugin=this;
        initWeps.init();
        initArmor.init();
        this.saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        config.set("debug", true);

        System.out.println("[TranscendentMobs2] TranscendentMobs2 by allylavanda has been loaded!");
        System.out.println("[TranscendentMobs2] Plugin Version 1.0");
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
