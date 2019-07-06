package kr.co.bit;
// 읽고 쓰기가 모두 가능한 RandomAccessFile 클래스. 
// pointer를 사용해서 작업할 위치를 자유롭게 조정할수 있다.  

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessTest {

	public static void main(String[] args) {
		RandomAccessFile raf = null; 
		try {							//텍파에서는 ASCI code 값으로 출력됨
										//mode: r(읽기), rw(읽고쓰기), rws(출력한 내용이 파일에 즉시 반영, i/o를 줄일수 있다. 파일의 내용과 상태정보가 같이 변경)
			raf = new RandomAccessFile("C:\\Users\\bitcamp\\Documents\\GitHub\\bitcamp\\Day190705\\src\\kr\\co\\bit\\randomTest.txt", "rw");
			System.out.println("시작파일 포인터" + raf.getFilePointer()); // 0
			raf.writeInt(70); //
			raf.writeBoolean(true); //(8byte)
			raf.writeChar('a'); //
			raf.writeLong(1000); //
			System.out.println("데이터출력 후 파일 포인터" + raf.getFilePointer()); // 상기 사용한 byte만큼 포인터 이동했을 것
			raf.seek(0); // 포인터를 0으로 재조정 
			
			System.out.println(raf.readInt());
			System.out.println(raf.readBoolean());
			raf.skipBytes(2); // 현재 위치에서 지정한 값만큼 skip
			System.out.println(raf.readLong());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				raf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
