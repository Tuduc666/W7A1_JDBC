package ItemPackage;

import java.sql.SQLException;

public class MainEntry {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		ItemDAO uDAO = new ItemDAO();
		uDAO.getAllItems();
		uDAO.getItemById(2);
		uDAO.getItemsCostingGreaterThan(7D);

	}
}
