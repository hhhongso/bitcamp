package kr.co.bit;

public class Employee extends Person {
	protected String dept; 
	int x; 
	
	public Employee() {
		this(null, 0);
	}
	
	public Employee(String dept, int x) {
		this.dept = dept;
		this.x = x;
	}
	
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [dept=" + dept + "]";
	}

	@Override // override �ּ��� �޾��־�� �����ڰ� �˾ƺ� �� �ִ�. 
	public void sleep() {
		super.sleep();
		System.out.println("�������� ���� 7�ð��� �ܴ�. ");
	}
	
	@Override // �Լ��̸�, �Ű����� ��� ���ƾ� �Ѵ�. 
	public void showSleepStyle() {
		System.out.println("�������� ����ð��� �����ϴ�. ");
	}
}
