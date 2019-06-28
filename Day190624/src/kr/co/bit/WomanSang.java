package kr.co.bit;

public class WomanSang extends WomanSchool {

	protected int sang; 

	@Override
	public double getAvg() {
		return this.total() / 5.0;
	}

	@Override
	public int total() {
		return super.total() + sang;
	}

	public WomanSang() {
		super();
	}

	public WomanSang(int kor, int eng, int math, int home, int sang) { // �������Լ��� ����� �Ұ��ϱ� ������ �Ķ���� ���� ���� ���� �Է��� �־�� �Ѵ�
		super(kor, eng, math, home);
		this.sang = sang;
	}

	public int getSang() {
		return sang;
	}

	public void setSang(int sang) {
		this.sang = sang;
	}

	@Override
	public String toString() {
		return super.toString() + "WomanSang [sang=" + sang + "]" + "	����= " + total();
	} // return super. �� ��ӹ��� toString �Լ� ����
	
	public static void main(String[] args) {
		WomanSang womanSang = new WomanSang();
		womanSang.setKor(90);
		womanSang.setEng(75);
		womanSang.setMath(55);
		womanSang.setHome(88);
		womanSang.setSang(98);
		System.out.println(womanSang.toString());
	}
}
