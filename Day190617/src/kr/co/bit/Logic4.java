package kr.co.bit;

public class Logic4 {

	public static void main(String[] args) {
		int age = Integer.parseInt(args[0]);
		String logic_result = ""; // ���ڿ� �ʱⰪ "" 
		
		if (age / 10 == 0) {
			logic_result = "10�� ����";
		} else if (age / 10 == 1) {
			logic_result = "10��";
		} else if (age / 10 == 2) {
			logic_result = "20��";
		} else if (age / 10 == 3) {
			logic_result = "30��";
		} else if (age / 10 == 4) {
			logic_result = "40��";
		} else if (age / 10 == 5) {
			logic_result = "50��";
		} else if (age / 10 == 6) {
			logic_result = "60��";
		} else {
			logic_result = "70�� �̻�";
		}
		System.out.println("�����" + logic_result + "�Դϴ�.");
	}

}
