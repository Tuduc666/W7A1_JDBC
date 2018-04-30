package UserMenu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MainEntry {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
outside: while(true) {
			UserDAO uDAO = new UserDAO();
			uDAO.getAllUsers();
			printMenu();
			int n = sc.nextInt();
			switch (n) {
				case 1 : 
					uDAO.registerUser();
					break;
				case 2 : 
					if(uDAO.loginUser()) System.out.println("Login Sucessful");
					else System.out.println("Login Failed");
					break;
				case 3 : 
					uDAO.updUser();
					break;
				case 4 : 
					break outside;
			}
			
			
			
			

//			uDAO.getUsersByEmail("nancy@yahoo.com");
//			System.out.println(uDAO.validateUser("tam@yahoo.com", "tx"));
//			uDAO.updateUser("nancy@yahoo.com", "NewNancy", "a11");
		}

	}
	public static void printMenu()  {
		System.out.println("Menu");
		System.out.println("1. Register");
		System.out.println("2. Login");
		System.out.println("3. Update info");
		System.out.println("4. Quit");
	}

}
