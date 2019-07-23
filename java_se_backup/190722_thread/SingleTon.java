class SingleTon {
	private int num = 3; 
	private static SingleTon instance; 

	public static SingleTon getInstance(){
		if(instance == null) {
			synchronized(SingleTon.class) {
				instance = new SingleTon(); // null �� ��(�ʱ�ȭ) �ѹ��� ����: heap������ ���� 
			}
		}
		return instance;
	}

	public static void main(String[] args) {
		SingleTon cc = SingleTon.getInstance(); // new���� ����, �Լ��� ó��. null �̸� static new ����.
		cc.num++;
		System.out.println("cc: " + cc);
		System.out.println("num: " + cc.num);
		System.out.println();

		
		SingleTon dd = SingleTon.getInstance(); // != null �̸� ������� new ������		
		dd.num++;
		System.out.println("dd: " + dd);
		System.out.println("num: " + dd.num);
		System.out.println();

	}
}

/* static
:�޸��� static ������ �����Ͽ�, �ʱ�ȭ 1���� �ϰ� ��� ����Ѵ�. 
*/