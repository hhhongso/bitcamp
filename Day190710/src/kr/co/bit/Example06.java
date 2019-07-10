package kr.co.bit;
//allocate

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;

public class Example06 {
	public static void main(String[] args) {
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100); // allocateDirect()의 수치는 1byte수치. 
		System.out.println("저장용량: " + byteBuffer.capacity());
		
		CharBuffer charBuffer = ByteBuffer.allocateDirect(100).asCharBuffer(); // char = 2bytes 
		System.out.println("저장용량: " + charBuffer.capacity());		
		
		IntBuffer intBuffer = ByteBuffer.allocateDirect(100).asIntBuffer(); // int = 4bytes
		System.out.println("저장용량: " + intBuffer.capacity());		
		
		ByteBuffer byteBuffer1 = ByteBuffer.allocate(100); // 다이렉트 버퍼가 아니라 non-direct버퍼로 allocate 됨.
		System.out.println("저장용량: " + byteBuffer1.capacity()); // 저장용량은 동일. 성격이 다른 것)
		
		byte[] byteArr = new byte[100];
		ByteBuffer byteBuffer2 = ByteBuffer.wrap(byteArr); // non-direct버퍼 -> wrap으로 감싼 후 선언할 수도 있음. 
		System.out.println("저장용량: " + byteBuffer2.capacity()); // 저장용량은 동일. 성격이 다른 것)
	}
}
