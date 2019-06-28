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

	@Override // override 주석을 달아주어야 개발자가 알아볼 수 있다. 
	public void sleep() {
		super.sleep();
		System.out.println("직장인은 보통 7시간을 잔다. ");
	}
	
	@Override // 함수이름, 매개변수 모두 같아야 한다. 
	public void showSleepStyle() {
		System.out.println("직장인은 수면시간이 부족하다. ");
	}
}
