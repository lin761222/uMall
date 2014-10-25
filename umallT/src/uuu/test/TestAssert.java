package uuu.test;

import uuu.domain.Customer;

public class TestAssert {

	public static void main(String[] args) {
		
		Customer.checkId("A123456789");
		System.out.println(Customer.checkId("A123456780"));
	}

}
