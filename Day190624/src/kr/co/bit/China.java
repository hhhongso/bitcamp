package kr.co.bit;

public class China {

	protected int za = 500; 
	protected int zzam;
	protected int tang;
	protected int total;
	

	public int getTotal() {
		int total = za + zzam + tang; 
		return total;
	}
	
	public China(int za, int zzam, int tang) {
		this.za = za;
		this.zzam = zzam;
		this.tang = tang;
	}

	public China() {
	}

	public int getZa() {
		return za;
	}

	public void setZa(int za) {
		this.za = za;
	}

	public int getZzam() {
		return zzam;
	}

	public void setZzam(int zzam) {
		this.zzam = zzam;
	}

	public int getTang() {
		return tang;
	}

	public void setTang(int tang) {
		this.tang = tang;
	}

	@Override
	public String toString() {
		return "China [za=" + za + ", zzam=" + zzam + ", tang=" + tang + ", total=" + total + "]";
	}
}
