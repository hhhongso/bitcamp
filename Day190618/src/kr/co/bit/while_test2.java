package kr.co.bit;

public class while_test2 {

	public static void main(String[] args) {
		int i = 1; 
		int sum = 0; 
		
		while (true) {
			//sum += i; 
			i++; 
			if(i == 5) break; //무한 루프의 제어 
		}
		System.out.println(i);

	}

}
