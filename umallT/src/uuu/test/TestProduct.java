package uuu.test;

import uuu.domain.Product;
public class TestProduct {
	public static void main(String arg[]){
		Product p = new Product();
		System.out.println(p.toString());
		System.out.println("-----------");
		p.setId(1);
		p.setName("iPhone 5s");
		p.setUnitPrice(20001);
		System.out.println(p);
		
	}
}
