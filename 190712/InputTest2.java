class InputTest2 {
	public static void main(String[] args) throws java.io.IOException {
		System.out.print("���� �Է�: ");
		int data = System.in.read(); //read() �� ���ڸ� �޾ƿ´�. 
		System.in.read(); // \r �� �Ծ���� flush
		System.in.read(); // \n

		System.out.print("���� �Է�: ");
		int data2 = System.in.read();

		System.out.println(data +", " + data2);
	}
}

	//�ý��� Ŭ���� ����
		//�ƿ� �ʵ� [out�� returnType�� OutputStream Ŭ����]
			//�ʵ� ���� print �Լ�
		//�� �ʵ�[InputStream �߻� Ŭ����]
			
/*Enter�� ��� 
1) \r �� �� ������
2) \n �� �ٲٱ�
*/