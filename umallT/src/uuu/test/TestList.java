package uuu.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class TestList {

	public static void main(String[] args) {
		List list = new ArrayList(); 
		list.add(1);
		list.add(2.5);
		list.add("3");
		list.add("6");
		list.add(0,'4');
		
		System.out.println(list);
		System.out.println(list.size());
		list.remove('4');
		
		list.add("3");
		System.out.println(list);
		
		double sum=0;
		for(Object o:list){
			
		}
	}

}
