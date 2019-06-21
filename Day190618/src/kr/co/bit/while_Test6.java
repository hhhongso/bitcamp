package kr.co.bit;
// 횟수가 정해진 반복문을 while을 이용하여 사용할 수도 있으나, 
// 개발자가 시작값, 증감식, 끝값을 모두 코드에서 설정하여 주어야 하는 번거로움이 있다.  
public class while_Test6 {

	public static void main(String[] args) {
		int i = 1;
		int j = 1; 
		while(i <= 9) {
			while(j <= 9) {
				System.out.print(i + "X" + j + "=" + i*j +"\t");
				j++;
			}
			System.out.println();
			i++; 
			j = 1; 
		}

	}

}
