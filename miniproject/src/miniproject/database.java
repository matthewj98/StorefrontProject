package miniproject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.mindrot.jbcrypt.BCrypt;



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

	public void signup(String fa, String la, String ad, int zc, String ua, String pa,int phone) throws SQLException
//	public void signup() throws SQLException
	{

		this.stmt = conn.createStatement();
		this.rs = null;
		String password = BCrypt.hashpw(pa, BCrypt.gensalt());
		String q = "INSERT into useraccount(fname,lname,address,zipcode,username,password,phone)VALUES(\""
				+ fa + "\",\"" + la + "\",\"" + ad + "\",\"" + zc + "\",\"" + ua + "\",\"" + password + "\"," + phone + ");";

		stmt.executeUpdate(q);

		// rs = stmt.executeQuery("INSERT into user VALUES(1,?,?,?,?,?,?,?)");

	}

	public boolean login(String username, String password) throws SQLException
//public void signup() throws SQLException
	{

		this.stmt = conn.createStatement();
		this.rs = null;
		this.stmt = conn.createStatement();
		this.rs = stmt.executeQuery("SELECT * FROM useraccount where username=\"" + username + "\";");

		if (rs.next()) {
			if (BCrypt.checkpw(password, rs.getString("Password"))){
				return true;
			}
//			if (rs.getString("Password").equals(password)) {
//				rs.close();
//				return true;
//
//			}
			else
			{
				rs.close();
				return false;
			}
			
		}
		rs.close();
		return false;

	}
	public boolean buy(String id,int qty) throws SQLException
	//public void signup() throws SQLException
		{

			this.stmt = conn.createStatement();
			this.rs = null;
			this.stmt = conn.createStatement();
			this.rs = stmt.executeQuery("SELECT * FROM products where productName=\"" + id + "\";");
			int qty1;
			String upt;
			if (rs.next()) {

				if (rs.getInt("quantity")<0 || rs.getInt("quantity")<qty) {
					rs.close();
					return false;

				}
				else 
				{
					rs.close();
					return true;
				}
			}
			rs.close();
			return true;

		}
	public int prize(String id) throws SQLException
	{
		this.stmt = conn.createStatement();
		this.rs = null;
		this.stmt = conn.createStatement();
		this.rs = stmt.executeQuery("SELECT * FROM products where productName=\"" + id + "\";");
		int qty1;
		String upt;
		if (rs.next()) {
			
			

			return (Integer)rs.getInt("prize");
		}
		rs.close();
		return -1;
	}
	
	public int bill(String id,int qty) throws SQLException
	//public void signup() throws SQLException
		{

			this.stmt = conn.createStatement();
			this.rs = null;
			this.stmt = conn.createStatement();
			this.rs = stmt.executeQuery("SELECT * FROM products where productName=\"" + id + "\";");
			int qty1;
			String upt;
			if (rs.next()) {

				
					int priz=rs.getInt("prize");
					qty1=rs.getInt("quantity")-qty;
					upt= "UPDATE products	SET quantity = \"" + qty1 +"\" WHERE productName = \"" +id+"\" ";
					stmt.executeUpdate(upt);
					
					
					
					rs.close();
					return priz;
				
			}
			rs.close();
			return -1;
		}

		public void updateitem(String id, int qty) throws SQLException
		// public void signup() throws SQLException
		{
			String upt;
			int qty1;
			this.stmt = conn.createStatement();
			this.rs = null;
			this.stmt = conn.createStatement();
			this.rs = stmt.executeQuery("SELECT * FROM products where  productName=\"" + id + "\";");
			
			if(rs.next())
			{
			qty1 = rs.getInt("quantity")+ qty;
			

			}
			else
			{
				qty1=qty;
				

			}
			rs.close();
			upt = "UPDATE products SET quantity = \"" + qty1 + "\" WHERE productName = \"" + id + "\" ";
			stmt.executeUpdate(upt);
			
			
		}

		
		

	}
