package uuu.domain;

/**
 * enum範例 
 *
 */
public enum BloodType {
	//public static final
	O(10),A(20),B(30),AB(40); //10,20,30,40
	
	final private int code;
	
	private BloodType(int code) {
		this.code = code;
	}
	public int getCode() {
		return code;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name()+" 型";
	}
}
