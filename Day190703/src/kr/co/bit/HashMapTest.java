package kr.co.bit;

import java.util.HashMap;

public class HashMapTest {

	public static void main(String[] args) {			//key	value
		HashMap<String, String> hashTest = new HashMap<String, String>();
		hashTest.put("ID", "bitcamp"); // hashMap ��� �ÿ��� put �Լ�
		hashTest.put("PW", "bitcamp"); 
		hashTest.put("ID", "another"); // key�� �ߺ��� �� ���� -> ���� �ٲ�� ���� 
		System.out.println(hashTest.get("ID"));
		System.out.println(hashTest.get("PW"));
		
	}

}
