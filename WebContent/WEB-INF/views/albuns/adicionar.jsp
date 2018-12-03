<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adição de albuns</title>
</head>
<body>
	<c:url var="actionAdicionar" value="/albuns/adicionar"></c:url>
	<form:form action="${actionAdicionar}" method="post" modelAttribute="album">
		<label>Nome:</label>
		<form:input path="nome"/>
		<form:errors path="nome"></form:errors>
		<br/>
		<label>Ano de Lancamento</label>
		<form:input path="anoDeLancamento" />
		<form:errors path="anoDeLancamento" ></form:errors>
		<br/>
		<input type="submit" value="Salvar!" />
	</form:form>
</body>
</html>