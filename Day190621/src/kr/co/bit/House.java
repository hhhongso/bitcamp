package kr.co.bit;

public class House {
	public int price; 
	public int size; 
	public String dong; 
	public String kind; 
	
	@Override
	public String toString() {
		return "House [가격=" + price + ", 평수=" + size + ", 동=" + dong + ", 종류=" + kind + "]";
	}


	public House() { //생성자 함수 안에서 
		this(100, 32, "동판교", "아파트"); // 생성자 함수를 또 불러온다. 
	}
	
	/* 상기 this() 함수를 사용하지 않는다면, 아래와 같이 this.변수 = 로 하나씩 다 초기화를 초기화 시켜줘야 하는 번거로움. 
	 * public House () {
	 * this.price = 100; 
	 * this.size = 32;
	 * this.dong = "동판교" ;
	 * this.kind = "아파트";
	 */
	
	public House(int price) { // house2에 사용중
		this(price, 32, "동판교", "빌라");
			//초기화	
	}
	
	public House(int price, int size) {
		this(price, size, "동판교", "주택");
			//초기화, 초기화	
	}
	
	public House(int price, int size, String dong) {
		this(price, size, dong, "아파트");
	}
	
	public House(int price, int size, String dong, String kind) { // house 클래스의 생성자함수
		this.price = price; 
		this.size = size; 
		this.dong = dong; 
		this.kind = kind; 
	}


	public static void main(String[] args) {
		House house1 = new House(); // public House()안에 파라미터는 없지만, this()로 생성자함수를 가져왔으니 { this(100.32.동판교.아파트) } 가 불러옴
		System.out.println(house1.toString());
		
		House house2 = new House(1000);
		System.out.println(house2.toString());
		
		House house3 = new House(10000, 55);
		System.out.println(house3.toString());
		
		House house4 = new House(10, 50, "서초동");
		System.out.println(house4.toString());
		
		House house5 = new House(100, 50, "서초동", "빌라");  // this 안쓰고 house 생성자함수 그대로 가져욤
		System.out.println(house5.toString());
	}
}
