package kr.co.bit;
					//선언하는 문자는 대/소 무엇이든 상관 없으나, 관례적으로 대문자를 사용
public class Product<T, M> {
	private T kind; 
	private M model;
	
	public T getKind() {
		return kind;
	}
	public void setKind(T kind) {
		this.kind = kind;
	}
	public M getModel() {
		return model;
	}
	public void setModel(M model) {
		this.model = model;
	} 
	
	
}
