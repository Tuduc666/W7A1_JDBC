package UserMenu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserDAO {
	public void registerUser() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");   //loading into memory
	    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	    String username = "TamJava";
	    String password = "Tampass";
	    Connection conn = DriverManager.getConnection(url, username, password);
		
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter your email");
	    String email = sc.nextLine();
	    System.out.println("Enter your username");
	    String name = sc.nextLine();
	    System.out.println("Enter your password");
	    String pass = sc.nextLine();
	    
	    String sql = "insert into user_table "
	            + "(user_email, user_name, user_password) "
	            + "VALUES(?, ?, ?)";
	      PreparedStatement stmt =  conn.prepareStatement(sql);
	      stmt.setString(1, email);        // position, varname
	      stmt.setString(2, name);            // position, varname
	      stmt.setString(3, pass);         // position, varname
	      
	      stmt.executeUpdate();      
	}
	public boolean loginUser() throws ClassNotFoundException, SQLException {	
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter your email");
	    String email = sc.nextLine();
	    System.out.println("Enter your password");
	    String pass = sc.nextLine();
	    
	    return validateUser(email, pass);   
	}
	public void updUser() throws ClassNotFoundException, SQLException {	
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter your email");
	    String email = sc.nextLine();
	    getUsersByEmail(email);            // print user info
	    
	    System.out.println("Enter your new username");
	    String name = sc.nextLine();
	    System.out.println("Enter your new password");
	    String pass = sc.nextLine();
	    
	    updateUser(email, name, pass);   
	}
	public void getAllUsers() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");   //loading into memory
	    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	    String username = "TamJava";
	    String password = "Tampass";
	    Connection conn = DriverManager.getConnection(url, username, password);
		
	    String sql = "select * from user_table";
	    PreparedStatement stmt =  null;
	    ResultSet result = null;
	    
	    stmt =  conn.prepareStatement(sql);
	    result = stmt.executeQuery();
	    
	    while(result != null && result.next()) {         // if not null, get first/next record from the result    
	    	System.out.printf("%-30d   %-30s   %-30s   %-30s \r\n",
	    			result.getInt(1),result.getString(2),result.getString(3),result.getString(4));     

	    }     
	}
	public void getUsersByEmail(String email) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");   //loading into memory
	    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	    String username = "TamJava";
	    String password = "Tampass";
	    Connection conn = DriverManager.getConnection(url, username, password);
		
	    String sql = "select * from user_table where user_email = ?";
	    PreparedStatement stmt =  null;
	    ResultSet result = null;
	    
	    stmt =  conn.prepareStatement(sql);
	    stmt.setString(1, email);
	    result = stmt.executeQuery();
	    
	    while(result != null && result.next()) {         // if not null, get first/next record from the result    
	    	System.out.printf("%-30d   %-30s   %-30s   %-30s \r\n",
	    			result.getInt(1),result.getString(2),result.getString(3),result.getString(4));     

	    }     
	    
	}
	public boolean validateUser(String email, String passwrd) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");   //loading into memory
	    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	    String username = "TamJava";
	    String password = "Tampass";
	    Connection conn = DriverManager.getConnection(url, username, password);
		
	    String sql = "select * from user_table where user_email = ? and user_password= ?";
	    PreparedStatement stmt =  null;
	    ResultSet result = null;
	    
	    stmt =  conn.prepareStatement(sql);
	    stmt.setString(1, email);
	    stmt.setString(2, passwrd);
	    result = stmt.executeQuery();
	                                                         // not null means there is no error
	    if (result != null && result.next()) return true;    // result.next is true means there is at least 1 record
	    else return false;
	}
	public void updateUser(String email, String name, String passwrd) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");   //loading into memory
	    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	    String username = "TamJava";
	    String password = "Tampass";
	    Connection conn = DriverManager.getConnection(url, username, password);
		
	    String sql = "update user_table set user_name=?, user_password= ? where user_email = ?";
	    PreparedStatement stmt =  null;
	    //ResultSet result = null;
	    
	    stmt =  conn.prepareStatement(sql);
	    stmt.setString(1, name);
	    stmt.setString(2, passwrd);
	    stmt.setString(3, email);
	    //result = stmt.executeQuery();
	    stmt.executeUpdate();
	   
	}
}
