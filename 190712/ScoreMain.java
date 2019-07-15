//field
//입력: setData(이름, 국어, 영어, 수학)
//계산: calc();
//출력: getName(), getKor(), getEng(), getMath(), getTotal(), getAvg();

class Score {
	private String name; 
	private int kor;
	private int eng;
	private int math;
	private int total;
	private double avg;
	
	public Score(){}

	public void setData(String name, int kor, int eng, int math){ //구현
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
		avg = total / 3.0; // (double)total/3; 으로 캐스팅도 가능. 
	}

	public int getTotal(){	
		return total;
	}
	
	public double getAvg(){		//%.2f
		return avg;
	}

	@Override // @Annotation : override 가 아니라면 컴파일 시 에러띄움 
	public String toString(){
		return name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + total + "\t" + String.format("%.2f", avg);
	}

}

/*
String.format();
%d 정수		%f 실수		%c 문자		%s 문자열
*/

// ---------------------------------------------------------------------
class ScoreMain {
	public static void main(String[] args) {
		Score[] arr = new Score[3]; //객체가 들어갈 배열을 생성

		for(int i = 0; i < arr.length; i ++){
			arr[i] = new Score(); // 배열방에 객체 생성			
		}

		arr[0].setData("길동", 95, 100, 82);
		arr[1].setData("코난", 90, 87, 76);
		arr[2].setData("또치", 75, 93, 84);
		System.out.println("이름 \t 국어 \t 영어 \t 수학 \t 총점 \t 평균");
	
		for(Score data : arr){ // arr 배열의 데이터 값(=Score 클래스의 값)을 하나씩 넘겨준다. 
			data.calc();
			System.out.println(data);
		}
	}
}
		
	
	
	/*	Score score = new Score(); //new(): >> 클래스 생성 + 생성자 함수 호출
		Score score2 = new Score();
		Score score3 = new Score();

		score.setData("길동", 95, 100, 82); //호출
		score2.setData("코난", 90, 87, 76);
		score3.setData("또치", 75, 93, 84);

		score.calc();
		score2.calc();
		score3.calc();

		System.out.println("이름 \t 국어 \t 영어 \t 수학 \t 총점 \t 평균");
		System.out.println(score); // .toString() 생략되어 있으니까 
		System.out.println(score2);
		System.out.println(score3);
		*/

//	System.out.println(score.getName() + "\t" + score.getKor() + "\t" + score.getEng() + "\t" + score.getMath() + "\t" 
//						+ score.getTotal() + "\t" + String.format("%.2f",score.getAvg()));
	