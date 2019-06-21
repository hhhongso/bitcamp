package kr.co.bit;
//중첩 if문
public class Logic7 {

	public static void main(String[] args) {
		int kor = Integer.parseInt(args[0]);
		int math = Integer.parseInt(args[1]);
		int eng = Integer.parseInt(args[2]);
		
		int total = 0; 
		total = kor + math + eng; 
		
		if (total >= 180) {
			if (kor < 40 || math < 40 || eng < 40) {
				System.out.println("과락, 불합격");
			} else {
				System.out.println("합격입니다 !");
			}
		} else {
			System.out.println("총점 부족, 불합격");
		}

	}

}
