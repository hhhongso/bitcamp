package kr.co.bit;
// ������ ���⸦ ����ϱ�
public class Switch_test {

	public static void main(String[] args) {
		String operator = "!";
		switch(operator) {
		case "+":
			System.out.println(5+5);
			break;
		case "-":
			System.out.println(5-5);
			break;
		case "x": case "*": // caseA: caseB: (���޾� �ΰ��� case���� = if�� ||�� ����)
			System.out.println(5*5);
			break;
		case "/":
			System.out.println(5/5);
			break;
		case "%":
			System.out.println(5%5);
			break;
		default: System.out.println("�����ڰ� �����ϴ�. ");
		}

	}

}
