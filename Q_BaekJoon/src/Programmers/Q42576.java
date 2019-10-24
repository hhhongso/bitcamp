package Programmers;

import java.util.Arrays;

public class Q42576 {

	   public String solution(String[] participant, String[] completion) {
	        String answer = "";
	        String temp="";
	        Arrays.sort(participant);
	        Arrays.sort(completion);
	        for(int i=0; i< completion.length; i++){
	            if(!completion[i].equals(participant[i])){
	                temp = participant[i];
	                break;
	            }               
	        }
	        if(!temp.equals("")) answer = temp; 
	        else answer = participant[participant.length-1];
	        return answer;
	    }
	
	public static void main(String[] args) {
		Q42576 q = new Q42576();
		String[] participant = {"Karl", "Marx", "Becky", "Jeanne"};
		String[] completion = {"Marx", "Becky", "Jeanne"};
		q.solution(participant, completion);
		
		int[] array = {1, 2, 3 , 4 ,5};
	

	}

}
