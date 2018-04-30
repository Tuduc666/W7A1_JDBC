package firstJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateAccess {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
			Class.forName("oracle.jdbc.driver.OracleDriver");   //loading into memory
		    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		    String username = "TamJava";
		    String password = "Tampass";
		    Connection conn = DriverManager.getConnection(url, username, password);
			
		    String sql = "update student set full_name = ?, "
		    		+ "major = ?, student_password = ? "
		    		+ "where email = ?";
		    PreparedStatement stmt =  conn.prepareStatement(sql);
		    stmt.setString(1, "Tam Uduc");        // position, varname
		    stmt.setString(2, "Computer Science");            // position, varname
		    stmt.setString(3, "Newpass");           // position, varname
		    stmt.setString(4, "Lance2@email.com");         // position, varname
		    
		    stmt.executeUpdate();
		    
	}
}
