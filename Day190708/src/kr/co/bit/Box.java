package kr.co.bit;
//와일드카드는 실상 많이 쓰지는 않는다. 

public class Box<T> {
	private T t; //never know what T is >> 외부에서 T를 정의하여 사용 
	public T get() {
		return t;
	}
	
	public void set(T t) {
		this.t = t; 
	}
	
}
