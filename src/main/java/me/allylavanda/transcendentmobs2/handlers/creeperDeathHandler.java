package me.allylavanda.transcendentmobs2.handlers;

import me.allylavanda.transcendentmobs2.utils.KillCounter;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDeathEvent;

public class creeperDeathHandler {
    KillCounter kc = new KillCounter();

    public void deathHandler(EntityDeathEvent e) {
        Entity entity = e.getEntity();
        Player p = e.getEntity().getKiller();

        assert p != null;
        kc.addKillCreeper(p, 1);
        // Class defined Creeper spawn condition

        if (kc.getKillsCreeper(p) >= 10) {
            World world = p.getWorld();
            // Spawn Loc
            p.sendMessage("A stronger foe has appeared...");
            // Spawn Creeper ... Near Player
        }


    }
}
