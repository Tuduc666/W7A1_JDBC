package ItemClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	public Item getItemById(int id) throws ClassNotFoundException, SQLException {
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
	    
	    Item s = null;
	    while(result != null && result.next()) {           
//	    	System.out.printf("%-30d   %-30s   %-30d   %-30f \r\n",
//	    			result.getInt(1),result.getString(2),result.getInt(3),result.getFloat(4));     
	    	 s = new Item(result.getInt(1),result.getString(2),result.getInt(3),result.getFloat(4));
	    }     
	    return s;
	    
	}
	public List<Item> getItemsCostingGreaterThan(double p) throws ClassNotFoundException, SQLException {
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
	    
	    List<Item> l = new ArrayList<Item>();
	    Item s = null;
	    while(result != null && result.next()) {             
//	    	System.out.printf("%-30d   %-30s   %-30d   %-30f \r\n",
//	    			result.getInt(1),result.getString(2),result.getInt(3),result.getFloat(4));
	    	s = new Item(result.getInt(1),result.getString(2),result.getInt(3),result.getFloat(4));
	    	l.add(s);
	    }
		return l;    
	}
	public List<Item> getItemsInStock() throws ClassNotFoundException, SQLException {
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
	    
	    List<Item> l = new ArrayList<Item>();
	    Item s = null;
	    while(result != null && result.next()) {            
//	    	System.out.printf("%-30d   %-30s   %-30d   %-30f \r\n",
//	    			result.getInt(1),result.getString(2),result.getInt(3),result.getFloat(4)); 
	    	s = new Item(result.getInt(1),result.getString(2),result.getInt(3),result.getFloat(4));
	    	l.add(s);
	    }
		return l;    
	}
}
