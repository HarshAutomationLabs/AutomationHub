package com.innit.web.helper;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Harsh Wardhan Gupta
 * 
 *         Class contains all the Enum values of Mobile Browsers.
 */
public enum Platform {

	CHROME("Chrome"), MOZILLA("Mozilla"), EDGE("Edge"), IPAD("iPad"), IPHONE5("iPhone_5"), IPHONE6("iPhone_6"),
	IPHONE6PLUS("iPhone_6_Plus"), IPHONE7("iPhone_7"), GALAXYNOTE3("Galaxy_Note_3");

	private String name;
	private static Map<String, Platform> map = new HashMap<>();

	static {
		for (Platform platform : Platform.values()) {
			map.put(platform.name, platform);
		}
	}

	Platform(String name) {
		this.name = name;
	}

	public static Platform getPlatformByName(String name) {
		return map.get(name);
	}
}
