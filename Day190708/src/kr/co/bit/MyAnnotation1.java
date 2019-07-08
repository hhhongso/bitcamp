package kr.co.bit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // elementType = 메소드에만 적용할 수 있도록 타겟팅
@Retention(RetentionPolicy.RUNTIME) // 어노테이션 유지 정책: 어노테이션을 어디까지 끌고 갈 건지 설정: Rumtime/Class/Source까지  
public @interface MyAnnotation1 {
	String value; // 어노테이션 시 value = "" 가 아니라 그냥 바로 값을 넣을 수 있음. 단, 복수로 value 설정을 할 경우에는 value 명시해주어야 함. 
//	String eleName1(); //어노테이션으로 값을 받을 수 있도록 설정
	int eleName2() default 5; // 디폴트로 5가 설정되어 있어, eleName2를 어노테이션으로 받지 않아도 됨
}
