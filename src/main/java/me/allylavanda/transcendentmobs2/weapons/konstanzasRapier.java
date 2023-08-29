package me.allylavanda.transcendentmobs2.weapons;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class konstanzasRapier {
    public static ItemStack konstanzasRapier;

    public void init() {
        createWeapon();
    }

    private void createWeapon() {
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        // Attributes
        AttributeModifier damageModifier = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage",
                10, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier frostModifier = new AttributeModifier(UUID.randomUUID(), "generic.slow",
               -10, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        ItemMeta meta = item.getItemMeta();
        // Lore
        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Konstanza's Rapier");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.AQUA + "" + ChatColor.ITALIC + "Transcendent");
        meta.setLore(lore);

        // Set Modifiers
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damageModifier);
        // meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, frostModifier);
        item.setItemMeta(meta);
        konstanzasRapier = item;
    }
}
