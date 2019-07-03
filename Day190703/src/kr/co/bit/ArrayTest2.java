package kr.co.bit;

import java.util.ArrayList;

public class ArrayTest2 {

	public static void main(String[] args) {
		ArrayList<String> array = new ArrayList<String>();
		array.add("한");
		array.add("중");
		array.add("일");	
		for(int i = 0; i < array.size(); i++) {
			System.out.print(array.get(i));
		}
		
		System.out.println();
		
		array.remove(0);
		array.remove("중"); // 인덱스 번호로 지우거나, 문자열로 직접 지우거나
		for(int i = 0; i < array.size(); i++) {
		System.out.println(array.get(i));
		}
	}

}
