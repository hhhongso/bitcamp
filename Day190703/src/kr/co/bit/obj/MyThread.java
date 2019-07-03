package kr.co.bit.obj;

public class MyThread extends Object implements Runnable {

	@Override
	public void run() {	
			try {
				for(int i = 0; i < 5; i++) {
					System.out.print(Thread.currentThread().getName()); //���� �������� ������ �̸� �ҷ����� >> ThreadŬ�������� static�Լ��� ���� �ҷ��;� �� 
					System.out.println();
					Thread.sleep(1000); //�Ͻ�����
					for(int j = 0; j <= i; j++) {
						System.out.print("$");
					}
					System.out.println();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
	
	public static void main(String[] args) {
		MyThread mythread2 = new MyThread();
		Thread thread = new Thread(mythread2, "MYthread2");
		thread.start();
		
		MyThread mythread3 = new MyThread();
		Thread thread1 = new Thread(mythread3, "MYthread3");
		thread1.start();
	}
}
