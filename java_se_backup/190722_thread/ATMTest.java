import java.util.Scanner; 

class ATMTest implements Runnable {
	public static ATMTest t1= new ATMTest();
	private long depositMoney; // ã�� �ݾ�
	private long balance = 100000; //�ܾ�


	public ATMTest(){
	
	}
	
	//static �������� this. �� ���� => new ������� ��
	// mom = new ATMTest(), son = new ATMTest() �ϸ� ���� �ٸ� ��ü�� �����ϰ� ��. 
	// ���� ��ü�� ������ �� �ֵ��� ���� new �� ���ְ� �� ��ü�� ����Ѵ�. 
	public static void main(String[] args) {
		ATMTest atm = new ATMTest();
		Thread mom = new Thread(t1, "����"); // ������ �̸� �ֱ�: .setName() Ȥ�� �����ϸ鼭
		Thread son = new Thread(t1, "�Ƶ�");	

		mom.start();
		son.start();
	}
//����ȭ! ���� ���� �����常 �Լ��� �����Ѵ�. 
	public void run(){
		synchronized(this){
//		synchronized(ATMTest.clas){ �̷��� �ǰ�
//	public synchronized void run(){ �̷��� �ǰ� 
		System.out.println("\n"+ Thread.currentThread().getName() + "�� �ȳ��ϼ��� !");

		Scanner scan = new Scanner(System.in); 
		System.out.print("ã�� �ݾ� �Է�: ");
		depositMoney = scan.nextLong();

		withDraw(); //�ܾ� ���
		}
	}

	public void withDraw(){
		if(depositMoney <= balance){
			if(depositMoney % 10000 == 0) {
				balance -= depositMoney;
				System.out.println("�ܾ���" + balance + "�Դϴ�. ");
			} else {
			System.out.println("���� ������ �Է��ϼ���");
			}
		} else {
			System.out.println("�ܾ� �ʰ��Ǿ����ϴ�. ");
		}

	}
	/* while�� ���� �Ʒ� 3�� �� �ϳ��� ��� 
	1. ã���� �ϴ� �ݾ� �Է�(1���� ����) > �ܾ��� nnn�Դϴ�. 
	2.					(=! 1��������) >> ���� ������ �Է��ϼ���. 
	3.					(�ܾ��ʰ�) > �ܾ� �ʰ��Ǿ����ϴ�. 
	*/
}
