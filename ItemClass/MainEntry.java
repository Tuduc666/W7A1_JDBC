package ItemClass;

import java.sql.SQLException;

public class MainEntry {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		ItemDAO uDAO = new ItemDAO();
		uDAO.getAllItems();
		
		Item s = uDAO.getItemById(2);     // get item where id = 2
		System.out.println(s.getName() + " " + s.getQty() + " " + s.getPrice());
		
		System.out.println("List of items cost more than7 dollars");
		for (Item i : uDAO.getItemsCostingGreaterThan(7D)) {  // List of items cost more than7 dollars
			System.out.println(i.getName() + " " + i.getQty() + " " + i.getPrice());
		}
		
		System.out.println("List of items in stock");
		for (Item i : uDAO.getItemsInStock()) {                 // List of items in stock
			System.out.println(i.getName() + " " + i.getQty() + " " + i.getPrice());
		}
	}
}
