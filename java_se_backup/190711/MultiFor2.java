class MultiFor2 {
	public static void main(String[] args) {
		int i, j;
		for(i = 2; i <=9 ; i++){
			for(j = 1; j <=9; j++){
				System.out.print(i + " * " + j + " = " + i*j +"\t");
				if(j % 5 == 0) System.out.println();

			}
			System.out.println("\n");
		}
	}
}
