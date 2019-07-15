package kr.co.bit;
/* 5문제를 채점하는 프로그램, 4지선다형. 
 * 
 * ==> 객체 배열로 이용 [발전]: 인원수 입력, 이름 입력, 압안지 입력 ==> 최종 출력 
*/


//맞았다?틀렷따? 비교하기 comp();
//getter

//1문제 당 20점

//입력값: 12311
//결과: 이름		채점결과		점수
//	김김김		oxxoo		60





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
		System.out.println("이름: ");
		name = scan.next();
		System.out.println("정답 입력: ");
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
		
		for (int i = 0; i < ex.getOX().length; i++) {
			getOXstr += ex.getOX()[i];
		}
		
		System.out.println("이름 \t 채점결과 \t 점수");
		System.out.println(ex.getName() + "\t" + getOXstr + "\t" + ex.getScore());
		}
	
		
	}
