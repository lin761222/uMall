package uuu.model;

import uuu.domain.Customer;

public class HelloService {
	
	
	//輸入空白
	public String sayHello(){
		String rtn = "勿輸入空白";
		return rtn;
	}
	//傳入一個名稱
	public String sayHello(String name){
		String rtn = "Hello";
		if(name!=null && name.length()>0){
			rtn += ", "+ name;
		}
		return rtn;
	}
	//已經登入
	public String sayHello(Customer c){
		String rtn;
		if(c!=null){
			rtn = sayHello(c.getName());
		}else
			rtn = sayHello();
		return rtn;
	}
}
