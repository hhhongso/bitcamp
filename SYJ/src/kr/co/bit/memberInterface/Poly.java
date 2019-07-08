package kr.co.bit.memberInterface;

import java.io.IOException;

public class Poly {
	public void process(Process p) {
		try {
			p.process();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public void printMember(PrintMember pm) {
		pm.printMembers();
	}

	public void printMember(Insert i) {
		try {
			i.insertData();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public void changeSessionStatus(Session s) {
		s.changeSessionStatus();
	}
}
