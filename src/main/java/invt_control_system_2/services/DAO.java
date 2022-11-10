package invt_control_system_2.services;

import java.sql.ResultSet;

public interface DAO {

	public void connectDB();
	
	public boolean verifyUser(String email, String password);
	
	public void registerUser(String email, String password);
	
	public void saveItemDetails(int id, String name, int stock, int price);
	
	public ResultSet getItemsList();
	
	public void deleteItem(int id);
	
	public void updateItem(int id, int stock, int price);
	
	public ResultSet findItemByName(String name);
	
	public ResultSet findItemByPrice(int low_price, int high_price);
	
	public ResultSet sortItemsInAsc();
	
	public ResultSet sortItemsInDesc();
	
}
