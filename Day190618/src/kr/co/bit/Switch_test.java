package kr.co.bit;
// 간단한 계산기를 출력하기
public class Switch_test {

	public static void main(String[] args) {
		String operator = "!";
		switch(operator) {
		case "+":
			System.out.println(5+5);
			break;
		case "-":
			System.out.println(5-5);
			break;
		case "x": case "*": // caseA: caseB: (연달아 두개의 case쓰기 = if의 ||와 같다)
			System.out.println(5*5);
			break;
		case "/":
			System.out.println(5/5);
			break;
		case "%":
			System.out.println(5%5);
			break;
		default: System.out.println("연산자가 없습니다. ");
		}

	}

}
