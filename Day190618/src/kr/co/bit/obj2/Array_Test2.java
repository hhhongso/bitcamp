package kr.co.bit.obj2;

public class Array_Test2 {

	public static void main(String[] args) {
		int num = 3; 
		int[] array1 = new int[3];
		
		for(int i = 0; i < array1.length; i++) { // 배열은 반복 횟수가 정해져 있음 => for문. 
			array1[i] = num++; // array1[0] = 3을 넣고, num++ = 4; 
			
		}
		for(int i = 0; i < array1.length; i++) {
			System.out.println("array1[" + i + "]= " + array1[i]);
		}
		System.out.println(num);
	
	}
}
