/* 3�� for��, if������ �������� 3�ܾ� �߶� ��� [10�� �̳�]

2 3 4�� 

5 6 7��

8 9  ��

*/

class MultiFor4 {
	public static void main(String[] args)	{
		int h, i, j;
		int n = 2; 
		
		for(h = 1; h <= 3; h++) {
			for(j = 1; j <=9 ; j++){
				for(i = n; i <=n+2; i++){
					if(i == 10) break;
					System.out.print(i + " * " + j + " = " + i*j +"\t");
				}
				System.out.println();
			}
			n +=3; 
			System.out.println();
		}
	}
}

/* h�� ���� n ����ϱ� 
	for(h = 2; h <= 8; h+=3) { // k = 2,5,8
		for(j = 1; j <=9 ; j++){
			for(i = k; i <=k+2; i++){
				if(i != 10)
					System.out.print(i + " * " + j + " = " + i*j +"\t");
				}
				System.out.println();
			}
			System.out.println();
	}

*/