package firstJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadAccess {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
			Class.forName("oracle.jdbc.driver.OracleDriver");   //loading into memory
		    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		    String username = "TamJava";
		    String password = "Tampass";
		    Connection conn = DriverManager.getConnection(url, username, password);
			
		    String byEmail = "select * from student";
		    
		    PreparedStatement stmt =  conn.prepareStatement(byEmail);

		    ResultSet result = stmt.executeQuery();
		    while(result != null && result.next()) {         // if not null, get first record from the result    
		    	System.out.println(result.getInt(1));
		    	System.out.println(result.getString(2));
		    	System.out.println(result.getString(3));
		    	System.out.println(result.getString(4));
		    	System.out.println(result.getString(5));
		    }
		      

	}
}
