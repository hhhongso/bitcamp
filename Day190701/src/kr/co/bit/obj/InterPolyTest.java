package kr.co.bit.obj;

public class InterPolyTest {

	public static void main(String[] args) {
		CommandProcess cp = new CommandProcess();
		WriteCommand wc = new WriteCommand(); 
		ListCommand lc = new ListCommand();
		
		cp.process(wc);
		cp.process(lc);
	}

}