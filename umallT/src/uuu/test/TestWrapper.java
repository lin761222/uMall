package uuu.test;

public class TestWrapper {

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Double.parseDouble("12.34"));
		System.out.println(Integer.parseInt("1234"));
		System.out.println(String.valueOf(1234444444));
		
		int i = 1;
		Integer one = new Integer(i); //boxing
		Integer two = new Integer(2); //boxing
		
		Integer j = new Integer(one.intValue() + two.intValue()); //unboxing
		System.out.println(j.intValue()); //unboxing
		
		int k = 3;
		Integer three = k; //new Integer(k);
		//System.out.println(three);
		
		Integer another_three = three; //three.intValue();
		another_three = another_three+1; //new Integer(three.intValue()+1);
		System.out.println(three); //3
		System.out.println(another_three); //4
	}

}
