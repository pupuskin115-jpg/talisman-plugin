package me.yourname.talisman;

import org.bukkit.plugin.java.JavaPlugin;

public class TalismanPlugin extends JavaPlugin {

    private static TalismanPlugin instance;

    @Override
    public void onEnable() {
        instance = this;

        getCommand("talisman").setExecutor((sender, command, label, args) -> {
            if (sender instanceof org.bukkit.entity.Player player) {
                GUIListener.openGUI(player);
            }
            return true;
        });

        getServer().getPluginManager().registerEvents(new GUIListener(), this);
    }

    public static TalismanPlugin getInstance() {
        return instance;
    }
}
