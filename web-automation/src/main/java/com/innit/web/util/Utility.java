package com.innit.web.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

import com.innit.web.constant.Constant;

/**
 * 
 * @author Harsh Wardhan Gupta
 * 
 *         Class contains the utils function of the framework.
 */
public class Utility {

	private static Properties prop = new Properties();

	public static Properties getProperties(String propertyFileName) {

		InputStream input = Utility.class.getClassLoader().getResourceAsStream(propertyFileName);

		if (input != null) {
			try {
				prop.load(input);
			} catch (IOException e) {
				System.out.println(e);
			}
		}
		return prop;
	}

	/**
	 * Name: Generate random string.
	 *
	 * @param length  Length of the string to be generated.
	 * @param symbols Characters from which the string should be generated.
	 * @return generated random string. Performs: Generate random string of given
	 *         length from the given characters.
	 */
	public static String generateRandomString(int length, String symbols) {
		char[] chars = symbols.toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i <= length; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		return sb.toString();
	}

	public static String generateRandomEmailId() {
		return (generateRandomString(5, Constant.ALPHABET) + "@gmail.com");
	}

	/**
	 * Delete all files of directory
	 * 
	 * @param dirPath: directory path for file deletion.
	 */
	public static void deleteAllFiles(String dirPath) {

		@SuppressWarnings("unused")
		String files;
		File file = new File(dirPath);
		File[] listOfFiles = file.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				files = listOfFiles[i].getName();
				@SuppressWarnings("unused")
				boolean issuccess = new File(listOfFiles[i].toString()).delete();
			}
		}
	}
}