package daoOperation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;

import connection.ConnectionFactory;
import connection.ConnectionI;
import connection.OracleConnection;
import entityPojo_customer.Customer;

import validation.Rejection;

public class InsertToDb implements InsertDao {
	Customer customer;
	Connection conn = null;
	ConnectionI c = null;
	PreparedStatement ps = null;
	int rowsAffected = 0;

	public Connection connection() {
		c = new OracleConnection();
		conn = c.myConnection();
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	@Override
	public void conditionCheck(String server, String str, String rejection, Customer customer) {
		if (rejection.equalsIgnoreCase("r")) {
			Rejection r = new Rejection();

			r.recordLevel(server, str, customer);
		} else {

			Rejection r = new Rejection();
			r.fileLevel(server, str, customer);
		}
	}
	
	public HashSet<String> fetch_customer_code()
	{
		HashSet<String> hs=new HashSet<String>();
		
		try 
		{
			Connection conn=connection();
			Statement stmt=null;
			ResultSet rs=null;
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select customer_code from acustomer_master");
			
			while(rs.next())
			{
				String code=rs.getString(1);
				
				hs.add(code);
			}
		
	}
		catch(Exception e)
		{}
		return hs;
	}

	public int inputbd(String server, Customer customer, Connection conn) {
		try {

			ps = conn.prepareStatement("insert into acustomer_master values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			ps.setInt(1, customer.getCustomer_id());
			ps.setString(2, customer.getCustomer_code());
			ps.setString(3, customer.getCustomer_name());
			ps.setString(4, customer.getCustomer_address1());
			ps.setString(5, customer.getCustomer_address2());
			ps.setInt(6, customer.getCustomer_pinCode());
			ps.setString(7, customer.getEmail_address());
			ps.setString(8, customer.getContact_number());
			ps.setString(9, customer.getPrimaryConatctPerson());
			ps.setString(10, customer.getRecord_status());
			ps.setString(11, customer.getActive_inactiveFlag());
			ps.setString(12, customer.getCreate_date());
			ps.setString(13, customer.getCreated_by());
			ps.setString(14, customer.getModified_date());
			ps.setString(15, customer.getModified_by());
			ps.setString(16, customer.getAuthorized_date());
			ps.setString(17, customer.getAuthorized_by());

			rowsAffected = ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println("ERROR OCCURED");
		}

		return rowsAffected;
	}

}
