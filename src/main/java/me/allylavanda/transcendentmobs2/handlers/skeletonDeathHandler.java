package me.allylavanda.transcendentmobs2.handlers;

import me.allylavanda.transcendentmobs2.utils.KillCounter;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDeathEvent;

public class skeletonDeathHandler {
    KillCounter kc = new KillCounter();

    public void deathHandler(EntityDeathEvent e) {
        Entity entity = e.getEntity();
        Player p = e.getEntity().getKiller();

        kc.addKillSkeleton(p,1);
        // Class defined Skeleton spawn condition

        if (kc.getKillsSkeleton(p) >= 10) {
            World world = p.getWorld();
            // Spawn Loc
            p.sendMessage("A stronger foe has appeared...");
            // Spawn Skeleton ... Near Player
        }


    }
}
