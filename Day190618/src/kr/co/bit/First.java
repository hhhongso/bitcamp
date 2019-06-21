package kr.co.bit;
//switch (인자값: 변수 or 표현식) -- 조건에 맞는 case를 '선택'한다. 
//case 인자값A: 
//break;

//
public class First {
	public static void main(String[] args) {
		String job = args[0]; //문자열을 입력 -> 외부값을 읽어 들여옴
		int salary = 0; //초기값 설정 
		switch (job) { //중괄호 하나에 모든 케이스를 다룬다.
		case "사원":
			salary = 20000000;
			break; //구조문을 빠져 나간다. 
		case "대리":
			salary = 35000000;
			break; // break 가 없으면 그 아래 케이스 값까지 돌리게 됨 
		case "과장":
			salary = 50000000; 
			break;
		case "부장":
			salary = 80000000;
			break;
		default: // else 의 역할과 같다 
			System.out.println("사원, 대리, 과장, 부장 중 다시 입력해주세요. ");
		}
		System.out.println("당신의 연봉은 " + salary  + "원 입니다. ");


	}

}
