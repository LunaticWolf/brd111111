package main_classes;

import java.io.BufferedReader;
import java.io.FileReader;
//import java.util.HashSet;
import java.util.Scanner;

import daoOperation.InsertDao;
import daoOperation.InsertToDb;
import entityPojo_customer.Customer;
//import validation.Rejection;
//import validation.ValidateMethods;

public class Input {
	Customer customer = new Customer();

	void input() {
		int count = 1;
		// int affectedRows=0;

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the type of database ypu want to work with\n" + "Oracle\n" + "MySql\n" + "Sqlserver");
		String server = sc.next();
		System.out.println("Enter the file with file location");
		String location = sc.next();
		System.out.println("Enter the file name");
		String fileName = sc.next();
		System.out.println("Enter the file extention");
		String fileExtention = sc.next();

		while (!(fileExtention.equals("txt"))) {
			System.out.println("Enter valid file extention");
			fileExtention = sc.next();
		}

		System.out.println("Enter rejection level");
		String rejection = sc.next();

		// ValidateMethods vm=new ValidateMethods();
		String str;
		try {
			FileReader fr = new FileReader(location + ":/" + fileName + "." + fileExtention);
			BufferedReader br = new BufferedReader(fr);
			InsertDao dao = new InsertToDb();

			while ((str = br.readLine()) != null) {
				String st[] = new String[20];
				st = str.split("~");
				try {
					customer.setCustomer_id(count);
					count = count + 1;
					customer.setCustomer_code(st[0]);
					customer.setCustomer_name(st[1]);
					customer.setCustomer_address1(st[2]);
					customer.setCustomer_address2(st[3]);
					customer.setCustomer_pinCode(Integer.parseInt(st[4]));
					customer.setEmail_address(st[5]);
					customer.setContact_number(st[6]);
					customer.setPrimaryConatctPerson(st[7]);
					customer.setRecord_status(st[8]);
					customer.setActive_inactiveFlag(st[9]);
					customer.setCreate_date(st[10]);
					customer.setCreated_by(st[11]);
					customer.setModified_date(st[12]);
					customer.setModified_by(st[13]);
					customer.setAuthorized_date(st[14]);
					customer.setAuthorized_by(st[15]);
				}

				catch (ArrayIndexOutOfBoundsException e) {
					/* e.printStackTrace(); */
				}

				finally {

					dao.conditionCheck(server, str, rejection, customer);
				}

			}

		} catch (Exception e) {
			System.out.println("File not found");
		}

		sc.close();
	}
}
