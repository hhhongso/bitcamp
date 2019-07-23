

class ConstructorMain {
	private String name; 
	private int age; 

	public ConstructorMain(){
		System.out.println("�⺻ ������(default): �Ķ���Ͱ��� ����");
	}

	public ConstructorMain(String name){ //������ Overload
		this();
		System.out.println("this= " + this);
		this.name = name;		// this. �ڱ��ڽ� Ŭ������ �������� ������ ����. 
	}

	public ConstructorMain(int age){
		this("�ڳ�"); //this();: �����ε� �� �ٸ� �����ڸ� ȣ�� **this(), super() �� �����ڸ� ȣ�� ��, �ݵ�� ù��° �ٿ� ��ġ�Ͽ��� �Ѵ�. **
		System.out.println("this= " + this);
		this.age = age;
			//�����ڴ� ����ȣ���� �� ����(new �� �� ȣ��). ***��, �����ε� �� �����ڳ����� ���� ȣ���� �����ϴ�.  ***
	}

	public static void main(String[] args) { //[1] ���α׷� ������ main������ ����

		ConstructorMain cm = new ConstructorMain();
		System.out.println("cm= " + cm);
		System.out.println("�̸�: " + cm.name + "	����: " + cm.age);
		System.out.println();

		ConstructorMain cm2 = new ConstructorMain("ȫ�浿");
		System.out.println("cm2= " + cm2);
		System.out.println("�̸�: " + cm2.name + "	����: " + cm2.age);
		System.out.println();

		ConstructorMain cm3 = new ConstructorMain(28);
		System.out.println("cm3= " + cm3);
		System.out.println("�̸�: " + cm3.name + "	����: " + cm3.age);
	}
}





/*
Ŭ���� = ����ȭ. 
�������� ����? ��ü �ʱ�ȭ (Garbage ���� ���ش�)
1. Ŭ������� �����ϴ� 
2. ����Ÿ���� ���� 
3. �����ڰ� �ϳ��� ���� ��, �ڵ����� default ������ ȣ�� 
*/