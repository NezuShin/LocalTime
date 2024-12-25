package org.localtime;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class LocalTimeExpansion extends PlaceholderExpansion {

    private LocalTimePlugin plugin;

    public LocalTimeExpansion(LocalTimePlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean persist(){
        return true;
    }

    @Override
    public boolean canRegister(){
        return true;
    }

    @Override
    public String getAuthor(){
        return plugin.getDescription().getAuthors().toString();
    }

    @Override
    public String getIdentifier(){
        return "localtime";
    }

    @Override
    public String getVersion(){
        return plugin.getDescription().getVersion();
    }

    @Override
    public String onPlaceholderRequest(Player player, String identifier){
        if(identifier.equals("time")){
            String timezone = plugin.getConfig().getString("timezone", "GMT");
            LocalDateTime now = LocalDateTime.now(ZoneId.of(timezone));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(plugin.getConfig().getString("format", "HH:mm:ss"));
            return now.format(formatter);
        }
        return null;
    }
}
