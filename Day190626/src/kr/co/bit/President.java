package kr.co.bit;
			//��� = �θ� �ڽĿ��� �����ִ� ��� (DownCasting) : Ŭ������ Ŭ���� ���̿��� ������ �ٿ�ĳ���� 
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
		System.out.println("������� �׻� ����ð��� �����ϴ�. ");
	}
}
