<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute></title>
</head>
<body>
	<div style="width: 100%">
		<tiles:insertAttribute name="header" ignore="false"></tiles:insertAttribute>
	</div>
	<div style="width: 100%">
		<tiles:insertAttribute name="body" ignore="false"></tiles:insertAttribute>
	</div>
	<div style="width: 100%">
		<tiles:insertAttribute name="footer" ignore="false"></tiles:insertAttribute>
	</div>
</body>
</html>