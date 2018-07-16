<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="musicaBean" class="br.com.exemplo.MusicaBean" scope="request"/>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="./cabecalho.jsp" %>
<title>Página JSP</title>
</head>
<body>
	<table class="dataTable" border="1">
		<tr>
		<th>Artista</th>
		<th>Musica</th>
		</tr>
	
    <c:forEach items="${musicaBean.musicas}" var="musica">
    <tr>
    	<td>${musica.artista}</td>
    	<td>${musica.nome}</td>
    </tr>
    </c:forEach>
    </table>
	<c:out value="${musciaBean.saudacao('Willian')}"/>
	
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


