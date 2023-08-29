package me.allylavanda.transcendentmobs2.armor;

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

public class plagueHelmet {
    public static ItemStack plagueHelmet;

    public void init() {
        createArmor();
    }

    private void createArmor() {
        ItemStack item = new ItemStack(Material.LEATHER_HELMET);

        // Attributes
        AttributeModifier defenseMod = new AttributeModifier(UUID.randomUUID(),"generic.armor",
                10, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);

        ItemMeta meta = item.getItemMeta();
        // Lore
        assert meta != null;
        meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Plague Dr's Helmet");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.AQUA + "" + ChatColor.ITALIC + "Transcendent");
        meta.setLore(lore);

        // Set Modifiers
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, defenseMod);
        item.setItemMeta(meta);
        plagueHelmet = item;
    }
}
