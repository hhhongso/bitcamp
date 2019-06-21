package kr.co.bit;

public class Logic5 {

	public static void main(String[] args) {
		String id = args[0]; // 0번째 배열
		String pw = args[1];
		
		if(!id.equals("java")) { //.equals: 문자열의 내용이 같은가 ?
			System.out.println("당신은 회원이 아닙니다. ");
		} else if (!pw.equals("java")) { // !~ equals: ~가 같지 않다  => true이면 코드블록 실행
			System.out.println("비밀번호가 일치하지 않습니다.");
		} else {
			System.out.println("환영합니다 !");
		}

	}

}
