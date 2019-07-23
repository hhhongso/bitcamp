class Sub extends Parent {
	protected String name;
	protected int age;

	public Sub(String name, int age, double weight, double height){
		super(weight,height); // �θ� ������ ȣ�� 
		System.out.println("Sub �Ķ���� �ִ� ������");
		this.name = name;
		this.age = age;
	}

	@Override
	public void disp(){
		System.out.println("�̸�: " + name);
		System.out.println("����: " + age);
		super.disp();
	}

	public static void main(String[] args) {
		Sub sub = new Sub("������", 25, 60, 170);
		sub.disp();
		System.out.println("------------------------");

		Parent pa = new Sub("�ڳ�", 11, 30, 130); 
		pa.disp();
	}
}
