package uuu.domain;

public class Product implements Comparable<Product>{
	private int id;
	private String name;
	private int unitPrice;
	private boolean free;
	private int stock;
	
	public Product() {
		
	}
	
	public Product(int id, String name, int unitPrice) {
		this.id = id;
		this.name = name;
		this.unitPrice = unitPrice;
	}

	public Product(int id, String name, int unitPrice, boolean free,
			int stock) {
		this(id,name,unitPrice);
		this.free = free;
		this.stock = stock;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public boolean isFree() {
		return free;
	}
	public void setFree(boolean free) {
		this.free = free;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String toString(){
		String rtn = "產品編號："+id +"\t產品名稱："+name+"\t產品價格："+unitPrice+"\n";
		return rtn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public int compareTo(Product o) {
		return this.id-o.id;
	}

	
}
