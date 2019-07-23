/* 주차관리 프로그램(POS)
주차되어 있으면 true, 차가 없으면 false. 주차 가능 공간은 5개. 
===============================
1. 입차 2. 출차 3. 입차리스트 4. 끝
===============================
번호입력: 1
주차 위치 입력: 3 ==> arr[2]
if(arr == true) 이미 주차되어 있습니다. 
else n번에 주차되었습니다. ===> 주차 시기부터 10분당 1000원 

번호입력: 2
if(arr != true) 주차된 차가 없습니다. 
else n번에 출차합니다. 주차비는 nnnn 원 입니다. 

번호입력: 3
1 위치: false (default)
2 위치: 
3 위치: 
4 위치: 
5 위치: 

*/
import java.util.Scanner;
class Car {
	public static void main(String[] args)	{
		int choice;		int i; 
		String carNum; 
		
		Scanner scan = new Scanner(System.in);
		boolean[] arr = new boolean[5]; //default = false; 배열은 객체형 > 참조주소값을 가져온다. 
		System.out.println("arr의 참조주소값: " + arr);
		
		while(true){
			System.out.println("======주차관리 프로젝트=======");
			System.out.println("1.입차 2.출차 3.리스트 4. 종료");
			System.out.println("=============================");
			choice = scan.nextInt();
			if(choice == 1){ //1.입차
				
				System.out.print("주차 위치 입력: ");
				i = scan.nextInt();
				if(arr[i-1]) { //boolean 형은 T/F의 값을 이미 가지고 있음 => arr[] == true 라는 것은 true == true 라고 물어보는 꼴이니 그냥 arr[] 이라고만 써도 T/F를 확인. 
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
				if(arr[i-1]) { 
					System.out.println(i + "번 공간에서 출차 완료되었습니다. ");
					arr[i-1] = false;
				} else {
					System.out.println("해당 공간에 주차된 차량이 없습니다. ");
				}
			} //2.출차
			
			else if(choice == 3){ //3.리스트
				for (i = 0; i < arr.length; i++) {
					System.out.println("위치: " + (i+1) + "	차량 있음/없음: " + arr[i]);
				}
			
			} //3.리스트
			else if(choice == 4){ //4.종료	
				break;
			} //4.종료
			else { //잘못된 번호 입력. 돌아갑니다. 
				System.out.println("잘못된 번호입니다. 다시 입력해주세요. ");
				continue;
			}//잘못된 번호 입력

		}//while
		System.out.println("종료합니다. ");
	}
}
