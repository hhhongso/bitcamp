/* 5문제를 채점하는 프로그램, 4지선다형. 
*/
import java.util.Scanner;

class Exam{
	public static final String correct = "11111"; //진짜답
	private String name; 
	private String answer; // 문제푼거 
	private char ox[]; // 선언과 동시에 배열방 생성해도 무관. 단, 
	//ox = new char[5]; 와 같이 필드 부분에서 선언 후 생성은 불가 ! 
	private int score;
	private int count; 
	
	public Exam(){	
		ox = new char[5]; // 배열 초기화 => 배열방 생성
		Scanner scan = new Scanner(System.in);
		System.out.print("이름: ");
		name = scan.next();
		System.out.print("정답 입력: ");
		answer = scan.next();
	}
	
	public void compareOX() {
		for (int i = 0; i < ox.length; i++) {	//문자열로 길이를 돌린다면 함수로 처리 correct.length();
			if(correct.charAt(i) == answer.charAt(i)) {		// cf) .indexOf("C"): C가 위치한 인덱스 번호 가져오기. 해당 문자가 없으면 -1
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
		return ox;		// 배열 주소를 리턴함 ==> 각 배열의 값을 받을 수 있도록 for문
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
		
		for (int i = 0; i < ex.getOX().length; i++) { //배열 길이만큼 돌리면서 i번째 배열의 값을 가져오기.
			getOXstr += ex.getOX()[i];
		}
		
		System.out.println("이름 \t 채점결과 \t 점수");
		System.out.println(ex.getName() + "\t" + getOXstr + "\t" + ex.getScore());
		}

		/*상기 프린트하는 문장을 3개로 쪼개서, getOX를 str으로 뽑지 않고 하나씩 print() 해도 ok.
		for (int i = 0; i < ex.getOX().length; i++) { //배열 길이만큼 돌리면서 i번째 배열의 값을 가져오기.
			System.out.print(ex.getOX()[i]);
		}
		*/
		
	}