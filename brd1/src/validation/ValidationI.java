package validation;

import java.util.HashSet;

import entityPojo_customer.Customer;

public interface ValidationI {

	public boolean validCustomerCode(Customer customer, HashSet<String> set);

	public boolean validCustomerName(Customer customer);

	public boolean validPinCode(Customer customer);

	public boolean validEmail(Customer customer);

	public boolean validRecordStatus(Customer customer);

	public boolean validFlag(Customer customer);

}
