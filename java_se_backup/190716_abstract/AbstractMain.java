class AbstractMain extends AbstractTest {
	@Override
	public void setName(String name){
		this.name = name; 
	}

	public static void main(String[] args) {
					//�߻�Ŭ������ new������ �Ұ��ϱ� ������, �θ� Ŭ������ new �Ͽ� �ڽ� Ŭ������ �����Ѵ�. [Upcasting]
		AbstractTest at = new AbstractMain(); 
		at.setName("����");
		System.out.println("�̸�: " + at.getName());
	}
}

/* �߻�Ŭ������ new ���� �Ұ�
- sub class �� �̿��Ͽ� new �����Ѵ�. �ݵ�� sub class�� �߻� �޼ҵ带 �������̵�[�籸��]�Ͽ��� �Ѵ�. 
- �޼ҵ带 �̿��Ͽ� new �����Ѵ�.
*/