package kr.co.bit;

public class ManSchool extends School {

	protected int tech;
	
	@Override
	public double getAvg() {
		return this.total() / 4.0;
	}			//�ڱ��ڽ��� �Լ� total()�� �����´�. 

	// source > override implement
	@Override
	public int total() {
		total = super.total() + tech; // total = ����Լ��� kor+eng+math + tech 
		return total;
	}

	public ManSchool() {
		super(); // ��ӹ޴� �Լ��� �������Լ� ȣ�� 
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
		return super.toString() + "ManSchool [tech=" + tech + "]" + "����= " + total();
	}
}
