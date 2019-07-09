package kr.co.bit;

public class TargetThread extends Thread{
	public void run() {
		for (long i = 0; i < 100000000; i++) {}
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (long i = 0; i < 100000000; i++) {}
	}
}
