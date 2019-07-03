package kr.co.bit.obj;

import java.io.ByteArrayInputStream;

public class ByteArrayInputStreamTest {

	public static void main(String[] args) {
		byte[] data = new byte[] {10, 20, 30, 40}; //{}으로 배열방 값을 초기화
		ByteArrayInputStream bais = new ByteArrayInputStream(data);
		
		int var_readbyte = -1;
		while((var_readbyte = bais.read()) != -1) {
			System.out.print(var_readbyte);
		}

	}

}
