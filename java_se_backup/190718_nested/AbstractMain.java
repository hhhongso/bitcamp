class AbstractMain {
	public static void main(String[] args)	{
		AbstractTest at = new AbstractTest(){ // �͸� inner class $1(�̸��� ������ ��ȣ�� ǥ��)
			@Override
			public void setName(String name){
				this.name = name; 
			}
		};

		InterA ia = new InterA(){ // �͸� inner class $2
			@Override
			public void aa(){}
			@Override
			public void bb(){}		
		};

		AbstractExam ae = new AbstractExam(){}; // �͸� inner class $3
	}
}


/*
�߻�Ŭ����/�������̽��� new �� �� ������
1. �޼ҵ� ���
2. sub class ��� (�ݵ�� �߻�޼ҵ带 �������̵� �� �־�� ��)
3. �͸� Ŭ���� ���: �ڽ� Ŭ������ �ƴ����� �ݵ�� �߻�޼ҵ带 �������̵� �� �شٸ� ��ü ���� �� �� ����. 

�߻�޼ҵ带 ������ �� �ִ� body�� �����ٸ� == (Ŭ������ �̸��� ���) Ŭ����.
*/