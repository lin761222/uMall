package uuu.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestCollection {

	public static void main(String[] args) {
		Collection collection = new ArrayList(); 
		collection.add(1);
		collection.add(2.5);
		collection.add("3");
		collection.add("6");
		((List)collection).add(0,'4');
		
		System.out.println(collection);
		System.out.println(collection.size());
		collection.remove('4');
		System.out.println(collection);
	}

}
