<%@page import="wifiinfo.History"%>
<%@page import="wifiinfo.WifiInfoService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
	<h1> 와이파이 정보 구하기 </h1>
	<p>
		<a href="http://localhost:8080/wifi-info/"> 홈 </a> | 
		<a href="history.jsp"> 위치 히스토리 목록 </a> | 
		<a href="load-wifi.jsp"> Open API 와이파이 정보 가져오기 </a>
	</p>
	
	<%
		List<History> historyList = WifiInfoService.getHistoryList();
	%>
	
	<table border = "1">
		<thead>
			<tr>
				<th> ID </th>
				<th> X좌표 </th>
				<th> Y좌표 </th>
				<th> 조회일자 </th>
				<th> 비고 </th>
			</tr>
		</thead>
		<tbody> 
			<%
				for (History history : historyList) {
			%>
					<tr> 
						<td>
							<%=history.getId()%>
						</td>
						<td>
							<%=history.getLat()%>
						</td>
						<td>
							<%=history.getLnt()%>
						</td>
						<td>
							<%=history.getDate()%>
						</td>
						<td>
							<div>
								<input type='button' id='button' value="삭제"/>
							</div>
						</td>
					</tr>
			<%
				}
			%>
		</tbody>
	</table>
</body>
</html>