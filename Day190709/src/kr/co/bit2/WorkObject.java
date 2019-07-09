package kr.co.bit2;

public class WorkObject {
	public synchronized void methodA() throws InterruptedException {
		System.out.println("Thread A의 methodA() 작업 실행 ");
		notify(); // 해당 메소드의 상태를 (runnable 상태로) 깨움 
		wait(); // 스레드를 다시 재움(기다리도록 함) 
	}
	
	public synchronized void methodB() throws InterruptedException {
		System.out.println("Thread B의 methodB() 작업 실행 ");
		notify(); // 실제로 해당 스레드를 깨움 
		wait(); // 스레드를 다시 재움 
	}
	
	//notify / wait를 이용하여 다발성으로 실행되지 않고, a -> b -> a -> b 번갈아가며 실행되도록 한다. 
	
}
