package kr.co.bit;

public class MyThread extends Thread {
	public MyThread(String name) {
		super(name);
	}
	
	public void run() {
		
		for(int i = 0; i <5; i++) {
			System.out.print(i);
		}
	}
	
	//상속받은 부분 
//	public void start() {
//		run();
//	}
	
	public static void main(String[] args) {
		MyThread myThread = new MyThread("myThread");
		myThread.start(); // Thread에서 start()를 상속받음 >> 
	}
}
