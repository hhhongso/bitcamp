class Variable2 { //Ŭ���� :==> heap ����
	int a; //�ʵ� -> �ʱ�ȭ �̹� �Ǿ�����. (0 / null) ==> heap ����
	static int b; // static: �� �� ����� ��ü ���� ���̵� �ٷ� ������ �� �� ����. Ŭ���� �ҼӸ� �˰� ������ �ȴ�. 
	String str; 

	public static void main(String[] args) { //static �Լ�: ����� ���ÿ� �޸𸮿� ������ ��.
		int a = 10; // ��������(���ú���), Garbage(�����Ⱚ) -> �ʱ�ȭ �ʿ� ==> static ����
		System.out.println("�������� a=" + a);
		System.out.println("�ʵ� a=" + new Variable2().a); //new �����ڸ� ���� ��ü ���� (�޴����� �������� ����� ����)
		System.out.println("�ʵ� b=" + b);
		System.out.println("�ʵ� str=" + new Variable2().str);

	}
}
