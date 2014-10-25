package uuu.test;

import java.util.Scanner;

import uuu.domain.Customer;
import uuu.model.HelloService;

public class TestHelloService{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		String s = "Alex測試";
		HelloService SH = new HelloService();
		SH.sayHello();
		SH.sayHello(s);
		
		Customer c = new Customer();
		c.setName(s);
		SH.sayHello(c);
		System.out.println("SH.sayHello(c)="+SH.sayHello(c));
		System.out.println("SH.sayHello(ALEX)="+SH.sayHello(s));
		System.out.println("SH.sayHello()"+SH.sayHello());
		
		
		
	}
}