//field
//�Է�: setData(�̸�, ����, ����, ����)
//���: calc();
//���: getName(), getKor(), getEng(), getMath(), getTotal(), getAvg();

class Score {
	private String name; 
	private int kor;
	private int eng;
	private int math;
	private int total;
	private double avg;
	
	public Score(){}

	public void setData(String name, int kor, int eng, int math){ //����
		this.name = name; 
		this.kor = kor; 
		this.eng = eng; 
		this.math = math; 
	}

	public String getName(){
		return name;
	}

	public int getKor(){
		return kor;
	}

	public int getEng(){
		return eng;
	}

	public int getMath(){
		return math;
	}

	public void calc(){
		total = kor + eng + math;
		avg = total / 3.0; // (double)total/3; ���� ĳ���õ� ����. 
	}

	public int getTotal(){	
		return total;
	}
	
	public double getAvg(){		//%.2f
		return avg;
	}

	@Override // @Annotation : override �� �ƴ϶�� ������ �� ������� 
	public String toString(){
		return name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + total + "\t" + String.format("%.2f", avg);
	}

}

/*
String.format();
%d ����		%f �Ǽ�		%c ����		%s ���ڿ�
*/

// ---------------------------------------------------------------------
class ScoreMain {
	public static void main(String[] args) {
		Score[] arr = new Score[3]; //��ü�� �� �迭�� ����

		for(int i = 0; i < arr.length; i ++){
			arr[i] = new Score(); // �迭�濡 ��ü ����			
		}

		arr[0].setData("�浿", 95, 100, 82);
		arr[1].setData("�ڳ�", 90, 87, 76);
		arr[2].setData("��ġ", 75, 93, 84);
		System.out.println("�̸� \t ���� \t ���� \t ���� \t ���� \t ���");
	
		for(Score data : arr){ // arr �迭�� ������ ��(=Score Ŭ������ ��)�� �ϳ��� �Ѱ��ش�. 
			data.calc();
			System.out.println(data);
		}
	}
}
		
	
	
	/*	Score score = new Score(); //new(): >> Ŭ���� ���� + ������ �Լ� ȣ��
		Score score2 = new Score();
		Score score3 = new Score();

		score.setData("�浿", 95, 100, 82); //ȣ��
		score2.setData("�ڳ�", 90, 87, 76);
		score3.setData("��ġ", 75, 93, 84);

		score.calc();
		score2.calc();
		score3.calc();

		System.out.println("�̸� \t ���� \t ���� \t ���� \t ���� \t ���");
		System.out.println(score); // .toString() �����Ǿ� �����ϱ� 
		System.out.println(score2);
		System.out.println(score3);
		*/

//	System.out.println(score.getName() + "\t" + score.getKor() + "\t" + score.getEng() + "\t" + score.getMath() + "\t" 
//						+ score.getTotal() + "\t" + String.format("%.2f",score.getAvg()));
	