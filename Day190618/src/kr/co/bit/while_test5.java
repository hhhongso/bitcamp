package kr.co.bit;
//2~9단까지 모두 쓰기 
public class while_test5 {

	public static void main(String[] args) {
		for(int i = 2; i <= 9; i++) {
			for(int j = 1; j <= 9; j++) {
				System.out.print(i + "X" + j + "=" + i*j + "\t");
			}
			System.out.println();
		}

	}

}
