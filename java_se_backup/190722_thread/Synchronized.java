class Synchronized extends Thread {
	private static int count; 

	public static void main(String[] args)	{
		Synchronized aa = new Synchronized(); // 스레드 생성 
		Synchronized bb = new Synchronized();
		Synchronized cc = new Synchronized();

		aa.setName("AA");
		bb.setName("BB");
		cc.setName("CC");

		aa.start();
		bb.start();
		cc.start();
	}
	
	public void run(){
//	public synchronized void run(){ => 동기화 X
//		synchronized(this) { // 각각의 this 값은 다름  => 동기화 X
		synchronized(Synchronized.class) { // 동기화 => 먼저 들어온 것이 실행될 때까지 나머지는 대기
			for(int i = 1; i <= 5; i++){
				count++;
				System.out.println(Thread.currentThread().getName() + " : " + count);
				try{
					Thread.sleep(100);
				} catch (InterruptedException e){
					e.printStackTrace();
				}
			}
		}
	}
}
