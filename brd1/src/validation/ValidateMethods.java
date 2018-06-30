package validation;

import java.util.HashSet;
import java.util.regex.Pattern;

import entityPojo_customer.Customer;

public class ValidateMethods implements ValidationI {

	@Override
	public boolean validCustomerCode(Customer customer, HashSet<String> set) {
		if (customer.getCustomer_code().length() > 10) {
			return false;
		} else {
			if (customer.getCustomer_code().equals("")) {
				return false;
			}

			else if (set.contains(customer.getCustomer_code())) {
				return false;
			}
		}

		return true;

	}

	@Override
	public boolean validCustomerName(Customer customer) {
		if (customer.getCustomer_name().length() > 30) {
			return false;
		} else {
			char[] arr = new char[40];
			// int count=0;

			arr = customer.getCustomer_name().toCharArray();
			for (int i = 0; i < customer.getCustomer_name().length(); i++) {
				int k = (int) arr[i];
				if ((k > 47 && k < 58) || (k > 64 && k < 91) || (k > 96 && k < 123) || k == 32) {
					// count++;
				} else
					return false;
			}
		}
		return true;

	}

	@Override
	public boolean validPinCode(Customer customer) {
		int length = String.valueOf(customer.getCustomer_pinCode()).length();
		if (length == 6)
			return true;
		else
			return false;
	}

	@Override
	public boolean validEmail(Customer customer) {

		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";
		Pattern pat = Pattern.compile(emailRegex);
		if (customer.getEmail_address().equals(""))
			return false;
		else
			return pat.matcher(customer.getEmail_address()).matches();
	}

	@Override
	public boolean validRecordStatus(Customer customer) {
		if (customer.getRecord_status().equalsIgnoreCase("N") || customer.getRecord_status().equalsIgnoreCase("M")
				|| customer.getRecord_status().equalsIgnoreCase("D")
				|| customer.getRecord_status().equalsIgnoreCase("A")
				|| customer.getRecord_status().equalsIgnoreCase("R"))
			return true;
		else
			return false;
	}

	@Override
	public boolean validFlag(Customer customer) {
		if (customer.getActive_inactiveFlag().equalsIgnoreCase("a")
				|| customer.getRecord_status().equalsIgnoreCase("I"))
			return true;
		else
			return false;
	}

}
