package kr.co.bit;

public class ZajangProcess {

	//�迭 ����
	public ZajangDomain[] zang;
	
	public ZajangProcess () {
		zang = new ZajangDomain[5]; // ������ �Լ� ZajangProcess �ȿ��� zang �� �ʱ�ȭ 
		zang[0] = new ZajangDomain("�Ｑ¥��", 8000, 5, 40000); 
		zang[1] = new ZajangDomain("����¥��", 9000, 2, 18000); 
		zang[2] = new ZajangDomain("¥������", 7000, 3, 21000); 
		zang[3] = new ZajangDomain("¥��", 5000, 5, 25000); 
		zang[4] = new ZajangDomain("«¥��", 6000, 1, 6000); 
	}

		// �迭�� ������ ������ ��� �ϴ� �Լ� �� ���� �� 
		
		public boolean productProcess(String productName) { //[5]
			boolean searchResult = false;
			for(int i = 0 ; i < zang.length; i++) {
				if (zang[i].getProductName().equals(productName)) {
					productDisp(zang[i]);
					searchResult = true; 
					
				}
		}
			return searchResult; 
	}

	/*
	 * ���ڿ������� Ŭ���� (������ ������) =null; 
	 * ������ ���� ���� �ʱ�ȭ�ִ� ���� ���� �����͸� �Ѱ����� 
	 * �� ���� �����ϱ� NullpointerExeption
	 */

								//Ŭ����       ��ü
	private void productDisp(ZajangDomain zang) {
		System.out.println(zang.toString());
		System.out.println("��ǰ �̸�: " + zang.getProductName());
		System.out.println("��ǰ �ܰ�: " + zang.getProductDan());
		System.out.println("��ǰ ����: " + zang.getProductSu());
		System.out.println("��ǰ �Ѿ�: " + zang.getProductMoney());
		
	}
}
