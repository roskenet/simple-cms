package de.roskenet.simplecms;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PagePathTokenizer {
	private static Pattern pattern = Pattern.compile("'(.*?)'");
	
	public static String pathToken(String fullPath) {
		Matcher matcher = pattern.matcher(fullPath);
		
		return matcher.group(0);
	}
	
}
