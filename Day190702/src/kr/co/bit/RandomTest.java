package kr.co.bit;
/*
 * seed���� �����ϰ� ���� >> random ���� �ݺ��ص� ������ ���� �����ȴ�. 
 * ��ǻ�ʹ� ������ �׳� �����ϴ� ���� �ƴ� ���� ���� �˰����� ����� ������ �����Ѵ�.
	�� �� �� ���� �˰��� �����ϱ� ���� ���� ���� Seed(����)�̶� �θ���.
 */
import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		Random random = new Random();
		System.out.println(random.nextInt(101));
		
		Random r1 = new Random(5); // seed = 5;
		Random r2 = new Random(1);
		for(int i = 0; i < 9; i++) {
			System.out.println(r1.nextInt());
		}
		System.out.println();
		for(int i = 0; i < 9; i++) {
			System.out.println(r2.nextInt());
		}

	}

}
