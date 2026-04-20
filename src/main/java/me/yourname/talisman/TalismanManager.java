package me.yourname.talisman;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TalismanManager {

    public static ItemStack createTalisman(ItemStack item) {
        ItemStack newItem = item.clone();

        ItemMeta meta = newItem.getItemMeta();

        meta.setDisplayName("§dТалисман");
        meta.setLore(java.util.List.of("§7Магический предмет"));

        NamespacedKey key = new NamespacedKey(TalismanPlugin.getInstance(), "talisman");

        meta.getPersistentDataContainer().set(
                key,
                org.bukkit.persistence.PersistentDataType.INTEGER,
                1
        );

        newItem.setItemMeta(meta);

        return newItem;
    }
}
