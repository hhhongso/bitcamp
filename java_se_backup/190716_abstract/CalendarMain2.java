/* ����޷� ����� 
�⵵ �Է�:nnnn ==> �����ڿ��� �Է�
�� �Է�:m		 ==> �����ڿ��� �Է�

�ϼ� calc()
�ϼ� ��� disp()

	[nnnn�� m��]
��	��	ȭ	��	��	��	��
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

	public CalendarMain2(){ // ������
		Scanner scan = new Scanner(System.in);
		System.out.println("�⵵ �Է�: ");
		year = scan.nextInt();
		System.out.println("�� �Է�: ");
		month = scan.nextInt();
	} // ������	

//1. ���� �̶� ��¥ �� ��Ī
//2. �����(7) ���� �ٹٲ�

	public void calc(){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
//1�ٷ� set�ϱ�				ù ���� �׻� 1���� ����
//		cal.set(year, month-1, 1);

		lastDate = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		//blankDay = cal.get(Calendar.DAY_OF_WEEK)-1;
		dayWeek = cal.get(Calendar.DAY_OF_WEEK);
	}

/*
		DAY_OF_WEEK: �ϳ��� �޿� 1�� �� ���� �������� ���������� �˷��ش�. 1���� �������̸� = 2 ;

		��	��	ȭ	��	��	��	��
doW		1	2	3	4	5	6	7
		=========7�� �޷�=========
					1	2	3	4 ===> blankdays = 3 + �� �� 4 = 7 �̸� �ٹٲ� 
		5	6	7	8	9	10	11
		=========8�� �޷�=========
		1	2	3	4	5	6	7	==> blankdays = 0;
*/
	

	public void disp(){
		System.out.println("[" + year +"�⵵ " + month +"�� �޷� ]");

		System.out.println("�� \t �� \t ȭ \t �� \t �� \t �� \t ��");
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