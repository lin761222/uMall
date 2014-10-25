package uuu.test;

import uuu.domain.Customer;

public class TestFinalCustomer {

	public static void main(String[] args) {
		final Customer c =new Customer("A123456789","張三","台北市");
		c.setName("張三豐");
		System.out.println(c.getName());
	}

}
