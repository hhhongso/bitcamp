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
			char cor = correct.charAt(i);
			char ans = answer.charAt(i);
			
			if(cor == ans) {
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
		String[] getOXstr = {};
		Exam2[] ex = new Exam2[pNum];
		
		for (int i = 0; i < ex.length; i++) {
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
	}
}