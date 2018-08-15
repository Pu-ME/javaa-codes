<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Asher</title>
  </head>
  
  <body>
   	<s:form action="register">
   		<s:textfield name="username" label="用户名" requiredLabel="true" requiredPosition="top"/>
   		<s:password name="password" label="密码"/>
   		<s:textfield name="email" label="邮箱"/>
   		<s:textfield name="birthday" label="出生日期"/>
   		<s:submit value="注册"></s:submit>
   	</s:form>
  </body>
</html>
