package com.kosa.mycompany;

import org.aspectj.lang.ProceedingJoinPoint;

//상속도 안 받고 그냥 POJP(Plain Old and Java Object)
//초창기는 상속을 받아서 작성했으나 지금은 그냥 클래스를 사용한다.
public class AdviceUsingXml {
	public Object aroundTargetMethod(ProceedingJoinPoint joinPoint) throws Throwable {
//		ProceedingJoinPoint -> 매개변수 타입
		System.out.println("arraound start");

//		함수를 납치해온다. joinPoint에 함수에 대한 모든 정보가 있다.
//		proceed 함수를 이용해 원래의 함수를 호출한다.
		String classname = joinPoint.getTarget().getClass().getSimpleName();
		String methodname = joinPoint.getSignature().getName();

		System.out.println("클래스명: " + classname);
		System.out.println("함수명: " + methodname);
		
		long time1 = System.currentTimeMillis(); // 현재 시간 가져오기
		Object retVal = joinPoint.proceed(); // 원래의 함수 호출
		long time2 = System.currentTimeMillis(); // 종료 시간을 가져온다.
		
		System.out.println("실행시간: "+(time2-time1)+"밀리초");
		System.out.println("arround end");

		return retVal;
	}
}
