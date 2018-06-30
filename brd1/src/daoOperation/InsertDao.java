package daoOperation;

import java.sql.Connection;
import java.util.HashSet;

import entityPojo_customer.Customer;

public interface InsertDao {
	public void conditionCheck(String server, String str, String rejection, Customer customer);

	public int inputbd(String server, Customer customer, Connection conn);

	public Connection connection();
	public HashSet<String> fetch_customer_code();
}
