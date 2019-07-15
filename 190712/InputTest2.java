class InputTest2 {
	public static void main(String[] args) throws java.io.IOException {
		System.out.print("문자 입력: ");
		int data = System.in.read(); //read() 한 글자만 받아온다. 
		System.in.read(); // \r 을 먹어가도록 flush
		System.in.read(); // \n

		System.out.print("문자 입력: ");
		int data2 = System.in.read();

		System.out.println(data +", " + data2);
	}
}

	//시스템 클래스 안의
		//아웃 필드 [out의 returnType이 OutputStream 클래스]
			//필드 안의 print 함수
		//인 필드[InputStream 추상 클래스]
			
/*Enter의 기능 
1) \r 줄 맨 앞으로
2) \n 줄 바꾸기
*/