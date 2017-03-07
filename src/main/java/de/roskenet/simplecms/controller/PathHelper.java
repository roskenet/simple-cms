package de.roskenet.simplecms.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PathHelper {
    private PathHelper() {}
    
    private static Pattern pathPattern = Pattern.compile("/page/(.*?)\\.html");
    
    public static String filterSuffix(final String fullPath) {
        Matcher matcher = pathPattern.matcher(fullPath);
        
        if(matcher.find()) {
            String pageId = matcher.group(1);
            return pageId;
        }
        return "";
    }
}
