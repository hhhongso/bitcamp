

class SnackTest extends Thread {
	private String str; 

	public SnackTest(String str){
		this.str = str;
	}

	@Override
	public void run(){ // thread로 만들어주어야 콜백처리가 된다 ==> 1) 상속 2) 인터페이스 
		for(int i = 1; i <= 5; i++){						//현재 실행중인 스레드 찾아보기
			System.out.println(str+ "\t i = " + i + "\t" + Thread.currentThread());
		}
	}
	public static void main(String[] args)	{
		SnackTest aa = new SnackTest("새우깡"); // 스레드1 생성
		SnackTest bb = new SnackTest("홈런볼"); // 스레드2
		SnackTest cc = new SnackTest("포카칩"); // 스레드3

		//스레드 이름 변경 
		aa.setName("새우새우");
		bb.setName("홈런");
		cc.setName("포카포카");

		//우선순위((낮)1~10(높)) : but 우선순위대로 운영체제가 처리하지는 않는다.. 
		bb.setPriority(Thread.MAX_PRIORITY); //보다 직관적 
		// bb.setPriority(10);
		cc.setPriority(Thread.MIN_PRIORITY);
		aa.setPriority(Thread.NORM_PRIORITY); // normal = 5; 



		aa.start(); // 스레드 시작. ==> 실행run() by 운영체제
		bb.start();
		try {
			bb.join();	// 스레드 죽이기: aa는 스레드 적용되지 않음. aa가 끝날 때까지 bb, cc는 대기상태
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		cc.start();
	}
}
