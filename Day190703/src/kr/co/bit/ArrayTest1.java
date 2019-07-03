package kr.co.bit;

import java.util.ArrayList;

public class ArrayTest1 {

	public static void main(String[] args) {
		ArrayList<String> array1 = new ArrayList<String>();		//ArrayList에 들어갈 수 있는 클래스 타입을 규정시켜주는 것: 제네릭 <>
		array1.add("X");
		
		ArrayList<Integer> array2 = new ArrayList<Integer>();
		array2.add(123);
		
		ArrayList<Double> array3 = new ArrayList<Double>();
		array3.add(3.14);
	}
 
}

		/*
		ArrayList array1 = new ArrayList(); // <> <<< 제네릭?
		array1.add("A"); //[0]번째 배열
		array1.add("B");
		array1.add("C");
		array1.add("D");
		array1.add("E");
		System.out.println(array1);
		
		//중간 어딘가에 있는 값을 삭제 시, 뒤의 값들이 한 칸씩 당겨오고, 마지막 칸에 비어있는 null배열방
		array1.remove(2);
		System.out.println(array1);
	
		//중간에 새로운 값을 넣을 경우, 뒤의 값들이 한 칸씩 밀려간다. 
		array1.add(2, "C");
		System.out.println(array1);
		
		array1.add(2, "F");
		System.out.println(array1);
		 */
