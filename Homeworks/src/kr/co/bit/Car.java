package kr.co.bit;

import java.util.Scanner;

public class Car {
	public static void main(String[] args)	{
		int choice;		int i; 
		String carNum; 
		
		Scanner scan = new Scanner(System.in);
		boolean[] arr = new boolean[5]; //default = false;
		
		while(true){
			System.out.println("========주차관리 프로젝트=========");
			System.out.println("1.입차 2.출차 3.입차리스트 4. 종료");
			System.out.println("=============================");
			choice = scan.nextInt();
			if(choice == 1){ //1.입차
				
				System.out.print("주차 위치 입력: ");
				i = scan.nextInt();
				if(arr[i-1] == true) {
					System.out.println("이미 주차된 공간입니다. ");
				} else {
				System.out.print("차량번호: ");
				carNum = scan.next();
				arr[i-1] = true;
				System.out.println(i + "번 공간에 주차 완료");
				}

			} //1.입차 
			else if(choice == 2){ //2.출차
				System.out.print("출차 위치 입력: ");
				i = scan.nextInt();
				if(arr[i-1] == true) {
					System.out.println(i + "번 공간에서 출차 완료되었습니다. ");
					arr[i-1] = false;
				} else {
					System.out.println("해당 공간에 주차된 차량이 없습니다. ");
				}
			} //2.출차
			
			else if(choice == 3){ //3.입차 리스트
				for (i = 0; i < arr.length; i++) {
					System.out.println("위치: " + i + "	차량 있음/없음: " + arr[i]);
				}
			
			} //3.입차 리스트
			else if(choice == 4){ //4.종료
				System.out.println("종료합니다. ");
				break;
			} //4.종료
			else { //잘못된 번호 입력. 돌아갑니다. 
				System.out.println("잘못된 번호입니다. 다시 입력해주세요. ");
				continue;
			}//잘못된 번호 입력

		}//while
	}
}
