import java.util.Scanner;

class Exam2 {
	public static final String correct = "11111"; //��¥��
	private String name; 
	private String answer; // ����Ǭ�� 
	private char ox[];
	private int score;
	private int count; 
	
	public Exam2(){	
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
class ExamMain2 {
	public static void main(String[] args) {		
		Scanner scan = new Scanner(System.in);
		System.out.print("�ο��� �Է�: ");
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
		
		System.out.println("�̸� \t ä����� \t ����");
		for (int i = 0; i < ex.length; i++) {
			System.out.println(ex[i].getName() + "\t" + getOXstr[i] + "\t" + ex[i].getScore());			
		}
	}
}