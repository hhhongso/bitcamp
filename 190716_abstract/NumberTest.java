import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

class NumberTest {
	public NumberTest(){
		//3�ڸ�����, �Ҽ� ���� 3° �ڸ�����
		NumberFormat nf = new DecimalFormat(); // �ڽ�Ŭ������ DecimalFormat���� ������ ȣ�� 
		System.out.println(nf.format(12345678.456789));
		System.out.println(nf.format(12345678));
		System.out.println();
		
		//3�ڸ�����, �Ҽ� ���� 1° �ڸ�����. ��ȿ���ڸ� #�� ǥ���ص� �ڸ����� ���´� (�ݿø���)
		NumberFormat nf2 = new DecimalFormat("#,###.#��"); 
		System.out.println(nf2.format(12345678.456789));
		System.out.println(nf2.format(12345678));
		System.out.println();

		//3�ڸ�����, �Ҽ� ���� 2° �ڸ�����. .00 �̶�� ���� ��, ��ȿ���ڰ� �ƴϴ��� 0�� ����ش�. 
		NumberFormat nf3 = new DecimalFormat("#,###.00��"); 
		System.out.println(nf3.format(12345678.456789));
		System.out.println(nf3.format(12345678));
		System.out.println();

		//static �޼ҵ�� ������ �Լ� ȣ���ϱ�. 
//		NumberFormat nf4 = NumberFormat.getInstance();
		NumberFormat nf4 = NumberFormat.getCurrencyInstance();
		nf4.setMaximumFractionDigits(1); // �Ҽ��� ���� 1�ڸ������� ǥ���϶�
		nf4.setMinimumFractionDigits(1); // ��ȿ ���ڰ� ������ �ּ��� �Ҽ��� 1�ڸ��� ǥ���϶� 
		System.out.println(nf4.format(12345678.456789));
		System.out.println(nf4.format(12345678));
		System.out.println();

		NumberFormat nf5 = NumberFormat.getCurrencyInstance(Locale.US);
		nf5.setMaximumFractionDigits(5); // �Ҽ��� ���� 1�ڸ������� ǥ���϶�
		nf5.setMinimumFractionDigits(2); // ��ȿ ���ڰ� ������ �ּ��� �Ҽ��� 1�ڸ��� ǥ���϶� 
		System.out.println(nf5.format(12345678.456789));
		System.out.println(nf5.format(12345678));
		System.out.println();
	}

	public static void main(String[] args) {
		// �����ڸ� �ܹ߼����� ����Ѵٸ� ��ü��(nt) ���� new �� �� ����. ��� �� ������ ���� GC�� �����ȴ�. GC�� �����Ǵ� ���� ���α׷��� �Ͻ� �����ȴ�. 
		new NumberTest(); 
		
	}
}
