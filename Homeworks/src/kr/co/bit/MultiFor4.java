package kr.co.bit;

public class MultiFor4 {

	public static void main(String[] args) {
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
