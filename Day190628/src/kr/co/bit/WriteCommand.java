package kr.co.bit;

public class WriteCommand extends Object implements Command {

	@Override
	public void execute() {
		System.out.println("글을 새로 작성한다. ");

	}

}
