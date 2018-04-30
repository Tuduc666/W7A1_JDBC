package UserPackage;

import java.sql.SQLException;

public class MainEntry {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		UserDAO uDAO = new UserDAO();
		uDAO.getAllUsers();
		uDAO.getUsersByEmail("nancy@yahoo.com");
		System.out.println(uDAO.validateUser("tam@yahoo.com", "tx"));
		uDAO.updateUser("nancy@yahoo.com", "NewNancy", "a11");

	}
	

}
