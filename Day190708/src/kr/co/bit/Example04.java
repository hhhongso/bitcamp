package kr.co.bit;

import java.lang.reflect.Method;

public class Example04 {
	public static void main(String[] args) {
		// Service 클래스의 메소드 정보 출력
		Method[] dMethods = Service.class.getDeclaredMethods(); // .getDeclaredMethods(): 해당 클래스에 담긴 모든 메소드를 가져온다
		
		for(Method method : dMethods) {
			// 해당 메소드에 Annotation이 실재하는지 여부 확인
			if(method.isAnnotationPresent(PrintAnnotation.class)) {
				//각각의 메소드 안에 존재하는 PrintAnnotation을 객체형태로 가져오기 
				PrintAnnotation pa = method.getAnnotation(PrintAnnotation.class); // new 연산자로 객체생성하는 것 처럼, method.~~
				System.out.println(method.getName());
				// 구분선 출력: 어노테이션의 elements 값에 따라 달라진다. 
		
				for(int i = 0; i < pa.number() ; i++) {
					System.out.print(pa.value());
				}
				System.out.println();
				
				try {
					method.invoke(new Service()); // 메소드 안의 객체 실행
				} catch(Exception e) {
					e.printStackTrace();
				}
				System.out.println();
			}
		}
	}

}
