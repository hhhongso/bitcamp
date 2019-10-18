package Questions;

import java.util.Scanner;

public class Q11720 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		String sumNum = scan.next();
		int sum = 0; 
		
		for (int i = 0; i < num; i++) {
			sum += sumNum.charAt(i) - '0';
			//sum += Integer.parseInt(sumNum.split("")[i]);
		}
		System.out.println(sum);
	}

}
