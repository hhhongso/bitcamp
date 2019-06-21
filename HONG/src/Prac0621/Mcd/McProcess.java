package Prac0621.Mcd;

public class McProcess {
	public McDomain[] mc; 
	
	public McProcess() { // 초기화 
	mc = new McDomain[5];
	mc[0] = new McDomain("A", 500, 5);
	mc[1] = new McDomain("B", 1500, 4);
	mc[2] = new McDomain("C", 3500, 6);
	mc[3] = new McDomain("D", 4500, 1);
	mc[4] = new McDomain("E", 5000, 2);	
	}
	
	public boolean mcProcess(String productName) { // 함수 	
		boolean selectResult = false;
			//선택값이 배열 안에 있으면 true 하고 값을 호출 
			// 아니면 없습니다. 
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
