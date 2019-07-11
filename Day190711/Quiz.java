/*
10~99사이의 난수를 2개 발생하여 합을 맞추는 게임
총 문제는 5문제를 제공한다
1문제당 점수 20점입니다
틀리면 1번 더 기회를 제공한다

[실행결과]
[1] 12 + 36 = xx
틀렸다
[1] 12 + 36 = xxx
틀렸다...정답은 48

[2] 10 + 15 = xx
딩동뎅

[5] 90 + 88 =
틀렸다
[5] 90 + 88 = 178
딩동뎅

총 맞은개수는 2문제이고 점수는 40점입니다

또 할래(Y/N) : n
프로그램을 종료합니다
*/

import java.util.Scanner;
class Quiz {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numQ= 0; 
		int wrongCount = 0;
		int correctQ = 0;
	while(true){
		while(numQ < 5){
			numQ++;
			int a = (int)(Math.random()*90)+10;
			int b = (int)(Math.random()*90)+10;
			
			
				for(int i = 0 ; i < 2 ; i++){	
					System.out.println("[" + numQ + "]" + a + "+" + b + "= ");
					int answer = scan.nextInt();
					if(a+b == answer) { 
						System.out.println("정답!");
						wrongCount = 0; correctQ++; break;
					} else { 
						System.out.println("틀렸습니다. 다시 계산해주세요: "); 
						wrongCount++; 	
						if(wrongCount == 2) { 
							System.out.println("도전 가능 횟수 초과.. 정답은: " + (a+b)); 
							wrongCount = 0;
						}	
					}
				}	

		}// while

		System.out.println("총 맞은 갯수: " + correctQ + "점수: " + correctQ*20);

		System.out.println("계속하시겠습니까? Y/N");
		String choice = scan.next();
		if(choice.equalsIgnoreCase("y")) { System.out.println("처음으로 돌아갑니다. "); numQ=0;}
		else if(choice.equalsIgnoreCase("N")) { System.out.println("바이바이!"); System.exit(0);}
	}
		
	}
}
