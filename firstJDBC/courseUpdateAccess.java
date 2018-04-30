package firstJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class courseUpdateAccess {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
			Class.forName("oracle.jdbc.driver.OracleDriver");   //loading into memory
		    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		    String username = "TamJava";
		    String password = "Tampass";
		    Connection conn = DriverManager.getConnection(url, username, password);
			
		    String sql = "update course set course_name = ? "
		    		+ "where course_id = ?";
		    PreparedStatement stmt =  conn.prepareStatement(sql);
		    stmt.setString(1, "New Tech");        // position, varname
		    stmt.setInt(2, 1);            // position, varname
		    
		    stmt.executeUpdate();
		    
	}
}
