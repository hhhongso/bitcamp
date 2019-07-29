package W0729;

import java.text.DecimalFormat;

public class ScoreDTO {
	private String idNum; 
	private String name;
	private int kor;
	private int eng;
	private int math; 
	private int total; 
	private double avg;
	private DecimalFormat df = new DecimalFormat("###.####");

	public ScoreDTO(String idNum, String name, int kor, int eng, int math) {
		super();
		this.idNum = idNum;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public String getIdNum() {
		return idNum;
	}

	public String getName() {
		return name;
	}

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public int getMath() {
		return math;
	}
	
	public void calc() {
		total = kor + eng + math;
		avg = total / 3.0;
	}
	
	
	@Override
	public String toString() {
	//	return "[학번=" + idNum + ", 이름=" + name + ", 국어=" + kor + ", 영어=" + eng + ", 수학=" + math
	//			+ ", 총점=" + total + ", 평균=" + df.format(avg) + "]";	
		return String.format("%4s %4s %4d %4d %4d %4d %5.4f", idNum, name, kor, eng, math, total, avg);
	}
	
	
}
