<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
  <style type="text/css">
body {
	padding-top: 30px;
	padding-bottom: 50px;
	background-color: #FFE4B5;
}
</style>
<%
session.removeAttribute("username");
session.invalidate();
response.sendRedirect("login.jsp");
 %>
