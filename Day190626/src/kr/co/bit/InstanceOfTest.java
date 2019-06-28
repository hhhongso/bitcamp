package kr.co.bit;

public class InstanceOfTest {

	public static void main(String[] args) {
		President president1 = new President();
		Person person1 = president1; //��� (Upcasting): ����, �Լ� ���� ��� ����ȯ�Ǹ�, ��, president �� ���� �޸� ������ ������ �����Ѵ�. 
		
		if(person1 instanceof President) { // person1 ��ü��  PresidentŸ������ ����ȯ�� �������� ?
			President president2 = (President) person1;  // Ȯ��(Downcasting)
			System.out.println("person1�� President Ÿ������ ĳ���� ����");
		} else {
			System.out.println("ĳ���� �Ұ�");
		}
		
		Person person2 = new Person();
		
		if (person2 instanceof President) {
			President president3 = (President) person2;
			System.out.println("person2�� President Ÿ������ ĳ���� ����");
		} else {
			System.out.println("ĳ���� �Ұ�");
		}

	}

}
