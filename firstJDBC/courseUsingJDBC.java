package firstJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class courseUsingJDBC {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
			Class.forName("oracle.jdbc.driver.OracleDriver");   //loading into memory
		    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		    String username = "TamJava";
		    String password = "Tampass";
		    Connection conn = DriverManager.getConnection(url, username, password);
			   
		    String course_name = "Gym";
		    String min_gpa = "2.5";
		    	    
		    String INSERT = "INSERT INTO course "
		    		+ "(course_name, min_gpa) "
		    		+ "VALUES(?, ?)";
		    PreparedStatement stmt =  conn.prepareStatement(INSERT);  
		    stmt.setString(1, course_name);        // position, varname
		    stmt.setString(2, min_gpa);            // position, varname
		    
		    stmt.executeUpdate();
		    
	}
}
