package kr.co.bit;

public class For_Test7_aaa {

	public static void main(String[] args) {
			aaa: for(char c = 'A'; c <= 'C'; c++) {
				for(int x = 1; x <=3; x++) {
					if(x == 2) 
						continue; //2�� �ش��ϴ� ���� �������� �ʰ� for������ �ö� x++ 
					if(c == 'B')
						continue aaa; // B�� �ش��ϴ� ���� �������� �ʰ� aaa �󺧷� �ö� c++ ���� 
					System.out.println("c=" +c+ ", x= " +x);
				}
			}
	}
}
			
			
			/*(int x = 1; x <= 3; x++) {
				System.out.println(x);
				if (x == 2) {
					continue; // 2�� �ش��ϴ� �ڵ带 �������� �ʰ� ������ ����ġ�� �ö󰣴�. 
			} 
			System.out.println(x);
			}*/
