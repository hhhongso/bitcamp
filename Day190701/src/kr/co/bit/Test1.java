package kr.co.bit;

public class Test1 {

	private String name; 
	public Test1() {
		name = "";
	}
	
	
	public void method() throws NullPointerException, SpaceException { // �ΰ� �̻��� ����Ŭ������ ���� ������ if ������ �ɾ��־�� 
		if(name == null) {
			throw new NullPointerException(); // throw �� ������ �߻���Ŵ
		}
		if(name.equals("")) { //������ ���� .equals("")
			throw new SpaceException("���� �Է� �� ����"); //���鿡 ���� ����ó���� ���� �����Ƿ� ���� ����� �־�� ��[����� ���� ����]
		}
	}
	public static void main(String[] args) {
		Test1 test1 = new Test1();
		try {
			test1.method();
		} catch (NullPointerException e1) {
			e1.printStackTrace();
		} catch (SpaceException e2) {
			e2.printStackTrace();
		}

	}

}
