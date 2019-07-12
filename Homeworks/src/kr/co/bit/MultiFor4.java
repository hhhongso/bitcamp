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
		
		/*
		int h, i, j;
		int n =2;
		for(h = 1; h <= 3; h++) {
			for(j = 1; j <=9 ; j++){
				if(n <= 4) {
					for(i = n; i <=4; i++){
						System.out.print(i + " * " + j + " = " + i*j +"\t");
					}						
				}
				else if (n >= 5 && n <= 7) {
					for(i = n; i <= 7; i++){
						System.out.print(i + " * " + j + " = " + i*j +"\t");	
					}
				} 
				else if (n >=8 && n <= 9) {
					for(i = n; i <=9; i++){
						System.out.print(i + " * " + j + " = " + i*j +"\t");	
					}
				}				
				System.out.println();	
			}
			n += 3;
			System.out.println();
	}
	*/
	
	}
}
