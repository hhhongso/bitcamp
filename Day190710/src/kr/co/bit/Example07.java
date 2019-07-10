package kr.co.bit;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public class Example07 {
	public static void main(String[] args) {
		System.out.println("7byte 크기의 버퍼 생성");
		ByteBuffer buffer = ByteBuffer.allocateDirect(7);
		printState(buffer);
		
		buffer.put((byte)10);
		buffer.put((byte)11);
		System.out.println("2bytes 저장 후: ");
		printState(buffer); // position 이 값이 쓰여진 만큼 이동 
	
		buffer.put((byte)12);
		buffer.put((byte)13);
		buffer.put((byte)14);
		System.out.println("3bytes 저장 후: ");
		printState(buffer); 
		
		buffer.flip();
		System.out.println("flip() 실행 후 포인터의 변화: ");
		printState(buffer); // limit이 포지션이 있던 자리로 감 
		
		buffer.get(new byte[3]); 
		System.out.println("3bytes 읽은 후: ");
		printState(buffer);
		
		buffer.mark();
		System.out.println("==현재 위치를 마크==");
		
		buffer.get(new byte[2]);
		System.out.println("2bytes 읽은 후: ");
		printState(buffer);
	
		buffer.reset(); //리셋하면 마킹한 자리로 포지션. 만일 mark 없이 reset 시 원상태(0)으로 리셋.
		System.out.println("==position 을 mark 위치로 옮김==");
		printState(buffer);
		
		buffer.rewind();
		System.out.println("rewind() 실행 후: 포지션이 처음으로 리셋됨.");
		printState(buffer);
		
		buffer.clear();
		System.out.println("clear() 실행 후: 모든 것이 처음으로 초기화 ");
		printState(buffer);
	} 
	
	public static void printState(Buffer buffer) {
		System.out.print("\t postition: " + buffer.position() + " ,");
		System.out.print("\t limit: " + buffer.limit() + " ,");
		System.out.println("\t capacity: " + buffer.capacity());
	}
}
/*
position: 현재 읽거나 쓰는 위치값(가장 처음에 위치하는 포인터. 이를 기준으로 읽기/쓰기를 시작) limit 위치와 같아지면 더이상 데이터를 읽고 쓰지 못하며, 넘어갈 수 없다.
limit: 버퍼에서 읽거나 쓸 수 있는 위치의 한계. capacity보다 작거나 같다. 
capacity: 버퍼의 최대 데이터 개수(버퍼의 크기, 메모리 크기) !!인덱스 값이 아니라, 수량 ! 
mark: 돌아오는 위치를 지정 시, mark 한 포인터 쪽으로 이동시킨다. 
*/