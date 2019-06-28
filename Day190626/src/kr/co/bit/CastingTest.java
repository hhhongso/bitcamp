package kr.co.bit;

public class CastingTest {

	public static void main(String[] args) {
		President president1 = new President(); // >> �ν��Ͻ� �����Ͽ� �޸� ������ president Ŭ������ ������ >> ����, �Լ�, ������, extends Person ���� ���� �� ���ƿ´�.  		
		Person person1 = president1; // ���
		president1 = (President) person1;  //Ȯ��
		president1.setNation("�ѱ�");
		System.out.println(president1.getNation());
		
		
		person1.setAddress("�����"); // �θ�Ŭ������ �����ۿ� ����� �� ����. [��ü�� ������ - ��ü�� ���]	
		/*
		 * persident1 ��ü�� Person Ŭ������ ���۷��� ����(��ü) �� ���� ��Ŵ 
			 				�� �ڵ����� Person Ÿ������ Upcasting �Ǹ鼭 ������
			 ��, (Person) president1 ��� �ڵ����� �����Ϸ� �Ǵ� �� 
		  	==> ��ü�� Upcasting���� ���� �Ǹ鼭 ������ �ִ� ����, �Լ�, Ÿ�� ��� ������ �θ�Ŭ���� Ÿ�������� ����ȯ�� �̷������. [���]
		  	
		  	Ŭ������ Ŭ������ ����� [Ȯ��] �ϴ� ���, 
		  	��ü��    ��ü��    Upcasting�� [���]�� ��� 
		 */
		
		President president2 = (President) person1;
		/*
		 * ��ü�� ��ü�� ���� ����� �Ұ���. 
		 * �θ�ü�� �ڽİ�ü�� ������ �ϸ� ���� �߻�, (President) �� ����������ν� ĳ������ ������ 
		 * ==> �ǵ������� �θ�Ÿ�Կ��� �ڽ�Ÿ������ ��ü ��ӽ�Ŵ. [��ü�� ������ - ��ü�� Ȯ��]	
		 */
		president2.setNation("���ѹα�"); //�������� president2 �� �����Ͽ� �����´�. 
		System.out.println(president2.getNation());
		
		Person person2 = new Person();
		President president3 = (President) person2;
		/*
		 * �� �̰� �ȵǴ��� ? 
		 * new person()�� �ν��Ͻ� �������� �θ� Ŭ������ �޸� ������ �������ȱ� ������, ������������ �θ��� ������ �Լ��� ��� ����Ű�� �־�  extends�� �о������ ���� ==> ��ü�� ��ü ���� Downcasting ���� �Ұ��� 
		 * UPcasting ����ȯ�� �ϴ���, �θ� Ŭ������ �ν��Ͻ��� �������� �ʴ´ٸ�, stack���� �޸� ������ ����Ű�� >? ===> 						����    
		 * ==> �޸� -> ���������� ����Ű�� �Ͽ�����, �ڽ��� ������ �� �� ���� ���� 
		 */
		president3.setNation("������");
		System.out.println(president3.getNation());
	}

}
