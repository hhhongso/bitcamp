package kr.co.bit;

public class BusanChina extends China {
	protected int samzzam;


	@Override
	public int getTotal() {
		return super.getTotal() + samzzam;
	}

	public BusanChina(int za, int zzam, int tang, int samzzam) {
		super(za, zzam, tang);
		this.samzzam = samzzam;
	}

	public BusanChina() {
		super();
	}

	public int getSamzzam() {
		return samzzam;
	}

	public void setSamzzam(int samzzam) {
		this.samzzam = samzzam;
	}

	@Override
	public String toString() {
		return super.toString() + "	BusanChina [samzzam=" + samzzam + "]";
	}
	
}
