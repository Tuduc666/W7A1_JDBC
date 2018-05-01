package ItemPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemDAO {
	public void getAllItems() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");   //loading into memory
	    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	    String username = "TamJava";
	    String password = "Tampass";
	    Connection conn = DriverManager.getConnection(url, username, password);
		
	    String sql = "select * from item";
	    PreparedStatement stmt =  null;
	    ResultSet result = null;
	    
	    stmt =  conn.prepareStatement(sql);
	    result = stmt.executeQuery();
	    
	    while(result != null && result.next()) {         // if not null, get first/next record from the result    
	    	System.out.printf("%-30d   %-30s   %-30d   %-30f \r\n",
	    			result.getInt(1),result.getString(2),result.getInt(3),result.getFloat(4));     
	    }     
	}
	public void getItemById(int id) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");   //loading into memory
	    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	    String username = "TamJava";
	    String password = "Tampass";
	    Connection conn = DriverManager.getConnection(url, username, password);
		
	    String sql = "select * from item where item_id = ?";
	    PreparedStatement stmt =  null;
	    ResultSet result = null;
	    
	    stmt =  conn.prepareStatement(sql);
	    stmt.setInt(1, id);
	    result = stmt.executeQuery();
	    
	    while(result != null && result.next()) {         // if not null, get first/next record from the result    
	    	System.out.printf("%-30d   %-30s   %-30d   %-30f \r\n",
	    			result.getInt(1),result.getString(2),result.getInt(3),result.getFloat(4));     
	    }     
	    
	}
	public void getItemsCostingGreaterThan(double p) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");   //loading into memory
	    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	    String username = "TamJava";
	    String password = "Tampass";
	    Connection conn = DriverManager.getConnection(url, username, password);
		
	    String sql = "select * from item where item_price > ?";
	    PreparedStatement stmt =  null;
	    ResultSet result = null;
	    
	    stmt =  conn.prepareStatement(sql);
	    stmt.setDouble(1, p);
	    result = stmt.executeQuery();
	    
	    while(result != null && result.next()) {         // if not null, get first/next record from the result    
	    	System.out.printf("%-30d   %-30s   %-30d   %-30f \r\n",
	    			result.getInt(1),result.getString(2),result.getInt(3),result.getFloat(4));     
	    }    
	}
	public void getItemsInStock() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");   //loading into memory
	    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	    String username = "TamJava";
	    String password = "Tampass";
	    Connection conn = DriverManager.getConnection(url, username, password);
		
	    String sql = "select * from item where item_quantity > 0";
	    PreparedStatement stmt =  null;
	    ResultSet result = null;
	    
	    stmt =  conn.prepareStatement(sql);
	    result = stmt.executeQuery();
	    
	    while(result != null && result.next()) {         // if not null, get first/next record from the result    
	    	System.out.printf("%-30d   %-30s   %-30d   %-30f \r\n",
	    			result.getInt(1),result.getString(2),result.getInt(3),result.getFloat(4));     
	    }    
	}
}
