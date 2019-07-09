package kr.co.bit;

public class Calculator2 {
	private int memory;

	public int getMemory() {
		return memory;
	} 
			// [동기화] !스레드의 오류 방지! 다발적으로 진행되는 스레드가 자원에 접근하려고 할 때, 하나의 스레드만 접근하고 나머지는 막아버림.  
	public synchronized void setMemory(int memory) throws InterruptedException{
		this.memory = memory;
		Thread.sleep(2000);
		System.out.println(Thread.currentThread().getName() + ":" + this.memory);
	}
}
