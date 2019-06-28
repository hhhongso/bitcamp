package kr.co.bit;

public class ManSchool extends School {

	protected int tech;
	
	@Override
	public double getAvg() {
		return this.total() / 4.0;
	}			//자기자신의 함수 total()을 가져온다. 

	// source > override implement
	@Override
	public int total() {
		total = super.total() + tech; // total = 상속함수의 kor+eng+math + tech 
		return total;
	}

	public ManSchool() {
		super(); // 상속받는 함수의 생성자함수 호출 
	}
	
	public ManSchool(int kor, int eng, int math, int tech) {
		super(kor, eng, math); // 
		this.tech = tech;
	}

	public int getTech() {
		return tech;
	}

	public void setTech(int tech) {
		this.tech = tech;
	}


	@Override
	public String toString() {
		return super.toString() + "ManSchool [tech=" + tech + "]" + "총합= " + total();
	}
}
