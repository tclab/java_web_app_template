package com.artica.recommender.dao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.artica.conf.dao.exceptions.ConnectionException;
import com.artica.recommender.conf.PropHandler;

public class ConnectionHandler {

	/**
	 * Returns a connection to the database.
	 * 
	 * @return
	 */
	public static Connection getConeccion() throws ConnectionException{
		Connection c = null;

//		try {
//			Class.forName("org.gjt.mm.mysql.Driver");
//			c = DriverManager.getConnection("jdbc:mysql://" + 
//					PropHandler.getDataBaseProp("recommender.host") + ":" + 
//					PropHandler.getDataBaseProp("recommender.port") + "/" + 
//					PropHandler.getDataBaseProp("recommender.dataBaseName")+"?" + 
//					"user=" +  PropHandler.getDataBaseProp("recommender.usr") + "&" + 
//					"password=" + PropHandler.getDataBaseProp("recommender.pss") + "&" + 
//					"characterEncoding=utf8" + "&" +
//					"connectionCollation=utf8_general_ci" + "&" +
//					PropHandler.getDataBaseProp("recommender.access")
//					
//			);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//			throw new ConnectionException("Error trying to stablish a connection");
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("SQLException: " + e.getMessage());
//		    System.out.println("SQLState: " + e.getSQLState());
//		    System.out.println("VendorError: " + e.getErrorCode());
//			throw new ConnectionException("Error trying to stablish a connection");
//		}
		return c;
	}
	
	/**
	 * Close the given connection
	 * @param connection
	 */
	public static void closeConnection(Connection connection){
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
