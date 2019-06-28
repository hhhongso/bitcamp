package kr.co.bit;

public class ManGongSchool extends ManSchool {

	protected int gong;
	
	@Override
	public double getAvg() {
		// TODO Auto-generated method stub
		return this.total() / 5.0;
	}

	@Override
	public int total() {
		return super.total() + gong;
	}

	public ManGongSchool() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ManGongSchool(int kor, int eng, int math, int tech, int gong) {
		super(kor, eng, math, tech);
		this.gong = gong;
	} 

	public int getGong() {
		return gong;
	}

	public void setGong(int gong) {
		this.gong = gong;
	}

	
	@Override
	public String toString() {
		return super.toString() + "ManGongSchool [gong=" + gong + "]" + "	รัวี= " + total();
	}
	
	public static void main(String[] args) {
		ManGongSchool manGong = new ManGongSchool();
		manGong.setKor(100);
		manGong.setEng(70);
		manGong.setMath(80);
		manGong.setTech(40);
		manGong.setGong(65);
		System.out.println(manGong.toString());
		
	}
	
}
