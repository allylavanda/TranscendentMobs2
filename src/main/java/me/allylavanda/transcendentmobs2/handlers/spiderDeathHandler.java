package me.allylavanda.transcendentmobs2.handlers;

import me.allylavanda.transcendentmobs2.utils.KillCounter;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDeathEvent;

public class spiderDeathHandler {
    KillCounter kc = new KillCounter();

    public void deathHandler(EntityDeathEvent e) {
        Entity entity = e.getEntity();
        Player p = e.getEntity().getKiller();

        assert p != null;
        kc.addKillSpider(p);
        // Class defined Spider spawn condition

        if (kc.getKillsSpider(p) >= 10) {
            World world = p.getWorld();
            // Spawn Loc
            p.sendMessage("A stronger foe has appeared...");
            // Spawn Spider ... Near Player
        }


    }
}
