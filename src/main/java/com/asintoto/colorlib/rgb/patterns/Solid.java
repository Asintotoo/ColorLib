
package com.asintoto.colorlib.rgb.patterns;

import com.asintoto.colorlib.rgb.RGBColor;
import java.util.regex.Matcher;

/**
 *
 * @author Asintoto
 */
public class Solid implements Pattern{
    java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("<SOLID:([0-9A-Fa-f]{6})>|#\\{([0-9A-Fa-f]{6})}");

    public String process(String string) {
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            String color = matcher.group(1);
            if (color == null) color = matcher.group(2);

            string = string.replace(matcher.group(), RGBColor.getColor(color) + "");
        }
        return string;
    }
}
