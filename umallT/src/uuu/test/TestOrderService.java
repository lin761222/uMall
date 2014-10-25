package uuu.test;

import uuu.domain.Customer;
import uuu.domain.Outlet;
import uuu.domain.Product;
import uuu.domain.VIP;
import uuu.model.OrderService;

public class TestOrderService {

	public static void main(String[] args) {
		Customer c1 = new Customer("A123456789","Alex","Taiper");
		Product p1 = new Product(1,"iPhone 5s",20000);
		OrderService os = new OrderService();
		System.out.println("--- 一般客戶買普通產品 ---");
		System.out.println(os.order(c1, p1, 1));
		Outlet p2 = new Outlet(2,"iPhone 4s",20000);
		System.out.println("--- 一般客戶買Outlet ---");
		System.out.println(os.order(c1, p2, 1));
		Customer c2 = new VIP("A123456789","Jeff","Taiper");
		System.out.println("--- VIP買Outlet ---");
		System.out.println(os.order(c2, p2, 1));
		System.out.println("---VIP買普通產品 ---");
		System.out.println(os.order(c2, p1, 1));
		
	}

}
