package kr.co.bit.obj2;
// �迭���� 

public class Array_Test1 {

	public static void main(String[] args) {
		//�迭 ����
		int arrayNumber[];
		String names[];
		
		//�迭 ��ü ����: new ������
		arrayNumber = new int[3]; 
		names = new String[3];
		
		//�ʱ�ȭ 
		arrayNumber[0] = 1; 
		arrayNumber[1] = 2; 
		arrayNumber[2] = 3; 
		
		names[0] = "ȫ�浿";
		names[1] = "����ġ";
		names[2] = "��ö��";
		
		//�� ���
		for(int i = 0; i < 3; i++) { // �� length �� ���ϰ� 3�̶�� ���� �Է� ? 
			System.out.println("arrayNumber[" + i + "]= " +arrayNumber[i]);
			System.out.println("names[" + i + "]= " +names[i]);
		}

	}

}
