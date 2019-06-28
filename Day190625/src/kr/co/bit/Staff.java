package kr.co.bit;

public class Staff {
	protected String name; 
	protected String dept; 
	protected int salary; 

	public Staff() {
		this("no", "no", 0);
	}
	
	public Staff(String name, String dept, int salary) {
		this.name = name;
		this.dept = dept;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Staff [이름=" + name + ", 부서=" + dept + ", 급여=" + salary + "]";	}
	
	
}
