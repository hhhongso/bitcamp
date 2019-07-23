class SingleTon {
	private int num = 3; 
	private static SingleTon instance; 

	public static SingleTon getInstance(){
		if(instance == null) {
			synchronized(SingleTon.class) {
				instance = new SingleTon(); // null 일 때(초기화) 한번만 생성: heap영역에 생성 
			}
		}
		return instance;
	}

	public static void main(String[] args) {
		SingleTon cc = SingleTon.getInstance(); // new하지 말고, 함수로 처리. null 이면 static new 생성.
		cc.num++;
		System.out.println("cc: " + cc);
		System.out.println("num: " + cc.num);
		System.out.println();

		
		SingleTon dd = SingleTon.getInstance(); // != null 이면 만들어진 new 가져옴		
		dd.num++;
		System.out.println("dd: " + dd);
		System.out.println("num: " + dd.num);
		System.out.println();

	}
}

/* static
:메모리의 static 영역에 생성하여, 초기화 1번만 하고 계속 사용한다. 
*/