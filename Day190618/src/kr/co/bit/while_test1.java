package kr.co.bit;
// 반복 횟수가 명확히 정해질 때: for
// 조건을 만족할 때 까지 계속 반복할 때: while 

public class while_test1 {

	public static void main(String[] args) {
		int sum = 0; 
		int i = 1; 
		
		while (i<=5) {
			sum += i;
			i++; 
		}
		System.out.println(sum);

	}

}
