
package com.asintoto.colorlib.rgb.patterns;

import com.asintoto.colorlib.rgb.RGBColor;
import java.awt.Color;
import java.util.regex.Matcher;

/**
 *
 * @author Asintoto
 */
public class Gradient implements Pattern{
    java.util.regex.Pattern patt = java.util.regex.Pattern.compile("<GRADIENT:([0-9A-Fa-f]{6})>(.*?)</GRADIENT:([0-9A-Fa-f]{6})>");

    @Override
    public String process(String string) {
        Matcher match = patt.matcher(string);
        while (match.find()) {
            String start = match.group(1);
            String end = match.group(3);
            String content = match.group(2);
            string = string.replace(match.group(), RGBColor.color(content, new Color(Integer.parseInt(start, 16)), new Color(Integer.parseInt(end, 16))));
        }
        return string;
    }
}
