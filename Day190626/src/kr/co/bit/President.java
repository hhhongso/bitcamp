package kr.co.bit;
			//상속 = 부모가 자식에게 내려주는 방식 (DownCasting) : 클래스와 클래스 사이에는 무조건 다운캐스팅 
public class President extends Person {

	protected int salary; 
	protected String nation; 
	
	public President() {
		this(0, null);
	}
	
	public President(int salary, String nation) {
		this.salary = salary; 
		this.nation = nation;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	@Override
	public void showSleepStyle() {
		System.out.println("대통령은 항상 수면시간이 부족하다. ");
	}
}
