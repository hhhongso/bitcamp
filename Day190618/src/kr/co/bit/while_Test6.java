package kr.co.bit;
// Ƚ���� ������ �ݺ����� while�� �̿��Ͽ� ����� ���� ������, 
// �����ڰ� ���۰�, ������, ������ ��� �ڵ忡�� �����Ͽ� �־�� �ϴ� ���ŷο��� �ִ�.  
public class while_Test6 {

	public static void main(String[] args) {
		int i = 1;
		int j = 1; 
		while(i <= 9) {
			while(j <= 9) {
				System.out.print(i + "X" + j + "=" + i*j +"\t");
				j++;
			}
			System.out.println();
			i++; 
			j = 1; 
		}

	}

}
