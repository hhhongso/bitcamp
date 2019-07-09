package kr.co.bit2;

public class DaemonEx {
	public static void main(String[] args) throws InterruptedException {
		AutoSaveThread ast = new AutoSaveThread();
		ast.setDaemon(true);	//데몬 스레드 없을 시 AutoSaveThread는 계속 돌아감 >> 계속 내용이 출력됨. 데몬스레드는 메인 스레드가 종료되면 같이 종료됨.
		ast.start();
		Thread.sleep(3000);
		System.out.println("메인 스레드 종료");
	
	}
	
}

