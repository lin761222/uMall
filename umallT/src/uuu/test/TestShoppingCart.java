package uuu.test;

import uuu.domain.Product;
import uuu.domain.ShoppingCart;

public class TestShoppingCart {

	public static void main(String[] args) {
		ShoppingCart s = new ShoppingCart();
		Product p = new Product(3,"HTC M8",21000);
		Product p1 = new Product(2,"HTC M7",17000);
		Product p2 = new Product(4,"IPhone 5S",20000);
		Product p3 = new Product(1,"Ipad mini",12000);
		s.add(p);
		s.add(p3,2);
		s.add(p2);
		s.add(p2);
		s.add(p1,5);
		System.out.println(s);
		System.out.println("---刪除p3---");
		s.remove(p3);
		System.out.println(s);
		s.clear(p);
		System.out.println("---清空---");
		System.out.println(s);
		System.out.println("---Update");
		s.update(p3, 6);
		System.out.println(p);
	}

}
