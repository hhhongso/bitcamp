package kr.co.bit;

public class JuExecuter {
//주문 관련 프로그램
	public static void main(String[] args) {
		System.out.println("주문 선택 Y/N");
		char ju = args[0].charAt(0); 
		// args0벉째에 외부 문자 들어옴 -> charAt(0)으로 한 문자를 잘라 singlecomma 로 만들어 줌
		// Yes => Y 로 인식하도록 함 
		if(ju == 'y' || ju == 'Y') { //주문선택
			System.out.println("주문선택");
			System.out.println("메뉴1.자장면 2.짬뽕 3.탕수육");
			int menu = Integer.parseInt(args[1]);
			if (menu == 1) {
				System.out.println("자장면 선택");
				System.out.println("자장면 곱배기 Y/N");
				char gob = args[2].charAt(0);
				if(gob == 'y' || gob == 'Y') {
					System.out.println("자장면 곱배기 선택");
				} else {
					System.out.println("자장면 보통 선택");
				}
			} else if (menu == 2) {
				System.out.println("짬뽕 선택");
				System.out.println("짬뽕 곱배기 Y/N");
				char gob = args[2].charAt(0);
				if(gob == 'y' || gob == 'Y') {
					System.out.println("짬뽕 곱배기 선택");
				} else {
					System.out.println("짬뽕 보통 선택");
				}
			} else if (menu == 3) {
				System.out.println("탕수육 선택");
				System.out.println("1.대 2. 중 3. 소");
				int tang = Integer.parseInt(args[2]); // 짬/짜에서는 args[2]가 문자, 탕에서는 숫자
				if(tang == 1) {
					System.out.println("탕수육 대");
				} else if (tang == 2) {
					System.out.println("탕수육 중");
				} else if (tang == 3) {
					System.out.println("탕수육 소");
				}
			} else {
				System.out.println("1, 2, 3번 중에 선택하세요. ");
			}
		}else { //주문취소
			System.out.println("주문취소");
		}

	}

}
