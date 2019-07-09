package kr.co.bit;

public class Example11 {
	public static void main(String[] args) throws InterruptedException{
		SumThread st = new SumThread();
		st.start();
		
		st.join(); // 조인으로 st.쓰레드의 종료를 메인 스레드에서 기다려주도록 함 > st.가 끝나게 되면 조인을 빠져나가며, getSum이 진행  
		System.out.println("1~100까지의 합: " + st.getSum()); //st.start()가 시작하기 전에, 이미 getSum이 출력이 되는 것 
		
		//** 작업량이 너무 많을 경우에는 권장하지 않음. 
	}
}
