package kr.co.bit.obj;

public class MyThread extends Object implements Runnable {

	@Override
	public void run() {	
			try {
				for(int i = 0; i < 5; i++) {
					System.out.print(Thread.currentThread().getName()); //현재 실행중인 스레드 이름 불러오기 >> Thread클래스에서 static함수를 직접 불러와야 함 
					System.out.println();
					Thread.sleep(1000); //일시정지
					for(int j = 0; j <= i; j++) {
						System.out.print("$");
					}
					System.out.println();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
	
	public static void main(String[] args) {
		MyThread mythread2 = new MyThread();
		Thread thread = new Thread(mythread2, "MYthread2");
		thread.start();
		
		MyThread mythread3 = new MyThread();
		Thread thread1 = new Thread(mythread3, "MYthread3");
		thread1.start();
	}
}
