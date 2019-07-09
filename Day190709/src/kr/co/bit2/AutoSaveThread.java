package kr.co.bit2;
/*
 * 주 스레드를 뒷받침해주는 보조 스레드 = 데몬 스레드 (.setDaemon으로 호출)
작업을 동기화시키고, 꺼짐/켜짐의 프로세스를 메인 스레드와 같이 진행한다. 
 */
public class AutoSaveThread extends Thread{
	public void save() { System.out.println("작업 내용을 저장함."); }
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				break;				
			}
			save();
		}
	}
}
