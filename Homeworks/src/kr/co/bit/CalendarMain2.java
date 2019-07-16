package kr.co.bit;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class CalendarMain2 {
	private int year;
	private int month;
	private int maxDate;
	private int blankDay; 
	
	public CalendarMain2() {
		Scanner scan = new Scanner(System.in);
		System.out.print("년도: ");
		year = scan.nextInt();
		System.out.print("월: ");
		month = scan.nextInt();
	}
	
	public void calc() {
		Calendar cal = new GregorianCalendar();
		cal.set(year, month-1, 1); //jan: 0 ~20 dec: 11
		
		maxDate = cal.getActualMaximum(cal.DAY_OF_MONTH);
		blankDay = cal.get(cal.DAY_OF_WEEK) -1; //일요일의 day of week = 1. //		일요일부터 1일이 시작하면 blank = 0. 
//		System.out.println(cal.YEAR + "년도" + cal.MONTH + "월"); // default
	}
	
	public void disp() {
		System.out.println(year + "년도" + month + "월");
		System.out.println("일 \t 월 \t 화 \t 수 \t 목 \t 금 \t 토");
		
		for (int i = 0; i < blankDay; i++) {
			System.out.print("\t");
		}
	
		for (int i = 1; i <= maxDate; i++) {
			System.out.print(i + "\t");
			if((blankDay + i) % 7 == 0) {
				System.out.println();
			}
		}
	
	}

	public static void main(String[] args) {
		CalendarMain2 cm = new CalendarMain2();
		cm.calc();
		cm.disp();

	}

}
