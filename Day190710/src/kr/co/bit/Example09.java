package kr.co.bit;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class Example09 {
	public static void main(String[] args) {
		Charset charset = Charset.forName("UTF-8"); // charset의 형식 = UTF-8 으로 지원하겠다 라는 의미. 
		
		//문자열 인코딩 : binary <-> 문자열 간 변환의 표준 제공
		String data = "안녕";
		ByteBuffer bb = charset.encode(data); // 문자열 String data를 binary - bytebuffer 형태로 저장 [encoding]
		
		//decoding 시 charset이 반드시 필요하며, 반드시 동일한 charset이어야 한다. (UTF-8 = UTF-8!)
		//문자열 디코딩
		data = charset.decode(bb).toString(); // 데이터를 출력 
		System.out.println("문자열 복원: " + data);
		
		
	} 
}

