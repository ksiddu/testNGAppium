package com.sid.mobile.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
	Properties properties;
	FileInputStream fis;
	String filePath;

	public PropertyUtils(String fileName) {
		filePath = fileName;
		try {
			properties = new Properties();
			fis = new FileInputStream(filePath);
			if (fis != null) {
				properties.load(fis);
			} else {
				System.out.println("property file '" + fileName + "' not found in the classpath");
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

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String propFilePath = "src/test/resources/config.properties";
		PropertyUtils obj = new PropertyUtils(propFilePath);

		System.out.println("USERNAME: " + obj.getValue("username"));
		System.out.println("PASSWORD: " + obj.getValue("password"));

	}

}
