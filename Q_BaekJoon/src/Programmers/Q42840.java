package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q42840 {
	public int[] solution(int[] answer) {
		int[] player1 = {1, 2, 3, 4, 5};
		int[] player2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] player3 = {3, 3, 1, 1, 2, 2, 4 , 4, 5, 5};
		answer = new int[] {0, 0, 0};
		
		
		for (int i = 0; i < answer.length; i++) {
			if(answer[i] == player1[i%5]) answer[0]++; 
			if(answer[i] == player2[i%8]) answer[1]++; 
			if(answer[i] == player3[i%10]) answer[2]++; 		
		}
		
		int maxNum = 0;
		for (int i : answer) {
			if(maxNum < i) maxNum = i; 
		}
		
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < answer.length; i++) {
			if(answer[i] == maxNum) list.add(i+1); 
			// answer[i] 번째가 제일 많이 맞춤 => list에 해당 플레이어의 번호(1 or 2 or 3) 을 add. 
		}
		int[] temp = new int[list.size()];
		for (int i = 0; i < temp.length; i++) {
			temp[i]= list.get(i);
			
		}
		return temp; 
	}

	public static void main(String[] args) {
		Q42840 q = new Q42840();
		int[] answer = {1, 3, 2, 4, 2};
		int[] answer2 = q.solution(answer);
		for (int i = 0; i < answer2.length; i++) {
			System.out.print(answer2[i]);
			
		}
		
		

	}

}
