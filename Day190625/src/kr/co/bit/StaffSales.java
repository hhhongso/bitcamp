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
	 * 오버라이드 = "부모에도 자식에도 같은 함수가 있다" 
	 */
	// source > override/implement method > 재사용 (==> super. 까지 자동완성)
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "수당= " + commission;
	}

	public static void main(String[] args) {
		StaffSales sales = new StaffSales("김김김", "개발부", 10000, 2000);
		String str = sales.toString();
		System.out.println(str);
	}
}
