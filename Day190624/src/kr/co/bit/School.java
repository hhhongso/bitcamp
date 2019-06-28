package kr.co.bit;

public class School {

	protected int kor; 
	protected int eng; 
	protected int math;
	protected int total;
	protected double avg; //����� �Ҽ������� ��Ÿ����.  
	
	public School(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public School() {
		this(0, 0, 0); // this. ��� this() ���� �������Լ� �����Ͽ� �ʱ�ȭ
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}
	
	public int total() { //���� �Լ� ===> ��ӹ޴� Ŭ�������� super.total()���� ���� return �޾ƾ� ��
		total = kor + eng + math;
		return total;
	}
	
	public double getAvg() {
		avg = total / 3.0; // double ���̴ϱ� 3.0���� ǥ���Ѵ�. 
		return avg;
	}

	@Override
	public String toString() {
		return "School [kor=" + kor + ", eng=" + eng + ", math=" + math + "]";
	}
}
