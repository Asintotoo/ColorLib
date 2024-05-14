

package com.asintoto.colorlib;

import com.asintoto.colorlib.rgb.RGBColor;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

/**
 *
 * @author Asintoto
 */
public class ColorLib {

    public static String setColors(String text) {
        return RGBColor.process(text);
    }
    
    public static String setColorsAndPlaceholders(Player p, String text) {
        String processed = PlaceholderAPI.setPlaceholders(p, text);
        return setColors(processed);
    }
    
    public static String setColorsAndPlaceholders(OfflinePlayer p, String text) {
        String processed = PlaceholderAPI.setPlaceholders(p, text);
        return setColors(processed);
    }
    
    public static String getColoredStringFromConfig(YamlConfiguration config, String path) {
        String text = config.getString(path);
        return setColors(text);
    }
    
    public static String getColoredStringFromConfigWithPlaceholders(YamlConfiguration config, Player p, String path) {
        String text = config.getString(path);
        return setColorsAndPlaceholders(p, text);
    }
    
    public static String getColoredStringFromConfigWithPlaceholders(YamlConfiguration config, OfflinePlayer p, String path) {
        String text = config.getString(path);
        return setColorsAndPlaceholders(p, text);
    }
}
