/* 5������ ä���ϴ� ���α׷�, 4��������. 
*/
import java.util.Scanner;

class Exam{
	public static final String correct = "11111"; //��¥��
	private String name; 
	private String answer; // ����Ǭ�� 
	private char ox[];
	private int score;
	private int count; 
	
	public Exam(){	
		ox = new char[5];
		Scanner scan = new Scanner(System.in);
		System.out.print("�̸�: ");
		name = scan.next();
		System.out.print("���� �Է�: ");
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
		
		System.out.println("�̸� \t ä����� \t ����");
		System.out.println(ex.getName() + "\t" + getOXstr + "\t" + ex.getScore());
		}
	
		
	}