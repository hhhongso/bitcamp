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
		System.out.print("번호 입력: ");
		num = scan.nextInt();
		System.out.print("이름 입력: ");
		name = scan.next();
		System.out.print("국어 성적 입력: ");
		kor = scan.nextInt();
		System.out.print("영어 성적 입력: ");
		eng = scan.nextInt();
		System.out.print("수학 성적 입력: ");
		math = scan.nextInt();
		System.out.println("성적 입력이 완료되었습니다. ");
		
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
