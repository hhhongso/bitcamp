package Questions;

import java.util.Scanner;

public class Q10809 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String word = scan.next();
		String alp = "abcdefghijklmnopqrstuvwxyz";
		for (int i = 0; i < word.length(); i++) {
			int a = word.charAt(i) - 97;
			if(!alp.contains(word.charAt(i)+"")) {
				a = -1; 
			}
			
			System.out.print(a);				
			
		}
	}

}

