package com.sid.mobile.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
	public Properties properties;
	FileInputStream fis;

	public PropertyUtils() {
		try {
			properties = new Properties();
			String propFileName = "src/test/resources/config.properties";
			// String propFileName = "config.properties";

			// inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			fis = new FileInputStream(propFileName);

			if (fis != null) {
				properties.load(fis);
			} else {
				System.out.println("property file '" + propFileName + "' not found in the classpath");
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally

		{
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public String getValue(String key) {
		return properties.getProperty(key);
	}

	public static void main(String args[]) throws IOException {

		PropertyUtils obj = new PropertyUtils();

		System.out.println("USERNAME: " + obj.getValue("username"));
		System.out.println("PASSWORD: " + obj.getValue("password"));
	}

}
