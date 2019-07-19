class Outer {
	private String name; 

	public void output(){
		System.out.println("�̸�:" + this.name + "����: " + new Inner().age);
				//�ƿ��� Ŭ������ �̳� Ŭ������ �ʵ带 �ٷ� ������ �� ����. ==> ��ü ���� �ʿ�.
				//���� Ŭ���� ������ ��ø���� �������� ������ setter/getter�� �ʿ���� 
	}

	class Inner {
		private int age;

		public void disp(){
			System.out.println("�̸�:" + Outer.this.name + "����: " + this.age);
					//�̳� Ŭ������ �ƿ��� Ŭ������ �ʵ带 �ٷ� ������ �� �ִ�. 
					//��, Ŭ���� �ȿ����� �����ϸ�, �������� static���� �޸𸮸� ���� ��� ������, �ٷ� ������ �� ����. 
					//name �� �ٷ� �� �� ������, ���� ���� �����Ǿ� �ִ�. 
		}

	}

	public static void main(String[] args)	{
		Outer aa = new Outer();	//��Ӱ��谡 �ƴϱ� ������, outer new �Ͽ��� �� inner �� ������ ����. 
		aa.name = "ȫ�浿"; // ���� Ŭ���� �ȿ��� getter/setter ���� ������ �� ����.
		aa.output();

		Outer.Inner bb = aa.new Inner(); // ��ø�Ǿ� ���� ((.)�� ��������)�� ǥ�����־��.
//		bb.name = "��"; *error!* �������� static���� �޸𸮸� ���� ��� ������, �ٷ� ������ �� ����. 
		bb.age = 25; 
		bb.disp();

		Outer.Inner cc = aa.new Inner();
		cc.age = 30; 
		cc.disp();

		Outer.Inner dd = new Outer().new Inner(); 
			//outer ��ü ���� �����, inner Ŭ������ dd��ü�� ����. dd�� �̳� Ŭ�����̱� ������ outerŬ������ �ִ� name �� ���� �Ұ�
		dd.age = 35; 
		dd.disp();


	}
}