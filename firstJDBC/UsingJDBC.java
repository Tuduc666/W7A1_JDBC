package firstJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsingJDBC {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
			Class.forName("oracle.jdbc.driver.OracleDriver");   //loading into memory
		    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		    String username = "TamJava";
		    String password = "Tampass";
		    Connection conn = DriverManager.getConnection(url, username, password);
			
		    Integer ID = null;
		    String[] COL = {"student_id"};      // array with column that we want.  request system generated id
		    
		    String full_name = "Lance Luke";
		    String email = "Lance3@email.com";
		    String major = "NONE";
		    String passwrd = "pass";
		    	    
		    String INSERT = "INSERT INTO student "
		    		+ "(full_name, email, major, student_password) "
		    		+ "VALUES(?, ?, ?, ?)";
		    PreparedStatement stmt =  conn.prepareStatement(INSERT, COL);  // request COL
		    stmt.setString(1, full_name);        // position, varname
		    stmt.setString(2, email);            // position, varname
		    stmt.setString(3, major);           // position, varname
		    stmt.setString(4, passwrd);         // position, varname
		    
		    stmt.executeUpdate();
		    
		    ResultSet result = stmt.getGeneratedKeys();
		    if(result != null && result.next()) {
		    	ID = result.getInt(1);
		    }
		    System.out.println(ID);        // ID is the system generated number
		    
	}
}
