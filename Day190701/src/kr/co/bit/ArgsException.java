package kr.co.bit;

public class ArgsException extends Exception {
	private int argsNumber;

	public int getArgsNumber() {
		return argsNumber;
	}

	public ArgsException(String msg) {
		super(msg);
	}

	public void setArgsNumber(int argsNumber) {
		this.argsNumber = argsNumber;
	}

}
