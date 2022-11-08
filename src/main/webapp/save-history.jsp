<%@page import="wifiinfo.History"%>
<%@page import="wifiinfo.WifiInfoService"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String lat = request.getParameter("lat");
		String lnt = request.getParameter("lnt"); 
		
		LocalDateTime now = LocalDateTime.now();
		String date = now.toString().substring(0, 19);
			
	 	if (lat != null && lnt != null) {
			History history = new History();
			history.setLat(Double.valueOf(lat));
			history.setLnt(Double.valueOf(lnt)); 
			history.setDate(date);
			
			WifiInfoService.dbHistoryInsert(history);	
		}  
	%>
	<script> 
		location.href="http://localhost:8080/wifi-info/?lat=<%=lat%>&lnt=<%=lnt%>"
	</script> 
</body>
</html>