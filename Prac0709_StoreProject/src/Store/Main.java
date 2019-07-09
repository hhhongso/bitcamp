package Store;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static int orderA; //수량 
	public static int orderB; //수량 
	public static int orderC; //수량 
	public static int orderD; //수량
	
	public static final int priceA = 2000; //가격
	public static final int priceB = 2500;
	public static final int priceC = 3000;
	public static final int priceD = 3500;
	
	public static int cashSales; 
	public static int cardSales;
	public static int totalSales = cashSales + cardSales; //매출
	
	public static int stockA = 2;
	public static int stockB = 10;
	public static int stockC = 10;
	public static int stockD = 10;
	
	public static int seat = 1; 
	
	protected String protocol; 
	protected String iceOption;
	protected int seatOption;
	protected int payOption;
	
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println(orderA + "\t" + priceA + "\t" + cashSales + "\t" + totalSales + "\t" + stockA + "\t" + seat);
			try {
				System.out.println("===== 가게관리 =====");
				System.out.println("A. 주문관리 B. 재고관리 C. 매출관리 D. 매장관리 Z. 종료");
				String protocol = br.readLine();
				
				if(protocol.equalsIgnoreCase("A")) {
					System.out.println("메뉴 선택");
					System.out.println("a. 아메리카노 b. 카페라떼 c.수박주스 d.자몽에이드 z.선택 종료 ");
					protocol = br.readLine();
					if(protocol.equalsIgnoreCase("a")) {
							System.out.println("수량입력: ");
							int amount = Integer.parseInt(br.readLine());
							stockA = stockA - amount;
							if(stockA <= 0) {
								System.out.println("재고부족!!! "); 
							} else {
								
								System.out.println("주문OK. 현재 남은 재고는: " + stockA);
								
								
								System.out.println("1. EatHere / 2. ToGo");
								int seatOption = Integer.parseInt(br.readLine());
								if(seatOption == 1) {
									if(seat <=0) {
										System.out.println("좌석이 없습니다 !! ");
									} else {
										seat--;									
									}
								}
								System.out.println("금액: " + priceA*amount);
								System.out.println("결제방식: 1. 현금 2. 카드");
								int payOption = Integer.parseInt(br.readLine());
								if(payOption == 1) {
									cashSales += cashSales;
								} else {
									cardSales += cardSales;
								}
								System.out.println("총 매출액: " + totalSales);
								amount = 0; 
								orderA = 0;
								
								
							}
						
					}//a.아메리카노
				} // A 주문관리 
				else if (protocol.equalsIgnoreCase("B")) {
					
				} else if (protocol.equalsIgnoreCase("C")){
					
				} else if (protocol.equalsIgnoreCase("D")){
					
				} else if (protocol.equalsIgnoreCase("Z")) {
					System.out.println("시스템 종료");
					System.exit(0);
				} else {
					System.out.println("잘못 눌렀습니다. ");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}//while

	}

}
