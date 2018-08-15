package com.asher.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation m) throws Throwable {
		System.out.println("before");
		Object obj = m.proceed();
		System.out.println("after");
		return obj;
	}

}
