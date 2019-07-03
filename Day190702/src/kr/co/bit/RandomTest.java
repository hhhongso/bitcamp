package kr.co.bit;
/*
 * seed값을 동일하게 지정 >> random 으로 반복해도 동일한 값이 유지된다. 
 * 컴퓨터는 난수를 그냥 생성하는 것이 아닌 난수 생성 알고리즘을 사용해 난수를 생성한다.
	이 때 이 난수 알고리즘 실행하기 위해 쓰는 수를 Seed(씨앗)이라 부른다.
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
