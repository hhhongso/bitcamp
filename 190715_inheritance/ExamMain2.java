
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
		System.out.print("�ο��� �Է�: ");
		int pNum = scan.nextInt();
		Exam2[] ex = new Exam2[pNum];


/*
		String[] getOXstr = new String[pNum]; //getOXstr�� pNum��ŭ ������ �Ŵϱ� �迭 ����	
		
		for (int i = 0; i < ex.length; i++) {
			getOXstr[i] = ""; //�迭���� ����Ʈ null�� �������� �ʱ�ȭ 
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
*/


		for(int i = 0; i < pNum; i++){
			ex[i] = new Exam2();
			ex[i].compareOX();
		}

		System.out.println("�̸� \t Q1 \t Q2 \t Q3 \t Q4 \t Q5 \t ����");
		for(int i = 0; i < pNum; i++){
			System.out.print(ex[i].getName() + "\t");
			for(int j = 0; j < ex[i].getOX().length; j++){
				System.out.print(ex[i].getOX()[j] + "\t");
			}
			System.out.println(ex[i].getScore());
		}




	}
}
