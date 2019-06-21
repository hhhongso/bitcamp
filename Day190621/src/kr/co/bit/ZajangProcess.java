package kr.co.bit;

public class ZajangProcess {

	//배열 선언
	public ZajangDomain[] zang;
	
	public ZajangProcess () {
		zang = new ZajangDomain[5]; // 생성자 함수 ZajangProcess 안에서 zang 을 초기화 
		zang[0] = new ZajangDomain("삼선짜장", 8000, 5, 40000); 
		zang[1] = new ZajangDomain("유니짜장", 9000, 2, 18000); 
		zang[2] = new ZajangDomain("짜장곱배기", 7000, 3, 21000); 
		zang[3] = new ZajangDomain("짜장", 5000, 5, 25000); 
		zang[4] = new ZajangDomain("짬짜면", 6000, 1, 6000); 
	}

		// 배열을 돌려서 있으면 출력 하는 함수 를 만들 자 
		
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
	 * 문자열변수나 클래스 (참조형 변수는) =null; 
	 * 변수에 값이 없고 초기화있는 곳에 무언가 포인터를 넘겼으면 
	 * 찍어낼 값이 없으니까 NullpointerExeption
	 */

								//클래스       객체
	private void productDisp(ZajangDomain zang) {
		System.out.println(zang.toString());
		System.out.println("상품 이름: " + zang.getProductName());
		System.out.println("상품 단가: " + zang.getProductDan());
		System.out.println("상품 수량: " + zang.getProductSu());
		System.out.println("상품 총액: " + zang.getProductMoney());
		
	}
}
