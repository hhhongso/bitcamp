/*
for를 이용하여 합을 구하시오

[실행결과]
-1+2-3+4-5+6-7+8-9+10 = 5
*/

class ForTest2 {
	public static void main(String[] args) {
		int num = 1;
		int sumResult = 0;

		for(num = 1; num <= 10; num++){
			if(num % 2 == 1) { 
				System.out.print("-" + num); 
				sumResult -= num; 
			} else if(num % 2 == 0) { 
				System.out.print("+" + num); 
				sumResult += num; 
			}			
		}
		System.out.print("= " + sumResult);

	
}
}
