/**
 * 
 */
package org.cuatrovientos.homework02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 * @author Administrador
 *
 */
public class Bd {

	private Connection connection;

	public Bd() {
		connection = new DataSource().getConnection();
	}

	public Vector<Customer> selectAll() {
		Vector<Customer> customers = new Vector<Customer>();
		String select = "select * from customers ";
		Statement statement;
		try {
			statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(select);

			while (resultSet.next()) {
				Customer customer = new Customer(resultSet.getInt("id"), resultSet.getString("name"));
				customers.addElement(customer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customers;
	}

	public Customer selectById(int id) {
		return new Customer();
	}

	public int insert() {
		return 1;
	}

	public int update() {
		return 1;
	}

	public int delete() {
		return 1;
	}

}
