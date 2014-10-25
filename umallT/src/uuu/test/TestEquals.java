package uuu.test;

import uuu.domain.Outlet;
import uuu.domain.Product;

public class TestEquals {

	public static void main(String[] args) {

			Product s1 = new Product(1,"HTC M7",20000);
			Product s2 = new Product(1,"HTC M7",20000);
			Product s3 = new Outlet(1,"HTC M7",20000);
			Product s4 = new Outlet(1,"HTC M7",20000);
			System.out.println(s1==s2); //false
			System.out.println(s1.equals(s2)); //true
			System.out.println(s1.equals(s3)); //false
			System.out.println(s4.equals(s3)); //true
			
	}

}
