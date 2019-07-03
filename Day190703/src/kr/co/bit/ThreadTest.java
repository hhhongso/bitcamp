package kr.co.bit;

class MyThread2 extends Thread {
	public MyThread2(String name) {
		super(name);
	}

	@Override
	public void run() {
		try {
			for(int i = 0; i < 5; i++) {
				System.out.print(currentThread().getName()); //현재 실행중인 스레드 이름 불러오기
				sleep(1000); //일시정지
				System.out.println();
				for(int j = 0; j <= i; j++) {
					System.out.print("$");
				}
				System.out.println();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}

public class ThreadTest {
	public static void main(String[] args) {
		// run()을 직접 부르지 않고, 상속받은 start()를 통해 호출 
		MyThread2 mythread = new MyThread2("my");
		mythread.start();								//첫번째 객체와 두번째 객체를 동시에 실행시킬 수 있으며, 첫번째와 두번째의 실행 순서는 계속 달라진다.  
		
		MyThread2 mythread1 = new MyThread2("MY");
		mythread1.start();
	}
} 
