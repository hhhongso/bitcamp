package kr.co.bit.obj1;
//ctrl+shift+f : 자동 줄맞춤 

import java.util.Scanner;

public class JuExecuter {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			String JU = JuFunction.juSelect(scan); //ctrl+ 커서올림 == 해당 함수 위치 확인 가능
			//static이 붙은 class의 method를 직접 호출
			
			if(JU.equals("yes") || JU.equals("YES")) { // 문자열과 비교하기 .equals() ==> 클래스끼리 비교하는 것 
				JuFunction.juDisp(1);
				
				int menu = JuFunction.menuSelect(scan); // ()에 키보드값이 그대로 오도록 scan  				
				if(menu == 1) {
					JuFunction.menuDisp(1);
					String GOB = JuFunction.gobSelect(scan);
					if(GOB.equals("yes") || GOB.equals("YES")) { 
						JuFunction.gobDisp(1);
					} else {
						JuFunction.gobDisp(2);
					}
					
				} else if (menu == 2) {
					JuFunction.menuDisp(2);
					String GOB = JuFunction.gobSelect(scan);
					if(GOB.equals("yes") || GOB.equals("YES")) { 
						JuFunction.gobDisp(3);
					} else {
						JuFunction.gobDisp(4);
					}
					
				} else if (menu == 3) {
					JuFunction.menuDisp(3);
					int TANG = JuFunction.tangSelect(scan);
					if (TANG == 1) {
						JuFunction.tangDisp(1);
					} else if (TANG == 2) {
						JuFunction.tangDisp(2);
					} else if (TANG == 3) {
						JuFunction.tangDisp(3);
					}
					
				}
			} else {
				JuFunction.juDisp(2);
				break;
			}
			
		} // while문 끝

	}

}
