package kr.co.bit.obj3;

public class AirConUser_Executer {

	public static void main(String[] args) {
		AirConUser airCon1 = new AirConUser(); //static�� ���� class 
		     // �ν��Ͻ�(��ü,object) = ����Ű�� ���
		// new �����ڸ� ����ؼ� �޸𸮻� airCon��ü�� �����Ѵ�. 
		
		/*
		 * AirCon airCon 			=				 new AirCon();
		 * Ŭ����(������=>Ŭ������					�������Լ� (������ -> �ش� �迭(����,�Լ�)�� ã�ư�)
		 * ����											��������
		 * => ������ ������ Ȯ��  	
		 */
		airCon1.company = "LG������"; // AirCon class�� �Լ��� static Ű���带 �������μ� execute ���� �ٷ� �ҷ��� �� �ֵ��� �Ѵ�. 
		airCon1.color = "������";
		airCon1.price = 50000;
		airCon1.size = 3; 
		airCon1.temp = 20;
		
		System.out.println("airCon1�� �µ��� " + airCon1.temp + ", airCon1�� ������" + airCon1.color +
				",airCon1�� ������ " + airCon1.price);
		

		
		// �ι�° ��ü ����
		AirConUser airCon2 = new AirConUser();
		
		// airCon2. company ~ temp �� ���� �������� �ʾ��� 
		// ==> �ʱⰪ�� �״�� �ҷ��´� 
		
		System.out.println("airCon2�� �µ��� " + airCon2.temp + ", airCon2�� ������" + airCon2.color +
				",airCon2�� ������ " + airCon2.price);
			
		
	}

}
