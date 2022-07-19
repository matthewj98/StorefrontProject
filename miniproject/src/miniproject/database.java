package miniproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class database {
	private Statement stmt;
	private ResultSet rs;
	private Connection conn;
	private boolean loggedIn = false;

	public database(String username, String password) {
		try {
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", username, password);
			this.loggedIn = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean getLoggedIn() {
		return this.loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public void signup(String fa, String la, String ad, String zc, String ua, String pa, int phone) throws SQLException
//	public void signup() throws SQLException
	{

		this.stmt = conn.createStatement();
		this.rs = null;

		String q = "INSERT into user(First_name,Last_name,address_1,zipcode,username,Passwd,phone_number)VALUES(\""
				+ fa + "\",\"" + la + "\",\"" + ad + "\",\"" + zc + "\",\"" + ua + "\",\"" + pa + "\"," + phone + ");";

		stmt.executeUpdate(q);

		// rs = stmt.executeQuery("INSERT into user VALUES(1,?,?,?,?,?,?,?)");

	}

	public boolean login(String username, String password) throws SQLException
//public void signup() throws SQLException
	{

		this.stmt = conn.createStatement();
		this.rs = null;
		this.stmt = conn.createStatement();
		this.rs = stmt.executeQuery("SELECT * FROM user where username=\"" + username + "\";");

		if (rs.next()) {
			if (rs.getString("Passwd").equals(password)) {
				
				return true;

			}
			else
			{
				return false;
			}
		}
		return false;

	}
	public boolean buy(int id,int qty) throws SQLException
	//public void signup() throws SQLException
		{

			this.stmt = conn.createStatement();
			this.rs = null;
			this.stmt = conn.createStatement();
			this.rs = stmt.executeQuery("SELECT * FROM product where product_id=\"" + id + "\";");
			int qty1;
			String upt;
			if (rs.next()) {

				if (rs.getInt("Quantity")<0 || rs.getInt("Quantity")<qty) {
					
					return false;

				}
				else 
				{
					
					qty1=rs.getInt("Quantity")-qty;
					upt= "UPDATE product	SET Quantity = \"" + qty1 +"\" WHERE product_id = \"" +id+"\" ";
					stmt.executeUpdate(upt);
				}
			}
			return true;

		}

		public void updateitem(int id, int qty) throws SQLException
		// public void signup() throws SQLException
		{
			String upt;
			int qty1;
			this.stmt = conn.createStatement();
			this.rs = null;
			this.stmt = conn.createStatement();
			this.rs = stmt.executeQuery("SELECT * FROM product where product_id=\"" + id + "\";");
			
			if(rs.next())
			{
			qty1 = rs.getInt("Quantity")+ qty;
			

			}
			else
			{
				qty1=qty;
				

			}
			upt = "UPDATE product SET Quantity = \"" + qty1 + "\" WHERE product_id = \"" + id + "\" ";
			stmt.executeUpdate(upt);
			
		}
		
		
				
				
		public void newitem(int id,String prodn ,String prodcat,int qty,int pri) throws SQLException
		// public void signup() throws SQLException
		{
			String upt;
			int qty1;
			this.stmt = conn.createStatement();
			this.rs = null;
			String q = "INSERT into product(product_id,Product_name,Product_category,Quantity,Prize)VALUES("
					+ id + ",\"" + prodn + "\",\"" + prodcat + "\"," + qty + "," + pri + ");";

			stmt.executeUpdate(q);

			
		}
	}
