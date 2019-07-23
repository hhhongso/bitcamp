import java.util.Scanner; 

class ATMTest implements Runnable {
	public static ATMTest t1= new ATMTest();
	private long depositMoney; // 찾을 금액
	private long balance = 100000; //잔액


	public ATMTest(){
	
	}
	
	//static 영역에는 this. 가 없음 => new 시켜줘야 함
	// mom = new ATMTest(), son = new ATMTest() 하면 각각 다른 객체를 참조하게 됨. 
	// 같은 객체를 참조할 수 있도록 먼저 new 를 해주고 그 객체를 사용한다. 
	public static void main(String[] args) {
		ATMTest atm = new ATMTest();
		Thread mom = new Thread(t1, "엄마"); // 스레드 이름 주기: .setName() 혹은 생성하면서
		Thread son = new Thread(t1, "아들");	

		mom.start();
		son.start();
	}
//동기화! 먼저 들어온 스레드만 함수를 실행한다. 
	public void run(){
		synchronized(this){
//		synchronized(ATMTest.clas){ 이래도 되고
//	public synchronized void run(){ 이래도 되고 
		System.out.println("\n"+ Thread.currentThread().getName() + "님 안녕하세요 !");

		Scanner scan = new Scanner(System.in); 
		System.out.print("찾을 금액 입력: ");
		depositMoney = scan.nextLong();

		withDraw(); //잔액 계산
		}
	}

	public void withDraw(){
		if(depositMoney <= balance){
			if(depositMoney % 10000 == 0) {
				balance -= depositMoney;
				System.out.println("잔액은" + balance + "입니다. ");
			} else {
			System.out.println("만원 단위로 입력하세요");
			}
		} else {
			System.out.println("잔액 초과되었습니다. ");
		}

	}
	/* while문 말고 아래 3개 중 하나로 결과 
	1. 찾고자 하는 금액 입력(1만원 단위) > 잔액은 nnn입니다. 
	2.					(=! 1만원단위) >> 만원 단위로 입력하세요. 
	3.					(잔액초과) > 잔액 초과되었습니다. 
	*/
}
