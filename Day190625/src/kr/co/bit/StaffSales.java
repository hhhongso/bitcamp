package kr.co.bit;
/*
 * 
 */
public class StaffSales extends Staff {
	protected int commission;

	public StaffSales() {
		super();
	}
	
	public StaffSales(String name, String dept, int salary, int commission) {
		super(name, dept, salary);
		this.commission = commission;
	}
	
	@Override 
	/*
	 * �������̵� = "�θ𿡵� �ڽĿ��� ���� �Լ��� �ִ�" 
	 */
	// source > override/implement method > ���� (==> super. ���� �ڵ��ϼ�)
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "����= " + commission;
	}

	public static void main(String[] args) {
		StaffSales sales = new StaffSales("����", "���ߺ�", 10000, 2000);
		String str = sales.toString();
		System.out.println(str);
	}
}
