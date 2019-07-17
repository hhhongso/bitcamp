package Problems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q15552 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
				try {
					int T = Integer.parseInt(br.readLine());
					
					for (int i = 0; i < T; i++) {
						String[] AB = br.readLine().split(" ");
						int result = Integer.parseInt(AB[0]) + Integer.parseInt(AB[1]);
						bw.write(result +"\n");
						bw.flush();
					}
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
 
}
