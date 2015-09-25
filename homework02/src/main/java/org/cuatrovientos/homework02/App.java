package org.cuatrovientos.homework02;

import java.util.Scanner;
import java.util.Vector;

/**
 * Solution to homework02 Not done
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		String option = "0";
		Scanner reader = new Scanner(System.in);
		Bd bd = new Bd();
		
		do {
			System.out.println("Enter option");
			option = reader.nextLine();
			
			switch (option) {
			case "1":
					Vector<Customer> result = bd.selectAll();
					System.out.println(result.toString());
				break;
			case "2":
				break;
			case "3":
				break;
			case "4":
				break;
			case "5":
				break;
			default:
				break;
			}
		} while (!option.equals("6"));
	}
}
