class ScoreDTO implements java.io.Serializable, Comparable<ScoreDTO> {
	private String idNum; 
	private String name;
	private int kor;
	private int eng;
	private int math; 
	private int total; 
	private double avg;

	public ScoreDTO(String idNum, String name, int kor, int eng, int math){
		this.idNum = idNum; 
		this.name = name; 
		this.kor = kor; 
		this.eng = eng; 
		this.math = math; 
	}

	public String getIdNum() { return idNum; }
	public String getName() { return name; }
	public int getKor() { return kor; }
	public int getEng() { return eng; }
	public int getMath() { return math; }
	public int getTotal() { return total; }
	public double getAge() { return avg; }
	
	public void calc(){
		total = kor + eng + math;
		avg = total / 3.0;
	}

	public int compareTo(ScoreDTO dto){
		if(this.total < dto.total) return 1;
		else if(this.total > dto.total) return -1; 
		else return 0;
	}

	@Override
	public String toString(){	//5자리 문자열 4자리 정수 ==> 자릿수 정렬 
		return String.format("%6s %6s %5d %5d %5d %5d %9.3f", idNum, name, kor, eng, math, total, avg);
	}													


}


/*
% s 문자열
% c 문자
% d 정수
% f 실수 
*/