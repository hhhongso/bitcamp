package kr.co.bit;
// 람다식에는 인터페이스를 반드시 선언해주어야 함. 


public class Example08 {
	public static void main(String[] args) {
		RambdaInterface ri; 		
		ri = () -> { // ri = new RambdaInterface() {~~~ }; 이렇게 안하고 간략하게 !! 
			System.out.println("method call_1");
		};
		ri.method();
		
		ri = () -> System.out.println("method call_2"); // {}brace 없어도 가능 !!! ((((한줄로 나타낼 때))))
		ri.method();
		
		
		RambdaInterface2 ri2; 
		ri2 = (x) -> {
			int result = x * 5;
			System.out.println(result);
		};
		ri2.method(6); // x값 입력 
		
		ri2 = x -> System.out.println(x * 5); // {}, () 모두 생략 가능!! ((((한줄로 나타낼 때))))
		ri2.method(6);
		
		
		RambdaInterface3 ri3; 
		ri3 = (x, y) -> {
			int result = x + y; 
			return result;
		};
		System.out.println(ri3.method(2, 5));
		
		ri3 = (x, y) -> x + y; // 복수 인자값 람다식에서는,()는 생략불가! {}는 생략할 때, return type까지 생략해주어야 함  
		System.out.println(ri3.method(2, 5));
		
		ri3 = (x, y) -> sum(x, y);
		System.out.println(ri3.method(2, 5));
	}
	
	//만약 람다식 안의 구조를 한줄로 도저히 줄이기 어렵다면? 이와 같이 return 구현부 메소드를 따로 만들어두고 해당 메소드를 데려오면 된다.   
	public static int sum(int x, int y) {
		return x+y;
	}
}
