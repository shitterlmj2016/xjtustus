<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <style type="text/css">
body {
	padding-top: 30px;
	padding-bottom: 50px;
	background-color: #FFE4B5;
}
</style>
<script language="javascript">
		alert("密码已修改，请重新登陆");
		window.location.href="${pageContext.request.contextPath}/login.jsp";
</script>
    <%
      session.removeAttribute("username");
	  session.invalidate();
     %>
	

  </head>
  
  <body>

  </body>
</html>
