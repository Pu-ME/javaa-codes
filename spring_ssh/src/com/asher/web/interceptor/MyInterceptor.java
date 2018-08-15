package com.asher.web.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class MyInterceptor extends MethodFilterInterceptor {

	@Override
	public String doIntercept(ActionInvocation invocation) throws Exception {
		
		/**
		 * 
		 * 拦截器中要进行的操作
		 *
		**/
		return null;
	}

}
