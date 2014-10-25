package uuu.test;

import uuu.domain.Outlet;
import uuu.domain.UMallException;
import uuu.domain.VIP;

public class TestExtends {

	public static void main(String[] args){

		VIP vip = new VIP();
		try {
			vip.setId("A12345678");
		} catch (Exception e) {
			System.out.println(e);
		}
		String id = vip.getId();
		System.out.println(id);
		vip.setDiscount(10);
		System.out.println(vip.getDiscount());
		
		Outlet o = new Outlet();
		o.setId(1);
		o.setName("HTC M8");
		o.setUnitPrice(22000);
		System.out.println(o.getUnitPrice());
		
	}
}
