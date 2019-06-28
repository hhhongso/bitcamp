package kr.co.bit;

import java.util.Scanner;

public class SchoolMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			ManSchool ms = new ManSchool(90, 80, 70, 100); // 초기화 후 대입할 수도 있고, 이와 같이 초기화&수입력 한번에 직접 입력 가능
			WomanSchool ws = new WomanSchool(90, 80, 88, 100);
			ManGongSchool mgs = new ManGongSchool(50, 60, 70, 80, 90);
			WomanSang wss = new WomanSang(60, 70, 80, 90, 100);
			
			System.out.println("1. 남자중학교 2. 여자중학교 3. 남자공고 4. 여자상고");
			
			int protocol = scan.nextInt();
			
			if(protocol == 1) {
				System.out.println("남중");
				System.out.println("국어:" + ms.getKor() + "	영어: " +ms.getEng() + "	수학: " + ms.getMath() + "	기술: " + ms.getTech()
				+ "	총합: " + ms.total() + "	평균: " + ms.getAvg());
			} else if (protocol == 2) {
				System.out.println("여중");
				System.out.print("국어:" + ws.getKor() + "	영어: " +ws.getEng() + "	수학: " + ws.getMath() + "	가정: " + ws.getHome()
				+ "	총합: " + ws.total() + "	평균: " + ws.getAvg() + "\n");
			} else if (protocol == 3) {
				System.out.println("남공");
				System.out.print("국어:" + mgs.getKor() + "	영어: " +mgs.getEng() + "	수학: " + mgs.getMath() + "	기술: " + mgs.getTech() + "	공업: " + mgs.getGong()
				+ "	총합: " + mgs.total() + "	평균: " + mgs.getAvg() + "\n");
			} else if (protocol == 4) {
				System.out.println("여상");
				System.out.print("국어:" + wss.getKor() + "	영어: " +wss.getEng() + "	수학: " + wss.getMath() + "	가정: " + wss.getHome() + "	상업: " + wss.getSang()
				+ "	총합: " + wss.total() + "	평균: " + wss.getAvg() + "\n");
			}
		} // while문

	}

}
