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
	} // ��� ������ ���� ���ڸ� �Է��� ���� ������, ��ӹ޴� China Ŭ������ �ʱ�ȭ���� ��� 0 �̶��, �����Ͱ� �θ� Ŭ�������� ���ٰ� �ٽ� �������� ������ ���������� �θ�Ŭ������ �ʱⰪ�� 0�� ��µȴ�. 

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
