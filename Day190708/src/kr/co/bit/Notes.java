package kr.co.bit;

public class Notes {

	/*
	 * 가변인자: method(...~) {}
	 * 
	 * JVM 의 메모리영역
	 * class heap stack pcRegister NativeMethod
	 * 					-> 스레드		-> APP통신
	 * 클래스에는 
	 * 1. 정적 영역(static) **static int a; 라고 스태틱 선언하는 것은 위험 ==> 변수가 바뀔 때마다 메모리 영역을 차지하게 됨(final을 붙인다면 OK)** 
	 * 2. 클래스 정보
	 * 3. main 정보
	 * 4. 프로그램이 끝날 때 소멸한다. 
	 * 
	 * 힙 에는 
	 * 1. 레퍼런스 타입의 실제 주소. (new 연산자를 통해 만든 객체의 주소-> stack의 일정 부분 가리키기 위한)
	 * 2. Garbage Collector(GC): JVM에서 사용하지 않는 것으로 여겨지는 인스턴스를 강제 누락(삭제)시킴 (==> 메모리 확보)  
	 * 
	 * 스택 에는
	 * 1. 메소드 내의 모든 코드 : 메소드의 로직이 끝났을 때, 스택에 있는 메모리는 반환된다. 
	 * 2. 선입후출
	 */
	
	
	/*
	 * Annotaion @MyAnnotation1
	 * 주석용도. 
	 */
	
	/* 제네릭: 컬렉션 안에서 사용할 타입 제한 (<String, Integer>)
	 * 
	 * 내부 클래스: 클래스 안에 클래스 정의하기  (인스턴스 클래스, 스태틱 클래스, 지역 클래스, *익명 클래스*)
	 * 컨벤션 규칙 상, 하나의 파일에는 하나의 클래스만 들어가야 하기 때문에, 내장 클래스를 많이 사용하지는 않는다. 
	 * 
	 */
}