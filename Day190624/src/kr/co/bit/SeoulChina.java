package kr.co.bit;

public class SeoulChina extends China {
	protected int jangza;


	@Override
	public int getTotal() {
		return super.getTotal() + jangza;
	}

	public SeoulChina(int za, int zzam, int tang, int jangza) {
		super(za, zzam, tang);
		this.jangza = jangza;
	} // 상기 변수에 직접 숫자를 입력할 수는 있으나, 상속받는 China 클래스의 초기화값이 모두 0 이라면, 포인터가 부모 클래스까지 갔다가 다시 내려오기 때문에 최종적으로 부모클래스의 초기값인 0이 출력된다. 

	public SeoulChina() {
		super();
	}

	public int getJangza() {
		return jangza;
	}

	public void setJangza(int jangza) {
		this.jangza = jangza;
	}
	

	@Override
	public String toString() {
		return super.toString() + "	SeoulChina [jangza=" + jangza + "]";
	}
}
