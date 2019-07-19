import java.util.Scanner;
import java.text.DecimalFormat;
		
class SungJukDTO implements Comparable<SungJukDTO> {
	private int num;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private double avg;

/*
	public setData(int num, String name, int kor, int eng, int math){
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	getter ~~~~~ 
*/

	public SungJukDTO(){
		Scanner scan = new Scanner(System.in);
		System.out.print("��ȣ �Է�: ");
		num = scan.nextInt();
		System.out.print("�̸� �Է�: ");
		name = scan.next();
		System.out.print("���� ���� �Է�: ");
		kor = scan.nextInt();
		System.out.print("���� ���� �Է�: ");
		eng = scan.nextInt();
		System.out.print("���� ���� �Է�: ");
		math = scan.nextInt();
		System.out.println("���� �Է��� �Ϸ�Ǿ����ϴ�. ");
		
	}

	public String getName(){
		return name;
	}


	public void calc(){
		total = kor + eng + math; 
		avg = total / 3.0;
	}

	
	@Override		
	public int compareTo(SungJukDTO s){
		if(this.total < s.total) return 1;
		else if(this.total > s.total) return -1; 
		else return 0;
	
	}


	@Override
	public String toString(){
		calc();
		return num + "\t" + name + "\t" + kor + "\t" + eng + "\t" + math + 
				"\t" + total + "\t" + new DecimalFormat("#.###").format(avg) + "\n";
	}

	
}
