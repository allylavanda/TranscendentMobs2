package me.allylavanda.transcendentmobs2.handlers;

import me.allylavanda.transcendentmobs2.mobs.zombieWarrior;
import me.allylavanda.transcendentmobs2.utils.KillCounter;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDeathEvent;

public class zombieDeathHandler {
    KillCounter kc = new KillCounter();
    zombieWarrior zw = new zombieWarrior();

    public void deathHandler(EntityDeathEvent e) {
        Player p = e.getEntity().getKiller();

        assert p != null;
        kc.addKillZombie(p);
        p.sendMessage("ZDH DEBUG");
        // Class defined Zombie spawn condition

        if (kc.getKillsZombie(p) >= 10) {
            World world = p.getWorld();
            // Spawn Loc
            p.sendMessage("A stronger foe has appeared...");
            // Spawn Zombie Warrior Near Player
            zw.spawnZombieWarrior(p, world);
        }


    }
}
