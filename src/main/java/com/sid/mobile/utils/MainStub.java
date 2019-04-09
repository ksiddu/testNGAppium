package com.sid.mobile.utils;

import java.io.IOException;

public class MainStub {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Hi!, Welcome to appium mobile testing..!");
		PropertyUtils obj = new PropertyUtils("src/test/resources/config.properties");

		System.out.println("PLATFORM: " + obj.getValue("platform"));
		System.out.println("TYPE: " + obj.getValue("type"));
	}

}
