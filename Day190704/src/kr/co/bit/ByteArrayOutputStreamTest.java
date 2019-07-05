package kr.co.bit;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayOutputStreamTest {

	public static void main(String[] args) {
		String msg = "byteArray outputStream_test_bit";
		ByteArrayOutputStream baout = null; 
		
		try {
			baout= new ByteArrayOutputStream();
			baout.write(msg.getBytes());
			System.out.println(baout);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				baout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
