<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${not empty error}">
Sistema temporariamente indisponível. Tente novamente.
<pre>${error}</pre>
</c:if>
	<h1>Cadastro</h1>
	<form action="./CadastroMusicaServlet" method="post">
		<table><tr><td>
		<label>Nome:</label></td><td> <input type="text" name="nome" /></td>
		<tr><td><label>Preço:</label></td> <td><input type="text" name="preco" /></td></tr>
		<tr><td><label>Duração:</label></td> <td><input type="text" name="duracao" /></td></tr> 
		<tr><td><input
			type="submit" value="Salvar" /></td></tr>
			
		</table>	
	</form>
</body>
</html>