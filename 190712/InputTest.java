class InputTest {
	public static void main(String[] args) {
		for(int i = 0 ; i < args.length; i++){ //��ɾ� length
			System.out.println("args[" + i + "]= " + args[i]);
			System.out.println("ù��° ����: " + args[i].charAt(0)); // ���� �ϳ��� �������� �Լ� .charAt()
			System.out.println("���ڿ��� ����(����): " + args[i].length()); // �Լ� .length()

		}
		System.out.println();

		for(String data : args) { // �迭 �ӿ��� �����͸� 1���� data�� �Ѱ��ش�. 
			System.out.println("data= " + data);

		}
	}
}
