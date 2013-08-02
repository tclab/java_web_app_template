package com.artica.administrator.dao.LogginDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.artica.administrator.bo.menuBO.MenuItem;
import com.artica.administrator.dao.exceptions.ConnectionException;
import com.artica.administrator.dao.utils.ConnectionHandler;
import com.artica.administrator.utils.AdminPropHandler;

public class LogginDAO {

	
	/**
	 * Gets the list of sections.
	 */
	public ArrayList<MenuItem> getMenuItems(String section) {
		
//		User user = new User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities)
		
		ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
		
		Connection connection = null;
        PreparedStatement sections = null;
        ResultSet result = null;

        try {
        	connection = ConnectionHandler.getConeccion();
			if (connection == null) {
				throw new ConnectionException(AdminPropHandler.getConfProp("msg.exception.connectionExcep"));
			}
			
            String sql = "SELECT * FROM `tb_menu` WHERE PARENT IS NULL AND section = ?;";
            sections = connection.prepareStatement(sql);
            sections.setString(1, section);
            result = sections.executeQuery();
            
            while (result.next()) {
            	menuItems.add(new MenuItem(
            			result.getString("section"),
            			result.getString("name"),
            			result.getString("url"),
            			result.getString("parent"),
            			result.getString("order"),
            			result.getString("code")
            	));
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	ConnectionHandler.closeConnection(connection);
        	try {
				if (sections != null && !sections.isClosed()) {
					sections.close();
				}
				if (result != null && !result.isClosed()) {
					result.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }

		return menuItems;
	}
}
