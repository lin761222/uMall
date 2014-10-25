package uuu.test;

import uuu.domain.Customer;
import uuu.domain.VIP;

public class TestPolymorphism {

	public static void main(String[] args) {
		Object o = "Hello";
		System.out.println("--String--");
		System.out.println(o.toString()+"\n"); //Hello
		
		Customer c1 = new Customer("A123456789","jeff","Taipei");
		o=new Object();
		System.out.println("--object.tostring--");
		System.out.println(o.toString()+"\n");
		o = c1;
		System.out.println("--Customer.toString()--");
		System.out.println(c1.toString()+"\n");
		System.out.println("--Customer.getName()--");
		System.out.println(c1.getName()+"\n");
		System.out.println("--VIP.getName()--");
		c1 = new VIP("A123456788","Mary","Tainan");
		System.out.println(c1.getName());
		//System.out.println(c1.getDiscount);  //Error
	}

}
