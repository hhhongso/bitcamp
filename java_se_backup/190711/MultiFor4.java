/* 3중 for문, if문으로 구구단을 3단씩 잘라서 출력 [10줄 이내]

2 3 4단 

5 6 7단

8 9  단

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

/* h로 변수 n 대신하기 
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