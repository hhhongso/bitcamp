package kr.co.bit2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/*
 * 
사용자 				서버							스레드 풀
				WAS							Queue 에서 관리: 해당 사용자마다의 스레드를 관리. 순차적으로 내려 진행 
				Web Application Service		스레드 끝나면 Queue 도 종료 
 */
public class Example02 {
	public static void main(String[] args) {
		//스레드 풀 생성: method - new fixed thread pool
		ExecutorService es = Executors.newFixedThreadPool(3); //스레드 풀 갯수 설정
		
		for (int i = 0; i < 10; i++) {
			Runnable runnable = () -> {
				ThreadPoolExecutor tpe = (ThreadPoolExecutor) es;
				int poolSize = tpe.getPoolSize();
				String threadName = Thread.currentThread().getName();
				System.out.println("총 스레드 개수: " + poolSize
						+ "작업 스레드 이름: " + threadName);
				//int value = Integer.parseInt("추웡");
			};
			es.execute(runnable);
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		es.shutdown(); // 자원을 계속 차지하지 않도록 완전 종료. 
	}
}


