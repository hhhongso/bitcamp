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

	public WomanSang(int kor, int eng, int math, int home, int sang) { // 생성자함수는 상속이 불가하기 때문에 파라미터 변수 값을 직접 입력해 주어야 한다
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
		return super.toString() + "WomanSang [sang=" + sang + "]" + "	총합= " + total();
	} // return super. 로 상속받은 toString 함수 재사용
	
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
