/* 5������ ä���ϴ� ���α׷�, 4��������. 
*/
import java.util.Scanner;

class Exam{
	public static final String correct = "11111"; //��¥��
	private String name; 
	private String answer; // ����Ǭ�� 
	private char ox[]; // ����� ���ÿ� �迭�� �����ص� ����. ��, 
	//ox = new char[5]; �� ���� �ʵ� �κп��� ���� �� ������ �Ұ� ! 
	private int score;
	private int count; 
	
	public Exam(){	
		ox = new char[5]; // �迭 �ʱ�ȭ => �迭�� ����
		Scanner scan = new Scanner(System.in);
		System.out.print("�̸�: ");
		name = scan.next();
		System.out.print("���� �Է�: ");
		answer = scan.next();
	}
	
	public void compareOX() {
		for (int i = 0; i < ox.length; i++) {	//���ڿ��� ���̸� �����ٸ� �Լ��� ó�� correct.length();
			if(correct.charAt(i) == answer.charAt(i)) {		// cf) .indexOf("C"): C�� ��ġ�� �ε��� ��ȣ ��������. �ش� ���ڰ� ������ -1
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
		return ox;		// �迭 �ּҸ� ������ ==> �� �迭�� ���� ���� �� �ֵ��� for��
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
		
		for (int i = 0; i < ex.getOX().length; i++) { //�迭 ���̸�ŭ �����鼭 i��° �迭�� ���� ��������.
			getOXstr += ex.getOX()[i];
		}
		
		System.out.println("�̸� \t ä����� \t ����");
		System.out.println(ex.getName() + "\t" + getOXstr + "\t" + ex.getScore());
		}

		/*��� ����Ʈ�ϴ� ������ 3���� �ɰ���, getOX�� str���� ���� �ʰ� �ϳ��� print() �ص� ok.
		for (int i = 0; i < ex.getOX().length; i++) { //�迭 ���̸�ŭ �����鼭 i��° �迭�� ���� ��������.
			System.out.print(ex.getOX()[i]);
		}
		*/
		
	}