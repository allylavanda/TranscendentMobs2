package me.allylavanda.transcendentmobs2.mobs;

import me.allylavanda.transcendentmobs2.utils.KillCounter;
import me.allylavanda.transcendentmobs2.weapons.konstanzasRapier;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;

public class zombieWarrior {
    KillCounter kc = new KillCounter();
    BossBar b = Bukkit.createBossBar("Zombie Warrior", BarColor.PINK, BarStyle.SOLID, BarFlag.DARKEN_SKY);
    public void spawnZombieWarrior (Player p, World world) {
        Location spawnLoc = p.getLocation().add(2,0,0);
        p.sendMessage("A Zombie Warrior Has Appeared!");
        b.addPlayer(p);
        b.getProgress();
        Zombie zombie = (Zombie) world.spawnEntity(spawnLoc, EntityType.ZOMBIE);
        zombie.setCustomName("Zombie Warrior");
        zombie.setCustomNameVisible(true);
        // Attributes
        zombie.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(100);
        zombie.setHealth(100);
        // Zombie Warrior Gear
        zombie.getEquipment().setItemInMainHand(new ItemStack(konstanzasRapier.konstanzasRapier));
        zombie.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
        zombie.getEquipment().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        zombie.getEquipment().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        zombie.getEquipment().setBoots(new ItemStack(Material.GOLDEN_BOOTS));

        zombie.getEquipment().setItemInMainHandDropChance(100);
        kc.resetKillsZombie(p);
    }
}
