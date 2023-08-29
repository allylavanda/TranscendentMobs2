package me.allylavanda.transcendentmobs2.utils;

import me.allylavanda.transcendentmobs2.Main;
import me.allylavanda.transcendentmobs2.handlers.zombieDeathHandler;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventListener implements Listener {
    zombieDeathHandler zdh = new zombieDeathHandler();
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

    @EventHandler
    public void entityDeathZombie(EntityDeathEvent e) {
        if (e.getEntity().getKiller() != null) {
            if (e.getEntity() instanceof Zombie)
                zdh.deathHandler(e);
        }
    }
}
