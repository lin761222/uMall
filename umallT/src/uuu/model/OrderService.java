package uuu.model;

import uuu.domain.Customer;
import uuu.domain.Outlet;
import uuu.domain.Product;
import uuu.domain.VIP;

public class OrderService {
	public double order(Customer c, Product p, int quanity) {
		double rtn = p.getUnitPrice() * quanity;
		if (c instanceof VIP) {
			if (p instanceof Outlet) {
				rtn *= 0.9;
			} else {
				VIP v = (VIP) c;
				rtn *= (100 - v.getDiscount()) / 100D;
			}
		}
		return rtn;
	}
}
