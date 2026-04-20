package me.yourname.talisman;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GUIListener implements Listener {

    private static final String GUI_NAME = "§6Создание талисмана";

    public static void openGUI(Player player) {
        Inventory inv = Bukkit.createInventory(null, 27, GUI_NAME);

        ItemStack createButton = new ItemStack(Material.EMERALD);
        ItemMeta meta = createButton.getItemMeta();
        meta.setDisplayName("§aСоздать талисман");
        createButton.setItemMeta(meta);

        inv.setItem(22, createButton);

        player.openInventory(inv);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (!e.getView().getTitle().equals(GUI_NAME)) return;

        Player player = (Player) e.getWhoClicked();

        if (e.getSlot() == 22) {
            e.setCancelled(true);

            ItemStack item = e.getInventory().getItem(13);

            if (item == null || item.getType().isAir()) {
                player.sendMessage("§cПоложи предмет в центр!");
                return;
            }

            ItemStack talisman = TalismanManager.createTalisman(item);

            player.getInventory().addItem(talisman);
            player.sendMessage("§aТалисман создан!");
        }

        if (e.getSlot() == 13) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
    }
}
