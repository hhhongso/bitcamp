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
	public String toString(){	//5�ڸ� ���ڿ� 4�ڸ� ���� ==> �ڸ��� ���� 
		return String.format("%6s %6s %5d %5d %5d %5d %9.3f", idNum, name, kor, eng, math, total, avg);
	}													


}


/*
% s ���ڿ�
% c ����
% d ����
% f �Ǽ� 
*/