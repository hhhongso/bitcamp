package kr.co.bit;

public class While_test4 {
public static void main(String[] args) {
	int number = 0; 
	char alphabet = 'A';
	
	aaa:while(true) { // aaa: 라벨. 
		while(true) {
			number++; 
			System.out.print(alphabet++ + "");
			if(number % 5 == 0)  // 한 줄에 다섯개 
				break;
			if (number == 26) 
				break aaa; //break(false) -> 멈추고 aaa로 이동 -> while(false) 가 되니 종료. 코드블록 넘어감  
			
		}
		System.out.println("");
	}
}
}
