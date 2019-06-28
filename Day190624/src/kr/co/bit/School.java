package kr.co.bit;

public class School {

	protected int kor; 
	protected int eng; 
	protected int math;
	protected int total;
	protected double avg; //평균은 소수점까지 나타내자.  
	
	public School(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public School() {
		this(0, 0, 0); // this. 대신 this() 으로 생성자함수 재사용하여 초기화
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
	
	public int total() { //총합 함수 ===> 상속받는 클래스에서 super.total()으로 값을 return 받아야 함
		total = kor + eng + math;
		return total;
	}
	
	public double getAvg() {
		avg = total / 3.0; // double 형이니까 3.0으로 표기한다. 
		return avg;
	}

	@Override
	public String toString() {
		return "School [kor=" + kor + ", eng=" + eng + ", math=" + math + "]";
	}
}
