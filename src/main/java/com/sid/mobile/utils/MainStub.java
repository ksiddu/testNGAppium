package com.sid.mobile.utils;

import java.io.IOException;

public class MainStub {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Hi!, Welcome to appium mobile testing..!");
		PropertyUtils obj = new PropertyUtils();

		System.out.println("USERNAME: " + obj.getValue("username"));
		System.out.println("PASSWORD: " + obj.getValue("password"));
	}

	}

