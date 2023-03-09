package com.kosa.mycompany;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//	자동으로 객체를 만들어야 함
//	Aspect 설정도 돼야 함
@Component
@Aspect
public class AdviceUsingAnnotation {
	@Pointcut("execution(public * com.kosa.mycompany.*Service.*(..))")
	private void publicTarget() {
	}
	
	@Around("publicTarget()") // @Pointcut이랑 @Around로 설정 끝 -> xml에서 하던 작업 간단하게
	public Object aroundTargetMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("arraound start ***");

		String classname = joinPoint.getTarget().getClass().getSimpleName();
		String methodname = joinPoint.getSignature().getName();

		System.out.println("클래스명: " + classname);
		System.out.println("함수명: " + methodname);
		
		long time1 = System.currentTimeMillis(); // 현재 시간 가져오기
		Object retVal = joinPoint.proceed(); // 원래의 함수 호출
		long time2 = System.currentTimeMillis(); // 종료 시간을 가져온다.
		
		System.out.println("실행시간: "+(time2-time1)+"밀리초");
		System.out.println("arround end ***");

		return retVal;
	}
}
