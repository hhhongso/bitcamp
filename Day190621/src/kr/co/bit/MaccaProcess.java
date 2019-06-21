package kr.co.bit;

public class MaccaProcess {
	public Macca[] macca; // Macca 클래스를 배열로 가져옴 
	
	public MaccaProcess() {
		macca = new Macca[5];
		macca[0] = new Macca("감튀", 500, 1, 500); // 단가*수량 = 금액
		macca[1] = new Macca("빅맥", 5000, 2, 10000);
		macca[2] = new Macca("사이다", 1000, 2, 2000);
		macca[3] = new Macca("초코콘", 700, 4, 2800);
		macca[4] = new Macca("해피밀", 3000, 5, 15000);
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
		System.out.println("제품이름: " + macca.getProductName());
		System.out.println("단가: " + macca.getProductDan());
		System.out.println("수량: " + macca.getProductSu());
		System.out.println("총가격: " + macca.getProductMoney());
		
	}
	
}
