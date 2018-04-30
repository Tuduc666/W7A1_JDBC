package firstJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class courseReadAccess {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
			Class.forName("oracle.jdbc.driver.OracleDriver");   //loading into memory
		    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		    String username = "TamJava";
		    String password = "Tampass";
		    Connection conn = DriverManager.getConnection(url, username, password);
			
		    String byEmail = "select * from course";
		    
		    PreparedStatement stmt =  conn.prepareStatement(byEmail);

		    ResultSet result = stmt.executeQuery();
		    while(result != null && result.next()) {         // if not null, get first record from the result    
		    	System.out.printf("%-30d   %-30s   %f \r\n",
		    			result.getInt(1),result.getString(2),result.getFloat(3));     

		    }      
	}
}
