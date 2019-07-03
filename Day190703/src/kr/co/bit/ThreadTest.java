package kr.co.bit;

class MyThread2 extends Thread {
	public MyThread2(String name) {
		super(name);
	}

	@Override
	public void run() {
		try {
			for(int i = 0; i < 5; i++) {
				System.out.print(currentThread().getName()); //���� �������� ������ �̸� �ҷ�����
				sleep(1000); //�Ͻ�����
				System.out.println();
				for(int j = 0; j <= i; j++) {
					System.out.print("$");
				}
				System.out.println();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}

public class ThreadTest {
	public static void main(String[] args) {
		// run()�� ���� �θ��� �ʰ�, ��ӹ��� start()�� ���� ȣ�� 
		MyThread2 mythread = new MyThread2("my");
		mythread.start();								//ù��° ��ü�� �ι�° ��ü�� ���ÿ� �����ų �� ������, ù��°�� �ι�°�� ���� ������ ��� �޶�����.  
		
		MyThread2 mythread1 = new MyThread2("MY");
		mythread1.start();
	}
} 
