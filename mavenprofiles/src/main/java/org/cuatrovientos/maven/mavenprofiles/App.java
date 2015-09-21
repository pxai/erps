package org.cuatrovientos.maven.mavenprofiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Testing properties");
		Properties properties = new Properties();

		try {
			// open properties file and load it
			properties.load(App.class.getClassLoader().getResourceAsStream("myproject.properties"));

			System.out.println("Properties values");
			System.out.println(properties.getProperty("app.name"));
			System.out.println(properties.getProperty("other"));
			System.out.println(properties.getProperty("greet"));

		} catch (IOException ex) {
			ex.printStackTrace();
			System.err.println("Exception msg: " + ex.getMessage());
		}
	}
}
