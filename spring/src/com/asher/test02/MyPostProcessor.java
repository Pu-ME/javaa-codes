package com.asher.test02;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
		System.out.println("AfterInitialization");
		return Proxy.newProxyInstance(MyPostProcessor.class.getClassLoader(), bean.getClass().getInterfaces(),
				new InvocationHandler() {
 					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("开启");
						Object obj = method.invoke(bean, args);
						System.out.println("关闭");
						return obj;
					}
				});
	}

	@Override
	public Object postProcessBeforeInitialization( Object bean, String beanName) throws BeansException {
		System.out.println("BeforeInitialization");
		return bean;
	}

}
