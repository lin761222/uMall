package uuu.domain;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class ShoppingCart {
	private Map<Product, Integer> cart;

	public ShoppingCart() {
		try {
			cart = new TreeMap<>();
		} catch (Exception e) {
			throw e;
		}

	}

	public Map<Product, Integer> getCart() {
		return Collections.unmodifiableMap(cart);
	}

	public void add(Product p) {
//		Integer q = cart.get(p);
//		if(q!=null){
//			cart.put(p, q+1);
//		}else{
//			cart.put(p,1);
//		}
		this.add(p, 1);
	}

	public void add(Product p, int quantity) {
		Integer q = cart.get(p);
		if(q!=null){
			cart.put(p, q+quantity);
		}else{
			cart.put(p,quantity);
		}
	}

	public void update(Product p, int quantity) {
		cart.put(p, quantity);
	}

	public void remove(Product p) {
		cart.remove(p);
	}

	public void clear(Product p) {
		cart.clear();
	}

	@Override
	public String toString() {
		return cart.toString();
	}
	
}
