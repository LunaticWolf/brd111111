package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnection implements ConnectionI 
{

	@Override
	public Connection myConnection() {
		Connection conn = null;
		try 
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());	//load class
			conn=DriverManager.getConnection("jdbc:oracle:thin:@10.1.50.198:1521:orcl","sh","sh");
					
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
		
		return conn;
	}

	
	
}
