package kr.co.bit;

public class While_test4 {
public static void main(String[] args) {
	int number = 0; 
	char alphabet = 'A';
	
	aaa:while(true) { // aaa: ��. 
		while(true) {
			number++; 
			System.out.print(alphabet++ + "");
			if(number % 5 == 0)  // �� �ٿ� �ټ��� 
				break;
			if (number == 26) 
				break aaa; //break(false) -> ���߰� aaa�� �̵� -> while(false) �� �Ǵ� ����. �ڵ��� �Ѿ  
			
		}
		System.out.println("");
	}
}
}
