package uuu.test;

import uuu.domain.Customer;
import uuu.domain.UMallException;

public class TestCustomerBirthData{
	public static void main(String args[]) throws UMallException{
		Customer c = new Customer();
		c.setBirthDate(2010,12,22);
		System.out.println(c.getBirthDate());
		c.setBirthDate("2014/7/16");
		System.out.println(c.getBirthDate());
	}
}