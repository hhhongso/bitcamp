package kr.co.bit;

import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		Date date1 = new Date();
		System.out.println("년: " + date1.getYear()); // 줄그어놓은 함수: "곧 사라질 예정"
		System.out.println("월: " + date1.getMonth());
		System.out.println("일: " + date1.getDate());
		System.out.println(date1);
	}

}
