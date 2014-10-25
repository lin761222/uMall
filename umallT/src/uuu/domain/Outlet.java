package uuu.domain;

public class Outlet extends Product {
	private int discount=40;
	public int getDiscount(){
		return discount;
	}
	
//	public void setDiscount(int discount){
//		this.discount=discount;
//	}
	
	
	public Outlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Outlet(int id, String name, int unitPrice, boolean free, int stock) {
		super(id, name, unitPrice, free, stock);
		// TODO Auto-generated constructor stub
	}

	public Outlet(int id, String name, int unitPrice) {
		super(id, name, unitPrice);
		// TODO Auto-generated constructor stub
	}

	public int getUnitPrice(){
		return super.getUnitPrice() * (100-discount)/100;
	}
	
}
