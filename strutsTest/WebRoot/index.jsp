<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Asher</title>
  </head>
  
  <body>
    <form action="${pageContext.request.contextPath }/register" method="post">
    	用户名：<input type="text" name="username"/><br/>
    	密码：<input type="password" name="password"/><br/>
    	邮箱：<input type="text" name="email"/><br/>
    	生日：<input type="text" name="birthday"/><br/>
    	<input type="submit"  value="注册"/>
    </form>
  </body>
</html>
