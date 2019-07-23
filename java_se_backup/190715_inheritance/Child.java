class Child extends Parent {
	protected String name;
	protected int age;

	public Child(String name, int age, double weight, double height){
		System.out.println("Child �Ķ���� �ִ� ������");
//		super(weight, height);
		this.name = name;
		this.age = age;
		this.weight = weight; // �θ� Ŭ������ �ʵ尡 �ڽ� Ŭ�������� ��� >> �ڽ� Ŭ�������� �ٷ� �ҷ��� �� ����(this.) 
		super.height = height; //�θ�Ŭ������ �ö󰡼� ������ ���̴�, super. ��� ���൵ ���� 
	}

	public void output(){
		System.out.println("�̸�: " + name);
		System.out.println("����: " + age);
		disp(); // super.�� �������� �ʾƵ�, �ڽ� Ŭ���� ���� ���ٸ� ��ӹ��� �θ� Ŭ������ �˾Ƽ� �ö� ��
//		System.out.println("������: " + weight);
//		System.out.println("Ű: " + height);
	}

	public static void main(String[] args)	{
		Child ch = new Child("����", 25, 50, 160); // *error!* �����ڰ� �ϳ��� ���� ��, default �����ڸ� �ڵ� ȣ���Ѵ�. ���� ��� �Ķ���Ͱ� �ִ� �����ڰ� �̹� �ֱ� ������, ����Ʈ �����ڸ� �ڵ� ȣ���� �� ����. 
		 //�ڽ� Ŭ������ new > �޸� ���� ��, Super, Sub Ŭ���� 2���� �޸𸮸� ���ÿ� �����Ѵ�. ��, �����ڵ� Super, Sub 2�� ȣ��ȴ�.
		 ch.output();
		System.out.println("------------------------");
		ch.disp();
		System.out.println("************************");

		Parent pa = new Child("�ڳ�", 11, 30, 130); //Upcasting. Super Class�� �͸� ����� �� ����.
		//pa.output(); *error!* �ڽĸ� ������ �ִ� �ʵ�/�޼ҵ忡 ���� �Ұ� 
		pa.disp();

		
	}
}



