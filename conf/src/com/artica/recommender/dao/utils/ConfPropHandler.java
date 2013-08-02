package com.artica.recommender.dao.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

public class ConfPropHandler {

	public static String getProperty(String key) {
		String property = null;
		ResourceBundle archivoPropiedades = ResourceBundle.getBundle("ConfPropHandler");
		
		try {
			property = archivoPropiedades.getString(key);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return property;
	}
	
	/**
	 * Get an administration configuration property.
	 * 
	 * @param key
	 * @return
	 */
	public static String getConfProp(String key) {
		String propName = ConfPropHandler.class.getSimpleName() + ".properties";
		return getProperty(key, propName);
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
			properties.load(ConfPropHandler.class.getResourceAsStream("/"+propName));
			property = properties.getProperty(key);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		return property;
	}
	
	//TEST
	public static void main(String[] args) {
		System.out.println("Prop: " + ConfPropHandler.getConfProp("conf.location"));
	}
}
