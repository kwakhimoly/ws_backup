package com.kwak.mycompany.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAdvice {
	@Pointcut("execution(public * com.kwak.mycompany.*.*ServiceImpl.*(..))")
	private void targetMethod() {
	}

	@Around("targetMethod()")
	public Object aroudTarget(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("aop test *********");
		
		Object retval = joinPoint.proceed();
		
		return retval;
	}
}
