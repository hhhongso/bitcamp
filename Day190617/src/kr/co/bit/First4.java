package kr.co.bit;

public class First4 {
public static void main(String[] args) {
	int logic1 = 5;
	int logic2 = 8; 
	String str = (logic1 > 0 && logic2 < 9)? "0부터 9사이의 범위다.":"0부터 9사이의 범위가 아니다."; 
	//삼항연산자: (조건) ? (True일 시 출력값) : (False일 시 출력값) ;
	System.out.println(str);
	
}
}
