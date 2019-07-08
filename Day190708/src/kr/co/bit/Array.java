package kr.co.bit;

import java.util.Scanner;

public class Array {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt(); 
		int num[] = new int[N];		
		int minNum = 10000000;
		int maxNum =-10000000; 
		
		for(int i = 0; i < num.length ; i++) {
			num[i] = scan.nextInt();
		}
		for(int j : num) {// [확장 for문] num의 모든 값을 순회하여, int j 에 대입한다. 
			if(j > maxNum) {
				j = maxNum;
			}
			if(j < minNum) {
				j = minNum;
			}
		}
		System.out.println(minNum + "" + maxNum);
	}

}
