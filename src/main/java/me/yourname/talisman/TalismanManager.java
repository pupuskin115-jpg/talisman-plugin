package me.yourname.talisman;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.Material;

public class TalismanManager {

    public static ItemStack createTalisman(String type) {

        ItemStack item;

        switch (type) {
            case "speed":
                item = new ItemStack(Material.SUGAR);
                break;
            case "strength":
                item = new ItemStack(Material.BLAZE_POWDER);
                break;
            case "health":
                item = new ItemStack(Material.APPLE);
                break;
            default:
                item = new ItemStack(Material.STONE);
        }

        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("§dТалисман " + type);
        meta.setLore(java.util.List.of("§7Магический предмет"));

        NamespacedKey key = new NamespacedKey(TalismanPlugin.getInstance(), "talisman_type");

        meta.getPersistentDataContainer().set(
                key,
                org.bukkit.persistence.PersistentDataType.STRING,
                type
        );

        item.setItemMeta(meta);

        return item;
    }
}
