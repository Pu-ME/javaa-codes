package com.asher.crm.web.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		Object object = ActionContext.getContext().getSession().get("loginStaff");
		if(object==null){
			//没有登录，需要登录
			Object action = invocation.getAction();
			if(action instanceof ActionSupport){
				ActionSupport actionSupport = (ActionSupport) action;
				actionSupport.addFieldError("", "请登录");
			}
			return "login";
		}
		return invocation.invoke();
	}

}
