package kr.co.bit;

import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		Date date1 = new Date();
		System.out.println("��: " + date1.getYear()); // �ٱ׾���� �Լ�: "�� ����� ����"
		System.out.println("��: " + date1.getMonth());
		System.out.println("��: " + date1.getDate());
		System.out.println(date1);
	}

}
