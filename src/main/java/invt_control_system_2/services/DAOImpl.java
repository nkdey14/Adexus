package invt_control_system_2.services;

import java.sql.*;

public class DAOImpl implements DAO {
	
	private Connection con;
	private Statement stmt;
	
	@Override
	public void connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Inv_db", "root", "nitin");
			
			stmt = con.createStatement();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean verifyUser(String email, String password) {
		try {
			ResultSet res = stmt.executeQuery("select * from Inv_Login where Email = '"+email+"' and Password = '"+password+"'");
			
			return res.next();
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
		return false;
	}

	@Override
	public void registerUser(String email, String password) {
		try {
			stmt.executeUpdate("insert into Inv_Login values('"+email+"', '"+password+"')");
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
	}

	@Override
	public void saveItemDetails(int id, String name, int stock, int price) {
		try {
			stmt.executeUpdate("insert into Inv_Registration values('"+id+"', '"+name+"', '"+stock+"', '"+price+"')");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public ResultSet getItemsList() {
		try {
			ResultSet res = stmt.executeQuery("select * from Inv_Registration");
			
			return res;
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
		return null;
	}

	@Override
	public void deleteItem(int id) {
		try {
			stmt.executeUpdate("delete from Inv_Registration where Id = '"+id+"'");
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
	}

	@Override
	public void updateItem(int id, int stock, int price) {
		try {
			stmt.executeUpdate("update Inv_Registration set Stock = '"+stock+"', Price = '"+price+"' where Id = '"+id+"'");
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
	}

	@Override
	public ResultSet findItemByName(String name) {
		try {
			ResultSet res = stmt.executeQuery("select * from Inv_Registration where Name = '"+name+"'");
			
			return res;
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
		return null;
	}

	@Override
	public ResultSet findItemByPrice(int low_price, int high_price) {
		try {
			ResultSet res = stmt.executeQuery("select * from Inv_Registration where Price between '"+low_price+"' and '"+high_price+"'");
			
			return res;
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
		return null;
	}

	@Override
	public ResultSet sortItemsInAsc() {
		try {
			ResultSet res = stmt.executeQuery("select * from Inv_Registration order by Price asc");
			
			return res;
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
		return null;
	}

	@Override
	public ResultSet sortItemsInDesc() {
		try {
			ResultSet res = stmt.executeQuery("select * from Inv_Registration order by Price desc");
			
			return res;
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
		return null;
	}	
}
