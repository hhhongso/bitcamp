package kr.co.bit;

import java.util.HashMap;

public class HashMapTest {

	public static void main(String[] args) {			//key	value
		HashMap<String, String> hashTest = new HashMap<String, String>();
		hashTest.put("ID", "bitcamp"); // hashMap 등록 시에는 put 함수
		hashTest.put("PW", "bitcamp"); 
		hashTest.put("ID", "another"); // key는 중복될 수 없다 -> 값이 바뀌기 때문 
		System.out.println(hashTest.get("ID"));
		System.out.println(hashTest.get("PW"));
		
	}

}
