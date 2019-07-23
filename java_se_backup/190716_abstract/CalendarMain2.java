/* 만년달력 만들기 
년도 입력:nnnn ==> 생성자에서 입력
월 입력:m		 ==> 생성자에서 입력

일수 calc()
일수 출력 disp()

	[nnnn년 m월]
일	월	화	수	목	금	토
			1	2	3	4
...		
				...	31
*/
import java.util.Calendar;
import java.util.Scanner;


class CalendarMain2 {
	private int year; 
	private int month; 
	private int date; // 1~28 / 30 / 31
	private int lastDate;
	private int blankDay;
	private int dayWeek;

	public CalendarMain2(){ // 생성자
		Scanner scan = new Scanner(System.in);
		System.out.println("년도 입력: ");
		year = scan.nextInt();
		System.out.println("월 입력: ");
		month = scan.nextInt();
	} // 생성자	

//1. 요일 이랑 날짜 랑 매칭
//2. 토요일(7) 마다 줄바꿈

	public void calc(){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
//1줄로 set하기				첫 날은 항상 1부터 시작
//		cal.set(year, month-1, 1);

		lastDate = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		//blankDay = cal.get(Calendar.DAY_OF_WEEK)-1;
		dayWeek = cal.get(Calendar.DAY_OF_WEEK);
	}

/*
		DAY_OF_WEEK: 하나의 달에 1일 이 무슨 요일인지 정수형으로 알려준다. 1일이 월요일이면 = 2 ;

		일	월	화	수	목	금	토
doW		1	2	3	4	5	6	7
		=========7월 달력=========
					1	2	3	4 ===> blankdays = 3 + 들어간 값 4 = 7 이면 줄바꿈 
		5	6	7	8	9	10	11
		=========8월 달력=========
		1	2	3	4	5	6	7	==> blankdays = 0;
*/
	

	public void disp(){
		System.out.println("[" + year +"년도 " + month +"월 달력 ]");

		System.out.println("일 \t 월 \t 화 \t 수 \t 목 \t 금 \t 토");
		/*	for(int i = 0; i < blankDay; i++){
				System.out.print("\t");
			} */

			for(int i = 1; i < dayWeek; i++){
				System.out.print("\t");
			}

			for(int i = 1; i <= lastDate; i++){
				System.out.print(i + "\t");
				if(dayWeek % 7 == 0){
					System.out.println(); 
				}
				dayWeek++;
			/*	if((blankDay + i) % 7 == 0){
					System.out.println();
				}*/
			}
				
	}



	public static void main(String[] args) {
		CalendarMain2 cm = new CalendarMain2();
		cm.calc();
		cm.disp();

	




	}
}


//1 3 5 7 8 10 12		
//4 6 9 11
//2