package me.allylavanda.transcendentmobs2.mobs;

import me.allylavanda.transcendentmobs2.Main;
import me.allylavanda.transcendentmobs2.utils.KillCounter;
import me.allylavanda.transcendentmobs2.weapons.konstanzasRapier;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.checkerframework.checker.units.qual.K;

import java.util.Objects;

public class skeletonPlagueDoctor {

    KillCounter kc = new KillCounter();

    BossBar b = Bukkit.createBossBar("Skelington Plague Doctor", BarColor.GREEN, BarStyle.SOLID);

    public void spawnSkeletonPlagueDoctor (Player p, World world) {
        Location spawnLoc = p.getLocation().add(2,0,0);
        p.sendMessage("A Skeleton Plague Doctor approaches!");
        b.addPlayer(p);
        b.getProgress();
        Skeleton skeleton = (Skeleton) world.spawnEntity(spawnLoc, EntityType.SKELETON);
        skeleton.setCustomName("Skeleton Warrior");
        skeleton.setCustomNameVisible(true);
        // Attributes
        Objects.requireNonNull(skeleton.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(100);
        skeleton.setHealth(100);
        // Skeleton Warrior Gear
        Objects.requireNonNull(skeleton.getEquipment()).setItemInMainHand(new ItemStack(Material.BOW));
        skeleton.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET));
        skeleton.getEquipment().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
        skeleton.getEquipment().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
        skeleton.getEquipment().setBoots(new ItemStack(Material.LEATHER_BOOTS));
        skeleton.getEquipment().setItemInMainHandDropChance(40);
        kc.resetKillsSkeleton(p);

        Bukkit.getScheduler().runTaskAsynchronously(Main.getPlugin(), new Runnable() {
            @Override
            public void run() {
                while (skeleton.getHealth() != 0) {
                    b.setProgress(skeleton.getHealth()/ 100);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
                b.removeAll();
            }
        });
    }
}
