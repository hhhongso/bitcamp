package kr.co.bit;

public class WomanSchool extends School {

	protected int home;
	

	@Override
	public double getAvg() {
		return this.total() / 4.0;
	}

	@Override
	public int total() {
		return super.total() + home ;
	}

	public WomanSchool(int kor, int eng, int math, int home) {
		super(kor, eng, math);
		this.home = home;
	}

	public WomanSchool() {
		super();
		// TODO Auto-generated constructor stub
	} 
	public int getHome() {
		return home;
	}

	public void setHome(int home) {
		this.home = home;
	}


	@Override
	public String toString() {
		return super.toString() + "WomanSchool [home=" + home + "]" + "รัวี=" + total();
	}
}
