package Prac0621.Mcd;

public class McProcess {
	public McDomain[] mc; 
	
	public McProcess() { // �ʱ�ȭ 
	mc = new McDomain[5];
	mc[0] = new McDomain("A", 500, 5);
	mc[1] = new McDomain("B", 1500, 4);
	mc[2] = new McDomain("C", 3500, 6);
	mc[3] = new McDomain("D", 4500, 1);
	mc[4] = new McDomain("E", 5000, 2);	
	}
	
	public boolean mcProcess(String productName) { // �Լ� 	
		boolean selectResult = false;
			//���ð��� �迭 �ȿ� ������ true �ϰ� ���� ȣ�� 
			// �ƴϸ� �����ϴ�. 
			for(int i = 0 ; i <mc.length; i++) {
				if (mc[i].getProductName().equals(productName)) {
					printInfo(mc[i]);
					selectResult = true;
				}
			}
			return selectResult;		
		}
	

	private void printInfo(McDomain mcDomain) {
		System.out.println(mc.toString());
		
	}
	
	

}
