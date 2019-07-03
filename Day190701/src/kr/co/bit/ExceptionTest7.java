package kr.co.bit;

public class ExceptionTest7 {

	public static void main(String[] args) {	
			try {
				if(args.length !=2) {
					ArgsException ae = new ArgsException("인자를 두 개 입력하여야 합니다.");
					ae.setArgsNumber(args.length);
					throw ae;
				}
				else {
					int num1 = Integer.parseInt(args[0]);
					int num2 = Integer.parseInt(args[1]);
					System.out.println(num1 + "+" + num2 + "=" + (num1+num2));
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ArgsException e1) {
				System.out.println(e1.getMessage());
				System.out.println("당신이 입력한 인자값은"+ e1.getArgsNumber()+"개");
			}
	
	}

}
