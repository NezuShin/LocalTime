
package org.localtime;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class LocalTimePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null){
            new LocalTimeExpansion(this).register();
        } else {
            getLogger().severe("PlaceholderAPI not found, disabling LocalTime.");
            Bukkit.getPluginManager().disablePlugin(this);
        }
    }
}
