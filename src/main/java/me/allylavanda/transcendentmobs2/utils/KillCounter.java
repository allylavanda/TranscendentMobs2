package me.allylavanda.transcendentmobs2.utils;

import me.allylavanda.transcendentmobs2.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class KillCounter {
    private final Main main = Main.getPlugin(Main.class);
    FileConfiguration cfg = main.getConfig();

    // Adds kill to player's Zombie kill count
    public void addKillZombie(Player p) {
        int count = cfg.getInt(p.getName() + "." + "zombie kills");
        p.sendMessage("DEBUG: Zombie killed");
        cfg.set(p.getName() + "." + "zombie kills", count++);
        main.saveConfig();
    }

    // Retrieves player's Zombie kill count
    public int getKillsZombie(Player p) {
        return cfg.getInt(p.getName() + "." + "zombie kills");
    }

    // Resets player's Zombie kill count
    public void resetKillsZombie(Player p) {
        cfg.set(p.getName() + "." + "zombie kills", 0);
        main.saveConfig();
    }

    // Adds kill to player's Skeleton kill count
    public void addKillSkeleton(Player p) {
        int count = cfg.getInt(p.getName() + "." + "skeleton kills");
        cfg.set(p.getName() + "." + "skeleton kills", count++);
        main.saveConfig();
    }

    // Retrieves player's Skeleton kill count
    public int getKillsSkeleton(Player p) {
        return cfg.getInt(p.getName() + "." + "skeleton kills");
    }

    // Resets player's Skeleton kill count
    public void resetKillsSkeleton(Player p) {
        cfg.set(p.getName() + "." + "skeleton kills", 0);
        main.saveConfig();
    }

    // Adds kill to player's Spider kill count
    public void addKillSpider(Player p) {
        int count = cfg.getInt(p.getName() + "." + "spider kills");
        cfg.set(p.getName() + "." + "spider kills", count++);
        main.saveConfig();
    }

    // Retrieves player's Spider kill count
    public int getKillsSpider(Player p) {
        return cfg.getInt(p.getName() + "." + "spider kills");
    }

    // Resets player's Spider kill count
    public void resetKillsSpider(Player p) {
        cfg.set(p.getName() + "." + "spider kills", 0);
        main.saveConfig();
    }

    // Adds kill to player's Creeper kill count
    public void addKillCreeper(Player p) {
        int count = cfg.getInt(p.getName() + "." + "creeper kills");
        cfg.set(p.getName() + "." + "creeper kills", count++);
        main.saveConfig();
    }

    // Retrieves player's Creeper kill count
    public int getKillsCreeper(Player p) {
        return cfg.getInt(p.getName() + "." + "creeper kills");
    }

    // Resets player's Creeper kill count
    public void resetKillsCreeper(Player p) {
        cfg.set(p.getName() + "." + "creeper kills", 0);
        main.saveConfig();
    }
}