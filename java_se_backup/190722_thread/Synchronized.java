class Synchronized extends Thread {
	private static int count; 

	public static void main(String[] args)	{
		Synchronized aa = new Synchronized(); // ������ ���� 
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
//	public synchronized void run(){ => ����ȭ X
//		synchronized(this) { // ������ this ���� �ٸ�  => ����ȭ X
		synchronized(Synchronized.class) { // ����ȭ => ���� ���� ���� ����� ������ �������� ���
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
