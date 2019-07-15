/*
	유저		가1	바2	보3
사용자
	가1		=	w	l
	바2		l	=	w		
	보3		w	l	=
*/

/*가위 바위 보
1: 가위 2: 바위 3:보 
컴퓨터: 1~3 사이의 난수를 발생 
사용자: 1~3 중 하나를 입력 (System.in.read()를 사용)
컴퓨터: 바위, 나: 가위 
졌다 ! 당신의 금액은 nnn

기본금액: 10,000 제공 
배팅금액: 입력받기
엔터를 치세요....

금액이 0이가 마이너스이면 코인 충전 여부 묻기 y/n
n: 프로그램 종료 
y: 코인 충전


'A' --- [32] --- 'a'
0 --- [48] --- '0'
*/

import java.util.Scanner; 
class Game {
	public static void main(String[] args) throws java.io.IOException {
		int com, user, bet, charge;
		int money = 10000;
		Scanner scan = new Scanner(System.in);
//1. 
while(true){
		while(money > 0){
			com = (int)(Math.random()*3)+1;
			System.out.println("1.가위 2.바위 3.보 중 하나를 선택");

			user = System.in.read()-'0';
			scan.nextLine();
			//System.in.read(); // flush
			//System.in.read();

			System.out.println("얼마를 베팅하시겠습니까? ");
			bet = scan.nextInt(); 
			scan.nextLine();
			//남음 \r\n
				
			System.out.print("진행하시려면 엔터키를 입력하세요..");
		    //scan.nextLine();
			System.in.read();
			System.in.read();

			if(com == 1){
				if(user == 1){
					System.out.println("컴퓨터: 가위, 사용자: 가위");
					System.out.println("비겼습니다.");

				} else if (user == 2){
					System.out.println("컴퓨터: 가위, 사용자: 바위");	
					System.out.println("이겼습니다.");
					money +=bet;
				
				} else if (user == 3){
					System.out.println("컴퓨터: 가위, 사용자: 보");
					System.out.println("졌습니다.");
					money -=bet;
				}
				
			}

			else if(com == 2){
				if(user == 1){
					System.out.println("컴퓨터: 바위, 사용자: 가위");
					System.out.println("졌습니다.");
					money -=bet;
				} else if (user == 2){
					System.out.println("컴퓨터: 바위, 사용자: 바위");	
					System.out.println("비겼습니다.");
				} else if (user == 3){
					System.out.println("컴퓨터: 바위, 사용자: 보");
					System.out.println("이겼습니다.");
					money +=bet;
				}
				
			}

			else if(com == 3){
				if(user == 1){
					System.out.println("컴퓨터: 보, 사용자: 가위");
					System.out.println("이겼습니다.");
					money +=bet;
				} else if (user == 2){
					System.out.println("컴퓨터: 보, 사용자: 바위");	
					System.out.println("졌습니다.");
					money -=bet;
				} else if (user == 3){
					System.out.println("컴퓨터: 보, 사용자: 보");
					System.out.println("비겼습니다.");
				}				
			}

			System.out.println("남은 코인은 " + money + "원 입니다.");
			System.out.println();
		
		}//while
			System.out.print("남은 코인이 없습니다. 충전하시겠습니까? y/n");
			String choice = scan.next();
			if(choice.equalsIgnoreCase("Y")) {
				System.out.print("충전 금액을 입력하세요: ");
				charge = scan.nextInt();
				System.out.print(charge + "원 충전 완료. 처음으로 돌아갑니다.");
				money = charge;
			} else if(choice.equalsIgnoreCase("N")){
				System.out.print("바이바이! ");
				break; //System.exit(0); 을 하고 나면 그 다음에 아래 sysout 을 찍을 수 없음 (이미 exit)
			}
	}//while
	System.out.println("프로그램을 종료합니다. ");
}
}


//2.
/*
			int result = user - com;
			if(result == 1 || result == -2) {
				System.out.println("이겼습니다.");
			} else if(result == -1 || result == 2) {
				System.out.println("졌습니다.");
			} else {
				System.out.println("비겼습니다.");
			}

			System.out.println("컴퓨터: " + com + "사용자: " + user);
*/


