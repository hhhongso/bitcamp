class InputTest {
	public static void main(String[] args) {
		for(int i = 0 ; i < args.length; i++){ //명령어 length
			System.out.println("args[" + i + "]= " + args[i]);
			System.out.println("첫번째 문자: " + args[i].charAt(0)); // 문자 하나를 가져오는 함수 .charAt()
			System.out.println("문자열의 길이(갯수): " + args[i].length()); // 함수 .length()

		}
		System.out.println();

		for(String data : args) { // 배열 속에서 데이터를 1개씩 data로 넘겨준다. 
			System.out.println("data= " + data);

		}
	}
}
