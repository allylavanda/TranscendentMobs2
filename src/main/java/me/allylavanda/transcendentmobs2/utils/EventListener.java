package me.allylavanda.transcendentmobs2.utils;

import me.allylavanda.transcendentmobs2.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventListener implements Listener {
    private final Main main = Main.getPlugin(Main.class);
    FileConfiguration cfg = main.getConfig();

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (!cfg.contains(p.getName())) {
            cfg.set(p.getName() + "." + "kills", 0);
            main.saveConfig();
        }
    }
}
