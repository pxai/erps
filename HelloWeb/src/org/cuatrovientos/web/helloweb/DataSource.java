/**
 * 
 */
package org.cuatrovientos.web.helloweb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Administrador
 *
 */
public class DataSource {
	private Connection connection;
	
	public DataSource () {
		init();
	}
	
	private void init () {
		try {
			                  Class.forName("com.mysql.jdbc.Driver");
		
			connection =
				DriverManager.getConnection("jdbc:mysql://localhost/erp","root","");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @return the connection
	 */
	public Connection getConnection() {
		return connection;
	}

	/**
	 * @param connection the connection to set
	 */
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	
}
