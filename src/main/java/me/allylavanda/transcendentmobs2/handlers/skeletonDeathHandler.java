package me.allylavanda.transcendentmobs2.handlers;

import me.allylavanda.transcendentmobs2.mobs.skeletonPlagueDoctor;
import me.allylavanda.transcendentmobs2.utils.KillCounter;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDeathEvent;

public class skeletonDeathHandler {
    KillCounter kc = new KillCounter();
    skeletonPlagueDoctor spd = new skeletonPlagueDoctor();

    public void deathHandler(EntityDeathEvent e) {
        Player p = e.getEntity().getKiller();

        assert p != null;
        kc.addKillSkeleton(p, 1);
        // Class defined Skeleton spawn condition

        if (kc.getKillsSkeleton(p) >= 10) {
            World world = p.getWorld();
            // Spawn Loc
            p.sendMessage("A stronger foe has appeared...");
            // Spawn Skeleton ... Near Player
            spd.spawnSkeletonPlagueDoctor(p, world);
        }
    }
}
