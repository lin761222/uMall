package uuu.domain;

public class VIP extends Customer {
	private int discount=30;
	public VIP() {
	}
	public VIP(String id,String name,String address){
		super(id,name,address);
	}
	public VIP(String id,String name,String address,int discount){
		super(id,name,address);
		this.discount = discount;
	}
	
	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	} 
		
}
