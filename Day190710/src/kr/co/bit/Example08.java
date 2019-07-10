package kr.co.bit;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public class Example08 {
	public static void main(String[] args) {
		System.out.println("7bytes 크기의 버퍼 생성");
		ByteBuffer buffer = ByteBuffer.allocateDirect(7);
		buffer.put((byte)10);
		buffer.put((byte)11);
		buffer.put((byte)12);
		buffer.put((byte)13);
		buffer.put((byte)14);
		buffer.flip();
		printState(buffer);
		
		buffer.get(new byte[3]);
		System.out.println("3bytes 읽음: ");
		printState(buffer);
		
		buffer.compact();
		System.out.println("compact() 실행 후: "); //현 포지션의 위치를 중심으로, 그 뒤의 모든 글자를 끌어올려 현재 있는 버퍼의 처음부터 다시 씀. 끌어올려진 다음, 다시 처음부터 시작할 때 포지셔닝+1. 
		printState(buffer);
	}
	
	
	public static void printState(ByteBuffer buffer) {
		System.out.print(buffer.get(0) + ", ");
		System.out.print(buffer.get(1) + ", ");
		System.out.print(buffer.get(2) + ", ");
		System.out.print(buffer.get(3) + ", ");
		System.out.println(buffer.get(4) + ", ");
		System.out.print("\t postition: " + buffer.position() + " ,");
		System.out.print("\t limit: " + buffer.limit() + " ,");
		System.out.println("\t capacity: " + buffer.capacity());
	}
}
