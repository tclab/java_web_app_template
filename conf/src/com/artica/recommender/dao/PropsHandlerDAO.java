package com.artica.recommender.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.artica.conf.dao.exceptions.ConnectionException;
import com.artica.recommender.dao.utils.ConfPropHandler;
import com.artica.recommender.dao.utils.ConnectionHandler;
import com.artica.recommender.model.Property;
import com.artica.recommender.model.RecomLogRecord;

public class PropsHandlerDAO {

	/* 
	 * ***************
	 * HANDLE LOGS
	 * ***************
	 */
	public ArrayList<RecomLogRecord> getRecomLogs(){
		Connection connection = null;
        PreparedStatement logsStatement = null;
        ResultSet resultLogs = null;
        ArrayList<RecomLogRecord> logs = new ArrayList<RecomLogRecord>();

        try {
        	connection = ConnectionHandler.getConeccion();
			if (connection == null) {
				throw new ConnectionException(ConfPropHandler.getConfProp("msg.exception.connectionExcep"));
			}
			
            String sql = "SELECT * FROM tb_logs;";
            
            logsStatement = connection.prepareStatement(sql);
            resultLogs = logsStatement.executeQuery();
            
            //Look for logs.
            while (resultLogs.next()) {
				logs.add(new RecomLogRecord(
						resultLogs.getString("date"),
						resultLogs.getString("level"),
						resultLogs.getString("message"))
				);
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	ConnectionHandler.closeConnection(connection);
        	try {
				if (logsStatement != null && !logsStatement.isClosed()) {
					logsStatement.close();
				}
				if (resultLogs != null && !resultLogs.isClosed()) {
					resultLogs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
		
		return logs;
	}
	
	/* 
	 * ***************
	 * HANDLE USERS
	 * ***************
	 */
	
	
	
	
	/**
	 * Update password
	 */
	public boolean updatePass(String username, String password){
		boolean res = false; 
		Connection connection = null;
		PreparedStatement sections = null;

		try {
			connection = ConnectionHandler.getConeccion();
			if (connection == null) {
				throw new ConnectionException(ConfPropHandler.getConfProp("msg.exception.connectionExcep"));
			}
			
			String sql = "UPDATE recomendador.users SET password = ? WHERE username = ?;";
			
			sections = connection.prepareStatement(sql);
			sections.setString(1, password);
			sections.setString(2, username);
			int exeRes = sections.executeUpdate();

			if (exeRes != 0) {
				res = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHandler.closeConnection(connection);
			try {
				if (sections != null && !sections.isClosed()) {
					sections.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return res;
	}
	
	/**
	 * Update the roles of the user. 
	 * @param admin
	 * @param user
	 */
	public boolean updateRole(String username, boolean admin, boolean user){
		System.out.println("Roles: admin=" + admin + " user=" + user);
		boolean res = false;
		int rolesCount = admin && user ? 2 : 1;
		int succesRolesInsert = 0;
		Connection connection = null;
		PreparedStatement deleteRoles = null;
		PreparedStatement insertRoles = null;

		try {
			connection = ConnectionHandler.getConeccion();
			if (connection == null) {
				throw new ConnectionException(ConfPropHandler.getConfProp("msg.exception.connectionExcep"));
			}
			
			String sqlDelete = "DELETE FROM recomendador.authorities WHERE username = ?;";
			String sqlInsert = "INSERT INTO recomendador.authorities (username, authority) VALUES (?,?);";
			
			//clean previous roles
			deleteRoles = connection.prepareStatement(sqlDelete);
			deleteRoles.setString(1, username);
			deleteRoles.executeUpdate();
			succesRolesInsert++;
			
			//insert new roles
			insertRoles = connection.prepareStatement(sqlInsert);
			if (admin && user) {
				insertRoles.setString(1, username);
				insertRoles.setString(2, "ROLE_ADMIN");
				int exeRes = insertRoles.executeUpdate();
				if (exeRes != 0) {
					succesRolesInsert++;
				}

				insertRoles.setString(1, username);
				insertRoles.setString(2, "ROLE_USER");
				int exeRes2 = insertRoles.executeUpdate();
				if (exeRes2 != 0) {
					succesRolesInsert++;
				}
			} else {
				if (admin) {
					insertRoles.setString(1, username);
					insertRoles.setString(2, "ROLE_ADMIN");
					int exeRes = insertRoles.executeUpdate();
					if (exeRes != 0) {
						succesRolesInsert++;
					}
				} else if (user) {
					insertRoles.setString(1, username);
					insertRoles.setString(2, "ROLE_USER");
					int exeRes = insertRoles.executeUpdate();
					if (exeRes != 0) {
						succesRolesInsert++;
					}
				}
			}
			
			
			if (rolesCount == succesRolesInsert - 1) {
				res = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHandler.closeConnection(connection);
			try {
				if (deleteRoles != null && !deleteRoles.isClosed()) {
					deleteRoles.close();
				}
				if (insertRoles != null && !insertRoles.isClosed()) {
					insertRoles.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}
	
	/**
	 * Creates a new user.
	 * @param username
	 * @param password
	 * @param admin
	 * @param username
	 */
	public boolean createUser(String username, String password){
		boolean res = false;
		Connection connection = null;
        PreparedStatement createUser = null;

        try {
        	connection = ConnectionHandler.getConeccion();
			if (connection == null) {
				throw new ConnectionException(ConfPropHandler.getConfProp("msg.exception.connectionExcep"));
			}
			
            String sql = "INSERT INTO recomendador.users (username, password, enabled) VALUES (?,?, 1);";
            createUser = connection.prepareStatement(sql);
            createUser.setString(1, username);
            createUser.setString(2, password);
            int exeRes = createUser.executeUpdate();
            if (exeRes != 0) {
				res = true;
			}

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	ConnectionHandler.closeConnection(connection);
        	try {
				if (createUser != null && !createUser.isClosed()) {
					createUser.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
        return res;
	}
	
	/**
	 * Saves user roles.
	 * @param username
	 * @param admin
	 * @param user
	 */
	public boolean saveRoles(String username, boolean admin, boolean user){
		boolean res = false;
		int rolesCount = admin && user ? 2 : 1;
		int succesRolesInsert = 0;
		Connection connection = null;
		PreparedStatement insertRoles = null;

		try {
			connection = ConnectionHandler.getConeccion();
			if (connection == null) {
				throw new ConnectionException(ConfPropHandler.getConfProp("msg.exception.connectionExcep"));
			}
			
			String sqlInsert = "INSERT INTO recomendador.authorities (username, authority) VALUES (?,?);";
			
			//insert new roles
			insertRoles = connection.prepareStatement(sqlInsert);
			if (admin) {
				insertRoles.setString(1, username);
				insertRoles.setString(2, "ROLE_ADMIN");
				int exeRes = insertRoles.executeUpdate();
				if (exeRes != 0) {
					succesRolesInsert++;
				}
			}
			if (user) {
				insertRoles.setString(1, username);
				insertRoles.setString(2, "ROLE_USER");
				int exeRes = insertRoles.executeUpdate();
				if (exeRes != 0) {
					succesRolesInsert++;
				}
			}
			
			if (rolesCount == succesRolesInsert) {
				res = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHandler.closeConnection(connection);
			try {
				if (insertRoles != null && !insertRoles.isClosed()) {
					insertRoles.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return res;
	}
	
	
	
	/**
	 * Delete the specified user.
	 */
	public boolean deleteUser(String username) {
		boolean res = false;
		if (deleteRoles(username)) {
			if (deleteUsr(username)) {
				res = true;
			}
		}
		return res;
	}
	
	
	public boolean deleteUsr(String username) {

		Connection connection = null;
		PreparedStatement deleteRoles = null;
		boolean res = false;

		try {
			connection = ConnectionHandler.getConeccion();
			if (connection == null) {
				throw new ConnectionException(
						ConfPropHandler.getConfProp("msg.exception.connectionExcep"));
			}

			String sqlDelete = "DELETE FROM recomendador.users WHERE username = ?;";

			// clean previous roles
			deleteRoles = connection.prepareStatement(sqlDelete);
			deleteRoles.setString(1, username);
			deleteRoles.executeUpdate();
			res = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHandler.closeConnection(connection);
			try {
				if (deleteRoles != null && !deleteRoles.isClosed()) {
					deleteRoles.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return res;
	}
	
	public boolean deleteRoles(String username) {

		Connection connection = null;
		PreparedStatement deleteRoles = null;
		boolean res = false;

		try {
			connection = ConnectionHandler.getConeccion();
			if (connection == null) {
				throw new ConnectionException(
						ConfPropHandler.getConfProp("msg.exception.connectionExcep"));
			}

			String sqlDelete = "DELETE FROM recomendador.authorities WHERE username = ?;";

			// clean previous roles
			deleteRoles = connection.prepareStatement(sqlDelete);
			deleteRoles.setString(1, username);
			deleteRoles.executeUpdate();
			res = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHandler.closeConnection(connection);
			try {
				if (deleteRoles != null && !deleteRoles.isClosed()) {
					deleteRoles.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return res;
	}
	
	/* 
	 * ***************
	 * HANDLE PROPERTIES
	 * ***************
	 */
	public ArrayList<Property> getEngineProperties(){
		ArrayList<Property> properties = new ArrayList<Property>();
		Connection connection = null;
		PreparedStatement props = null;
		ResultSet result = null;

		try {
			connection = ConnectionHandler.getConeccion();
			if (connection == null) {
				throw new ConnectionException(ConfPropHandler.getConfProp("msg.exception.connectionExcep"));
			}
			
			String sql = "SELECT name, value  FROM recomendador.tb_props WHERE section = 'engine';";
			props = connection.prepareStatement(sql);
			result = props.executeQuery();

			while (result.next()) {
				properties.add(new Property(
						result.getString("name"), 
						result.getString("value"))
				);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHandler.closeConnection(connection);
			try {
				if (props != null && !props.isClosed()) {
					props.close();
				}
				if (result != null && !result.isClosed()) {
					result.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return properties;
	}
	
	
	/**
	 * Gets spider frequency
	 * @param spider
	 * @return
	 */
	public String getFrequency(String spider) {
		String frequency = null;

		Connection connection = null;
		PreparedStatement sections = null;
		ResultSet result = null;

		try {
			connection = ConnectionHandler.getConeccion();
			if (connection == null) {
				throw new ConnectionException(ConfPropHandler.getConfProp("msg.exception.connectionExcep"));
			}
			
			String sql = "SELECT ds.description, sc.frequency  FROM `recomendador`.`tb_datasource` AS ds, `recomendador`.`tb_schedule` AS sc WHERE sc.fkDataSource = ds.id AND description = ?;";
			sections = connection.prepareStatement(sql);
			sections.setString(1, spider);
			result = sections.executeQuery();

			while (result.next()) {
				frequency = result.getString("frequency");
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

		return frequency;
	}
	
	/**
	 * Sets spider frequency
	 * @param spider
	 * @param frequency
	 * @return
	 */
	public boolean setFrequency(String spider, String frequency) {

		Connection connection = null;
		PreparedStatement sections = null;
		boolean returnRes = false; 

		try {
			connection = ConnectionHandler.getConeccion();
			if (connection == null) {
				throw new ConnectionException(ConfPropHandler.getConfProp("msg.exception.connectionExcep"));
			}
			
			String sql = "UPDATE `recomendador`.`tb_schedule` SET frequency = ? WHERE fkDataSource = (select id from (SELECT ds.id FROM `recomendador`.`tb_datasource` AS ds, `recomendador`.`tb_schedule` AS sc WHERE sc.fkDataSource = ds.id AND description = ? limit 1) as c);";
			
			sections = connection.prepareStatement(sql);
			sections.setString(1, frequency);
			sections.setString(2, spider);
			int result = sections.executeUpdate();

			if (result != 0) {
				returnRes = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHandler.closeConnection(connection);
			try {
				if (sections != null && !sections.isClosed()) {
					sections.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return returnRes;

	}
	
	
	/* 
	 * ***************
	 * HANDLE METADATA
	 * ***************
	 */
	
	/**
	 * Inserts a metadata item.
	 */
	public boolean insertVodMetadata(String keyName, String description) {
		boolean res = false;
		Connection connection = null;
        PreparedStatement sections = null;

        try {
        	connection = ConnectionHandler.getConeccion();
			if (connection == null) {
				throw new ConnectionException(ConfPropHandler.getConfProp("msg.exception.connectionExcep"));
			}
			
            String sql = "INSERT INTO `recomendador`.`tb_metadata` (keyName, description, fkContentType) VALUES (?,?,(SELECT id FROM tb_contenttype WHERE type = 'VOD'));";
            
            sections = connection.prepareStatement(sql);
            sections.setString(1, keyName);
            sections.setString(2, description);
            int result = sections.executeUpdate();
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	ConnectionHandler.closeConnection(connection);
        	try {
				if (sections != null && !sections.isClosed()) {
					sections.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
        return res;
	}
	
	/**
	 * Deletes a metadata item.
	 */
	public boolean deleteContMetadata(Long keyName) {
		boolean res = false;
		Connection connection = null;
        PreparedStatement sections = null;

        try {
        	connection = ConnectionHandler.getConeccion();
			if (connection == null) {
				throw new ConnectionException(ConfPropHandler.getConfProp("msg.exception.connectionExcep"));
			}
			
            String sql = "DELETE FROM `recomendador`.`tb_metadata` WHERE id = ?;";
            
            sections = connection.prepareStatement(sql);
            sections.setLong(1, keyName);
            int result = sections.executeUpdate();
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	ConnectionHandler.closeConnection(connection);
        	try {
				if (sections != null && !sections.isClosed()) {
					sections.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
        return res;
	}
	
	
	
	/**
	 * Updates the content of a metadata.
	 * @param id
	 * @param keyName
	 * @param description
	 * @return
	 */
	public boolean setVodMetadata(Long id, String keyName, String description) {
		boolean res = false;
		Connection connection = null;
        PreparedStatement sections = null;

        try {
        	connection = ConnectionHandler.getConeccion();
			if (connection == null) {
				throw new ConnectionException(ConfPropHandler.getConfProp("msg.exception.connectionExcep"));
			}
			
            String sql = "UPDATE `recomendador`.`tb_metadata` SET keyName = ?, description = ? WHERE id = ?;";
            sections = connection.prepareStatement(sql);
            sections.setString(1, keyName);
            sections.setString(2, description);
            sections.setLong(3, id);
            
            int result = sections.executeUpdate();
            res = true;
           
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	ConnectionHandler.closeConnection(connection);
        	try {
				if (sections != null && !sections.isClosed()) {
					sections.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }

		return res;
	}
	
	
	/**
	 * Inserts a metadata item.
	 */
	public boolean insertEpgMetadata(String keyName, String description) {
		boolean res = false;
		Connection connection = null;
        PreparedStatement sections = null;

        try {
        	connection = ConnectionHandler.getConeccion();
			if (connection == null) {
				throw new ConnectionException(ConfPropHandler.getConfProp("msg.exception.connectionExcep"));
			}
			
            String sql = "INSERT INTO `recomendador`.`tb_metadata` (keyName, description, fkContentType) VALUES (?,?,(SELECT id FROM tb_contenttype WHERE type = 'LIVE'));";
            sections = connection.prepareStatement(sql);
            sections.setString(1, keyName);
            sections.setString(2, description);
            int result = sections.executeUpdate();
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	ConnectionHandler.closeConnection(connection);
        	try {
				if (sections != null && !sections.isClosed()) {
					sections.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
        return res;
	}
	
	
	
	/**
	 * Updates the content of a metadata.
	 * @param id
	 * @param keyName
	 * @param description
	 * @return
	 */
	public boolean setEpgMetadata(Long id, String keyName, String description) {
		boolean res = false;
		Connection connection = null;
        PreparedStatement sections = null;

        try {
        	connection = ConnectionHandler.getConeccion();
			if (connection == null) {
				throw new ConnectionException(ConfPropHandler.getConfProp("msg.exception.connectionExcep"));
			}
			
            String sql = "UPDATE `recomendador`.`tb_metadata` SET keyName = ?, description = ? WHERE id = ?;";
            sections = connection.prepareStatement(sql);
            sections.setString(1, keyName);
            sections.setString(2, description);
            sections.setLong(3, id);
            
            int result = sections.executeUpdate();
            res = true;
           
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	ConnectionHandler.closeConnection(connection);
        	try {
				if (sections != null && !sections.isClosed()) {
					sections.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }

		return res;
	}

	
	/**
	 * Inserts a metadata item.
	 */
	public boolean insertChannelMetadata(String keyName, String description) {
		boolean res = false;
		Connection connection = null;
        PreparedStatement sections = null;

        try {
        	connection = ConnectionHandler.getConeccion();
			if (connection == null) {
				throw new ConnectionException(ConfPropHandler.getConfProp("msg.exception.connectionExcep"));
			}
			
            String sql = "INSERT INTO `recomendador`.`tb_channelmetadatakey` (keyName, description) VALUES (?,?);";
            sections = connection.prepareStatement(sql);
            sections.setString(1, keyName);
            sections.setString(2, description);
            int result = sections.executeUpdate();
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	ConnectionHandler.closeConnection(connection);
        	try {
				if (sections != null && !sections.isClosed()) {
					sections.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
        return res;
	}
	
	/**
	 * Deletes a metadata item.
	 */
	public boolean deleteChannelMetadata(Long metaId) {
		boolean res = false;
		Connection connection = null;
        PreparedStatement sections = null;

        try {
        	connection = ConnectionHandler.getConeccion();
			if (connection == null) {
				throw new ConnectionException(ConfPropHandler.getConfProp("msg.exception.connectionExcep"));
			}
			
            String sql = "DELETE FROM `recomendador`.`tb_channelmetadatakey` WHERE id = ?;";
            sections = connection.prepareStatement(sql);
            sections.setLong(1, metaId);
            int result = sections.executeUpdate();
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	ConnectionHandler.closeConnection(connection);
        	try {
				if (sections != null && !sections.isClosed()) {
					sections.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
        return res;
	}
	
	
	
	/**
	 * Updates the content of a metadata.
	 * @param id
	 * @param keyName
	 * @param description
	 * @return
	 */
	public boolean setChannelMetadata(Long id, String keyName, String description) {
		boolean res = false;
		Connection connection = null;
        PreparedStatement sections = null;

        try {
        	connection = ConnectionHandler.getConeccion();
			if (connection == null) {
				throw new ConnectionException(ConfPropHandler.getConfProp("msg.exception.connectionExcep"));
			}
			
            String sql = "UPDATE `recomendador`.`tb_channelmetadatakey` SET keyName = ?, description = ? WHERE id = ?;";
            sections = connection.prepareStatement(sql);
            sections.setString(1, keyName);
            sections.setString(2, description);
            sections.setLong(3, id);
            
            int result = sections.executeUpdate();
            res = true;
           
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	ConnectionHandler.closeConnection(connection);
        	try {
				if (sections != null && !sections.isClosed()) {
					sections.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }

		return res;
	}
	
	/**
	 * Inserts a metadata item.
	 */
	public boolean insertPageMetadata(String keyName, String description) {
		boolean res = false;
		Connection connection = null;
        PreparedStatement sections = null;

        try {
        	connection = ConnectionHandler.getConeccion();
			if (connection == null) {
				throw new ConnectionException(ConfPropHandler.getConfProp("msg.exception.connectionExcep"));
			}
			
            String sql = "INSERT INTO `recomendador`.`tb_pagemetadatakey` (keyName, description) VALUES (?,?);";
            sections = connection.prepareStatement(sql);
            sections.setString(1, keyName);
            sections.setString(2, description);
            int result = sections.executeUpdate();
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	ConnectionHandler.closeConnection(connection);
        	try {
				if (sections != null && !sections.isClosed()) {
					sections.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
        return res;
	}
	
	/**
	 * Deletes a metadata item.
	 */
	public boolean deletePageMetadata(Long keyName) {
		boolean res = false;
		Connection connection = null;
        PreparedStatement sections = null;

        try {
        	connection = ConnectionHandler.getConeccion();
			if (connection == null) {
				throw new ConnectionException(ConfPropHandler.getConfProp("msg.exception.connectionExcep"));
			}
			
            String sql = "DELETE FROM `recomendador`.`tb_pagemetadatakey` WHERE id = ?;";
            sections = connection.prepareStatement(sql);
            sections.setLong(1, keyName);
            int result = sections.executeUpdate();
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	ConnectionHandler.closeConnection(connection);
        	try {
				if (sections != null && !sections.isClosed()) {
					sections.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
        return res;
	}
	
	
	
	/**
	 * Updates the content of a metadata.
	 * @param id
	 * @param keyName
	 * @param description
	 * @return
	 */
	public boolean setPageMetadata(Long id, String keyName, String description) {
		boolean res = false;
		Connection connection = null;
        PreparedStatement sections = null;

        try {
        	connection = ConnectionHandler.getConeccion();
			if (connection == null) {
				throw new ConnectionException(ConfPropHandler.getConfProp("msg.exception.connectionExcep"));
			}
			
            String sql = "UPDATE `recomendador`.`tb_pagemetadatakey` SET keyName = ?, description = ? WHERE id = ?;";
            sections = connection.prepareStatement(sql);
            sections.setString(1, keyName);
            sections.setString(2, description);
            sections.setLong(3, id);
            
            int result = sections.executeUpdate();
            res = true;
           
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	ConnectionHandler.closeConnection(connection);
        	try {
				if (sections != null && !sections.isClosed()) {
					sections.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }

		return res;
	}
	
	
	
	
	
	/**
	 * Gets spider frequency
	 * @param spider
	 * @return
	 */
	public String getProp(String propName) {
		String value = null;

		Connection connection = null;
		PreparedStatement sections = null;
		ResultSet result = null;

		try {
			connection = ConnectionHandler.getConeccion();
			if (connection == null) {
				throw new ConnectionException(ConfPropHandler.getConfProp("msg.exception.connectionExcep"));
			}
			
			String sql = "SELECT * FROM `recomendador`.`tb_props` WHERE name = ?;";
			sections = connection.prepareStatement(sql);
			sections.setString(1, propName);

			result = sections.executeQuery();

			while (result.next()) {
				value = result.getString("value");
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

		return value;
	}
	
	/**
	 * Gets spider frequency
	 * @param spider
	 * @return
	 */
	public String getProp(String propName, Connection connection) {
		String value = null;

		PreparedStatement sections = null;
		ResultSet result = null;

		try {
			if (connection == null) {
				throw new ConnectionException(ConfPropHandler.getConfProp("msg.exception.connectionExcep"));
			}
			
			String sql = "SELECT * FROM `recomendador`.`tb_props` WHERE name = ?;";
			sections = connection.prepareStatement(sql);
			sections.setString(1, propName);

			result = sections.executeQuery();

			while (result.next()) {
				value = result.getString("value");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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

		return value;
	}
	
	/**
	 * Gets spider frequency
	 * @param spider
	 * @return
	 */
	public boolean setProp(String propName, String propValue) {
		Connection connection = null;
		PreparedStatement sections = null;
		boolean res = false;

		try {
			connection = ConnectionHandler.getConeccion();
			if (connection == null) {
				throw new ConnectionException(ConfPropHandler.getConfProp("msg.exception.connectionExcep"));
			}
			
			String sql = "UPDATE `recomendador`.`tb_props` SET value = ? WHERE name = ?;";
			sections = connection.prepareStatement(sql);
			sections.setString(1, propValue);
			sections.setString(2, propName);

			int result = sections.executeUpdate();
			if (result != 0) {
				res = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionHandler.closeConnection(connection);
			try {
				if (sections != null && !sections.isClosed()) {
					sections.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}
	
	//TEST
	public static void main(String [] args){
		
//		System.out.println("Propiedad antes: " + new PropsHandlerDAO().getProp("global.propsLocation"));
//		new PropsHandlerDAO().setProp("global.propsLocation","mod location");
//		
//		System.out.println("Propiedad despues: " + new PropsHandlerDAO().getProp("global.propsLocation"));
		
	}
}