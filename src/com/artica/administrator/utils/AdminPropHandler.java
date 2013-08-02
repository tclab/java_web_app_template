package com.artica.administrator.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class AdminPropHandler {
	
	/**
	 * Get an administration configuration property.
	 * 
	 * @param key
	 * @return
	 */
	public static String getConfProp(String key) {
		String propName = AdminPropHandler.class.getSimpleName() + ".properties";
		return getProperty(key, propName);
	}
	
	
	/**
	 * Set an administration configuration property.
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public static void setConfProp(String key, String value) {
		String propName = AdminPropHandler.class.getSimpleName() + ".properties";
		setProperty(key, value, propName);
	}
	
	
	/**
	 * Get a property
	 * @param key
	 * @param propName
	 * @return
	 */
	private static String getProperty(String key, String propName) {
		String property = null;
		Properties properties = new Properties();
		
		try {
			properties.load(AdminPropHandler.class.getResourceAsStream(File.separator + propName));
			property = properties.getProperty(key);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		return property;
	}
	
	/**
	 * Set a property
	 * @param key
	 * @param value
	 * @param propertyFile
	 * @return
	 */
	private static void setProperty(String key, String value, String propertyFile){
		File archivo = new File("./" + propertyFile);
		Properties properties = new Properties();
		FileInputStream stream = null;
		try {
			stream = new FileInputStream(archivo); 
			properties.load(stream); 
			
			FileOutputStream fos = new FileOutputStream(archivo);
			properties.setProperty(key, value);
			properties.store(fos, null);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stream != null) {
					stream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//TEST
	public static void main(String[] args) {
		System.out.println("Prop: " + AdminPropHandler.getConfProp("FCInit.do.spdCables.url"));
		AdminPropHandler.setConfProp("FCInit.do.spdCables.url", "http://www.w3schools.com");
		System.out.println("Prop: " + AdminPropHandler.getConfProp("FCInit.do.spdCables.url"));
	}
}