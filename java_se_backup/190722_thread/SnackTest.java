

class SnackTest extends Thread {
	private String str; 

	public SnackTest(String str){
		this.str = str;
	}

	@Override
	public void run(){ // thread�� ������־�� �ݹ�ó���� �ȴ� ==> 1) ��� 2) �������̽� 
		for(int i = 1; i <= 5; i++){						//���� �������� ������ ã�ƺ���
			System.out.println(str+ "\t i = " + i + "\t" + Thread.currentThread());
		}
	}
	public static void main(String[] args)	{
		SnackTest aa = new SnackTest("�����"); // ������1 ����
		SnackTest bb = new SnackTest("Ȩ����"); // ������2
		SnackTest cc = new SnackTest("��īĨ"); // ������3

		//������ �̸� ���� 
		aa.setName("�������");
		bb.setName("Ȩ��");
		cc.setName("��ī��ī");

		//�켱����((��)1~10(��)) : but �켱������� �ü���� ó�������� �ʴ´�.. 
		bb.setPriority(Thread.MAX_PRIORITY); //���� ������ 
		// bb.setPriority(10);
		cc.setPriority(Thread.MIN_PRIORITY);
		aa.setPriority(Thread.NORM_PRIORITY); // normal = 5; 



		aa.start(); // ������ ����. ==> ����run() by �ü��
		bb.start();
		try {
			bb.join();	// ������ ���̱�: aa�� ������ ������� ����. aa�� ���� ������ bb, cc�� ������
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		cc.start();
	}
}
