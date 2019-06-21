package kr.co.bit;

public class For_Test7_aaa {

	public static void main(String[] args) {
			aaa: for(char c = 'A'; c <= 'C'; c++) {
				for(int x = 1; x <=3; x++) {
					if(x == 2) 
						continue; //2에 해당하는 것은 실행하지 않고 for문으로 올라가 x++ 
					if(c == 'B')
						continue aaa; // B에 해당하는 것을 실행하지 않고 aaa 라벨로 올라가 c++ 실행 
					System.out.println("c=" +c+ ", x= " +x);
				}
			}
	}
}
			
			
			/*(int x = 1; x <= 3; x++) {
				System.out.println(x);
				if (x == 2) {
					continue; // 2에 해당하는 코드를 실행하지 않고 강제로 증감치로 올라간다. 
			} 
			System.out.println(x);
			}*/
