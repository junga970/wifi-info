<%@page import="wifiinfo.ApiExplorer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<title>와이파이 정보 구하기</title>
</head>
<body>
	<%
		ApiExplorer.loadWifi();
	%>
	<div>
		<h1><%=ApiExplorer.getListTotalCount()%>개의 WIFI 정보를 정상적으로 저장하였습니다. </h1>
	</div>
	<div>
		<a href="http://localhost:8080/wifi-info/"> 홈 으로 가기 </a> 
	</div>
</body>
</html>