package Practice;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class PracticeMap {
	private Map<Integer, BigInteger> memoizeMap = new HashMap<Integer, BigInteger>();
	
	{
		memoizeMap.put(0, BigInteger.ZERO);
		memoizeMap.put(1, BigInteger.ONE);
		memoizeMap.put(2, BigInteger.ONE);
	}
	
	private BigInteger fibonacci(int n) {
		/* 1. containsKey(): int n 값을 key 로 포함하고 있는지 확인
		if(memoizeMap.containsKey(n)) return memoizeMap.get(n); 
		else {
			BigInteger result = fibonacci(n-1).add(fibonacci(n-2));
			memoizeMap.put(n, result);
			return result;
		}
		*/
		
		//2. computeIfAbsent(): 해당 키(n)이 있으면 get 하고, 없으면 put 한다. 
		// <-> computeIfPresent(): 키가 있으면 해당 메소드를 호출하여 (값을 변경, 변경된 value 값으로) 다시 put 한다. 키가 없으면 메소드를 호출하지 않는다.  
		// cf) putIfAbsent(): 해당 키가 있으나 없으나 get한다. (key 값이 없다면 입력 된 key와 value 를 입력, 해당 key가 존재하면 입력 되었던 값 반환)
		return memoizeMap.computeIfAbsent(n,
				(key) -> fibonacci(n-1).add(fibonacci(n-2)));
		
		//key 가 존재하여도 해당 메소드가 호출된다. 
		//productPriceMap.putIfAbsent(theKey, callExpensiveMethodToFindValue(theKey)); 
		//key 가 존재하면 해당 메소드는 호출되지 않는다. 
		//productPriceMap.computeIfAbsent(theKey, key -> callExpensiveMethodToFindValue(key));
		
		// 3. getOrDefault() : key 값이 없다면 입력 시 설정한 default 값을 반환.
		
	}
	
	public static void main(String[] args) {
		PracticeMap pm = new PracticeMap();
		for (int i = 0; i < 100; i++) {
			System.out.println(pm.fibonacci(i));
		}
		
		Map<String, String> hm = new HashMap<String, String>();
		System.out.println("key가 없을 때: "+ hm.get("key"));
		System.out.println("getOrDefault(): " + hm.getOrDefault("key", "car"));
		//key 가 비어있으면 default로 설정한 값을 출력
		System.out.println("putIfAbsent(): "+ hm.putIfAbsent("key", "ship"));
		//값이 비어있으면 해당 메소드의 value("ship")을 put 함. 단, 이전 값이 존재하지 않기 때문에 null 반환
		System.out.println("putIfAbsent(): "+ hm.putIfAbsent("key", "bike"));
		//재호출: 이전에 put 해둔 값을 get 함. 값이 없을 때 put 하는 것이기 때문에 이미 값이 있을 경우 value("bike") 를 대체하지 않음. 
		System.out.println("values in map: "+ hm.toString());
		// getOrDefault은 해당 key가 없을 경우  값을 set은 하지 않고 정해진 default 값만 리턴 하기 떄문에 car 없음
		// putIfAbsent는 이미 동일한 key로 된 값이 입력되어있었기 때문에 나중에 입력한 bike로 덮어 씌워지지 않음
		System.out.println("putIfAbsent()로 신규 key 값 입력: " + hm.putIfAbsent("key2", "bike"));
		System.out.println("values in map: "+ hm.toString());
	}
}
