package kr.co.bit;
//삼각형 만들기
public class For_test6_triangle {

	public static void main(String[] args) {
		int num = 0; 
		for (int i = 1; i<=5; i++) {
			for(int j = 1; j<=i; j++) {
				// 혹은 num++; 하고 sysout num+\t
				System.out.print(++num + "\t");
			}
			System.out.println();
		}
		
		num = 0; 
		for(int i = 1; i<=5; i++) {
			for (int j = 1; j <= (6-i); j++) { // 6-i 를 사용하여 5까지 찍게 하기 위하여 
				num++;
				System.out.print(num + "\t");
			}
			System.out.println();	
		}
		

	}

}
