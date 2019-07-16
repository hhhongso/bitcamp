
import java.util.Scanner;

class Exam2 {
	public static final String correct = "11111"; //진짜답
	private String name; 
	private String answer; // 문제푼거 
	private char ox[];
	private int score;
	private int count; 
	
	public Exam2(){	
		ox = new char[5];
		Scanner scan = new Scanner(System.in);
		System.out.print("이름: ");
		name = scan.next();
		System.out.print("정답 입력: ");
		answer = scan.next();
	}
	
	public void compareOX() {
		for (int i = 0; i < ox.length; i++) {			
			if(correct.charAt(i) == answer.charAt(i)) {
				ox[i] = 'o';
				score+= 20;
			} else {
				ox[i] = 'x';
			}
		}
	}
	
	public String getName() { //name, ox, score
		return name;
	}
	
	public char[] getOX() { 
		return ox;
	}
	
	public int getScore() {
		return score;
	}

}
//--------------------------------------------------------------
class ExamMain2 {
	public static void main(String[] args) {		
		Scanner scan = new Scanner(System.in);
		System.out.print("인원수 입력: ");
		int pNum = scan.nextInt();
		Exam2[] ex = new Exam2[pNum];


/*
		String[] getOXstr = new String[pNum]; //getOXstr도 pNum만큼 생성될 거니까 배열 생성	
		
		for (int i = 0; i < ex.length; i++) {
			getOXstr[i] = ""; //배열방의 디폴트 null을 공백으로 초기화 
			ex[i] = new Exam2();
			ex[i].compareOX();
			for(int j = 0; j < ex[i].getOX().length; j++) {
				getOXstr[i] += ex[i].getOX()[j];
			}
		}		
		
		System.out.println("이름 \t 채점결과 \t 점수");
		for (int i = 0; i < ex.length; i++) {
			System.out.println(ex[i].getName() + "\t" + getOXstr[i] + "\t" + ex[i].getScore());			
		}
*/


		for(int i = 0; i < pNum; i++){
			ex[i] = new Exam2();
			ex[i].compareOX();
		}

		System.out.println("이름 \t Q1 \t Q2 \t Q3 \t Q4 \t Q5 \t 점수");
		for(int i = 0; i < pNum; i++){
			System.out.print(ex[i].getName() + "\t");
			for(int j = 0; j < ex[i].getOX().length; j++){
				System.out.print(ex[i].getOX()[j] + "\t");
			}
			System.out.println(ex[i].getScore());
		}




	}
}
