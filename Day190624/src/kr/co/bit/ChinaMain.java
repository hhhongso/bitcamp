package kr.co.bit;

import java.util.Scanner;

public class ChinaMain {

	public static void main(String[] args) {
		SeoulChina sc = new SeoulChina(); 
		BusanChina bc = new BusanChina(3000, 5000, 7000, 20000); // new 연산자로 초기화 시 생성자 안에서 바로 초기화&값 입력 할 수도 있고 
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("1. 서울중국집 2. 부산중국집");
			int protocol = scan.nextInt();
			
			if (protocol == 1) {
				System.out.println("서울 중국집");
				sc.setZa(5000); // new연산자로는 초기화만 하고, set함수를 통해 대입할 수도 있다. 
				sc.setZzam(6000);
				sc.setTang(10000);
				sc.setJangza(18000);
				System.out.println("자장:" + sc.getZa() + "	짬뽕: " + sc.getZzam() + "	탕수육: " + sc.getTang() + "	쟁반자장: " + sc.getJangza()
				+ "	총합: " + sc.getTotal());
				System.out.println(sc.toString());
			} else if (protocol == 2) {
				System.out.println("부산 중국집");
				System.out.println("자장:" + bc.getZa() + "	짬뽕: " + bc.getZzam() + "	탕수육: " + bc.getTang() + "	삼선짬뽕: " + bc.getSamzzam()
				+ "	총합: " + bc.getTotal());
				System.out.println(bc.toString());
			}
		} // while문

	}

}
