package kr.co.bit;

public class MaccaProcess {
	public Macca[] macca; // Macca Ŭ������ �迭�� ������ 
	
	public MaccaProcess() {
		macca = new Macca[5];
		macca[0] = new Macca("��Ƣ", 500, 1, 500); // �ܰ�*���� = �ݾ�
		macca[1] = new Macca("���", 5000, 2, 10000);
		macca[2] = new Macca("���̴�", 1000, 2, 2000);
		macca[3] = new Macca("������", 700, 4, 2800);
		macca[4] = new Macca("���ǹ�", 3000, 5, 15000);
	}
	
	public boolean productProcess(String productName) {
		boolean searchResult = false; 
		for (int i = 0; i < macca.length; i++) {
			if(macca[i].getProductName().equals(productName)) {
				productdisp(macca[i]);
				searchResult = true;
			}
		}
		return searchResult;
	}

	private void productdisp(Macca macca) {
		System.out.println("��ǰ�̸�: " + macca.getProductName());
		System.out.println("�ܰ�: " + macca.getProductDan());
		System.out.println("����: " + macca.getProductSu());
		System.out.println("�Ѱ���: " + macca.getProductMoney());
		
	}
	
}
