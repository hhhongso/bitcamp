package kr.co.bit;
/*
 * equals override
 */
class Student4 {
	private String name; 
	private int number; 
	
	@Override
	public String toString() {
		return "Student4 [name=" + name + ", number=" + number + "]";
	}

	public Student4(String name, int number) {
		super();
		this.name = name;
		this.number = number;
	}

	@Override			//Ojbect obj = (object)st2 �� ĳ���õǾ� ���� [Upcasting]
	public boolean equals(Object obj) {
		Student4 st = null; 
		if (obj instanceof Student4) { // [instanceof] ���ɿ��� Ȯ��: obj���� student4Ŭ������ ����ȯ�� ��������? ==> t/F�� ��� 
			st = (Student4)obj; 
		}
		return st != null && st.name.equals(name) && st.number == number;
	}

}

public class EqualsTest2 {
	public static void main(String[] args) {
		Student4 st1 = new Student4("���л�", 1);
		Student4 st2 = new Student4("���л�", 1);
		System.out.println(st1 == st2);
		System.out.println(st1.equals(st2));
		
		System.out.println(st1.toString());
		System.out.println(st2); // Object��ü�� toString�Լ��� �����Ǿ� �ִ� ��.  >> override tostring���� >> 
	}
}

