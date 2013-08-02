package com.artica.recommender.log;

import java.sql.Connection;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.artica.conf.dao.exceptions.ConnectionException;
import com.artica.recommender.dao.utils.ConnectionHandler;

public class LogHandler {

	public static void log(String level,String message, Class usedClass) {
		try{
			Logger logger;
			logger = Logger.getLogger(usedClass);
			try {
				DOMConfigurator.configure("src/log4j.xml");
				
				switch(level.charAt(0)){
				case 'I':
					logger.info(message);
					break;
				case 'W':
					logger.warn(message);
					break;
				case 'E':
					logger.error(message);
					break;
				case 'D':
					logger.debug(message);
					break;
				case 'F':
					logger.fatal(message);
					break;
				}
			} catch (Exception e1) { }	
			
			Connection connection = null;
			try{
				connection = ConnectionHandler.getConeccion();
				if (connection == null) {
					throw new ConnectionException();
				}
				
				Statement stm=connection.createStatement();
				String sqlLog="INSERT INTO tb_logs (date,level,message) VALUES ("+"now()"+",'"+level+"','"+message+"')";
				stm.executeUpdate(sqlLog);
				
			} catch (ConnectionException e) {
				logger.error("The logger coldn't stablish a connection to the data base!");
			}
					
		}catch(Exception exc){
//			exc.printStackTrace();
			System.out.println("Error intentando escribir Log");
		}
	}
	
	public static void main(String [] args){
		log("WARNING", "This is a test message2...!!", LogHandler.class);
	}

}
