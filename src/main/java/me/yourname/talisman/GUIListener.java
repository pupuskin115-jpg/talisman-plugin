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

    private static final String GUI_NAME = "§6Выбор талисмана";

    public static void openGUI(Player player) {
        Inventory inv = Bukkit.createInventory(null, 27, GUI_NAME);

        inv.setItem(11, createItem(Material.SUGAR, "§bТалисман скорости"));
        inv.setItem(13, createItem(Material.BLAZE_POWDER, "§cТалисман силы"));
        inv.setItem(15, createItem(Material.APPLE, "§aТалисман здоровья"));

        player.openInventory(inv);
    }

    private static ItemStack createItem(Material mat, String name) {
        ItemStack item = new ItemStack(mat);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        item.setItemMeta(meta);
        return item;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (!e.getView().getTitle().equals(GUI_NAME)) return;

        e.setCancelled(true);

        Player player = (Player) e.getWhoClicked();

        ItemStack clicked = e.getCurrentItem();
        if (clicked == null || clicked.getType().isAir()) return;

        switch (clicked.getType()) {
            case SUGAR:
                player.getInventory().addItem(
                        TalismanManager.createTalisman("speed")
                );
                player.sendMessage("§bТы получил талисман скорости!");
                break;

            case BLAZE_POWDER:
                player.getInventory().addItem(
                        TalismanManager.createTalisman("strength")
                );
                player.sendMessage("§cТы получил талисман силы!");
                break;

            case APPLE:
                player.getInventory().addItem(
                        TalismanManager.createTalisman("health")
                );
                player.sendMessage("§aТы получил талисман здоровья!");
                break;
        }
    }
}
