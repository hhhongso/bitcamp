package kr.co.bit;
//switch (���ڰ�: ���� or ǥ����) -- ���ǿ� �´� case�� '����'�Ѵ�. 
//case ���ڰ�A: 
//break;

//
public class First {
	public static void main(String[] args) {
		String job = args[0]; //���ڿ��� �Է� -> �ܺΰ��� �о� �鿩��
		int salary = 0; //�ʱⰪ ���� 
		switch (job) { //�߰�ȣ �ϳ��� ��� ���̽��� �ٷ��.
		case "���":
			salary = 20000000;
			break; //�������� ���� ������. 
		case "�븮":
			salary = 35000000;
			break; // break �� ������ �� �Ʒ� ���̽� ������ ������ �� 
		case "����":
			salary = 50000000; 
			break;
		case "����":
			salary = 80000000;
			break;
		default: // else �� ���Ұ� ���� 
			System.out.println("���, �븮, ����, ���� �� �ٽ� �Է����ּ���. ");
		}
		System.out.println("����� ������ " + salary  + "�� �Դϴ�. ");


	}

}
