package kr.co.bit;

public class Example09 {
	public static void main(String[] args) {
		StatePrintThread spt = new StatePrintThread(new TargetThread());
		spt.start();
	}
	
}


/* 스레드 생성 [NEW] --> 시작 [START] -> RUNNABLE[실행상태] -> 실행이 된 이후 WAITING / BLOCKED 을 거쳐 [일시정지] -> 다시 RUNNABLE로 돌아감 
 * 각각의 상태는 자신만의 상태값을 가지고 있다. >> 1) LOCK에 걸렸는지 여부를 확인 2) 강제 핸들링 시  
 */