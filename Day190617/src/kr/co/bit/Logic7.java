package kr.co.bit;
//��ø if��
public class Logic7 {

	public static void main(String[] args) {
		int kor = Integer.parseInt(args[0]);
		int math = Integer.parseInt(args[1]);
		int eng = Integer.parseInt(args[2]);
		
		int total = 0; 
		total = kor + math + eng; 
		
		if (total >= 180) {
			if (kor < 40 || math < 40 || eng < 40) {
				System.out.println("����, ���հ�");
			} else {
				System.out.println("�հ��Դϴ� !");
			}
		} else {
			System.out.println("���� ����, ���հ�");
		}

	}

}
