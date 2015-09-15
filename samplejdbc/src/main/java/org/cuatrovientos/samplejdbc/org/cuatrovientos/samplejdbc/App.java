package org.cuatrovientos.samplejdbc.org.cuatrovientos.samplejdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) 
			throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		Connection connection =
				DriverManager.getConnection("jdbc:sqlite:test.db");
		Statement statement = connection.createStatement();
		
		String sql = "create table friends (id integer, name varchar(30))";
		//statement.executeUpdate(sql);
		
		String deleteSql = "delete from friends where id=3";
		statement.executeUpdate(deleteSql);
		
		String insertSql = "insert into friends values(3,'Zoco')";
		statement.executeUpdate(insertSql);
		
		String updateSql = "update friends set name='Zocolate',id=42 where id=3";
		statement.executeUpdate(updateSql);
		
		String select = "select * from friends order by name desc";
		ResultSet resultSet = statement.executeQuery(select);
		
		while (resultSet.next()) {
			//System.out.print("ID: " + resultSet.getString(1));
			//System.out.println(" Name: " + resultSet.getString(2));
			System.out.print("ID: " + resultSet.getInt("id"));
			System.out.println(" Name: " + resultSet.getString("name"));
		}
		
		int id = 5;
		String name = "Abilio";
		// Wrong way
		String insert = 
				"insert into friends values("+id+",'"+name+"')";
		statement.executeUpdate(insert);
		
		// Like a pro
		PreparedStatement preparedStatement =
				connection.prepareStatement("insert into friends values (?,?)");
		preparedStatement.setInt(1,7);
		preparedStatement.setString(2, "Endika");
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1,8);
		preparedStatement.setString(2, "David");
		preparedStatement.addBatch();
		
		preparedStatement.executeBatch();

		resultSet.close();
		connection.close();
		System.out.println("Hello World!");
	}
}
