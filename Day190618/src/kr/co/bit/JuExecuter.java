package kr.co.bit;

public class JuExecuter {

	public static void main(String[] args) {
		System.out.println("주문하세요 Y/N");
		char ju = 'y';
		if (ju == 'y' || ju == 'Y') {
			System.out.println("주문선택");
			System.out.println("메뉴 1.자장면 2.짬뽕 3.탕수육");
			int menu = 1; 
			switch(menu) { //스위치 코드는 중첩하지 않는 것이 좋다. 
			case 1: 
				System.out.println("자장면 선택");
				System.out.println("자장면 곱배기 Y/N");
				char gob = 'y';
				if (gob =='y' || gob == 'Y') {
					System.out.println("자장면 곱배기 선택");
				} else {
					System.out.println("자장면 보통 선택");
				}
				break;
			case 2:
				System.out.println("짬뽕 선택");
				System.out.println("짬뽕 곱배기 Y/N");
				gob = 'y';
				if (gob =='y' || gob == 'Y') {
					System.out.println("짬뽕 곱배기 선택");
				} else {
					System.out.println("짬뽕 보통 선택");
				}
				break;
			case 3:
				System.out.println("탕수육 선택");
				System.out.println("1. 대 2. 중 3. 소");
				int tang = 1; 
				switch(tang) { //case 안에서 switch를 다시 사용하는 것은 괜찮.
				case 1:
					System.out.println("탕수육 대 ");
					break;
				case 2: 
					System.out.println("탕수육 중");
					break;
				case 3:
					System.out.println("탕수육 소");
					break; 
				}
				break;
			default: 
				System.out.println("1,2,3번 중에 다시 선택하세요.");
			}
		} else {
			System.out.println("주문취소");
		}

	}

}
