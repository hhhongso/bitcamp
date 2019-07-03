package kr.co.bit.obj;

import java.io.IOException;

public class InputStream {

	public static void main(String[] args) {
		int var_byte = -1;
		System.out.println("문자 하나를 입력하세요. ");
		
		do {
			try {
				var_byte = System.in.read(); // 문자하나를 읽어옴 인데 왜 문자열도 가능한지 ?
			} catch (IOException e) {
				e.printStackTrace();
			} 
			
			if(var_byte == 10 || var_byte == 13) // 10, 13 = enter값
				continue;
			if(var_byte == '*')
				break; 
			System.out.println("읽은값: " + (char)var_byte); // var_byte는 정수형 - (char)으로 형변환
		} while(true);

	}

}
