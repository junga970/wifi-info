<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>와이파이 정보 구하기</title>
</head>
<body>
	<h1> 와이파이 정보 구하기 </h1>
	<a href="http://localhost:8080/wfi-info/"> 홈 </a> | 
	<a href="history.jsp"> 위치 히스토리 목록 </a> | 
	<a href="load-wifi.jsp"> Open API 와이파이 정보 가져오기 </a>
	
	<table border = "1">
		<thead>
			<th> ID </th>
			<th> X좌표 </th>
			<th> Y좌표 </th>
			<th> 조회일자 </th>
			<th> 비고 </th>
		</thead>
		<tr> 
			<td>
				0
			</td>
			<td>
				126.0000000
			</td>
		
			<td>
				126.0000000
			</td>
			<td>
				2022-06-09T02:34:38
			</td>
			<td>
				<input type='button' value="삭제"/>
			</td>
		</tr>
	</table>
</body>
</html>