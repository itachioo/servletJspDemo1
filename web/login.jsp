<%--
  Created by IntelliJ IDEA.
  User: huanggang
  Date: 2019/4/29
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=GBK">
  <center><title>MVC登录实例</title></center>
</head>
<body>
<center><h2>用户登录程序</h2></center>
<center>
  <%
    request.setCharacterEncoding("GBK");
  %>
  <%
    List<String> info=(List<String>)request.getAttribute("info");
    if(info!=null){
      Iterator<String> iter=info.iterator();
      while(iter.hasNext()){
  %>
  <h4><%=iter.next()%></h4>
  <%
      }
    }
  %>
</center>
<center>
  <form action="LoginServlet" method="post" onSubmit="return validate(this)">
    用户名:<input type="text" name="name"><br>
    密 码：<input type="password" name="password"><br>
    <input type="submit" value="登录">
    <input type="reset" value="重置">
  </form>
</center>
</body>
</html>