package kr.co.bit;

public class StatePrintThread extends Thread {
	private Thread targetThread; 
	
	public StatePrintThread(Thread targetThread) {
		this.targetThread = targetThread; 
	}

	@Override
	public void run() {
		while(true) {
			Thread.State state = targetThread.getState(); // enum 값인 State에서 해당 값을 받아오기
			System.out.println("타겟 스레드 상태: " + state);
			
			if(state == Thread.State.NEW)targetThread.start();
			if(state == Thread.State.TERMINATED) break;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
