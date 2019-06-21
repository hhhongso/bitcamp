package kr.co.bit.obj1;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMap_ArrayList_prac {
	public static void main(String[] args) {
	ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
	/* ArrayList의 선언
	 * ArrayList에 HashMap 타입을 넣어줄 계획이며, 
	 * HashMap은 key(String값), value(String값)
	 */
	
	HashMap<String, String> hashMap = new HashMap<String, String> ();
	hashMap.put("1", "김철수");
	hashMap.put("2", "이영이");
	hashMap.put("3", "박상재"); // key, valuse로 String의 값을 넣어주고
	list.add(hashMap); // 이를 ArrayList 클래스의 list 변수에 더함 
	
	hashMap = new HashMap<String, String>();
	
		
	}
 	
	
	
}

