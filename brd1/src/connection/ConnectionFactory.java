package connection;

public class ConnectionFactory
{
	public static ConnectionI factoryIntial(String name)
	{
		if(name.equalsIgnoreCase("oracle"))
		{
			return new OracleConnection();
		}
		else if(name.equalsIgnoreCase("mysql"))
		{
			return new MySQL();
		}
		else if(name.equalsIgnoreCase("sqlserver"))
		{
			return new SqlServer();
		}
		else {
			System.out.println("Wrong choice.. ");
			return  null;
	}
	}
}
