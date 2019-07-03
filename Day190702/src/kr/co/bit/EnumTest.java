package kr.co.bit;

class Student {
	SchoolType stype; 
	
	public Student(SchoolType stype) {
		this.stype = stype;
	}
}
//������(������) Ŭ���� : ���� ������ ������� ���� 
enum SchoolType { // enum�� ���� ���ڷ� �Ǵ�, ���ڿ������� ���ڷ� ���ȴ�. �� public static int ELE = 1 / MID = 2/ HIGH = 3 / UNIV = 4�� ������ ���
	ELE, MID, HIGH, UNIV
}


public class EnumTest {
	public static void main(String[] args) {
		Student student = new Student(SchoolType.ELE);
		
		System.out.println("����� ����� ���");
		System.out.println(student.stype);
		
		if(student.stype == SchoolType.ELE) {
			System.out.println("�ʵ��л�");
		}
		
		/* �����߻� 
		 * if(student.stype == 1) {
			System.out.println("�ʵ��л�");
		}
		*/
	}

}
