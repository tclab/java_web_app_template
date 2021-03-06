package co.tclab.template.utils;

import java.io.File;
import java.io.FileNotFoundException;
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
	 * Get a property
	 * @param key
	 * @param propName
	 * @return
	 */
	public static String getProperty(String key, String propName) {
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
	
	//TEST
	public static void main(String[] args) {
		System.out.println("Prop: " + AdminPropHandler.getConfProp("admin.host"));
	}
}
