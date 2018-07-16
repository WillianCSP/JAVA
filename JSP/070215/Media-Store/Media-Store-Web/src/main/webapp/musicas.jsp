<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="musicaBean" class="br.com.dextraining.mediaStore.beans.MusicaBean" scope="request"/>  

  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table class="dataTable" border="1">
		<tr>
		<th>Nome</th>
		<th>Preço</th>
		<th>Duração</th>
		<th>Excluir</th>
		</tr>
	
    <c:forEach items="${musicaBean.musicas}" var="musica">
    <tr>
    	<td>${musica.nome}</td>
    	<td><fmt:formatNumber value="${musica.preco}" type="currency"></fmt:formatNumber></td>
    	<td><fmt:formatNumber value="${musica.duracao}" type="number"/>
    	<td><a href="/RemoveMusicaServlet?id=${musica.id} ">X</a></td>
    </tr>
    </c:forEach>
    </table>
</body>
</html>