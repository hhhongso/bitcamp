package kr.co.bit.obj;

import java.io.ByteArrayInputStream;

public class ByteArrayInputStreamTest {

	public static void main(String[] args) {
		byte[] data = new byte[] {10, 20, 30, 40}; //{}���� �迭�� ���� �ʱ�ȭ
		ByteArrayInputStream bais = new ByteArrayInputStream(data);
		
		int var_readbyte = -1;
		while((var_readbyte = bais.read()) != -1) {
			System.out.print(var_readbyte);
		}

	}

}
