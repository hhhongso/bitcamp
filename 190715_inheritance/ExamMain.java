/* 5문제를 채점하는 프로그램, 4지선다형. 
*/
import java.util.Scanner;

class Exam{
	public static final String correct = "11111"; //진짜답
	private String name; 
	private String answer; // 문제푼거 
	private char ox[];
	private int score;
	private int count; 
	
	public Exam(){	
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
class ExamMain {
	public static void main(String[] args) {
		Exam ex = new Exam();	
		String getOXstr = "";
		ex.compareOX();
		
		
//		for(int i = 0; i < ex.getOX().length; i++) {
//			getOXstr += ex.getOX()[i] + "";
//		}
		
		for (int i = 0; i < ex.getOX().length; i++) {
			getOXstr += ex.getOX()[i];
		}
		
		System.out.println("이름 \t 채점결과 \t 점수");
		System.out.println(ex.getName() + "\t" + getOXstr + "\t" + ex.getScore());
		}
	
		
	}