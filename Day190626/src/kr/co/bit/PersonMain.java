package kr.co.bit;

public class PersonMain {

	public static void main(String[] args) {

		Person person1 = new Student();
		Person person2 = new President();
		Person person3 = new Employee();
						//�ڽ� ��ü�� �θ� ��ü �� �� �� ���� 

		Person person4 = new Person();  
		//Student student1 = person4; 
			// �ڽ� ��ü�� �θ� ��ü�� ���� ���� �Ұ����ϴ�. 
			// ��, ��ü�� ��ü������, DownCasting�� �Ұ����ϴ�. 
		
		Student student2 = (Student)person4; // (�ڽ�Ŭ����)�� �ٿ� ĳ������ ������ �� �ִ�. 
		
		
	}

}
