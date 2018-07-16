<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="./cabecalho.jsp" %>
<title>Página JSP</title>
</head>
<body>
	<h1>Página JSP</h1>
	<p><%=new Date()%></p>
	<p><%=request.getParameter("nome")%>
		<%=request.getParameter("idade")%>
	<ul>
		<li>Ficou mais limpo</li>
		<li>Cada um cuida da sua especialidade</li>

	</ul>
	<a href="./logoff">logoff</a>
</body>
</html>


