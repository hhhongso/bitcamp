package kr.co.bit;

import java.util.Scanner;

public class SchoolMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			ManSchool ms = new ManSchool(90, 80, 70, 100); // �ʱ�ȭ �� ������ ���� �ְ�, �̿� ���� �ʱ�ȭ&���Է� �ѹ��� ���� �Է� ����
			WomanSchool ws = new WomanSchool(90, 80, 88, 100);
			ManGongSchool mgs = new ManGongSchool(50, 60, 70, 80, 90);
			WomanSang wss = new WomanSang(60, 70, 80, 90, 100);
			
			System.out.println("1. �������б� 2. �������б� 3. ���ڰ��� 4. ���ڻ��");
			
			int protocol = scan.nextInt();
			
			if(protocol == 1) {
				System.out.println("����");
				System.out.println("����:" + ms.getKor() + "	����: " +ms.getEng() + "	����: " + ms.getMath() + "	���: " + ms.getTech()
				+ "	����: " + ms.total() + "	���: " + ms.getAvg());
			} else if (protocol == 2) {
				System.out.println("����");
				System.out.print("����:" + ws.getKor() + "	����: " +ws.getEng() + "	����: " + ws.getMath() + "	����: " + ws.getHome()
				+ "	����: " + ws.total() + "	���: " + ws.getAvg() + "\n");
			} else if (protocol == 3) {
				System.out.println("����");
				System.out.print("����:" + mgs.getKor() + "	����: " +mgs.getEng() + "	����: " + mgs.getMath() + "	���: " + mgs.getTech() + "	����: " + mgs.getGong()
				+ "	����: " + mgs.total() + "	���: " + mgs.getAvg() + "\n");
			} else if (protocol == 4) {
				System.out.println("����");
				System.out.print("����:" + wss.getKor() + "	����: " +wss.getEng() + "	����: " + wss.getMath() + "	����: " + wss.getHome() + "	���: " + wss.getSang()
				+ "	����: " + wss.total() + "	���: " + wss.getAvg() + "\n");
			}
		} // while��

	}

}
