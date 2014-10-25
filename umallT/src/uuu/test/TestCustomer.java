package uuu.test;

import uuu.domain.BloodType;
import uuu.domain.Customer;
import uuu.domain.UMallException;
import uuu.domain.VIP;

public class TestCustomer {

	public static void main(String[] args) {
		Customer customer = new Customer();
		VIP vip = new VIP();
		vip.setName("Alex");
		try {
			customer.setId("A123009141");
		} catch (UMallException e) {
			System.out.println(e);
		}
//		customer.setGender('M');
//		customer.setAddress("aa");
		try {
			customer.setBirthDate("2013/1/22");
		} catch (UMallException e) {
			System.out.println(e);
		}
		System.out.println(customer.getId());
		System.out.println(customer.getBirthDate());
//		System.out.println(customer.getGender());
//		System.out.println(vip);
//		
//		customer.setBloodtype(BloodType.A);
//		System.out.println(customer.getBloodtype());
		System.out.println("-------");
		/**
		 * 取enum的getCode()
		 */
//		
//		for(int i=0;i<BloodType.values().length;i++){
//			System.out.println(BloodType.values()[i].getCode());
//		}
//		customer.setBloodtype(BloodType.A);
//		BloodType t = customer.getBloodtype();
//		System.out.println(t.equals(BloodType.O));
//		System.out.println(t==BloodType.O);
//		
//		switch(t){
//			case A:
//				System.out.println("AAA");
//				break;
//			case B:
//				System.out.println("BBB");
//				break;
//			case O:
//				System.out.println("OOO");
//				break;
//			case AB:
//				System.out.println("ABABAB");
//				break;
//		}
		
	}

}
